package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import android.Manifest
import android.app.Dialog
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
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PostCategrory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterLeadStatusCategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.EditPostResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import kotlinx.android.synthetic.main.activity_create_posts.*
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class CreatePostsActivity : BaseActivity(),AdapterPostCategoriesNew.OnClick2{
    private lateinit var binding: ActivityCreatePostsBinding
    private val pickImage3 = 103
    private val pickImage4 = 104
    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    lateinit var downsizedImageBytes: ByteArray
    private var destination: File? = null
    var downis: InputStream? = null
    var Path:String=""
    var selectedData:String=""
    var editedData:String=""
    var ID:String=""
    var TYPE:String=""

    private val PERMISSION_REQUEST_CODE = 159

    override fun enablePresence(): Boolean {
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_posts)
        binding.lifecycleOwner = this
        TYPE=intent.getStringExtra("type").toString()
        if (intent.getStringExtra("type").equals("edit")){
            binding.toolbar.tvTitle.text = "Edit Post"
            ID=intent.getStringExtra("id").toString()
            binding.toolbar.ivPublish.text = "Save"
            binding.toolbar.ivPublish.visibility=View.VISIBLE
        }else{
            binding.toolbar.tvTitle.text = resources.getText(R.string.create_posts)
            binding.toolbar.ivPublish.text = "Save"
            binding.toolbar.ivPublish.visibility=View.GONE
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclecategory.layoutManager = layoutManager

        binding.rvPostInfo.layoutManager = GridLayoutManager(this@CreatePostsActivity, 2)

        onInitListener()

    }

    fun onInitListener() {
        binding.toolbar.ivPublish.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    if (TYPE.equals("edit")){
                        app_edit_Post(Path,ID)
                    }else{
                        app_create_Post(Path)
                    }

                }
            }
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.layoutmanager1.startAnimation(anim)

        if(isInternetAvailable(this)) {
            getAllPostCate()
        }

        binding.llCategorySelection.setOnClickListener {
            if (binding.ivDropDown.isVisible) {
                binding.ivDropDown.visibility = View.GONE
                binding.ivDropUp.visibility = View.VISIBLE
                binding.recyclecategory.visibility = View.VISIBLE
            } else {
                binding.ivDropDown.visibility = View.VISIBLE
                binding.ivDropUp.visibility = View.GONE
                binding.recyclecategory.visibility = View.GONE
            }
        }

