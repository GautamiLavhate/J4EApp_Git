package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile

import android.Manifest
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterLeadStatusCategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalArea
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterGender
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.DeleteImageResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GeneralModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ProfileContactUsModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ProfilepicModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class ProfileContactUsEditActivity : BaseActivity() ,AdapterLeadStatusCategory.OnClick2,AdapterGender.OnClick{
    private lateinit var binding: ActivityProfileContactUsEditBinding
    private val pickImage = 100
    private val pickImage1 = 101
    private var imageUri: Uri? = null
    private var strGen = ""

    override fun enablePresence(): Boolean {
        return true
    }

    private val pickImage2 = 102
    private val pickImage21 = 103

    private val pickEditFrontImage1 = 200
    private val pickEditFrontImage2 = 201

    private val pickImageBa = 108
    private val pickImageBa1 = 109


    private var imageUri2: Uri? = null
    private val pickImage3 = 104
    private val pickImage4 = 105
    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    private val PERMISSION_CODE=1003
    lateinit var downsizedImageBytes: ByteArray
    private var destination: File? = null
    var downis: InputStream? = null

    lateinit var downsizedImageBytescard: ByteArray
    var Path:String=""
    lateinit var downsizedImageBytesBackcard: ByteArray
    var PathBack:String=""

    var areaid :String=""

    private val PERMISSION_REQUEST_CODE = 159
    var bitmap: Bitmap ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_contact_us_edit)
        binding.lifecycleOwner = this

        binding.toolbar.ivEdit.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_done, null
            )
        )

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.editcontact1.startAnimation(anim)


        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.phonenumber.setTag( binding.phonenumber.getKeyListener())
        binding.phonenumber.keyListener=null

        binding.dobedt.setTag( binding.dobedt.getKeyListener())
        binding.dobedt.keyListener=null

        binding.llGender.setOnClickListener {
            if (binding.ivDropDownGen.isVisible) {
                binding.ivDropDownGen.visibility = View.GONE
                binding.crossfunGen.visibility = View.GONE
                binding.ivDropUpGen.visibility = View.VISIBLE
                binding.rvGen.visibility = View.VISIBLE
            } else {
                binding.ivDropDownGen.visibility = View.VISIBLE
                binding.ivDropUpGen.visibility = View.GONE
                binding.rvGen.visibility = View.GONE
                if (binding.edtGen.text.length == 0){
                    binding.crossfunGen.visibility = View.GONE
                }else{
                    binding.crossfunGen.visibility = View.VISIBLE
                }
            }
        }

        binding.crossfunDateOfBirth.setOnClickListener {
            binding.crossfunDateOfBirth.visibility = View.GONE
            binding.dobedt.setText("")
        }

        binding.crossfunGen.setOnClickListener {
            binding.crossfunGen.visibility = View.GONE
            binding.edtGen.setText("")
        }
        spGender()

        if(!(readUsingSharedPreference(this@ProfileContactUsEditActivity, "total_experience")?.equals("0")!!)){

            binding.address.text = readUsingSharedPreference(this@ProfileContactUsEditActivity, "business_entity").toString() + ", " +
                    readUsingSharedPreference(this@ProfileContactUsEditActivity, "business_type").toString() + ", " +
                    readUsingSharedPreference(this@ProfileContactUsEditActivity, "business_category").toString() + ", " +
                    readUsingSharedPreference(this@ProfileContactUsEditActivity, "total_experience").toString()
        }else{
            binding.address.text =""
        }

        binding.ivImgAddfont.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBSRewardListBinding.root)
            //bitmap = (binding.ivImgAddfont.getDrawable() as BitmapDrawable).bitmap
            GlobalDialog(bitmap!!)

            mBSRewardListBinding.Galleryimg.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionFrontImgeGallery()
            }

            mBSRewardListBinding.camera.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionFrontImgecamera()
            }

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()

            }
            dialog.show()
        }
        binding.ivdeletefront1.setOnClickListener {

            DeleteDialog()
        }
        binding.iveditfront1.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBSRewardListBinding.root)

            mBSRewardListBinding.Galleryimg.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionEditFrontImgeGallery()
            }

            mBSRewardListBinding.camera.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionEditFrontImgecamera()
            }

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()

            }
            dialog.show()
        }


        binding.ivImgAddBack.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBSRewardListBinding.root)

            mBSRewardListBinding.Galleryimg.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionBackImgeGallery()
            }

            mBSRewardListBinding.camera.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionBackImgecamera()
            }

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()

            }
            dialog.show()
        }

        binding.imgvcardback2.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBSRewardListBinding.root)

            mBSRewardListBinding.Galleryimg.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionBackImgeGallery0ne()
            }

            mBSRewardListBinding.camera.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionBackImgecamera0ne()
            }

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()

            }
            dialog.show()
        }

        binding.ivdeleteback2.setOnClickListener {
            DeleteDialog1()
        }





        binding.dobedt.setOnClickListener {
            val c = Calendar.getInstance()
            val yr = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val display = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, year, monthOfYear, dayOfMonth ->
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
                val months=monthOfYear+1
                binding.dobedt.setText("$dayOfMonth/$months/$year")
                binding.dobedt.setError(null)
            }, yr, month, day)
            display.datePicker.maxDate = System.currentTimeMillis()
            display.show()


        }

        binding.dobedt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {

                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.length == 0){
                    binding.crossfunDateOfBirth.visibility=View.GONE
                }else{
                    binding.crossfunDateOfBirth.visibility=View.VISIBLE
                }
            }
        })

        binding.imageadd.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBSRewardListBinding.root)

            mBSRewardListBinding.Galleryimg.setOnClickListener {
                dialog.dismiss()
                CheckperimmissionGallery()
            }

            mBSRewardListBinding.camera.setOnClickListener {
                dialog.dismiss()
                Checkperimmissioncamera()
            }

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()

            }
            dialog.show()
        }

        if (isInternetAvailable(this)) {
            getAppUserContactsUs(readUsingSharedPreference(this@ProfileContactUsEditActivity, "userid").toString());
        }

        Glide.with(this)
                .load(readUsingSharedPreference(this@ProfileContactUsEditActivity, "profilepic").toString())
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.ivProfileImg)

        if(!(readUsingSharedPreference(this@ProfileContactUsEditActivity, "fullname")?.toString().equals("0"))){
            binding.fullname.setText(wordFirstCap(readUsingSharedPreference(this@ProfileContactUsEditActivity, "fullname").toString()))
            binding.toolbar.tvTitle.text = wordFirstCap(readUsingSharedPreference(this@ProfileContactUsEditActivity, "flatname").toString())
        }else{
            binding.fullname.text=""
        }

        if(!(readUsingSharedPreference(this@ProfileContactUsEditActivity, "company_name")?.toString().equals("0"))){
            binding.companyNameti.setText(readUsingSharedPreference(this@ProfileContactUsEditActivity, "company_name").toString().capitalize())
        }else{
            binding.companyNameti.text=""
        }

        if(!(readUsingSharedPreference(this@ProfileContactUsEditActivity, "fullname")?.toString().equals("0"))){
            binding.fullname1.setText(wordFirstCap(readUsingSharedPreference(this@ProfileContactUsEditActivity, "fullname").toString()))
        }else{
            binding.fullname1.text=""
        }

        binding.tvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@ProfileContactUsEditActivity)) {
                        getAllArae("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@ProfileContactUsEditActivity)) {
                        getAllArae("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@ProfileContactUsEditActivity)) {
                    if (s.length > 0) {
                        binding.rvCategory.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        getAllArae(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategory.setAdapter(null)
                        getAllArae("")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory.setText("")
            areaid=""
        }


    }

    private fun spGender() {
        val list: MutableList<String> = ArrayList()
        list.add("Select Gender")
        list.add("Male")
        list.add("Female")
        list.add("Other")
        val dataAdapter = ArrayAdapter(
            this, R.layout.simple_spinner_item_gender, list
        )
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item_gender)
        binding.spGender.adapter = dataAdapter

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvGen.layoutManager = layoutManager1

        val mAdapterGen = AdapterGender(
            this@ProfileContactUsEditActivity,
            list, this@ProfileContactUsEditActivity
        )
        binding.rvGen.adapter=mAdapterGen

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager

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
    }

    override fun OnClick(position: String, id: String) {
        binding.tvCategory.setText(position)
        areaid=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());
    }

    fun validation() : Boolean {
        var Temp: Boolean?= true
        if (binding.contactemail.text.toString().length == 0) {
            binding.contactemail.setError("Field is empty")
            Temp = false
        } else {
            binding.contactemail.setError(null)
        }

        if (binding.phonenumber.text.toString().length == 0) {
            binding.phonenumber.setError("Field is empty")
            Temp = false
        } else {
            binding.phonenumber.setError(null)
        }

        if (binding.companyName.text.toString().length == 0) {
            binding.companyName.setError("Field is empty")
            Temp = false
        } else {
            binding.companyName.setError(null)
        }

        if (binding.edtWhatsapp.text.toString().length == 0) {
            binding.edtWhatsapp.setError("Field is empty")
            Temp = false
        } else {
            binding.edtWhatsapp.setError(null)
        }

//        if (binding.designation.text.toString().length == 0) {
//            binding.designation.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.designation.setError(null)
//        }

//        if (binding.totalexperiiace.text.toString().length == 0) {
//            binding.totalexperiiace.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.totalexperiiace.setError(null)
//        }

        /*if (binding.businesscategory.text.toString().length == 0) {
            binding.businesscategory.setError("Field is empty")
            Temp = false
        } else {
            binding.businesscategory.setError(null)
        }*/

//        if (binding.website.text.toString().length == 0) {
//            binding.website.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.website.setError(null)
//        }

//        if (binding.location.text.toString().length == 0) {
//            binding.location.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.location.setError(null)
//        }

//        if (binding.dobedt.text.toString().length == 0) {
//            binding.dobedt.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.dobedt.setError(null)
//        }

        if (binding.Google.length() !=0 ){
            if(!binding.Google.text.toString().isValidUrl()){
                binding.Google.setError("Enter valid url")
                Temp = false
            }else{
                //binding.Google.setError(null)
                if (binding.Google.text.startsWith("https")|| binding.Google.text.startsWith("http")|| binding.Google.text.startsWith("www")){
                    binding.Google.setError(null)
                }else{
                    binding.Google.setError("Enter valid url")
                    Temp = false
                }
            }
        }


        if (binding.linkedintwo.length() != 0){
            if(!binding.linkedintwo.text.toString().isValidUrl()){
                binding.linkedintwo.setError("Enter valid url")
                Temp = false
            }else{
                if (binding.linkedintwo.text.startsWith("https")|| binding.linkedintwo.text.startsWith("http")|| binding.linkedintwo.text.startsWith("www")){
                    binding.linkedintwo.setError(null)
                }else{
                    binding.linkedintwo.setError("Enter valid url")
                    Temp = false
                }
            }
        }

        if (binding.Facebooklink.length() != 0){
            if(!binding.Facebooklink.text.toString().isValidUrl()){
                binding.Facebooklink.setError("Enter valid url")
                Temp = false
            }else{
                if (binding.Facebooklink.text.startsWith("https")|| binding.Facebooklink.text.startsWith("http")|| binding.Facebooklink.text.startsWith("www")){
                    binding.Facebooklink.setError(null)
                }else{
                    binding.Facebooklink.setError("Enter valid url")
                    Temp = false
                }

            }
        }

      /*  if (binding.Google.text.toString().length == 0) {
            binding.Google.setError("Field is empty")
            Temp = false
        } else {
            binding.Google.setError(null)
        }

        if (binding.linkedintwo.text.toString().length == 0) {
            binding.linkedintwo.setError("Field is empty")
            Temp = false
        } else {
            binding.linkedintwo.setError(null)
        }

        if (binding.Facebooklink.text.toString().length == 0) {
            binding.Facebooklink.setError("Field is empty")
            Temp = false
        } else {
            binding.Facebooklink.setError(null)
        }*/

        if (binding.edtGen.text.toString().equals("Select Gender")) {
            displayToast(this@ProfileContactUsEditActivity,"Select Gender")
            Temp = false
        }

        if (areaid.isEmpty() &&  areaid.equals("null")) {
            displayToast(this,"Select your Category")
            Temp = false
        }

        return Temp!!
    }

    fun onEditBtnClick(view: View) {
        //onBackPressed()

        if (validation()) {

            if (isInternetAvailable(this)) {
                showLoader(this)

                val request = ServiceBuilder.buildService(APIinterface::class.java)

                val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
                val contactemail = RequestBody.create(MediaType.parse("text/plain"),binding.contactemail.text.toString())
                val phonenumber = RequestBody.create(MediaType.parse("text/plain"),binding.phonenumber.text.toString())
                val companyName = RequestBody.create(MediaType.parse("text/plain"),binding.companyName.text.toString())
                val designation = RequestBody.create(MediaType.parse("text/plain"),binding.designation.text.toString())
                val totalexperiiace = RequestBody.create(MediaType.parse("text/plain"),binding.totalexperiiace.text.toString())
                val businesscategory = RequestBody.create(MediaType.parse("text/plain"),areaid)
                val website = RequestBody.create(MediaType.parse("text/plain"),binding.website.text.toString())
                val location = RequestBody.create(MediaType.parse("text/plain"),binding.location.text.toString())
                val Facebooklink = RequestBody.create(MediaType.parse("text/plain"),binding.Facebooklink.text.toString())
                val linkedintwo = RequestBody.create(MediaType.parse("text/plain"),binding.linkedintwo.text.toString())
                val spGender = RequestBody.create(MediaType.parse("text/plain"),binding.edtGen.text.toString())
                val Google = RequestBody.create(MediaType.parse("text/plain"),binding.Google.text.toString())
                val dobedt = RequestBody.create(MediaType.parse("text/plain"),binding.dobedt.text.toString())
                val whatsapp = RequestBody.create(MediaType.parse("text/plain"),binding.edtWhatsapp.text.toString())
                val whatsappBusiness = RequestBody.create(MediaType.parse("text/plain"),"")

                val Inasata = RequestBody.create(MediaType.parse("text/plain"),"")
                var formDatacard: MultipartBody.Part? = null
                if(!(Path.equals(""))) {
                    val file1 = File(Path)
                    val Filenale1: String
                    Filenale1 = if (file1.name.contains(".png")) {
                        file1.name
                    } else {
                        file1.name + ".png"
                    }
                    val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytescard)
                    formDatacard = MultipartBody.Part.createFormData("vcard_front", Filenale1, requestBody)
                }else{
                    val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                    formDatacard = MultipartBody.Part.createFormData("vcard_front", "", requestBody)
                }

                var formDatacardback: MultipartBody.Part? = null
                if(!(PathBack.equals(""))) {
                    val file2 = File(PathBack)
                    val Filenale2: String
                    Filenale2 = if (file2.name.contains(".png")) {
                        file2.name
                    } else {
                        file2.name + ".png"
                    }
                    val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytesBackcard)
                    formDatacardback = MultipartBody.Part.createFormData("vcard_back", Filenale2, requestBody)
                }else{
                    val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                    formDatacardback = MultipartBody.Part.createFormData("vcard_back", "", requestBody)
                }


                val call = request.EditProfilecontactus(userId, contactemail,phonenumber, companyName,
                        designation, totalexperiiace,businesscategory,website, location, formDatacard,
                    formDatacardback,Facebooklink, linkedintwo,Inasata,Inasata,Inasata,Inasata,
                    spGender,Google,dobedt,whatsapp,whatsappBusiness)
                call.enqueue(object : Callback<GeneralModel> {
                    override fun onResponse(
                            call: Call<GeneralModel>,
                            response: Response<GeneralModel>
                    ) {
                        dismissLoader();
                        if (response.isSuccessful) {
                            if (response.body()?.status == true) {
                                displayToast(this@ProfileContactUsEditActivity, response.body()?.message.toString())
                                val intent = Intent(this@ProfileContactUsEditActivity, ProfileActivity::class.java)
                                intent.putExtra("typeedit", "contacts")
                                startActivity(intent)

                            } else {
                                displayToast(this@ProfileContactUsEditActivity, response.body()?.message.toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<GeneralModel>, t: Throwable) {
                        dismissLoader();
                        displayToast(this@ProfileContactUsEditActivity, this@ProfileContactUsEditActivity.resources.getString(R.string.error_something_wrong))
                    }
                })
            }
        }
    }
    fun String.isValidUrl(): Boolean = Patterns.WEB_URL.matcher(this).matches()
    private fun getAppUserContactsUs(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getuser_view_profile_contacts(id)
       // showLoader(this);
        call.enqueue(object : Callback<ProfileContactUsModel> {
            override fun onResponse(
                    call: Call<ProfileContactUsModel>,
                    response: Response<ProfileContactUsModel>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                           // binding.profileContactUs.name.text =   response.body()?.message?.first_name+" "+ response.body()?.message?.lastt_name
                            binding.contactemail.setText( response.body()?.data?.email)
                            binding.phonenumber.setText( response.body()?.data?.mobile)
                            binding.companyName.setText( response.body()?.data?.company_name)
                            binding.designation.setText( response.body()?.data?.designation)
                           // binding.businesscategory.setText( response.body()?.message?.business_category)
                            if(response.body()?.data?.whatsapp_no != null)
                                binding.edtWhatsapp.setText( response.body()?.data?.whatsapp_no)

//                            if(response.body()?.data?.company_whatsapp_no != null)
//                                binding.edtWhatsappBusiness.setText( response.body()?.data?.company_whatsapp_no)

                            binding.tvCategory.setText(response.body()?.data?.business_category)
                            areaid= response.body()?.data?.business_category_id.toString()
                            binding.website.setText( response.body()?.data?.website)
                            binding.location.setText( response.body()?.data?.company_address)
                            binding.totalexperiiace.setText( response.body()?.data?.total_experience)

                            binding.Facebooklink.setText( response.body()?.data?.company_facebook)
                            binding.linkedintwo.setText( response.body()?.data?.company_linkedin)
                            binding.Google.setText( response.body()?.data?.company_google)
                            if (response.body()?.data?.date_of_birth.equals("")){
                                binding.crossfunDateOfBirth.visibility=View.GONE
                            }else{
                                binding.crossfunDateOfBirth.visibility=View.VISIBLE
                            }
                            binding.dobedt.setText( response.body()?.data?.date_of_birth)
                            strGen=response.body()?.data?.gender.toString()
                            if (response.body()?.data?.gender.equals("")){
                                binding.crossfunGen.visibility = View.GONE
                            }else{
                                binding.crossfunGen.visibility = View.VISIBLE
                            }
                            binding.edtGen.setText(response.body()?.data?.gender)
                            Glide.with(this@ProfileContactUsEditActivity)
                                .load(response.body()?.data?.vcard_front)
                                .into(binding.imgvcardfront1)
                            Glide.with(this@ProfileContactUsEditActivity)
                                .load(response.body()?.data?.vcard_back)
                                .into(binding.imgvcardback2)
                            if (response.body()?.data?.vcard_front.equals("")){
                                binding.relativelayoutvCardFront.visibility = View.GONE
                                binding.ivImgAddfont.visibility = View.VISIBLE
                            }else{
                                binding.ivImgAddfont.visibility = View.GONE
                                binding.relativelayoutvCardFront.visibility = View.VISIBLE
                            }

                            if (response.body()?.data?.vcard_back.equals("")){
                                binding.relativelayoutvCardBack.visibility = View.GONE
                                binding.ivImgAddBack.visibility = View.VISIBLE
                            }else{
                                binding.ivImgAddBack.visibility = View.GONE
                                binding.relativelayoutvCardBack.visibility = View.VISIBLE
                            }

//                            Glide.with(this@ProfileContactUsEditActivity)
//                                    .load(response.body()?.data?.vcard_front)
//                                    .centerCrop()
//                                    .placeholder(R.drawable.ic_add_card_1)
//                                    .into(binding.ivImgAddfont)



//                            Glide.with(this@ProfileContactUsEditActivity)
//                                    .load(response.body()?.data?.vcard_back)
//                                    .centerCrop()
//                                    .placeholder(R.drawable.ic_add_card_1)
//                                    .into(binding.ivImgAddBack)


                            for (i in 0 until binding.spGender.getCount()) {
                                if (binding.spGender.getItemAtPosition(i).equals(response.body()?.data?.gender)) {
                                    binding.spGender.setSelection(i)

                                    break
                                }
                            }



                        }
                    }else{
                        binding.editcontact1.visibility=View.GONE
                        binding.editcontact.visibility=View.VISIBLE
                    }

                }else{
                    binding.editcontact1.visibility=View.GONE
                    binding.editcontact.visibility=View.VISIBLE
                }
                getAllArae("")
            }

            override fun onFailure(call: Call<ProfileContactUsModel>, t: Throwable) {
                dismissLoader();

            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.ivImgAddfont.setImageURI(imageUri)
            bitmap = (binding.ivImgAddfont.getDrawable() as BitmapDrawable).bitmap
            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytescard = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            Path = data!!.data!!.path.toString()
        } else if (resultCode == RESULT_OK && requestCode == pickImage1) {
            val bitmap = data!!.extras!!["data"] as Bitmap?
            Glide.with(this@ProfileContactUsEditActivity)
                    .load(bitmap)
                    .centerCrop()
                    .placeholder(R.drawable.ic_add_card_1)
                    .into(binding.ivImgAddfont)
            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            Path = destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width / 1
            val scaleHeight: Int = bitmap.height / 1
            downsizedImageBytescard = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!
        }else if (resultCode == RESULT_OK && requestCode == pickImage2){
            imageUri2 = data?.data
            binding.ivImgAddBack.setImageURI(imageUri2)
            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri2)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytesBackcard = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            PathBack= data!!.data!!.path.toString()
        }else if (resultCode == RESULT_OK && requestCode == pickImage21) {
            val bitmap = data!!.extras!!["data"] as Bitmap?
            Glide.with(this@ProfileContactUsEditActivity)
                    .load(bitmap)
                    .centerCrop()
                    .placeholder(R.drawable.ic_add_card_1)
                    .into(binding.ivImgAddBack)
            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

           PathBack= destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width / 1
            val scaleHeight: Int = bitmap.height / 1
            downsizedImageBytesBackcard = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!
        } else if (resultCode == RESULT_OK && requestCode == pickImage3) {
            imageUri3 = data?.data
            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri3)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytes = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            val Path :String= data!!.data!!.path.toString()
            getapp_user_edit_profile_pic(Path,downsizedImageBytes,fullBitmap)
        }else if(resultCode == RESULT_OK && requestCode == pickImage4){
            val bitmap = data!!.extras!!["data"] as Bitmap?

            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            val Path :String= destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width / 1
            val scaleHeight: Int = bitmap.height / 1
            downsizedImageBytes = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!

            getapp_user_edit_profile_pic(Path,downsizedImageBytes,bitmap)
        }else if (resultCode == RESULT_OK && requestCode == pickEditFrontImage1){
            imageUri = data?.data
            binding.imgvcardfront1.setImageURI(imageUri)

            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytescard = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            Path = data!!.data!!.path.toString()
        }else if (resultCode == RESULT_OK && requestCode == pickEditFrontImage2){
            val bitmap = data!!.extras!!["data"] as Bitmap?
            Glide.with(this)
                .load(bitmap)
                .into(binding.imgvcardfront1)
            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            Path = destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width / 1
            val scaleHeight: Int = bitmap.height / 1
            downsizedImageBytescard = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!
        }else if (resultCode == RESULT_OK && requestCode == pickImageBa){
            imageUri2 = data?.data
            binding.imgvcardback2.setImageURI(imageUri2)
            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri2)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytesBackcard = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            PathBack= data!!.data!!.path.toString()
        }else if (resultCode == RESULT_OK && requestCode == pickImageBa1) {
            val bitmap = data!!.extras!!["data"] as Bitmap?
            Glide.with(this)
                .load(bitmap)
                .centerCrop()
                .placeholder(R.drawable.ic_add_card_1)
                .into(binding.imgvcardback2)
            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            PathBack= destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width / 1
            val scaleHeight: Int = bitmap.height / 1
            downsizedImageBytesBackcard = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!
        }
    }

    private fun getapp_user_edit_profile_pic(attachment:String,downsizedImageBytes: ByteArray, bitmap:Bitmap) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            val file = File(attachment)
            /* File file = new File(Fiximge,Fiximge);*/
            /* File file = new File(Fiximge,Fiximge);*/
            val Filenale: String
            Filenale = if (file.name.contains(".png")) {
                file.name
            } else {
                file.name + ".png"
            }

            val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
            var formData: MultipartBody.Part? = null
            val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
            formData = MultipartBody.Part.createFormData("profile_pic", Filenale, requestBody)
            val call = request.app_user_edit_profile_pic(userId,formData)
            showLoader(this);
            call.enqueue(object : Callback<ProfilepicModel> {
                override fun onResponse(
                        call: Call<ProfilepicModel>,
                        response: Response<ProfilepicModel>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            if (response.body()?.message != null) {
                                Glide.with(this@ProfileContactUsEditActivity)
                                        .load(bitmap)
                                        .centerCrop()
                                        .placeholder(R.drawable.ic_profile_edit)
                                        .into(binding.ivProfileImg)
                                storeUsingSharedPreference(this@ProfileContactUsEditActivity, "profilepic", response.body()?.profile_pic.toString())
                                displayToast(this@ProfileContactUsEditActivity, response.body()?.message.toString())
                            }
                        }else{
                            displayToast(this@ProfileContactUsEditActivity,"profile Pic not updated")
                        }

                    }
                }

                override fun onFailure(call: Call<ProfilepicModel>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@ProfileContactUsEditActivity, this@ProfileContactUsEditActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }

    @Throws(IOException::class)
    fun getDownsizedImageBytes(fullBitmap: Bitmap?, scaleWidth: Int, scaleHeight: Int): ByteArray? {
        val scaledBitmap = Bitmap.createScaledBitmap(fullBitmap!!, scaleWidth, scaleHeight, true)

        // 2. Instantiate the downsized image content as a byte[]
        val baos = ByteArrayOutputStream()
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        return baos.toByteArray()
    }

    //gallary/camera

    fun Checkperimmissioncamera(){
        if (checkPermissions()){
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED)) {
                //Apply for multiple permissions together

                //Apply for multiple permissions together
                ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), PERMISSION_CODEcamera)
            }else {
                val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(gallery, pickImage4)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }

    fun CheckperimmissionGallery(){
        if (checkPermissions()){
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_CODEGallry)
            } else {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                gallery.type = "image/*"
                startActivityForResult(gallery, pickImage3)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }

    //camera


    private fun getImageFileFromSDCard(filename: String): Bitmap? {
        var bitmap: Bitmap? = null
        destination = File(Environment.getExternalStorageDirectory().toString() + "/" + filename)
        try {
            val fis = FileInputStream(destination)
            bitmap = BitmapFactory.decodeStream(fis)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return bitmap
    }

    fun CheckperimmissionBackImgeGallery(){
        if (checkPermissions()){
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_CODEGallry)
            } else {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                gallery.type = "image/*"
                startActivityForResult(gallery, pickImage2)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }

    fun CheckperimmissionBackImgecamera(){
        if (checkPermissions()){
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED)) {
                //Apply for multiple permissions together

                //Apply for multiple permissions together
                ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), PERMISSION_CODEcamera)
            }else {
                val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(gallery, pickImage21)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }


    fun CheckperimmissionFrontImgeGallery(){
        if (checkPermissions()){
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_CODEGallry)
            } else {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                gallery.type = "image/*"
                startActivityForResult(gallery, pickImage)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }

    fun CheckperimmissionFrontImgecamera(){
        if (checkPermissions()){
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED)) {
                //Apply for multiple permissions together

                //Apply for multiple permissions together
                ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_CODEcamera)
            }else {
                val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(gallery, pickImage1)
            }
        }
