package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import android.Manifest
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
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
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateEventsBinding
import com.justforentrepreneurs.j4eapp.databinding.CameraGallaryBottomsheetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterCategoryEvent
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterGallerymultiple
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterGalleryUpdate
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterEventsGallery
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventBookingActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivityZoom
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import com.justforentrepreneurs.j4eapp.databinding.SplashPermissiondialogBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.ext.isInt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class UpdateEventsActivity : BaseActivity(), AdapterCategoryEvent.OnClick2,AdapterGallerymultiple.OnClick2 {
    private lateinit var binding: ActivityCreateEventsBinding
    var areaid :String=""
    private val pickImage3 = 103
    private val pickImage4 = 104


    var dataimage :String=""
    var dataimage1 :Int=0

    private val PERMISSION_REQUEST_CODE = 159

    override fun enablePresence(): Boolean {
        return true
    }

    private val PICK_IMAGE_MULTIPLE = 1005


    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    lateinit var downsizedImageBytes: ByteArray

    private var destination: File? = null
    var downis: InputStream? = null
    var Path:String=""
    var imagesUriArrayList: ArrayList<Uri> = arrayListOf<Uri>()
    lateinit var eventid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_events)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.create_events)
        binding.toolbar.ivPublish.text ="Save"
        binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        binding.btdPublishev.setBackgroundResource(R.drawable.ab_overlay_c)

        onInitListener()

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.layoutmanager1.startAnimation(anim)

        eventid = intent.getStringExtra("id").toString()


        if(isInternetAvailable(this)) {
            getEventsDeatils(eventid)
        }


    }

    fun onInitListener() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager

        binding.toolbar.ivPublish.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    app_create_event(Path, "2")
                }
            }
        }

         binding.btdPublishev.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    app_create_event(Path,"1")
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

        binding.addimage.setOnClickListener {
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

        binding.tvStartDate.setOnClickListener {
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

                            val Datecre = "$dayOfMonth/$months/$year"
                            val Timecre = hr + ":" + minut
                            val dtsendDate: String = Datecre + " " + Timecre

                            val Datesub: String =dtsendDate
                            val inputPattern = "dd/MM/yyyy hh:mm"
                            val outputPattern = "dd MMM yyyy hh:mm a"
                            val inputFormat = SimpleDateFormat(inputPattern)
                            val outputFormat = SimpleDateFormat(outputPattern)

                            var date: Date? = null
                            var mainstr: String? = null

                            try {
                                date = inputFormat.parse(Datesub)
                                mainstr = outputFormat.format(date)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }
                            binding.tvStartDate.setText(mainstr)
                            binding.tvStartDate.setError(null)
                        }, mHour, mMinute, false)
                timePickerDialog.show()
//                binding.dobedt.setText("$dayOfMonth/$months/$year")
//                binding.dobedt.setError(null)
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }

        binding.tvEndDate.setOnClickListener {
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

                            val Datecre = "$dayOfMonth/$months/$year"
                            val Timecre = hr + ":" + minut
                            val dtsendDate: String = Datecre + " " + Timecre

                            val Datesub: String =dtsendDate
                            val inputPattern = "dd/MM/yyyy hh:mm"
                            val outputPattern = "dd MMM yyyy hh:mm a"
                            val inputFormat = SimpleDateFormat(inputPattern)
                            val outputFormat = SimpleDateFormat(outputPattern)

                            var date: Date? = null
                            var mainstr: String? = null

                            try {
                                date = inputFormat.parse(Datesub)
                                mainstr = outputFormat.format(date)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }
                            binding.tvEndDate.setText(mainstr)
                            binding.tvEndDate.setError(null)
                        }, mHour, mMinute, false)
                timePickerDialog.show()
//                binding.dobedt.setText("$dayOfMonth/$months/$year")
//                binding.dobedt.setError(null)
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }


        binding.imagesmultiple.setOnClickListener {
            if (checkPermissions()){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODEGallry)
                } else {
                    if(dataimage.equals(0)){
                        dataimage1=10
                    }else{
                        dataimage1=10 -dataimage.toInt()
                    }
                    if(!(imagesUriArrayList.size>dataimage1)) {
                        val intent = Intent()
                        intent.type = "image/*"
                        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                        intent.action = Intent.ACTION_GET_CONTENT
                        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE)
                    }else{
                        displayToast(this, "You can not select more than "+dataimage1 +" images")
                    }
                }
            }
