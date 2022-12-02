package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
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
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsStatusAddBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterLeadStatusSetCategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.GetLeadStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.SetStatusLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MyLeadsStatusAddActivity : BaseActivity(),AdapterLeadStatusSetCategory.OnClick2{

    private lateinit var binding: ActivityMyLeadsStatusAddBinding
    var cataid :String=""
    var statusids :String=""
    var categorytext :String=""
    lateinit var requiremenid:String
    lateinit var reconmmend_user:String
    var Datecre:String=""
    var Timecre:String=""
    var Timecre2:String=""
    lateinit var OwnRe:String
    var radatiodata:String=""
    var mainstr: String =""
    var createFollowUpStatus: String=""
    var DATE:String=""
    var TIME:String=""

    override fun enablePresence(): Boolean {
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_leads_status_add)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.lead_status)
        binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))

        requiremenid=intent.getStringExtra("id").toString()
        reconmmend_user=intent.getStringExtra("reconmmend_user").toString()
        OwnRe=intent.getStringExtra("own").toString()


        if(OwnRe.equals("own")){
            radatiodata="lead"
        }else{
            radatiodata="requirement"
        }

        recyclerData()
        onCLickListener()



        if(isInternetAvailable(this)) {
            app_get_lead_status()
        }

        binding.enterdate.setOnClickListener {
            if(categorytext.equals("Payment")){
                      val c = Calendar.getInstance()
                val yr = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val display = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
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

                                binding.enterdate.setText(mainstr+" "+Timecre2)
                                DATE=mainstr
                                TIME=Timecre2
                                binding.enterdate.setError(null)
                            }, mHour, mMinute, false
                        )
                        timePickerDialog.show()
//                binding.dobedt.setText("$dayOfMonth/$months/$year")
//                binding.dobedt.setError(null)
                    },
                    yr,
                    month,
                    day
                )
                display.datePicker.maxDate = System.currentTimeMillis()
                display.show()
            }else {
                val c = Calendar.getInstance()
                val yr = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val display = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
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

                                binding.enterdate.setText(mainstr+" "+Timecre2)
                                DATE=mainstr
                                TIME=Timecre2
                                binding.enterdate.setError(null)
                            }, mHour, mMinute, false
                        )
                        timePickerDialog.show()