//        binding.tvCategory.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//                if (s == "") {
//                    if (isInternetAvailable(this@CreatePostsActivity)) {
//                        getAllPostCate()
//                    }
//                    binding.crossfun.visibility=View.GONE
//                }
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                if (s == "") {
//                    if (isInternetAvailable(this@CreatePostsActivity)) {
//                        getAllPostCate()
//                    }
//                    binding.crossfun.visibility=View.GONE
//                }
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                if (isInternetAvailable(this@CreatePostsActivity)) {
//                    if (s.length > 0) {
//                        binding.recyclecategory.setAdapter(null)
//                        binding.crossfun.visibility=View.VISIBLE
//                        getAllPostCate()
//                    } else if (s.length == 0) {
//                        binding.recyclecategory.setAdapter(null)
//                        getAllPostCate()
//                        binding.crossfun.visibility=View.GONE
//                    }
//                }
//            }
//        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory.setText("")
            selectedData=""
        }
        binding.addimage.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
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

        binding.imgSelectedImage.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: CameraGallaryBottomsheetBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this), R.layout.camera_gallary_bottomsheet, null, false)
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

        binding.ivDelete.setOnClickListener {
            DeleteDialog()
        }

        binding.edtFeedback.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.visibility=View.GONE
                } else {
                    binding.toolbar.ivPublish.visibility=View.VISIBLE
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })
    }



    private fun getAllPostCate(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_post_category()
        call.enqueue(object : Callback<PostCategrory> {
            override fun onResponse(
                call: Call<PostCategrory>,
                response: Response<PostCategrory>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE

                            binding.imgSelectedImage.visibility=View.GONE
                            binding.ivDelete.visibility=View.GONE
                            binding.addimage.visibility=View.VISIBLE
                            val mAdapter = AdapterPostCategoriesNew(
                                this@CreatePostsActivity,
                                response.body()?.data as MutableList<PostCategrory.Postdata>, this@CreatePostsActivity
                            )
                            binding.recyclecategory.adapter = mAdapter

                            val mAdapter2 = AdapterPostInfo(
                                this@CreatePostsActivity,
                                response.body()?.data as MutableList<PostCategrory.Postdata>
                            )
                            binding.rvPostInfo.adapter = mAdapter2

                            if (TYPE.equals("edit")){
                                get_edit_post_detail(ID,response.body()?.data as MutableList<PostCategrory.Postdata>)
                            }
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

            override fun onFailure(call: Call<PostCategrory>, t: Throwable) {
                dismissLoader();
            }
        })

    }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage3) {
            imageUri3 = data?.data

            val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri3)

            val scaleWidth: Int = fullBitmap.width /2
            val scaleHeight: Int = fullBitmap.height /2
            downsizedImageBytes = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
            Path= data!!.data!!.path.toString()

            Glide.with(this)
                .load(fullBitmap)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.addimage)

            Glide.with(this)
                .load(fullBitmap)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.imgSelectedImage)


            //  getapp_user_edit_profile_pic(Path,downsizedImageBytes,fullBitmap)
        }else if(resultCode == RESULT_OK && requestCode == pickImage4){
            val bitmap = data!!.extras!!["data"] as Bitmap?

            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            Path= destination?.getAbsolutePath().toString()


            val scaleWidth: Int = bitmap.width/1
            val scaleHeight: Int = bitmap.height/1
            downsizedImageBytes = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!

            Glide.with(this)
                .load(bitmap)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.addimage)

            Glide.with(this)
                .load(bitmap)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.imgSelectedImage)


        }
    }
    //

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

    @Throws(IOException::class)
    fun getDownsizedImageBytes(fullBitmap: Bitmap?, scaleWidth: Int, scaleHeight: Int): ByteArray? {
        val scaledBitmap = Bitmap.createScaledBitmap(fullBitmap!!, scaleWidth, scaleHeight, true)

        // 2. Instantiate the downsized image content as a byte[]
        val baos = ByteArrayOutputStream()
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        return baos.toByteArray()
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true

        if (binding.edtFeedback.text.toString().length == 0) {
            binding.edtFeedback.setError("Field is empty")
            Temp = false
        } else {
            binding.edtFeedback.setError(null)
        }

        if (TYPE.equals("edit")){
            if(editedData==""){
                displayToast(this,"Select Category")
                Temp = false
            }
        }else{
            if(selectedData==""){
                displayToast(this,"Select Category")
                Temp = false
            }
        }


        return Temp!!
    }

    fun validationText() : Boolean {

        var Temp: Boolean? = true

        if (binding.edtFeedback.text.toString().length == 0) {
            Temp = false
        } else {

        }

        if (!TYPE.equals("edit")){
            if(selectedData==""){
                Temp = false
            }
        }


        return Temp!!
    }

    private fun app_create_Post(attachment:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        var formData: MultipartBody.Part? = null
        if (attachment.equals("")) {
            val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
            formData = MultipartBody.Part.createFormData("post_thumbnail", "", requestBody)
        } else{
        val file = File(attachment)
        val Filenale: String
        Filenale = if (file.name.contains(".png")) {
            file.name
        } else {
            file.name + ".png"
        }
        val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
           formData = MultipartBody.Part.createFormData("post_thumbnail", Filenale, requestBody)
        }

            val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
            val catid = RequestBody.create(MediaType.parse("text/plain"),selectedData)
            val postdes = RequestBody.create(MediaType.parse("text/plain"),binding.edtFeedback.text.toString())

            val sdf = SimpleDateFormat("dd MMM yyyy")
            val currentDate = sdf.format(Date())
            val currentDatest = RequestBody.create(MediaType.parse("text/plain"),currentDate)

            val sdf1 = SimpleDateFormat("hh:mm a")
            val currentDate1 = sdf1.format(Date())
            val currentDatest1 = RequestBody.create(MediaType.parse("text/plain"),currentDate1)

            val call = request.app_create_posts(userId,catid,postdes,currentDatest,currentDatest1,formData)
            showLoader1(this);
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                                startActivity(Intent(this@CreatePostsActivity, MainActivity::class.java))
                                displayToast(this@CreatePostsActivity, response.body()?.message.toString())
                            }else{
                                PermissionDialog(response.body()?.message.toString())
                            }
                        }else{
                            displayToast(this@CreatePostsActivity, response.body()?.message.toString())
                        }

                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@CreatePostsActivity,this@CreatePostsActivity.resources.getString(R.string.error_something_wrong))
                }
            })
    }

    private fun app_edit_Post(attachment:String,POSTID:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        var formData: MultipartBody.Part? = null
        if (attachment.equals("")) {
            val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
            formData = MultipartBody.Part.createFormData("post_thumbnail", "", requestBody)
        } else{
            val file = File(attachment)
            val Filenale: String
            Filenale = if (file.name.contains(".png")) {
                file.name
            } else {
                file.name + ".png"
            }
            val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
            formData = MultipartBody.Part.createFormData("post_thumbnail", Filenale, requestBody)
        }

        val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
        val catid = RequestBody.create(MediaType.parse("text/plain"),editedData)
        val postdes = RequestBody.create(MediaType.parse("text/plain"),binding.edtFeedback.text.toString())
        val postid = RequestBody.create(MediaType.parse("text/plain"),POSTID)


        val call = request.app_edit_posts(userId,catid,postdes,formData,postid)
        showLoader1(this);
        call.enqueue(object : Callback<EditPostResponse> {
            override fun onResponse(
                call: Call<EditPostResponse>,
                response: Response<EditPostResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        startActivity(Intent(this@CreatePostsActivity, MainActivity::class.java))
                        displayToast(this@CreatePostsActivity, response.body()?.msg.toString())
                    }else{
                        PermissionDialog(response.body()?.msg.toString())
                    }
                }else{
                    displayToast(this@CreatePostsActivity, response.body()?.msg.toString())
                }

            }

            override fun onFailure(call: Call<EditPostResponse>, t: Throwable) {
                dismissLoader()
                displayToast(this@CreatePostsActivity,this@CreatePostsActivity.resources.getString(R.string.error_something_wrong))
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
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

    fun get_edit_post_detail(post_id:String,companyName: MutableList<PostCategrory.Postdata>){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_edit_post_detail(post_id)
        call.enqueue(object : Callback<EditPostResponse> {
            override fun onResponse(
                call: Call<EditPostResponse>,
                response: Response<EditPostResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            if (response.body()?.data?.post_image.equals("")){
                                binding.addimage.visibility=View.VISIBLE
                                binding.ivDelete.visibility=View.GONE
                                binding.imgSelectedImage.visibility=View.GONE
                            }else{
                                binding.imgSelectedImage.visibility=View.VISIBLE
                                binding.ivDelete.visibility=View.VISIBLE
                                binding.addimage.visibility=View.GONE
                            }

                            Glide.with(this@CreatePostsActivity)
                                .load(response.body()?.data?.post_image)
                                .centerCrop()
                                .into(binding.imgSelectedImage)
                            binding.edtFeedback.setText(response.body()?.data?.post_description.toString())
                            binding.tvCategory.setText(response.body()?.data?.post_catname.toString())
                            editedData=response.body()?.data?.post_catid.toString()


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

            override fun onFailure(call: Call<EditPostResponse>, t: Throwable) {
                dismissLoader();
            }
        })
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
            delete_image(ID,dialog)

        }


    }

    fun delete_image(post_id:String,dialog:Dialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.delete_post_image(post_id)
        //displayToast(this,post_id)
        call.enqueue(object : Callback<EditPostResponse> {
            override fun onResponse(
                call: Call<EditPostResponse>,
                response: Response<EditPostResponse>
            ) {
                dismissLoader();
                //displayToast(this@CreatePostsActivity,response.body()?.status.toString())
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        dialog.dismiss()
                        app_edit_Post(Path,ID)
                    }else{
                        dialog.dismiss()
                    }

                }
            }

            override fun onFailure(call: Call<EditPostResponse>, t: Throwable) {

                dismissLoader();
                dialog.dismiss()

            }
        })
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
        val listPermissionsNeeded: MutableList<String> = java.util.ArrayList()
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

    override fun OnClick(position: String, id: String) {
        binding.tvCategory.setText(position)
        selectedData=id
        editedData=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.recyclecategory.visibility = View.GONE
        if(validationText()==false){
            binding.toolbar.ivPublish.visibility=View.GONE
        } else {
            binding.toolbar.ivPublish.visibility=View.VISIBLE
            binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
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
}