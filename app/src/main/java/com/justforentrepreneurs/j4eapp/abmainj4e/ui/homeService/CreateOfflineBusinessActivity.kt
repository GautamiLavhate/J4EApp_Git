package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateOfflineBusinessBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesMembers
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.OfflineUnique
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CreateOfflineBusinessActivity : BaseActivity(),AdapterBuddiesMembers.OnClick2 {
    private lateinit var binding: ActivityCreateOfflineBusinessBinding
    var useridst:String=""

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_offline_business)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.create_offline_business)
        binding.toolbar.ivPublish.text = "Save"
        binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        onInitListener()


    }

    fun onInitListener() {

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)


        binding.edtDate.setOnClickListener {
            val c = Calendar.getInstance()
            val yr = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val display = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                var monthInput = (monthOfYear + 1).toString()
                if (monthInput.toInt() == 1) {
                    monthInput = "Jan"
                } else if (monthInput.toInt() == 2) {
                    monthInput = "Feb"
                } else if (monthInput.toInt() == 3) {
                    monthInput = "March"
                } else if (monthInput.toInt() == 4) {
                    monthInput = "April"
                } else if (monthInput.toInt() == 5) {
                    monthInput = "May"
                } else if (monthInput.toInt() == 6) {
                    monthInput = "June"
                } else if (monthInput.toInt() == 7) {
                    monthInput = "July"
                } else if (monthInput.toInt() == 8) {
                    monthInput = "Aug"
                } else if (monthInput.toInt() == 9) {
                    monthInput = "Sept"
                } else if (monthInput.toInt() == 10) {
                    monthInput = "Oct"
                } else if (monthInput.toInt() == 11) {
                    monthInput = "Nov"
                } else if (monthInput.toInt() == 12) {
                    monthInput = "Dec"
                }
                val months = monthOfYear + 1
                binding.edtDate.setText("$dayOfMonth/$months/$year")
                binding.edtDate.setError(null)
            }, yr, month, day)
            display.datePicker.maxDate = System.currentTimeMillis()
            display.show()
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            getRecommlistKeyWord("")
        }

        binding.tvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@CreateOfflineBusinessActivity)) {
                        getRecommlistKeyWord1("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@CreateOfflineBusinessActivity)) {
                        getRecommlistKeyWord1("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateOfflineBusinessActivity)) {
                    if (s.length > 0) {
                        binding.rvCategory.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        getRecommlistKeyWord1(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategory.setAdapter(null)
                        getRecommlistKeyWord1("")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory.setText("")
            useridst=""
        }


        binding.llCategorySelection.setOnClickListener {
            if (binding.ivDropDown.isVisible) {
                binding.ivDropDown.visibility = View.GONE
                binding.ivDropUp.visibility = View.VISIBLE
                binding.rvCategory.visibility = View.VISIBLE
            } else {
                binding.ivDropDown.visibility = View.VISIBLE
                binding.ivDropUp.visibility = View.GONE
                binding.rvCategory.visibility = View.GONE
            }
        }

        binding.toolbar.ivPublish.setOnClickListener {
            if(isInternetAvailable(this)) {
                if(validation()) {
                    app_create_offline_business_transaction()
                }
            }
        }
    }

    private fun app_create_offline_business_transaction(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val radioButtonID: Int = binding.radioGrp.getCheckedRadioButtonId()
        var radatiodata:String=""

        if(radioButtonID==-1){
            radatiodata=""
        }else{
            val radioButton: RadioButton = binding.radioGrp.findViewById(radioButtonID)

            if(radioButton.text.toString().equals("Received")){
                radatiodata="1"
            }else if(radioButton.text.toString().equals("Given")){
                radatiodata="2"
            }
        }

        val call = request.app_create_offline_business_transaction(readUsingSharedPreference(this@CreateOfflineBusinessActivity, "userid").toString(),radatiodata,useridst,binding.edtServiceName.text.toString(),binding.edtDate.text.toString(),binding.edtPrice.text.toString(),binding.edtRemarks.text.toString(),binding.edtTitle.text.toString())
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        startActivity(Intent(this@CreateOfflineBusinessActivity, MainActivity::class.java))
                        displayToast(this@CreateOfflineBusinessActivity,response.body()?.message.toString())
                    }else{
                        displayToast(this@CreateOfflineBusinessActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
                displayToast(this@CreateOfflineBusinessActivity,this@CreateOfflineBusinessActivity.resources.getString(R.string.error_something_wrong))
            }
        })

    }

    private fun getRecommlistKeyWord(Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_memberskey(readUsingSharedPreference(this, "userid").toString(),"0","0",Keyword)
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                    call: Call<J4EMember>,
                    response: Response<J4EMember>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {
                            binding.linearlayout1.visibility=View.GONE
                            binding.linearlayout.visibility=View.VISIBLE
                            val mAdapter = AdapterBuddiesMembers(
                                    this@CreateOfflineBusinessActivity,
                                    response.body()?.data?.member_info as MutableList<Memberinfo>, this@CreateOfflineBusinessActivity
                            )
                            binding.rvCategory.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility=View.GONE
                            binding.linearlayout.visibility=View.VISIBLE
                        }
                    }else{
                        binding.linearlayout1.visibility=View.GONE
                        binding.linearlayout.visibility=View.VISIBLE
                    }
                    getuniqueid()
                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getRecommlistKeyWord1(Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_memberskey(readUsingSharedPreference(this, "userid").toString(),"0","0",Keyword)
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                call: Call<J4EMember>,
                response: Response<J4EMember>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {
                            binding.linearlayout1.visibility=View.GONE
                            binding.linearlayout.visibility=View.VISIBLE
                            val mAdapter = AdapterBuddiesMembers(
                                this@CreateOfflineBusinessActivity,
                                response.body()?.data?.member_info as MutableList<Memberinfo>, this@CreateOfflineBusinessActivity
                            )
                            binding.rvCategory.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility=View.GONE
                            binding.linearlayout.visibility=View.VISIBLE
                        }
                    }else{
                        binding.linearlayout1.visibility=View.GONE
                        binding.linearlayout.visibility=View.VISIBLE
                    }

                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getuniqueid(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_offline_business_transaction_id()
        call.enqueue(object : Callback<OfflineUnique> {
            override fun onResponse(
                    call: Call<OfflineUnique>,
                    response: Response<OfflineUnique>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                       binding.edtTitle.setText(response.body()?.data)
                    }
                }
            }

            override fun onFailure(call: Call<OfflineUnique>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun OnClick(position: String, id: String) {
        binding.tvCategory.setText(position)
        useridst=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true
        if (useridst.isEmpty()) {
            displayToast(this, "Select Members")
            Temp = false
        }

        if (binding.radioGrp.getCheckedRadioButtonId()==-1) {
            displayToast(this, "Select Radio Button")
            Temp = false
        }

        if (binding.edtDate.text.toString().length == 0) {
            binding.edtDate.setError("Field is empty")
            Temp = false
        } else {
            binding.edtDate.setError(null)
        }

        if (binding.edtTitle.text.toString().length == 0) {
            binding.edtTitle.setError("Field is empty")
            Temp = false
        } else {
            binding.edtTitle.setError(null)
        }


        if (binding.edtPrice.text.toString().length == 0) {
            binding.edtPrice.setError("Field is empty")
            Temp = false
        } else {
            binding.edtPrice.setError(null)
        }



        if (binding.edtPrice.text.toString().length != 0) {
            val Edtprise:Int=binding.edtPrice.text.toString().toInt()

            if (Edtprise < 1){
                displayToast(this, "0 Price not allow")
                Temp = false
            }
        }

        if (binding.edtPrice.text.toString().length == 0) {
            binding.edtPrice.setError("Field is empty")
            Temp = false
        } else {
            binding.edtPrice.setError(null)
        }

        if (binding.edtRemarks.text.toString().length == 0) {
            binding.edtRemarks.setError("Field is empty")
            Temp = false
        } else {
            binding.edtRemarks.setError(null)
        }

        if (binding.edtServiceName.text.toString().length == 0) {
            binding.edtServiceName.setError("Field is empty")
            Temp = false
        } else {
            binding.edtServiceName.setError(null)
        }

        return Temp!!
    }


}