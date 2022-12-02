package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateFollowUpBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowLeadData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowUserData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpmem
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CreateFollowUpActivity : BaseActivity(),AdapterFollowLeadData.OnClick2,AdapterFollowUserData.OnClick2 {
    private lateinit var binding: ActivityCreateFollowUpBinding
    var requirementst:String=""
    var userdatal:String=""
    var radatiodata:String=""
    var Datecre:String=""
    var Timecre:String=""
    var mainstr: String =""
    var Timecre2:String=""
    var typelead=""
    var companyName1: MutableList<FollowUpmem.DataLead> = mutableListOf<FollowUpmem.DataLead>()

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_follow_up)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.create_follow_up)
        binding.toolbar.ivPublish.text = "Save"
        onInitListener()
    }

    fun onInitListener() {

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory2.layoutManager = layoutManager1

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

        binding.llCategorySelection2.setOnClickListener {
            if (binding.ivDropDown2.isVisible) {
                binding.ivDropDown2.visibility = View.GONE
                binding.ivDropUp2.visibility = View.VISIBLE
                binding.rvCategory2.visibility = View.VISIBLE
            } else {
                binding.ivDropDown2.visibility = View.VISIBLE
                binding.ivDropUp2.visibility = View.GONE
                binding.rvCategory2.visibility = View.GONE
            }
        }

        binding.radioone.setOnClickListener {
            radatiodata="lead"
            val text1:String="Selection Lead <font color='#F82C2C'> *</font>"
            binding.tvCategory.hint=Html.fromHtml(text1)
            binding.radioone.isChecked=true
            binding.radiotwo.isChecked=false
            binding.tvCategory.setText("")
            requirementst=""
            userdatal=""

            binding.tvCategory2.text=""
            binding.llCategorySelection2.visibility=View.GONE
            binding.edtUserName.visibility=View.VISIBLE
            typelead="1"
            binding.rvCategory.adapter = null
            if(isInternetAvailable(this)){
                app_get_fallowup_lead_data(typelead,"")
            }

            binding.tvCategory.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                    if (s == "") {
                        if (isInternetAvailable(this@CreateFollowUpActivity)) {
                            app_get_fallowup_lead_data(typelead,"")
                        }
                        binding.crossfun.visibility=View.GONE
                    }
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (s == "") {
                        if (isInternetAvailable(this@CreateFollowUpActivity)) {
                            app_get_fallowup_lead_data(typelead,"")
                        }
                        binding.crossfun.visibility=View.GONE
                    }
                }

                override fun afterTextChanged(s: Editable) {
                    if (isInternetAvailable(this@CreateFollowUpActivity)) {
                        if (s.length > 0) {
                            binding.rvCategory.setAdapter(null)
                            binding.crossfun.visibility=View.VISIBLE
                            app_get_fallowup_lead_data(typelead,s.toString())
                        } else if (s.length == 0) {
                            binding.rvCategory.setAdapter(null)
                            app_get_fallowup_lead_data(typelead,"")
                            binding.crossfun.visibility=View.GONE
                        }
                    }
                }
            })

            binding.crossfun.setOnClickListener {
                binding.tvCategory.setText("")
                requirementst=""
                userdatal=""
                binding.tvCategory2.text=""
                binding.edtUserName.setText("")
            }
        }

        binding.radiotwo.setOnClickListener {
            val text2:String="Selection Requirement <font color='#F82C2C'> *</font>"
            binding.tvCategory.hint= Html.fromHtml(text2)
            radatiodata="requirement"
            binding.radiotwo.isChecked=true
            binding.radioone.isChecked=false
            binding.tvCategory.setText("")
            binding.tvCategory2.text=""
            requirementst=""
            userdatal=""

            binding.edtUserName.setText("")
            binding.llCategorySelection2.visibility=View.VISIBLE
            binding.edtUserName.visibility=View.GONE
            typelead="2"
            binding.rvCategory.adapter = null
            if(isInternetAvailable(this)){
                app_get_fallowup_lead_data(typelead,"")
            }

              binding.tvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@CreateFollowUpActivity)) {
                        app_get_fallowup_lead_data(typelead,"")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@CreateFollowUpActivity)) {
                        app_get_fallowup_lead_data(typelead,"")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateFollowUpActivity)) {
                    if (s.length > 0) {
                        binding.rvCategory.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        app_get_fallowup_lead_data(typelead,s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategory.setAdapter(null)
                        app_get_fallowup_lead_data(typelead,"")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory.setText("")
            binding.tvCategory2.text=""
            requirementst=""
            userdatal=""
            binding.edtUserName.setText("")
        }
        }







        binding.toolbar.ivPublish.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    app_create_fallowup()
                }
            }
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
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true
        if(radatiodata.equals("requirement")) {
            if (requirementst.isEmpty()) {
                displayToast(this, "Select Requirement")
                Temp = false
            }
        }

        if(radatiodata.equals("lead")) {
            if (requirementst.isEmpty()) {
                displayToast(this, "Select Lead")
                Temp = false
            }
        }

        if(radatiodata.equals("requirement")){
            if (userdatal.isEmpty()) {
                displayToast(this, "Select User")
                Temp = false
            }
        }


        if (binding.radiogroup.getCheckedRadioButtonId()==-1) {
            displayToast(this, "Select Radio Button")
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
        if(radatiodata.equals("requirement")) {
            if (requirementst.isEmpty()) {
                Temp = false
            }
        }

        if(radatiodata.equals("lead")) {
            if (requirementst.isEmpty()) {
                Temp = false
            }
        }

        if(radatiodata.equals("requirement")){
            if (userdatal.isEmpty()) {
                Temp = false
            }
        }


        if (binding.radiogroup.getCheckedRadioButtonId()==-1) {
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

    override fun OnClick(position: String, id: String, type: String) {
        binding.tvCategory.setText(position)
        requirementst=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString())

        userdatal=""
        binding.tvCategory2.text=""
        binding.edtUserName.setText("")
        if(isInternetAvailable(this)){
            if(type == "1") {
                app_get_fallowup_lead_userdata(id, "2")
            }else{
                app_get_fallowup_lead_userdata(id, "1")
            }
        }

        if(validationText()==false){
            binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
        } else {
            binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        }
    }

    private fun app_get_fallowup_lead_data(type:String,Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_fallowup_lead_data(readUsingSharedPreference(this, "userid").toString(),type,Keyword)
       // showLoader(this);
        call.enqueue(object : Callback<FollowUpLead> {
            override fun onResponse(
                    call: Call<FollowUpLead>,
                    response: Response<FollowUpLead>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    binding.rvCategory.adapter = null
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {


                                val mAdapter = AdapterFollowLeadData(
                                        this@CreateFollowUpActivity,
                                        response.body()?.data as MutableList<FollowUpLead.DataLead>, this@CreateFollowUpActivity, type)
                                binding.rvCategory.adapter = mAdapter


                        }else{
                            binding.rvCategory.adapter = null

                        }
                    }else{

                            binding.rvCategory.adapter = null
                       //     displayToast(this@CreateFollowUpActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<FollowUpLead>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun app_get_fallowup_lead_userdata(uiserid:String,type:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_fallowup_lead_userdata(uiserid,type)
        //showLoader(this);
        call.enqueue(object : Callback<FollowUpmem> {
            override fun onResponse(
                    call: Call<FollowUpmem>,
                    response: Response<FollowUpmem>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {

                        if (response.body()?.data?.size != 0) {
                            companyName1.clear()
                            if(type.equals("1")){

                                for (j in 0 until response.body()?.data!!.size) {
                                    if(response.body()?.data?.get(j)?.user_id.toString().equals(readUsingSharedPreference(this@CreateFollowUpActivity, "userid").toString())){


                                    }else{
                                        companyName1.add(response.body()?.data?.get(j)!!)
                                    }
                                    val mAdapter = AdapterFollowUserData(
                                        this@CreateFollowUpActivity,
                                        companyName1,
                                        this@CreateFollowUpActivity,
                                        type
                                    )
                                    binding.rvCategory2.adapter = mAdapter
                                }

                            }else {
                                userdatal= response.body()?.data?.get(0)?.user_id.toString()
                                if(response.body()?.data?.get(0)?.user_id.toString().equals(readUsingSharedPreference(this@CreateFollowUpActivity, "userid").toString())) {
                                    displayToast(this@CreateFollowUpActivity,"own User")
                                }else{
                                    binding.edtUserName.setText(response.body()?.data?.get(0)?.user_name?.toString())
                                }

                            }

                        }else{
                            displayToast(this@CreateFollowUpActivity,response.body()?.message.toString())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<FollowUpmem>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun app_create_fallowup(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())


        val call = request.app_create_fallowup(radatiodata,readUsingSharedPreference(this, "userid").toString(),userdatal,  binding.edtdescription.text.toString(), mainstr,currentDate,currentDate1,requirementst,Timecre2)
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        val intent = Intent(this@CreateFollowUpActivity, PendingResponsibilitiesActivity::class.java)
                        intent.putExtra("type", "2")
                        startActivity(intent)

                        displayToast(this@CreateFollowUpActivity,response.body()?.message.toString())
                    }else{
                        PermissionDialog(response.body()?.message.toString())
                        displayToast(this@CreateFollowUpActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
                displayToast(this@CreateFollowUpActivity,this@CreateFollowUpActivity.resources.getString(R.string.error_something_wrong))
            }
        })

    }

    override fun OnClicklead(position: String, id: String, type: String) {
        binding.tvCategory2.text = position;
        userdatal=id
        binding.ivDropDown2.visibility = View.VISIBLE
        binding.ivDropUp2.visibility = View.GONE
        binding.rvCategory2.visibility = View.GONE

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