//                binding.dobedt.setText("$dayOfMonth/$months/$year")
//                binding.dobedt.setError(null)
                    },
                    yr,
                    month,
                    day
                )
                display.datePicker.minDate = System.currentTimeMillis()
                display.show()
            }
        }


    }

    private fun onCLickListener() {
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
            if (validation()) {
                if (isInternetAvailable(this)) {
                    if(categorytext.equals("Follow Up Date")) {
                        app_create_fallowup()
                    }else if(categorytext.equals("Buddy Meet")) {
                        app_create_Buudy()
                    }else{
                        Create_app_lead_status()
                    }


                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun validation() : Boolean {

        var Temp: Boolean?= true

        if(categorytext.equals("Attempted to Contact") || categorytext.equals("Follow Up Date") || categorytext.equals("Buddy Meet")) {
            if (binding.edtFeedback.text.toString().length == 0) {
                binding.edtFeedback.setError("Field is empty")
                Temp = false
            } else {
                binding.edtFeedback.setError(null)
            }
        }

        if(categorytext.equals("Payment")){
            if (binding.amount.text.toString().length == 0) {
                binding.amount.setError("Field is empty")
                Temp = false
            } else {
                binding.amount.setError(null)
            }


            if (binding.amount.text.toString().length != 0) {
                val Edtprise:Int=binding.amount.text.toString().toInt()

                if (Edtprise < 1){
                    displayToast(this, "0 Amount not allow")
                    Temp = false
                }
            }
        }

        if(categorytext.equals("Follow Up Date") || categorytext.equals("Buddy Meet")  || categorytext.equals("Payment")) {
            if (binding.enterdate.text.toString().length == 0) {
                binding.enterdate.setError("Field is empty")
                Temp = false
            } else {
                binding.enterdate.setError(null)
            }
        }

        if(categorytext.equals("Service / Product Received by Customer")|| categorytext.equals("Full Payment Received")) {
            if (binding.radioGrp.getCheckedRadioButtonId()==-1) {
                displayToast(this, "Select Radio Button")
                Temp = false
            }
        }

        if (cataid.equals("0")) {
            displayToast(this, "Select your Category")
            Temp = false
        }

        if (statusids.isEmpty()) {
            displayToast(this, "Select your Category")
            Temp = false
        }

        return Temp!!
    }


    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager
    }

    override fun OnClick(position: String, id: String, statusid: String) {
        binding.tvCategory.text = position;
        cataid=id
        statusids=statusid
        categorytext=position
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());
        if(position.equals("Payment")){
            binding.amount.setText("")
            binding.paymentselectedli.visibility=View.VISIBLE
            binding.noteTextview.text="Business transaction amount"
            binding.enterdate.hint="Enter Received date & time"
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.setText("")
            binding.enterdate.visibility=View.VISIBLE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }


        if(position.equals("Attempted to Contact")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.VISIBLE
            binding.noteTextview.text="Purpose of calling"
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Follow Up Date")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.VISIBLE
            binding.noteTextview.text="Follow up meeting details"
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.hint="Enter Follow up date & time"
            binding.enterdate.visibility=View.VISIBLE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Buddy Meet")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.VISIBLE
            binding.noteTextview.text="Discussion"
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.hint="Enter Buddy meet date & time"
            binding.enterdate.visibility=View.VISIBLE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.VISIBLE
        }

        if(position.equals("Proposal Shared")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Waiting for (customer / vendor) Response")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Full Payment Received")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.radiotext.text="Payment received"
            binding.Radioli.visibility=View.VISIBLE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Product / Service Delivered by Vendor")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Service / Product Received by Customer")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.radiotext.text="Product / service delivered"
            binding.Radioli.visibility=View.VISIBLE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Not Qualified Lead")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Closed, Converted in Business ")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

        if(position.equals("Closed, Not converted into Business")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }
        if(position.equals("Testimonial Shared")){
            binding.amount.setText("")
            binding.enterdate.setText("")
            binding.paymentselectedli.visibility=View.GONE
            binding.noteTextview.visibility=View.GONE
            binding.edtFeedback.visibility=View.VISIBLE
            binding.enterdate.visibility=View.GONE
            binding.Radioli.visibility=View.GONE
            binding.edtlocation.visibility=View.GONE
        }

    }

    private fun app_get_lead_status(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_lead_status()
        call.enqueue(object : Callback<GetLeadStatus> {
            override fun onResponse(
                    call: Call<GetLeadStatus>,
                    response: Response<GetLeadStatus>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            val Alldata: MutableList<SetStatusLead> = mutableListOf<SetStatusLead>()


                            val d = SetStatusLead("Pending", "0", "0")
                            Alldata.add(d)

                            for (i in 0 until response.body()?.data?.get(0)?.PendingData?.size!!) {
                                val d = SetStatusLead(response.body()?.data?.get(0)?.PendingData?.get(i)?.req_status_name.toString(), response.body()?.data?.get(0)?.PendingData?.get(i)?.req_status_category_id.toString(), response.body()?.data?.get(0)?.PendingData?.get(i)?.req_status_id.toString())
                                Alldata.add(d)
                            }

                            val d1 = SetStatusLead("Inprogress", "0", "0")
                            Alldata.add(d1)

                            for (i in 0 until response.body()?.data?.get(0)?.InprogressData?.size!!) {
                                val d = SetStatusLead(response.body()?.data?.get(0)?.InprogressData?.get(i)?.req_status_name.toString(), response.body()?.data?.get(0)?.InprogressData?.get(i)?.req_status_category_id.toString(), response.body()?.data?.get(0)?.InprogressData?.get(i)?.req_status_id.toString())
                                Alldata.add(d)
                            }

                            val d2 = SetStatusLead("Closed", "0", "0")
                            Alldata.add(d2)

                            for (i in 0 until response.body()?.data?.get(0)?.ClosedData?.size!!) {
                                val d = SetStatusLead(response.body()?.data?.get(0)?.ClosedData?.get(i)?.req_status_name.toString(), response.body()?.data?.get(0)?.ClosedData?.get(i)?.req_status_category_id.toString(), response.body()?.data?.get(0)?.ClosedData?.get(i)?.req_status_id.toString())
                                Alldata.add(d)
                            }


                            val mAdapter = AdapterLeadStatusSetCategory(
                                    this@MyLeadsStatusAddActivity,
                                    Alldata, this@MyLeadsStatusAddActivity
                            )
                            binding.rvCategory.adapter = mAdapter


                        } else {

                        }
                    }
                }
            }

            override fun onFailure(call: Call<GetLeadStatus>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun Create_app_lead_status(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm aa")
        val currentDate1 = sdf1.format(Date())

        val radioButtonID: Int = binding.radioGrp.getCheckedRadioButtonId()
        val radatiodata:String

        if(radioButtonID==-1){
            radatiodata=""
        }else{
            val radioButton: RadioButton = binding.radioGrp.findViewById(radioButtonID)
            radatiodata=radioButton.text.toString()
        }

        //displayToast(this,Datecre+","+ currentDate1)
        val call = request.app_user_add_lead_status(reconmmend_user,
            requiremenid,
            statusids,
            binding.edtFeedback.text.toString(),
            currentDate,
            currentDate1,
            cataid,
            binding.amount.text.toString(),
            readUsingSharedPreference(this, "userid").toString(),
            currentDate,
            currentDate1,
            radatiodata)
//        displayToast(this,reconmmend_user+","+
//            requiremenid+","+
//            statusids+","+
//            binding.edtFeedback.text.toString()+","+
//                currentDate+","+
//                currentDate+","+
//            cataid+","+
//            binding.amount.text.toString()+","+
//            readUsingSharedPreference(this, "userid").toString()+","+
//                currentDate+","+
//                currentDate+","+
//            radatiodata)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
//                        if(categorytext.equals("Buddy Meet")) {
//                            app_create_Buudy()
//                        }else if(categorytext.equals("Follow Up Date")) {
//                            app_create_fallowup()
//                        }

                        val returnIntent = Intent()
                        returnIntent.putExtra("result", "123")
                        returnIntent.putExtra("own", OwnRe)
                        setResult(RESULT_OK, returnIntent)
                        finish()
                        displayToast(this@MyLeadsStatusAddActivity, response.body()?.message.toString())
                    } else {
                        displayToast(this@MyLeadsStatusAddActivity, response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
                displayToast(this@MyLeadsStatusAddActivity, this@MyLeadsStatusAddActivity.resources.getString(R.string.error_something_wrong))
            }
        })

    }

    private fun app_create_Buudy(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())


        val call = request.app_create_buddy_meet(readUsingSharedPreference(this, "userid").toString(),reconmmend_user,binding.edtFeedback.text.toString(),binding.edtlocation.text.toString(),
            mainstr.toString(),currentDate,currentDate1,Timecre2)
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        Create_app_lead_status()
                    }else{
                        PermissionBackDialog(response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
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

        val call = request.app_create_fallowup(radatiodata,readUsingSharedPreference(this, "userid").toString(),reconmmend_user,  binding.edtFeedback.text.toString(), mainstr.toString(),currentDate,currentDate1,requiremenid,Timecre2)
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        Create_app_lead_status()
                    }else{
                        PermissionBackDialog(response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

            }
        })

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
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

    private fun PermissionBackDialog(massage:String){
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