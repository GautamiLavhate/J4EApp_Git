package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile

import android.Manifest
import android.app.Dialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
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
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import com.justforentrepreneurs.j4eapp.databinding.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class ProfileAboutUsEditActivity : BaseActivity(),AdapterTurnOver.OnClick2, AdapterNoEmployee.OnClick2,AdapterGender.OnClick,
                                    AdapterBusinessType.OnClickBusinessType, AdapterBusinessEntity.OnClickBusinessEntity{

    override fun enablePresence(): Boolean {
        return true
    }

    private lateinit var binding: ActivityProfileAboutUsEditBinding
    private val pickImage3 = 103
    private val pickImage4 = 104
    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    lateinit var downsizedImageBytes: ByteArray
    var turnoverid :String=""
    var turnovervalue :String=""
    var AboutId :String=""
    var AboutValue :String=""

    private var destination: File? = null
    var downis: InputStream? = null

    private val PERMISSION_REQUEST_CODE = 159
    var Path :String=""
    var pptPath :String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_about_us_edit)
        binding.lifecycleOwner = this
        binding.toolbar.ivEdit.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_done,
                null
            )
        )
        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.editabout1.startAnimation(anim)

        spBusinessEntity()
        spBusinessType()
        spBusinessExpertise()
        spExpectedTurnover()
        spedtNoOfEmployee()

        binding.ivCrossBusinessEntity.setOnClickListener {
            binding.ivCrossBusinessEntity.visibility=View.GONE
            binding.tvBusinessEntity.text = ""
        }

        binding.ivCrossBusinessType.setOnClickListener {
            binding.ivCrossBusinessType.visibility=View.GONE
            binding.tvBusinessType.text = ""
        }

        binding.ivCrossBusinessExpertise.setOnClickListener {
            binding.ivCrossBusinessExpertise.visibility=View.GONE
            binding.tvBusinessExpertise.text = ""
        }

        binding.ivCrossNoOfEmployee.setOnClickListener {
            binding.ivCrossNoOfEmployee.visibility=View.GONE
            binding.tvCategory1.text = ""
            AboutId=""
            AboutValue=""
        }

        binding.ivCrossExpectedTurnover.setOnClickListener {
            binding.ivCrossExpectedTurnover.visibility=View.GONE
            binding.tvCategory.text = ""
            turnovervalue=""
            turnoverid=""
        }
        binding.ivCancel.setOnClickListener {
            binding.relativelayoutPdfAvailable.visibility=View.GONE
            binding.relativelayoutPdfEdit.visibility=View.GONE
            binding.ivImgAdd.visibility=View.VISIBLE
            Path=""
        }

        binding.ivCancelPpt.setOnClickListener {
            binding.relativelayoutPptAvailable.visibility=View.GONE
            binding.relativelayoutPptEdit.visibility=View.GONE
            binding.ivImgAddPpt.visibility=View.VISIBLE
            pptPath=""
        }
        binding.llBusinessExpertise.setOnClickListener {
            if (binding.ivDropDownBusinessExpertise.isVisible) {
                binding.ivDropDownBusinessExpertise.visibility = View.GONE
                binding.ivCrossBusinessExpertise.visibility = View.GONE
                binding.ivDropUpBusinessExpertise.visibility = View.VISIBLE
                binding.rvBusinessExpertise.visibility = View.VISIBLE
            } else {
                binding.ivDropDownBusinessExpertise.visibility = View.VISIBLE
                binding.ivDropUpBusinessExpertise.visibility = View.GONE
                binding.rvBusinessExpertise.visibility = View.GONE
                if (binding.tvBusinessExpertise.text.length == 0){
                    binding.ivCrossBusinessExpertise.visibility = View.GONE
                }else{
                    binding.ivCrossBusinessExpertise.visibility = View.VISIBLE
                }
            }
        }

        binding.llBusinessType.setOnClickListener {
            if (binding.ivDropDownBusinessType.isVisible) {
                binding.ivDropDownBusinessType.visibility = View.GONE
                binding.ivCrossBusinessType.visibility = View.GONE
                binding.ivDropUpBusinessType.visibility = View.VISIBLE
                binding.rvBusinessType.visibility = View.VISIBLE
            } else {
                binding.ivDropDownBusinessType.visibility = View.VISIBLE
                binding.ivDropUpBusinessType.visibility = View.GONE
                binding.rvBusinessType.visibility = View.GONE
                if (binding.tvBusinessType.text.length == 0){
                    binding.ivCrossBusinessType.visibility = View.GONE
                }else{
                    binding.ivCrossBusinessType.visibility = View.VISIBLE
                }
            }
        }

        binding.llBusinessEntity.setOnClickListener {
            if (binding.ivDropDownBusinessEntity.isVisible) {
                binding.ivDropDownBusinessEntity.visibility = View.GONE
                binding.ivCrossBusinessEntity.visibility = View.GONE
                binding.ivDropUpBusinessEntity.visibility = View.VISIBLE
                binding.rvBusinessEntity.visibility = View.VISIBLE
            } else {
                binding.ivDropDownBusinessEntity.visibility = View.VISIBLE
                binding.ivDropUpBusinessEntity.visibility = View.GONE
                binding.rvBusinessEntity.visibility = View.GONE
                if (binding.tvBusinessEntity.text.length == 0){
                    binding.ivCrossBusinessEntity.visibility = View.GONE
                }else{
                    binding.ivCrossBusinessEntity.visibility = View.VISIBLE
                }
            }
        }

        if(!(readUsingSharedPreference(this@ProfileAboutUsEditActivity, "total_experience")?.equals(
                "0"
            )!!)){
            binding.address.text = readUsingSharedPreference(
                this@ProfileAboutUsEditActivity,
                "business_entity"
            ).toString() + ", " +
                    readUsingSharedPreference(this@ProfileAboutUsEditActivity, "business_type").toString() + ", " +
                    readUsingSharedPreference(this@ProfileAboutUsEditActivity, "business_category").toString() + ", " +
                    readUsingSharedPreference(this@ProfileAboutUsEditActivity, "total_experience").toString()
        }else{
            binding.address.text =""
        }

        binding.imageadd.setOnClickListener {

            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(
                    this
                ), R.layout.camera_gallary_bottomsheet, null, false
            )
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

        if(!(readUsingSharedPreference(this@ProfileAboutUsEditActivity, "fullname")?.toString().equals(
                "0"
            ))){
            binding.fullname.setText(wordFirstCap(
                readUsingSharedPreference(
                    this@ProfileAboutUsEditActivity,
                    "fullname"
                ).toString())
            )
            binding.toolbar.tvTitle.text =wordFirstCap(
                readUsingSharedPreference(
                    this@ProfileAboutUsEditActivity,
                    "flatname"
                ).toString())
        }else{
            binding.fullname.text=""
        }

        if(!(readUsingSharedPreference(this@ProfileAboutUsEditActivity, "company_name")?.toString().equals(
                "0"
            ))){
            binding.companyName.setText(
                readUsingSharedPreference(
                    this@ProfileAboutUsEditActivity,
                    "company_name"
                ).toString().capitalize()
            )
        }else{
            binding.companyName.text=""
        }



        Glide.with(this)
                .load(
                    readUsingSharedPreference(
                        this@ProfileAboutUsEditActivity,
                        "profilepic"
                    ).toString()
                )
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.ivProfileImg)

        getAppUserAbouts(readUsingSharedPreference(this, "userid").toString())

        binding.ivImgAdd.setOnClickListener {
            if (checkPermissions()) {
                val mimeTypes = arrayOf(
                    "application/pdf"
                )
                println("chooseFile activated!");
                var selectFile = Intent(Intent.ACTION_GET_CONTENT)
                selectFile.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
                if (mimeTypes.isNotEmpty()) {
                    selectFile.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                }
                selectFile = Intent.createChooser(selectFile, "Choose a file")
                startActivityForResult(selectFile, 111)
                //Apply for multiple permissions together

                //Apply for multiple permissions together
//                ActivityCompat.requestPermissions(
//                    this, arrayOf(
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_EXTERNAL_STORAGE
//                    ), PERMISSION_CODEcamera
//                )

            }
//            else{
//                showAlertDialog()
//            }

        }

        binding.ivPdfEdit.setOnClickListener {
            if (checkPermissions()) {
                val mimeTypes = arrayOf(
                    "application/pdf"
                )
                println("chooseFile activated!");
                var selectFile = Intent(Intent.ACTION_GET_CONTENT)
                selectFile.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
                if (mimeTypes.isNotEmpty()) {
                    selectFile.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                }
                selectFile = Intent.createChooser(selectFile, "Choose a file")
                startActivityForResult(selectFile, 113)

            }
        }

        binding.ivImgAddPpt.setOnClickListener {
            if (checkPermissions()) {
                val mimeTypes = arrayOf(
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"
                )
                println("chooseFile activated!");
                var selectFile = Intent(Intent.ACTION_GET_CONTENT)
                selectFile.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
                if (mimeTypes.isNotEmpty()) {
                    selectFile.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                }
                selectFile = Intent.createChooser(selectFile, "Choose a file")
                startActivityForResult(selectFile, 112)
            }
        }

        binding.ivPptEdit.setOnClickListener {
            if (checkPermissions()) {
                val mimeTypes = arrayOf(
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"
                )
                println("chooseFile activated!");
                var selectFile = Intent(Intent.ACTION_GET_CONTENT)
                selectFile.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
                if (mimeTypes.isNotEmpty()) {
                    selectFile.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                }
                selectFile = Intent.createChooser(selectFile, "Choose a file")
                startActivityForResult(selectFile, 114)
            }
        }

        binding.ivPdfDelete.setOnClickListener {
            DeleteDialog()
        }

        binding.ivPptDelete.setOnClickListener {
            DeleteDialog1()
        }
    }

    private fun spBusinessEntity() {
        val list: MutableList<String> = ArrayList()
        list.add("Trust")
        list.add("Private Ltd")
        list.add("Partnership")
        list.add("Public Ltd")
        list.add("Properitiorship")
        list.add("LLP")
        list.add("NGO")
        val dataAdapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item, list
        )
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_item)
        binding.spBusinessEntity.adapter = dataAdapter

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBusinessEntity.layoutManager = layoutManager1

        val mAdapterGen = AdapterBusinessEntity(
            this,
            list, this)
        binding.rvBusinessEntity.adapter=mAdapterGen
    }

    private fun spedtNoOfEmployee() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory1.layoutManager = layoutManager
        binding.llCategorySelection1.setOnClickListener {
            if (binding.ivDropDown1.isVisible) {
                binding.ivDropDown1.visibility = View.GONE
                binding.ivCrossNoOfEmployee.visibility = View.GONE
                binding.ivDropUp1.visibility = View.VISIBLE
                binding.rvCategory1.visibility = View.VISIBLE
            } else {
                binding.ivDropDown1.visibility = View.VISIBLE
                binding.ivDropUp1.visibility = View.GONE
                binding.rvCategory1.visibility = View.GONE
                if (binding.tvCategory1.text.length == 0){
                    binding.ivCrossNoOfEmployee.visibility = View.GONE
                }else{
                    binding.ivCrossNoOfEmployee.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun spBusinessType() {
        val list: MutableList<String> = ArrayList()
        list.add("Business to Business (B2B)")
        list.add("Business to Consumer (B2C)")
        list.add("Business to Government (B2G)")
        val dataAdapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item, list
        )
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_item)
        binding.spBusinessType.adapter = dataAdapter

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBusinessType.layoutManager = layoutManager1

        val mAdapterGen = AdapterBusinessType(
            this,
            list, this)
        binding.rvBusinessType.adapter=mAdapterGen
    }

    private fun spBusinessExpertise() {
        val list: MutableList<String> = ArrayList()
        list.add("Agriculture")
        list.add("Other")
        list.add("Manufacturer")
        list.add("Services")
        list.add("Products")
        list.add("Trader")
        val dataAdapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item, list
        )
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_item)
        binding.spBusinessExpertise.adapter = dataAdapter

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBusinessExpertise.layoutManager = layoutManager1

        val mAdapterGen = AdapterGender(
            this,
            list, this)
        binding.rvBusinessExpertise.adapter=mAdapterGen
    }

    private fun spExpectedTurnover() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager
        binding.llCategorySelection.setOnClickListener {
            if (binding.ivDropDown.isVisible) {
                binding.ivDropDown.visibility = View.GONE
                binding.ivCrossExpectedTurnover.visibility = View.GONE
                binding.ivDropUp.visibility = View.VISIBLE
                binding.rvCategory.visibility = View.VISIBLE
            } else {
                binding.ivDropDown.visibility = View.VISIBLE
                binding.ivDropUp.visibility = View.GONE
                binding.rvCategory.visibility = View.GONE
                if (binding.tvCategory.text.length == 0){
                    binding.ivCrossExpectedTurnover.visibility = View.GONE
                }else{
                    binding.ivCrossExpectedTurnover.visibility = View.VISIBLE
                }
            }
        }

    }

    fun validation() : Boolean {

        var Temp: Boolean?= true
        if (binding.edtCompanyName.text.toString().length == 0) {
            binding.edtCompanyName.setError("Field is empty")
            Temp = false
        } else {
            binding.edtCompanyName.setError(null)
        }

//        if (binding.edtAboutCompany.text.toString().length == 0) {
//            binding.edtAboutCompany.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.edtAboutCompany.setError(null)
//        }

//        if (binding.edtWorkingFrom.text.toString().length == 0) {
//            binding.edtWorkingFrom.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.edtWorkingFrom.setError(null)
//        }


       /* if (binding.edtTypeOfMemberShip.text.toString().length == 0) {
            binding.edtTypeOfMemberShip.setError("Field is empty")
            Temp = false
        } else {
            binding.edtTypeOfMemberShip.setError(null)
        }*/

        if (turnovervalue.isEmpty() &&  turnovervalue.equals("null")) {
            displayToast(this, "Select your Expected Turnover")
            Temp = false
        }

        if (AboutValue.isEmpty() &&  AboutValue.equals(null)) {
            displayToast(this, "Select your No Of Employees")
            Temp = false
        }


//        if (binding.edtTagetAudience.text.toString().length == 0) {
//            binding.edtTagetAudience.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.edtTagetAudience.setError(null)
//        }

        return Temp!!
    }

    fun onEditBtnClick(view: View) {
        if (validation()) {
            if (isInternetAvailable(this)) {
                showLoader(this)

                    val request = ServiceBuilder.buildService(APIinterface::class.java)
                    val userId = RequestBody.create(
                        MediaType.parse("text/plain"), readUsingSharedPreference(
                            this,
                            "userid"
                        ).toString()
                    )
                    val edtCompanyName = RequestBody.create(
                        MediaType.parse("text/plain"),
                        binding.edtCompanyName.text.toString()
                    )
                    val edtAboutCompany = RequestBody.create(
                        MediaType.parse("text/plain"),
                        binding.edtAboutCompany.text.toString()
                    )
                    val spBusinessEntity = RequestBody.create(
                        MediaType.parse("text/plain"),
                        //binding.spBusinessEntity.selectedItem.toString()
                        binding.tvBusinessEntity.text.toString()
                    )
                    val spBusinessExpertise = RequestBody.create(
                        MediaType.parse("text/plain"),
                        //binding.spBusinessExpertise.selectedItem.toString()
                        binding.tvBusinessExpertise.text.toString()
                    )
                    val spBusinessType = RequestBody.create(
                        MediaType.parse("text/plain"),
                        //binding.spBusinessType.selectedItem.toString()
                        binding.tvBusinessType.text.toString()
                    )
                    val edtWorkingFrom = RequestBody.create(
                        MediaType.parse("text/plain"),
                        binding.edtWorkingFrom.text.toString()
                    )
                    val edtNoOfEmployee = RequestBody.create(
                        MediaType.parse("text/plain"),
                       AboutId
                    )
                    val spExpectedTurnover = RequestBody.create(
                        MediaType.parse("text/plain"),
                        turnoverid
                    )
                    val edtTagetAudience = RequestBody.create(
                        MediaType.parse("text/plain"),
                        binding.edtTagetAudience.text.toString()
                    )
                    val companyppt = RequestBody.create(MediaType.parse("text/plain"), "")
                var formData: MultipartBody.Part? = null

             if(Path!="") {
                 val file = File(Path)
                 val Filenale: String
                 Filenale = if (file.name.contains(".pdf")) {
                     file.name
                 } else {
                     file.name + ".pdf"
                 }

                 val requestBody = MultipartBody.create(
                     MediaType.parse("multipart/form-data"),
                     file
                 )
                 formData = MultipartBody.Part.createFormData(
                     "company_profile",
                     Filenale,
                     requestBody
                 )
             }else{
                 val requestBody =
                     MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                 formData =
                     MultipartBody.Part.createFormData("company_profile", "", requestBody)
             }
                var formData1: MultipartBody.Part? = null
             if (pptPath != ""){
                 val file = File(pptPath)
                 val Filenale: String
                 Filenale = if (file.name.contains(".ppt")) {
                     file.name
                 } else {
                     file.name + ".ppt"
                 }

                 val requestBody = MultipartBody.create(
                     MediaType.parse("multipart/form-data"),
                     file
                 )
                 formData1 = MultipartBody.Part.createFormData(
                     "company_ppt",
                     Filenale,
                     requestBody
                 )
             }else{
                 val requestBody =
                     MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                 formData1 =
                     MultipartBody.Part.createFormData("company_ppt", "", requestBody)
             }

//                    displayToast(this,""+edtCompanyName +","+ edtAboutCompany+","+ spBusinessEntity+","+
//                        spBusinessType+","+ spBusinessExpertise+","+ edtWorkingFrom+","+
//                        edtNoOfEmployee+","+ spExpectedTurnover+","+ edtTagetAudience+","+
//                        formData+","+ formData1)

                    val call = request.EditProfileAboutus(
                        userId, edtCompanyName, edtAboutCompany, spBusinessEntity,
                        spBusinessType, spBusinessExpertise, edtWorkingFrom,
                        edtNoOfEmployee, spExpectedTurnover, edtTagetAudience,
                        formData, formData1
                    )
                    call.enqueue(object : Callback<ConnectionDecline> {
                        override fun onResponse(
                            call: Call<ConnectionDecline>,
                            response: Response<ConnectionDecline>
                        ) {
                            dismissLoader();
                            if (response.isSuccessful) {
                                if (response.body()?.status == true) {
                                    displayToast(
                                        this@ProfileAboutUsEditActivity,
                                        response.body()?.message.toString()
                                    )
                                    startActivity(
                                        Intent(
                                            this@ProfileAboutUsEditActivity,
                                            ProfileActivity::class.java
                                        )
                                    )

                                } else {
                                    displayToast(
                                        this@ProfileAboutUsEditActivity,
                                        response.body()?.message.toString()
                                    )
                                }
                            }
                        }

                        override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                            displayToast(
                                this@ProfileAboutUsEditActivity,
                                this@ProfileAboutUsEditActivity.resources.getString(
                                    R.string.error_something_wrong
                                )
                            )
                        }
                    })
                }
            }

    }

    private fun getAppUserAbouts(id: String) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val call = request.getuser_view_profile_about(id)
            //showLoader(this);
            call.enqueue(object : Callback<ProfileAboutModel> {
                override fun onResponse(
                    call: Call<ProfileAboutModel>,
                    response: Response<ProfileAboutModel>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            if (response.body()?.message != null) {



                                binding.edtCompanyName.setText(response.body()?.message?.company_name)
                                binding.edtAboutCompany.setText(response.body()?.message?.about_company)
                                binding.edtWorkingFrom.setText(response.body()?.message?.working_from)

                                //  binding.edtTypeOfMemberShip.setText(response.body()?.message?.membership_title)
                                binding.edtTagetAudience.setText(response.body()?.message?.target_audiance)
                                binding.tvBusinessExpertise.setText(response.body()?.message?.business_expertise)
                                binding.tvBusinessType.setText(response.body()?.message?.business_type)
                                binding.tvBusinessEntity.setText(response.body()?.message?.business_entity)

                                if (response.body()?.message?.business_entity.equals("")){
                                    binding.ivCrossBusinessEntity.visibility = View.GONE
                                }else{
                                    binding.ivCrossBusinessEntity.visibility = View.VISIBLE
                                }

                                if (response.body()?.message?.business_type.equals("")){
                                    binding.ivCrossBusinessType.visibility = View.GONE
                                }else{
                                    binding.ivCrossBusinessType.visibility = View.VISIBLE
                                }

                                if (response.body()?.message?.business_expertise.equals("")){
                                    binding.ivCrossBusinessExpertise.visibility = View.GONE
                                }else{
                                    binding.ivCrossBusinessExpertise.visibility = View.VISIBLE
                                }

                                if (response.body()?.message?.company_profile.toString().contains(".pdf")){
                                    binding.relativelayoutPdfEdit.visibility=View.VISIBLE
                                    binding.relativelayoutPdfAvailable.visibility=View.GONE
                                    binding.ivImgAdd.visibility=View.GONE
                                }else{
                                    binding.ivImgAdd.visibility=View.VISIBLE
                                    binding.relativelayoutPdfAvailable.visibility=View.GONE
                                    binding.relativelayoutPdfEdit.visibility=View.GONE
                                }

                                if (response.body()?.message?.company_ppt.toString().contains(".ppt")){
                                    binding.ivImgAddPpt.visibility = View.GONE
                                    binding.relativelayoutPptAvailable.visibility = View.GONE
                                    binding.relativelayoutPptEdit.visibility = View.VISIBLE
                                }else{
                                    binding.relativelayoutPptEdit.visibility = View.GONE
                                    binding.relativelayoutPptAvailable.visibility = View.GONE
                                    binding.ivImgAddPpt.visibility = View.VISIBLE
                                }
                                for (i in 0 until binding.spBusinessType.getCount()) {
                                    if (binding.spBusinessType.getItemAtPosition(i)
                                            .equals(response.body()?.message?.business_type)
                                    ) {
                                        binding.spBusinessType.setSelection(i)
                                        break
                                    }
                                }



                                for (i in 0 until binding.spBusinessEntity.getCount()) {
                                    if (binding.spBusinessEntity.getItemAtPosition(i).equals(
                                            response.body()?.message?.business_entity
                                        )
                                    ) {
                                        binding.spBusinessEntity.setSelection(i)
                                        break
                                    }
                                }

                                for (i in 0 until binding.spBusinessExpertise.getCount()) {
                                    if (binding.spBusinessExpertise.getItemAtPosition(i).equals(
                                            response.body()?.message?.business_expertise
                                        )
                                    ) {
                                        binding.spBusinessExpertise.setSelection(i)
                                        break
                                    }
                                }

                                binding.tvCategory.text =
                                    response.body()?.message?.expected_turnover
                                if (response.body()?.message?.expected_turnover != null){
                                    if (response.body()?.message?.expected_turnover.equals("")){
                                        binding.ivCrossExpectedTurnover.visibility = View.GONE
                                    }else{
                                        binding.ivCrossExpectedTurnover.visibility = View.VISIBLE
                                    }
                                }else{
                                    binding.ivCrossExpectedTurnover.visibility = View.GONE
                                }

                                turnoverid =
                                    response.body()?.message?.expected_turnover_id.toString()

                                binding.tvCategory1.text = response.body()?.message?.no_of_employees
                                if (response.body()?.message?.no_of_employees != null){
                                    if (response.body()?.message?.no_of_employees.equals("")){
                                        binding.ivCrossNoOfEmployee.visibility = View.GONE
                                    }else{
                                        binding.ivCrossNoOfEmployee.visibility = View.VISIBLE
                                    }
                                }else{
                                    binding.ivCrossNoOfEmployee.visibility = View.GONE
                                }

                                AboutId =
                                    response.body()?.message?.no_of_employees_id.toString()

                                AboutValue= response.body()?.message?.no_of_employees.toString()



                            }
                        }


                    }else{
                    binding.editabout1.visibility=View.GONE
                    binding.editabout.visibility=View.VISIBLE
                    }
                    getAllTurnOver()


                }

                override fun onFailure(call: Call<ProfileAboutModel>, t: Throwable) {
                    dismissLoader()

                }
            })
        }
    }

    fun Checkperimmissioncamera(){
        if(checkPermissions()){
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                        != PackageManager.PERMISSION_GRANTED)) {
                //Apply for multiple permissions together

                //Apply for multiple permissions together
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ), PERMISSION_CODEcamera
                )
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



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage3) {
            imageUri3 = data?.data

            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri3)

            val scaleWidth: Int = fullBitmap.width / 2
            val scaleHeight: Int = fullBitmap.height / 2
            downsizedImageBytes = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
           val Path :String= data!!.data!!.path.toString()

            getapp_user_edit_profile_pic(Path, downsizedImageBytes, fullBitmap)
        }else if(resultCode == RESULT_OK && requestCode == pickImage4){
            val bitmap = data!!.extras!!["data"] as Bitmap?

            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            val Path :String= destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width/1
            val scaleHeight: Int = bitmap.height/1
            downsizedImageBytes = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!

            getapp_user_edit_profile_pic(Path, downsizedImageBytes, bitmap)
        }else if (requestCode == 111 && resultCode == RESULT_OK) {
            val uri = data!!.data
            val selectedFile = data?.data //The uri with the location of the file
            binding.ivImgAdd.visibility=View.GONE
            binding.relativelayoutPdfAvailable.visibility=View.VISIBLE
            binding.relativelayoutPdfEdit.visibility=View.GONE
            //Path = data!!.data!!.path.toString()
            Path = getFilePathFromURI(this, uri).toString()

        }else if (requestCode == 112 && resultCode == RESULT_OK){
            val uri = data!!.data
            val selectedFile = data?.data //The uri with the location of the file
            binding.ivImgAddPpt.visibility = View.GONE
            binding.relativelayoutPptAvailable.visibility = View.VISIBLE
            binding.relativelayoutPptEdit.visibility = View.GONE
            pptPath = getFilePathFromURI2(this,uri).toString()
        }else if (requestCode == 113 && resultCode == RESULT_OK){
            val uri = data!!.data
            val selectedFile = data?.data //The uri with the location of the file
            binding.ivImgAdd.visibility=View.GONE
            binding.relativelayoutPdfAvailable.visibility=View.VISIBLE
            binding.relativelayoutPdfEdit.visibility=View.GONE

            //Path = data!!.data!!.path.toString()
            Path = getFilePathFromURI(this, uri).toString()
        }else if (requestCode == 114 && resultCode == RESULT_OK){
            val uri = data!!.data
            val selectedFile = data?.data //The uri with the location of the file
            binding.ivImgAddPpt.visibility = View.GONE
            binding.relativelayoutPptAvailable.visibility = View.VISIBLE
            binding.relativelayoutPptEdit.visibility = View.GONE
            pptPath = getFilePathFromURI2(this,uri).toString()
        }
    }
    open fun getFilePathFromURI2(context: Context?, contentUri: Uri?): String? {
        //copy file and send new file path
        val cw = ContextWrapper(applicationContext)
        val directory = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(directory, "")

        val fileName: String? = getFileName(contentUri)

        // have the object build the directory structure, if needed.
        if (!file.exists()) {
            file.mkdirs()
        }
        if (!TextUtils.isEmpty(fileName)) {
            val copyFile = File(file, File.separator.toString() + fileName+ ".ppt")
            // create folder if not exists
            context?.let { copy(it, contentUri, copyFile) }
            return copyFile.absolutePath
        }
        return null
    }
    private fun getapp_user_edit_profile_pic(
        attachment: String,
        downsizedImageBytes: ByteArray,
        bitmap: Bitmap
    ) {
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

            val userId = RequestBody.create(
                MediaType.parse("text/plain"), readUsingSharedPreference(
                    this,
                    "userid"
                ).toString()
            )
            var formData: MultipartBody.Part? = null
            val requestBody = MultipartBody.create(
                MediaType.parse("multipart/form-data"),
                downsizedImageBytes
            )
            formData = MultipartBody.Part.createFormData("profile_pic", Filenale, requestBody)
            val call = request.app_user_edit_profile_pic(userId, formData)
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
                                Glide.with(this@ProfileAboutUsEditActivity)
                                    .load(bitmap)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_profile_edit)
                                    .into(binding.ivProfileImg)
                                storeUsingSharedPreference(
                                    this@ProfileAboutUsEditActivity,
                                    "profilepic",
                                    response.body()?.profile_pic.toString()
                                )
                                displayToast(
                                    this@ProfileAboutUsEditActivity,
                                    response.body()?.message.toString()
                                )
                            }
                        } else {
                            displayToast(this@ProfileAboutUsEditActivity, "profile Pic not updated")
                        }

                    }
                }

                override fun onFailure(call: Call<ProfilepicModel>, t: Throwable) {
                    dismissLoader()
                    displayToast(
                        this@ProfileAboutUsEditActivity,
                        this@ProfileAboutUsEditActivity.resources.getString(
                            R.string.error_something_wrong
                        )
                    )
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
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    //
    private val BUFFER_SIZE: Int = 1024 * 2
    private val IMAGE_DIRECTORY = ""
    open fun getFilePathFromURI(context: Context?, contentUri: Uri?): String? {
        //copy file and send new file path
        val cw = ContextWrapper(applicationContext)
        val directory = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(directory, "")

        val fileName: String? = getFileName(contentUri)

        // have the object build the directory structure, if needed.
        if (!file.exists()) {
            file.mkdirs()
        }
        if (!TextUtils.isEmpty(fileName)) {
            val copyFile = File(file, File.separator.toString() + fileName+ ".pdf")
            // create folder if not exists
            context?.let { copy(it, contentUri, copyFile) }
            return copyFile.absolutePath
        }
        return null
    }

    fun getFileName(uri: Uri?): String? {
        if (uri == null) return null
        var fileName: String? = null
        val path = uri.path
        val cut = path!!.lastIndexOf('/')
        if (cut != -1) {
            fileName = path.substring(cut + 1)
        }
        return fileName
    }

    fun copy(context: Context, srcUri: Uri?, dstFile: File?) {
        try {
            val inputStream = context.contentResolver.openInputStream(srcUri!!) ?: return
            val outputStream: OutputStream = FileOutputStream(dstFile)
            copystream(inputStream, outputStream)
            inputStream.close()
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(Exception::class, IOException::class)
    fun copystream(input: InputStream?, output: OutputStream?): Int {
        val buffer = ByteArray(BUFFER_SIZE)
        val `in` = BufferedInputStream(input, BUFFER_SIZE)
        val out = BufferedOutputStream(output, BUFFER_SIZE)
        var count = 0
        var n = 0
        try {
            while (`in`.read(buffer, 0, BUFFER_SIZE).also { n = it } != -1) {
                out.write(buffer, 0, n)
                count += n
            }
            out.flush()
        } finally {
            try {
                out.close()
            } catch (e: IOException) {
               // Log.e(e.getMessage(), java.lang.String.valueOf(e))
            }
            try {
                `in`.close()
            } catch (e: IOException) {
              //  Log.e(e.getMessage(), java.lang.String.valueOf(e))
            }
        }
        return count
    }

    override fun OnClick(position: String, id: String) {
        binding.tvCategory.text = position;
        turnovervalue=position
        turnoverid=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivCrossExpectedTurnover.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());
    }

    private fun getAllTurnOver(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_turnover()
        call.enqueue(object : Callback<GetTurnOver> {
            override fun onResponse(
                call: Call<GetTurnOver>,
                response: Response<GetTurnOver>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            val mAdapter = AdapterTurnOver(
                                this@ProfileAboutUsEditActivity,
                                response.body()?.data as MutableList<GetTurnOver.DataTurn>,
                                this@ProfileAboutUsEditActivity
                            )
                            binding.rvCategory.adapter = mAdapter


                        } else {
                            binding.editabout1.visibility=View.GONE
                            binding.editabout.visibility=View.VISIBLE
                        }
                    }else {
                        binding.editabout1.visibility=View.GONE
                        binding.editabout.visibility=View.VISIBLE
                    }
                    getAllNoofEmpoyee()
                }
            }

            override fun onFailure(call: Call<GetTurnOver>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    private fun getAllNoofEmpoyee(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_employee_data()
        call.enqueue(object : Callback<GetEmployeeWork> {
            override fun onResponse(
                call: Call<GetEmployeeWork>,
                response: Response<GetEmployeeWork>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            binding.editabout1.visibility=View.GONE
                            binding.editabout.visibility=View.VISIBLE

                            val mAdapter = AdapterNoEmployee(
                                this@ProfileAboutUsEditActivity,
                                response.body()?.data as MutableList<GetEmployeeWork.EmployeeWork>,
                                this@ProfileAboutUsEditActivity
                            )
                            binding.rvCategory1.adapter = mAdapter


                        } else {
                            binding.editabout1.visibility=View.GONE
                            binding.editabout.visibility=View.VISIBLE

                        }
                    }else {
                        binding.editabout1.visibility=View.GONE
                        binding.editabout.visibility=View.VISIBLE

                    }
                }
            }

            override fun onFailure(call: Call<GetEmployeeWork>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnEmpClick(position: String, id: String) {
        binding.tvCategory1.text = position;
        AboutValue=position
        AboutId=id
        binding.ivDropDown1.visibility = View.VISIBLE
        binding.ivCrossNoOfEmployee.visibility = View.VISIBLE
        binding.ivDropUp1.visibility = View.GONE
        binding.rvCategory1.visibility = View.GONE
        Log.d("position", position.toString());
    }

    override fun OnClick(gender: String) {
        binding.tvBusinessExpertise.setText(gender)
        binding.ivDropDownBusinessExpertise.visibility = View.VISIBLE
        binding.ivCrossBusinessExpertise.visibility = View.VISIBLE
        binding.ivDropUpBusinessExpertise.visibility = View.GONE
        binding.rvBusinessExpertise.visibility = View.GONE
    }

    override fun OnClickBusinessType(gender: String) {
        binding.tvBusinessType.setText(gender)
        binding.ivDropDownBusinessType.visibility = View.VISIBLE
        binding.ivCrossBusinessType.visibility = View.VISIBLE
        binding.ivDropUpBusinessType.visibility = View.GONE
        binding.rvBusinessType.visibility = View.GONE
    }

    override fun OnClickBusinessEntity(gender: String) {
        binding.tvBusinessEntity.setText(gender)
        binding.ivDropDownBusinessEntity.visibility = View.VISIBLE
        binding.ivCrossBusinessEntity.visibility = View.VISIBLE
        binding.ivDropUpBusinessEntity.visibility = View.GONE
        binding.rvBusinessEntity.visibility = View.GONE
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
    private fun DeleteDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: DeleteDialogPdfBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.delete_dialog_pdf, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mbsAddAccountDialog.No.setOnClickListener {
            dialog.dismiss()
        }

        mbsAddAccountDialog.yes.setOnClickListener {
            delete_pdf(dialog)
        }
    }
    private fun DeleteDialog1(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: DeleteDialogPptBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.delete_dialog_ppt, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mbsAddAccountDialog.No.setOnClickListener {
            dialog.dismiss()
        }

        mbsAddAccountDialog.yes.setOnClickListener {
            delete_ppt(dialog)
        }
    }

    private fun delete_pdf(dialog: Dialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_delete_company_profile(readUsingSharedPreference(this,"userid").toString())
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
                        binding.relativelayoutPdfEdit.visibility = View.GONE
                        binding.ivImgAdd.visibility = View.VISIBLE
                    }else{
                        dialog.dismiss()
                        binding.ivImgAdd.visibility = View.GONE
                        binding.relativelayoutPdfEdit.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<DeleteImageResponse>, t: Throwable) {
                dismissLoader();
                dialog.dismiss()
            }
        })

    }

    private fun delete_ppt(dialog: Dialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_delete_company_ppt(readUsingSharedPreference(this,"userid").toString())
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
                        binding.relativelayoutPptEdit.visibility = View.GONE
                        binding.ivImgAddPpt.visibility = View.VISIBLE
                    }else{
                        dialog.dismiss()
                        binding.ivImgAddPpt.visibility = View.GONE
                        binding.relativelayoutPptEdit.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<DeleteImageResponse>, t: Throwable) {
                dismissLoader();
                dialog.dismiss()
            }
        })

    }


}