//            else{
//                showAlertDialog()
//            }

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


            //  binding.addimage.setImageBitmap(bitmap)

            Glide.with(this)
                    .load(bitmap)
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile_edit)
                    .into(binding.addimage)


            // getapp_user_edit_profile_pic(Path,downsizedImageBytes,bitmap)
        }else if(resultCode == RESULT_OK && requestCode == PICK_IMAGE_MULTIPLE) {
                   Log.e("++data", "" + data?.clipData?.itemCount) // Get count of image here.
                   Log.e("++count", "" + data?.clipData?.itemCount)

                    if(dataimage.equals(0)){
                        dataimage1=10
                    }else{
                        dataimage1=10-dataimage.toInt()
                    }

                   if(data?.clipData?.itemCount!=null) {
                       if (data.clipData?.itemCount!! > dataimage1) {
                           imagesUriArrayList.clear()
                           displayToast(this, "You can not select more than" +dataimage1+ " images")
                       } else {
                           //imagesUriArrayList.clear()
                           for (i in 0 until data.clipData?.itemCount!!) {
                               imagesUriArrayList.add(data.clipData?.getItemAt(i)?.getUri()!!)
                           }
                           binding.rvGallary1.adapter=null
                           val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
                           binding.rvGallary1.layoutManager =layoutManager
                           val mAdapter = AdapterGallerymultiple(
                                   this,
                                   imagesUriArrayList,this
                           )

                           binding.rvGallary1.adapter = mAdapter


                       }
                   }else{
                       //imagesUriArrayList.clear()
                       imagesUriArrayList.add(data?.data!!)
                       val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
                       binding.rvGallary1.layoutManager =layoutManager
                       val mAdapter = AdapterGallerymultiple(
                               this,
                               imagesUriArrayList,this
                       )

                       binding.rvGallary1.adapter = mAdapter


                   }

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

        var Temp: Boolean?= true
        if (binding.edtTitle.text.toString().length == 0) {
            binding.edtTitle.setError("Field is empty")
            Temp = false
        } else {
            binding.edtTitle.setError(null)
        }

        if (binding.edtFeedback.text.toString().length == 0) {
            binding.edtFeedback.setError("Field is empty")
            Temp = false
        } else {
            binding.edtFeedback.setError(null)
        }

        if (binding.edtvenue.text.toString().length == 0) {
            binding.edtvenue.setError("Field is empty")
            Temp = false
        } else {
            binding.edtvenue.setError(null)
        }

        if (binding.tvStartDate.text.toString().length == 0) {
            binding.tvStartDate.setError("Field is empty")
            Temp = false
        } else {
            binding.tvStartDate.setError(null)
        }

        if (binding.tvEndDate.text.toString().length == 0) {
            binding.tvEndDate.setError("Field is empty")
            Temp = false
        } else {
            binding.tvEndDate.setError(null)
        }

        if (binding.entryFees.text.toString().length == 0) {
            binding.entryFees.setError("Field is empty")
            Temp = false
        } else {
            binding.entryFees.setError(null)
        }

        if (binding.entryFeesgu.text.toString().length == 0) {
            binding.entryFeesgu.setError("Field is empty")
            Temp = false
        } else {
            binding.entryFeesgu.setError(null)
        }

        if (binding.entryFees.text.toString().length != 0) {
            val Edtprise:Int=binding.entryFees.text.toString().toInt()

            if (Edtprise < 1){
                displayToast(this, "0 Price not allow for Member")
                Temp = false
            }
        }

        if (binding.entryFeesgu.text.toString().length != 0) {
            val Edtprise1:Int=binding.entryFeesgu.text.toString().toInt()

            if (Edtprise1 < 1){
                displayToast(this, "0 Price not allow for Guest")
                Temp = false
            }
        }

        if (binding.allocatedtick.text.toString().length == 0) {
            binding.allocatedtick.setError("Field is empty")
            Temp = false
        } else {
            binding.allocatedtick.setError(null)
        }

        if (Path.isEmpty()) {
            displayToast(this, "Add Image")
            Temp = false
        }

        if (areaid.isEmpty()) {
            displayToast(this, "Select your Category")
            Temp = false
        }

        if(dataimage.equals(0)){
            dataimage1=9
        }else{
            dataimage1=10-dataimage.toInt()
        }

         if(imagesUriArrayList.size>dataimage1) {
             displayToast(this, "You can not select more than "+dataimage1 +" images")
             Temp = false
        }

        return Temp!!
    }


    override fun OnClick(position: String, id: String) {
        binding.tvCategory.text = position;
        areaid=id
        binding.ivDropDown.visibility = View.VISIBLE
        binding.ivDropUp.visibility = View.GONE
        binding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());

    }

    private fun getAllEvents(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_category()
        call.enqueue(object : Callback<Eventcategory> {
            override fun onResponse(
                    call: Call<Eventcategory>,
                    response: Response<Eventcategory>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE

                            val mAdapter = AdapterCategoryEvent(
                                    this@UpdateEventsActivity,
                                    response.body()?.data as MutableList<Eventcategory.Eventdata>, this@UpdateEventsActivity
                            )
                            binding.rvCategory.adapter = mAdapter


                        } else {
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE
                        }
                    }else {
                        binding.layoutmanager1.visibility=View.GONE
                        binding.layoutmanager.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Eventcategory>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    private fun app_create_event(attachment:String,typest:String) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            var formData: MultipartBody.Part? = null

            if(attachment.startsWith("https://applex360.co.in/j4e_new/upload/events")){

                val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                formData = MultipartBody.Part.createFormData("event_thumbnail", "", requestBody)

            }else {
                val file = File(attachment)
                val Filenale: String
                Filenale = if (file.name.contains(".png")) {
                    file.name
                } else {
                    file.name + ".png"
                }


                val requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
                formData = MultipartBody.Part.createFormData("event_thumbnail", Filenale, requestBody)
            }

            val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
            val eventidst = RequestBody.create(MediaType.parse("text/plain"), eventid)
            val eventtitle = RequestBody.create(MediaType.parse("text/plain"),binding.edtTitle.text.toString())
            val eventdes = RequestBody.create(MediaType.parse("text/plain"),binding.edtFeedback.text.toString())
            val evebtaddress = RequestBody.create(MediaType.parse("text/plain"),binding.edtvenue.text.toString())
            val reqfunctionalid = RequestBody.create(MediaType.parse("text/plain"),areaid.toString())

            val maxtikit = RequestBody.create(MediaType.parse("text/plain"),binding.allocatedtick.text.toString())
            val tvStartDatest = RequestBody.create(MediaType.parse("text/plain"),binding.tvStartDate.text.toString())
            val tvenddate = RequestBody.create(MediaType.parse("text/plain"),binding.tvEndDate.text.toString())
            val entryFeesst = RequestBody.create(MediaType.parse("text/plain"),binding.entryFees.text.toString())

            val typecreate= RequestBody.create(MediaType.parse("text/plain"), typest)


            val entryFeesgust = RequestBody.create(MediaType.parse("text/plain"),binding.entryFeesgu.text.toString())

            val sdf = SimpleDateFormat("dd MMM yyyy")
            val currentDate = sdf.format(Date())
            val currentDatest = RequestBody.create(MediaType.parse("text/plain"),currentDate)

            val sdf1 = SimpleDateFormat("hh:mm a")
            val currentDate1 = sdf1.format(Date())
            val currentDatest1 = RequestBody.create(MediaType.parse("text/plain"),currentDate1)




            val list: MutableList<MultipartBody.Part> = ArrayList()

            if(imagesUriArrayList.size==0){
                val requestBodyimages = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                list.add(MultipartBody.Part.createFormData("images[]", "", requestBodyimages))
            }else {
                for (i in 0 until imagesUriArrayList.size) {

                    val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imagesUriArrayList.get(i))

                    val scaleWidth: Int = fullBitmap.width / 2
                    val scaleHeight: Int = fullBitmap.height / 2
                    val downsizedImageBytesmulti: ByteArray = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
                    val Pathmulti: String = imagesUriArrayList.get(i).path.toString()


                    val file = File(Pathmulti)
                    val Filenale: String
                    Filenale = if (file.name.contains(".png")) {
                        file.name
                    } else {
                        file.name + ".png"
                    }

                    val requestBodyimages = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytesmulti)
                    list.add(MultipartBody.Part.createFormData("images[]", Filenale, requestBodyimages))

                }
            }


            val call = request.app_update_event(userId,eventidst,eventtitle,eventdes,evebtaddress,formData,tvStartDatest,tvenddate,entryFeesst,maxtikit,currentDatest,currentDatest1,reqfunctionalid,entryFeesgust,typecreate, list)
            showLoader(this);
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                        call: Call<ConnectionDecline>,
                        response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            val returnIntent = Intent()
                            setResult(RESULT_OK, returnIntent)
                            finish()
                            displayToast(this@UpdateEventsActivity, response.body()?.message.toString())

                        }else{
                            displayToast(this@UpdateEventsActivity, response.body()?.message.toString())
                        }

                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()

                }
            })
        }
    }

    override fun OnClick(position: Int) {
        imagesUriArrayList.removeAt(position)
        val mAdapter = AdapterGallerymultiple(
            this,
            imagesUriArrayList,this
        )

        binding.rvGallary1.adapter = mAdapter
        binding.rvGallary1.adapter?.notifyDataSetChanged()

    }

    private fun getEventsDeatils(eventid:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_detail(eventid, readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(
                call: Call<EventDetails>,
                response: Response<EventDetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            Glide.with(this@UpdateEventsActivity)
                                .load(response.body()?.data?.get(0)?.event_data?.event_thumbnil)
                                .into(binding.addimage)

                            Path= response.body()?.data?.get(0)?.event_data?.event_thumbnil!!.toString()

                            binding.edtTitle.setText(response.body()?.data?.get(0)?.event_data?.event_title)
                            binding.edtFeedback.setText(response.body()?.data?.get(0)?.event_data?.event_description)

                            binding.edtvenue.setText(response.body()?.data?.get(0)?.event_data?.event_address)


                            val Datesub: String = response.body()?.data?.get(0)?.event_data?.event_startdate!!
                            val inputPattern = "EEE,dd MMM yyyy hh:mm a"
                            val outputPattern = "dd MMM yyyy hh:mm a"
                            val inputFormat = SimpleDateFormat(inputPattern)
                            val outputFormat = SimpleDateFormat(outputPattern)

                            var date: Date? = null
                            var mainstr: String? = null

                            try {
                                date = inputFormat.parse(Datesub)
                                mainstr = outputFormat.format(date)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }
                            binding.tvStartDate.setText(mainstr)

                            val Datesub1: String = response.body()?.data?.get(0)?.event_data?.event_enddate!!
                            val inputPattern1 = "EEE,dd MMM yyyy hh:mm a"
                            val outputPattern1 = "dd MMM yyyy hh:mm a"
                            val inputFormat1 = SimpleDateFormat(inputPattern1)
                            val outputFormat1 = SimpleDateFormat(outputPattern1)

                            var date1: Date? = null
                            var mainstr1: String? = null

                            try {
                                date1 = inputFormat1.parse(Datesub1)
                                mainstr1 = outputFormat1.format(date1)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }


                            binding.tvEndDate.setText(mainstr1)
                            binding.entryFees.setText(response.body()?.data?.get(0)?.event_data?.event_fees)
                            binding.entryFeesgu.setText(response.body()?.data?.get(0)?.event_data?.event_guest_fees)

                            binding.allocatedtick.setText(response.body()?.data?.get(0)?.event_data?.event_allocated_ticket)


                            if(response.body()?.data?.get(0)?.gallery_data==null) {
                                dataimage ="0"
                            }else{
                                dataimage =response.body()?.data?.get(0)?.gallery_data!!.size.toString()
                                val layoutManager = LinearLayoutManager(this@UpdateEventsActivity, RecyclerView.HORIZONTAL, false)
                                binding.rvGallary.layoutManager =layoutManager
                                val mAdapter = AdapterGalleryUpdate(
                                    this@UpdateEventsActivity,
                                    response.body()?.data?.get(0)?.gallery_data as MutableList<EventDetails.Alleventsdata.Gallerydata>
                                )

                                binding.rvGallary.adapter = mAdapter
                            }



                            binding.tvCategory.text = response.body()?.data?.get(0)?.event_data?.event_cat_name
                            areaid= response.body()?.data?.get(0)?.event_data?.event_cat_id!!.toString()


                        }
                    }else{
                        PermissionDialog(response.body()?.msg.toString())
                    }

                    getAllEvents()
                }
            }

            override fun onFailure(call: Call<EventDetails>, t: Throwable) {
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
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
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