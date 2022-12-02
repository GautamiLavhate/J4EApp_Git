package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateBuddyMeetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.BuddiesAll
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import kotlinx.android.synthetic.main.activity_my_membership_benefits.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CreateBuddyMeetActivity : BaseActivity(),AdapterBuddiesData.OnClick2 {
    private lateinit var binding: ActivityCreateBuddyMeetBinding
    var useridst:String=""
    var Datecre:String=""
    var Timecre:String=""
    var mainstr: String =""
    var Timecre2:String=""
    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_buddy_meet)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.create_buddy_meet)
        binding.toolbar.ivPublish.text = "Save"
        onInitListener()

        binding.edtDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.edtdescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })
    }

    fun onInitListener() {

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.layoutmanager1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            getBuddiesList("")
        }

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


        // Get Current Time


        // Get Current Time
        val c = Calendar.getInstance()
        val mHour = c[Calendar.HOUR_OF_DAY]
        val mMinute = c[Calendar.MINUTE]


        // Launch Time Picker Dialog


        // Launch Time Picker Dialog
        val timePickerDialog = TimePickerDialog(this,
            { view, hourOfDay, minute ->
                var hr = ""
                var minut = ""
                if (minute == 0) {
                    minut = "00"
                } else if (minute == 1) {
                    minut = "01"
                } else if (minute == 2) {
                    minut = "02"
                } else if (minute == 3) {
                    minut = "03"
                } else if (minute == 4) {
                    minut = "04"
                } else if (minute == 5) {
                    minut = "05"
                } else if (minute == 6) {
                    minut = "06"
                } else if (minute == 7) {
                    minut = "07"
                } else if (minute == 8) {
                    minut = "08"
                } else if (minute == 9) {
                    minut = "09"
                } else if (minute > 9) {
                    minut = minute.toString()
                }
                if (hourOfDay == 0) {
                    hr = "00"
                } else if (hourOfDay == 1) {
                    hr = "01"
                } else if (hourOfDay == 2) {
                    hr = "02"
                } else if (hourOfDay == 3) {
                    hr = "03"
                } else if (hourOfDay == 4) {
                    hr = "04"
                } else if (hourOfDay == 5) {
                    hr = "05"
                } else if (hourOfDay == 6) {
                    hr = "06"
                } else if (hourOfDay == 7) {
                    hr = "07"
                } else if (hourOfDay == 8) {
                    hr = "08"
                } else if (hourOfDay == 9) {
                    hr = "09"
                } else if (hourOfDay > 9) {
                    hr = hourOfDay.toString()
                }

                Datecre = "$dayOfMonth/$months/$year"
                Timecre = hr + ":" + minut
                val dtsendDate: String = Datecre + " " + Timecre


                val Datesub: String =Datecre
                val inputPattern = "dd/MM/yyyy"
                val outputPattern = "dd MMM yyyy"
                val inputFormat = SimpleDateFormat(inputPattern)
                val outputFormat = SimpleDateFormat(outputPattern)

                var date: Date? = null


                try {
                    date = inputFormat.parse(Datesub)
                    mainstr = outputFormat.format(date)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }


                val Datesub1: String =Timecre
                val inputPattern1 = "hh:mm"
                val outputPattern1 = "hh:mm a"
                val inputFormat1 = SimpleDateFormat(inputPattern1)
                val outputFormat1 = SimpleDateFormat(outputPattern1)

                var date1: Date? = null


                try {
                    date1 = inputFormat1.parse(Datesub1)
                    Timecre2 = outputFormat1.format(date1)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                binding.edtDate.setText(mainstr+" "+Timecre2)
                binding.edtDate.setError(null)
                            }, mHour, mMinute, false
                        )
                timePickerDialog.show()
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }


        binding.toolbar.ivPublish.setOnClickListener {
           if(validation()){
               if(isInternetAvailable(this)){
                   app_create_Buudy()
               }
           }
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

        binding.tvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@CreateBuddyMeetActivity)) {
                        getBuddiesList("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@CreateBuddyMeetActivity)) {
                        getBuddiesList("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateBuddyMeetActivity)) {
                    if (s.length > 0) {
                        binding.rvCategory.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        getBuddiesList(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategory.setAdapter(null)
                        getBuddiesList("")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory.setText("")
            useridst=""
        }
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true
          if (useridst.isEmpty()) {
              displayToast(this, "Select Members")
              Temp = false
          }

        if (binding.edtDate.text.toString().length == 0) {
            binding.edtDate.setError("Field is empty")
            Temp = false
        } else {
            binding.edtDate.setError(null)
        }

        if (binding.edtdescription.text.toString().length == 0) {
            binding.edtdescription.setError("Field is empty")
            Temp = false
        } else {
            binding.edtdescription.setError(null)
        }


        return Temp!!
    }

    fun validationText() : Boolean {

        var Temp: Boolean? = true
        if (useridst.isEmpty()) {
            Temp = false
        }

        if (binding.edtDate.text.toString().length == 0) {
            Temp = false
        } else {

        }

        if (binding.edtdescription.text.toString().length == 0) {
            Temp = false
        } else {

        }

        return Temp!!
    }

    private fun getBuddiesList(keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_buddieskeword(readUsingSharedPreference(this, "userid").toString(),keyword,"0","0")
        call.enqueue(object : Callback<BuddiesAll> {
            override fun onResponse(
                    call: Call<BuddiesAll>,
                    response: Response<BuddiesAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE

                            val mAdapter = AdapterBuddiesData(
                                    this@CreateBuddyMeetActivity,
                                    response.body()?.data as MutableList<AllBuddies>, this@CreateBuddyMeetActivity
                            )
                            binding.rvCategory.adapter = mAdapter

                        }else{
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE
                        }
                    }else{
                        binding.layoutmanager1.visibility=View.GONE
                        binding.layoutmanager.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<BuddiesAll>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun app_create_Buudy(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())


        val call = request.app_create_buddy_meet(readUsingSharedPreference(this, "userid").toString(),useridst,binding.edtdescription.text.toString(),binding.edtlocation.text.toString(),mainstr,currentDate,currentDate1,Timecre2)
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (intent.getStringExtra("type") == "fragbuddymeet") {
                            val intent = Intent(this@CreateBuddyMeetActivity, PendingResponsibilitiesActivity::class.java)
                            intent.putExtra("type", "1")
                            startActivity(intent)
                        }else{
                            startActivity(Intent(this@CreateBuddyMeetActivity, MainActivity::class.java))
                        }
                        displayToast(this@CreateBuddyMeetActivity,response.body()?.message.toString())
                    }else{
                        PermissionDialog(response.body()?.message.toString())
                        displayToast(this@CreateBuddyMeetActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
                displayToast(this@CreateBuddyMeetActivity,this@CreateBuddyMeetActivity.resources.getString(R.string.error_something_wrong))
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

        if(validationText()==false){
            binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
        } else {
            binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        }
    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}