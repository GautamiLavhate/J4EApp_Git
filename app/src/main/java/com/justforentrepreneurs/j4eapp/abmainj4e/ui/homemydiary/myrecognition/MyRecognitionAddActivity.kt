package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition

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
import android.view.LayoutInflater
import android.view.Window
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRecognitionAddBinding
import com.justforentrepreneurs.j4eapp.databinding.CameraGallaryBottomsheetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.databinding.SplashPermissiondialogBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class MyRecognitionAddActivity : BaseActivity() {
    private lateinit var binding: ActivityMyRecognitionAddBinding
    private val pickImage3 = 103
    override fun enablePresence(): Boolean {
        return true
    }
    private val pickImage4 = 104
    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    lateinit var downsizedImageBytes: ByteArray
    private var destination: File? = null
    var downis: InputStream? = null
    var Path:String=""

    private val PERMISSION_REQUEST_CODE = 159


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_recognition_add)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.create_recognition)
        binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        onCLickListener()

    }

    private fun onCLickListener() {
        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.ivPublish.setOnClickListener {
           if(validation()) {
               if (isInternetAvailable(this)) {
                   app_create_Recongnition(Path, downsizedImageBytes)
               }
           }
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

        if (binding.title.text.toString().length == 0) {
            binding.title.setError("Field is empty")
            Temp = false
        } else {
            binding.title.setError(null)
        }

        if (binding.edtWriteSomething.text.toString().length == 0) {
            binding.edtWriteSomething.setError("Field is empty")
            Temp = false
        } else {
            binding.edtWriteSomething.setError(null)
        }

        if (Path.isEmpty()) {
            displayToast(this,"Add Image")
            Temp = false
        }

        return Temp!!
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (intent.getStringExtra("type") != null && intent.getStringExtra("type") == "all_recognition") {
            val intent = Intent(this, MyRecognitionActivity::class.java)
            intent.putExtra("type", "all_recognition")
            startActivity(intent)
        }else{
            startActivity(Intent(this@MyRecognitionAddActivity, MyRecognitionActivity::class.java))
        }
    }

    private fun app_create_Recongnition(attachment:String,downsizedImageBytes: ByteArray) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val file = File(attachment)
        val Filenale: String
        Filenale = if (file.name.contains(".png")) {
            file.name
        } else {
            file.name + ".png"
        }

        val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
        val title = RequestBody.create(MediaType.parse("text/plain"),binding.title.text.toString())
        val des = RequestBody.create(MediaType.parse("text/plain"),binding.edtWriteSomething.text.toString())

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())
        val currentDatest = RequestBody.create(MediaType.parse("text/plain"),currentDate)

        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
        val currentDatest1 = RequestBody.create(MediaType.parse("text/plain"),currentDate1)

        var formData: MultipartBody.Part? = null
        val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
        formData = MultipartBody.Part.createFormData("recognition_thumbnail", Filenale, requestBody)
        val call = request.app_create_recognition(userId,title,des,currentDatest,currentDatest1,formData)
        showLoader(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (intent.getStringExtra("type") != null && intent.getStringExtra("type") == "all_recognition") {
                            val intent = Intent(this@MyRecognitionAddActivity, MyRecognitionActivity::class.java)
                            intent.putExtra("type", "all_recognition")
                            startActivity(intent)
                        }else{
                            startActivity(Intent(this@MyRecognitionAddActivity, MyRecognitionActivity::class.java))
                        }
                        displayToast(this@MyRecognitionAddActivity, response.body()?.message.toString())
                    }
                }else{
                    displayToast(this@MyRecognitionAddActivity, response.body()?.message.toString())
                }

            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader()
                displayToast(this@MyRecognitionAddActivity,this@MyRecognitionAddActivity.resources.getString(R.string.error_something_wrong))
            }
        })
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


}