//        else{
//            showAlertDialog()
//        }

    }

    private fun currentDateFormat(): String {
        val dateFormat = SimpleDateFormat("yyyyMMdd_HH_mm_ss")
        return dateFormat.format(Date())
    }

    private fun storeCameraPhotoInSDCard(bitmap: Bitmap, currentDate: String) {
        val outputFile = File(Environment.getExternalStorageDirectory(), "photo_$currentDate")
        try {
            val fileOutputStream = FileOutputStream(outputFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }



    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("typeedit", "contacts")
        startActivity(intent)
    }

    private fun getAllArae(keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_functional_area(keyword)
      //  showLoader(this);
        call.enqueue(object : Callback<FunctionalArea> {
            override fun onResponse(
                    call: Call<FunctionalArea>,
                    response: Response<FunctionalArea>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.editcontact1.visibility=View.GONE
                            binding.editcontact.visibility=View.VISIBLE
                            val mAdapter = AdapterLeadStatusCategory(
                                    this@ProfileContactUsEditActivity,
                                    response.body()?.data as MutableList<FunctionalData>, this@ProfileContactUsEditActivity
                            )
                            binding.rvCategory.adapter = mAdapter


                        }else{
                            binding.editcontact1.visibility=View.GONE
                            binding.editcontact.visibility=View.VISIBLE
                        }
                    }else{
                        binding.editcontact1.visibility=View.GONE
                        binding.editcontact.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<FunctionalArea>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnClick(gender:String) {
        binding.edtGen.setText(gender)
        binding.ivDropDownGen.visibility = View.VISIBLE
        binding.ivDropUpGen.visibility = View.GONE
        binding.rvGen.visibility = View.GONE
        binding.crossfunGen.visibility = View.VISIBLE
    }

    private fun showAlertDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: SplashPermissiondialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.splash_permissiondialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mBsRecommendPersonListBinding.goseeting.setOnClickListener {
            val gallery = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(gallery)

        }

        mBsRecommendPersonListBinding.okbtd.setOnClickListener {
            dialog.dismiss()
        }

        mBsRecommendPersonListBinding.noclosetheapp.setOnClickListener {
            requestPermissions()
        }
    }

    private fun requestPermissions() {

        ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
    }

    fun checkPermissions(): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in PermissionsUtil.permissions()) {
            result = ContextCompat.checkSelfPermission(this, p)
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0) {
            if (requestCode == PERMISSION_REQUEST_CODE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    checkUserRequestedDontAskAgain()
                }
            }
        }
    }

    private fun checkUserRequestedDontAskAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rationalFalgREAD =
                shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val rationalFalgWRITE =
                shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
            if (!rationalFalgREAD && !rationalFalgWRITE) {
                showAlertDialog()
            }
        }
    }

    fun CheckperimmissionEditFrontImgeGallery(){
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            requestPermissions(permissions, PERMISSION_CODEGallry)
        } else {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            gallery.type = "image/*"
            startActivityForResult(gallery, pickEditFrontImage1)
        }
    }

    fun CheckperimmissionEditFrontImgecamera(){
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED)) {
            //Apply for multiple permissions together

            //Apply for multiple permissions together
            ActivityCompat.requestPermissions(this, arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ), PERMISSION_CODEcamera)
        }else {
            val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(gallery, pickEditFrontImage2)
        }
    }
    private fun DeleteDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: DeleteDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.delete_dialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mbsAddAccountDialog.No.setOnClickListener {
            dialog.dismiss()
        }

        mbsAddAccountDialog.yes.setOnClickListener {
            delete_front_image(dialog)

        }


    }

    private fun DeleteDialog1(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: DeleteDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.delete_dialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mbsAddAccountDialog.No.setOnClickListener {
            dialog.dismiss()
        }

        mbsAddAccountDialog.yes.setOnClickListener {
            delete_back_image(dialog)

        }


    }
    private fun delete_front_image(dialog: Dialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_delete_vcard_front(readUsingSharedPreference(this,"userid").toString())
        //  showLoader(this);
        call.enqueue(object : Callback<DeleteImageResponse> {
            override fun onResponse(
                call: Call<DeleteImageResponse>,
                response: Response<DeleteImageResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true){
                        dialog.dismiss()
                        binding.relativelayoutvCardFront.visibility = View.GONE
                        binding.ivImgAddfont.visibility = View.VISIBLE
                    }else{
                        dialog.dismiss()
                        binding.ivImgAddfont.visibility = View.GONE
                        binding.relativelayoutvCardFront.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<DeleteImageResponse>, t: Throwable) {
                dismissLoader();
                dialog.dismiss()
            }
        })

    }

    private fun delete_back_image(dialog: Dialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_delete_vcard_back(readUsingSharedPreference(this,"userid").toString())
        //  showLoader(this);
        call.enqueue(object : Callback<DeleteImageResponse> {
            override fun onResponse(
                call: Call<DeleteImageResponse>,
                response: Response<DeleteImageResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true){
                        dialog.dismiss()
                        binding.relativelayoutvCardBack.visibility = View.GONE
                        binding.ivImgAddBack.visibility = View.VISIBLE
                    }else{
                        dialog.dismiss()
                        binding.ivImgAddBack.visibility = View.GONE
                        binding.relativelayoutvCardBack.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<DeleteImageResponse>, t: Throwable) {
                dismissLoader();
                dialog.dismiss()
            }
        })

    }

    fun CheckperimmissionBackImgeGallery0ne(){
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            requestPermissions(permissions, PERMISSION_CODEGallry)
        } else {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            gallery.type = "image/*"
            startActivityForResult(gallery, pickImageBa)
        }
    }

    fun CheckperimmissionBackImgecamera0ne(){
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED)) {
            //Apply for multiple permissions together

            //Apply for multiple permissions together
            ActivityCompat.requestPermissions(this, arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ), PERMISSION_CODEcamera)
        }else {
            val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(gallery, pickImageBa1)
        }
    }

    private fun GlobalDialog(bitmap: Bitmap){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: FullImageDialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.full_image_dialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mBsRecommendPersonListBinding.imgGlobalImage.setImageBitmap(bitmap)
        mBsRecommendPersonListBinding.fabClosePopup.setOnClickListener {
            dialog.dismiss()
        }


    }

}