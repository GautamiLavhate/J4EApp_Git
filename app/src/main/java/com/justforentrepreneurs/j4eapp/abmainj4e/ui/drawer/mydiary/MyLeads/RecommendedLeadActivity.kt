package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Filter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.ActiveMultiSelection
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityRecommendedLeadBinding
import com.justforentrepreneurs.j4eapp.databinding.RecommendationpeopleBottomsheetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterRecommendPerson
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterLeadAllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.BuddiesAll
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterRecommendCreatedList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterRecommendExitList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.MyRecommadPeo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.CreateRequirementActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import com.justforentrepreneurs.j4eapp.databinding.RecommandExitListpeopleBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class RecommendedLeadActivity : BaseActivity() , ActiveMultiSelection {

    private lateinit var binding: ActivityRecommendedLeadBinding
    lateinit var requireid:String
    var new1st:String= ""
    var new2st:String=""
    lateinit var type:String
    private lateinit var imageAdapter: AdapterLeadAllBuddies
    var Nodata:String=""
    var Buddesislist: MutableList<AllBuddies> = mutableListOf<AllBuddies>()
    var count_available:Int =-1

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recommended_lead)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.send_to)

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.leaddeatis1.startAnimation(anim)

        recyclerData()

        binding.nextBtd.setOnClickListener {
            bottomSheetRecommendPerson()
        }

        binding.editsearchname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedLeadActivity,
                        Buddesislist,
                        this@RecommendedLeadActivity,count_available)
                    binding.rvAllBuddies.adapter = imageAdapter
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedLeadActivity,
                        Buddesislist,
                        this@RecommendedLeadActivity,count_available)
                    binding.rvAllBuddies.adapter = imageAdapter
                }
            }

            override fun afterTextChanged(s: Editable) {

                if (s.length > 0) {
                    binding.rvAllBuddies.setAdapter(null)

                    binding.leaddeatis1.visibility=View.GONE
                    binding.rvAllBuddies.visibility=View.VISIBLE
                    binding.NoLeadInvited.visibility=View.GONE
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedLeadActivity,
                        Buddesislist,
                        this@RecommendedLeadActivity,count_available)
                    binding.rvAllBuddies.adapter = imageAdapter
                    imageAdapter.getFilter()?.filter(s)

                } else if (s.length == 0) {
                    binding.rvAllBuddies.setAdapter(null)
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedLeadActivity,
                        Buddesislist,
                        this@RecommendedLeadActivity,count_available)
                    binding.rvAllBuddies.adapter = imageAdapter
                }
            }
        })
    }


  //  val companyName: MutableList<RecommandList> = mutableListOf<RecommandList>()

    var companyName1: MutableList<AllBuddies> = mutableListOf<AllBuddies>()
    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvAllBuddies.layoutManager = layoutManager

        requireid=intent.getStringExtra("id").toString()
        type=intent.getStringExtra("type").toString()
        if (isInternetAvailable(this)) {
            getRecommlist()

        }


    }

    private fun bottomSheetRecommendPerson() {
        // val dialog = BottomSheetDialog(this, R.style.CustomBottomSheet)
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: RecommendationpeopleBottomsheetBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.recommendationpeople_bottomsheet, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBsRecommendPersonListBinding.rvRecommendPersonList.layoutManager = layoutManager

        val mAdapter = AdapterRecommendPerson(this, companyName1,mBsRecommendPersonListBinding.Confirm)
        mBsRecommendPersonListBinding.rvRecommendPersonList.adapter = mAdapter
        (mBsRecommendPersonListBinding.rvRecommendPersonList.adapter as AdapterRecommendPerson).notifyDataSetChanged()
        dialog.show()
        mBsRecommendPersonListBinding.cancle.setOnClickListener {
            val returnIntent = Intent()
            intent.putExtra("type", type)
            intent.putExtra("id", requireid)
            setResult(RESULT_OK, returnIntent)
            finish()
            dialog.dismiss()
        }
            mBsRecommendPersonListBinding.Confirm.setOnClickListener {

                if (readUsingSharedPreference(this,"PermissionCreateRecommendation").equals("0")){
                    PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                }else{
                    if (companyName1.size != 0) {

                        if(MyRecomvalidation(mBsRecommendPersonListBinding)) {
                            new1st=""
                            new2st=""
                            for (i in companyName1.indices) {
                                new1st =companyName1.get(i).userid
                                new2st = new2st + "," + new1st
                            }
                            Recommendeddialogbox(mBsRecommendPersonListBinding,dialog,new2st.replaceFirst(",",""))
                        }
                    } else {
                        mBsRecommendPersonListBinding.Confirm.background=getResources()?.getDrawable(R.drawable.disable_btd)
                    }
                }

            }


    }

    override fun addMultiSelection(multiModel: AllBuddies) {
        companyName1.add(multiModel)
        binding.nextBtd.setVisibility(View.VISIBLE)
    }

    override fun removeMultiSelection(multiModel: AllBuddies, id: String) {

            try {
                    for (j in 0 until companyName1.size) {
                        if (companyName1.get(j).id.equals(id)) {
                            companyName1.remove(multiModel)
                        }
                    }



                if (companyName1.size != 0) {
                    binding.nextBtd.setVisibility(View.VISIBLE)
                } else {
                    binding.nextBtd.setVisibility(View.GONE)
                }
            } catch (exception: ConcurrentModificationException) {
                // Catch ConcurrentModificationExceptions.
                // Logging.log(exception);
            } catch (throwable: Throwable) {
                // Catch any other Throwables.
                // Logging.log(throwable);
            }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val returnIntent = Intent()
        intent.putExtra("type", type)
        intent.putExtra("id", requireid)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

    private fun getRecommlist(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_buddies(readUsingSharedPreference(this, "userid").toString(),"0","0")

        call.enqueue(object : Callback<BuddiesAll> {
            override fun onResponse(
                    call: Call<BuddiesAll>,
                    response: Response<BuddiesAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.leaddeatis1.visibility=View.GONE
                            binding.rvAllBuddies.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            count_available=response.body()?.count_available!!
                            for (i in 0 until (response.body()?.data as MutableList<AllBuddies>).size) {
                                Buddesislist.add(response.body()?.data?.get(i)!!)
                            }
                            imageAdapter = AdapterLeadAllBuddies(
                                    this@RecommendedLeadActivity,
                                    Buddesislist,
                                    this@RecommendedLeadActivity,count_available)
                            binding.rvAllBuddies.adapter = imageAdapter

                        }else{
                            binding.leaddeatis1.visibility=View.GONE
                            binding.rvAllBuddies.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                        }
                    }
                }
            }

            override fun onFailure(call: Call<BuddiesAll>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    fun MyRecomvalidation(mBsRecommendPersonListBinding: RecommendationpeopleBottomsheetBinding) : Boolean {

        var Temp: Boolean? = true
        if (mBsRecommendPersonListBinding.edtFeedback.text.toString().length == 0) {
            mBsRecommendPersonListBinding.edtFeedback.setError("Field is empty")
            Temp = false
        } else {
            mBsRecommendPersonListBinding.edtFeedback.setError(null)
        }

        return Temp!!
    }

    private fun Recommendeddialogbox(mBsRecommendPersonListBinding: RecommendationpeopleBottomsheetBinding,dialog:BottomSheetDialog,new2st:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
//        displayToast(this,readUsingSharedPreference(this, "userid").toString()+","+
//            new2st+","+mBsRecommendPersonListBinding.edtFeedback.text.toString()+","+requireid+","+currentDate+","+currentDate1)
        val call = request.app_recommend_buddies(
            readUsingSharedPreference(this, "userid").toString(),
            new2st,mBsRecommendPersonListBinding.edtFeedback.text.toString(),requireid,currentDate,currentDate1)
        showLoaderf(this);
        call.enqueue(object : Callback<MyRecommadPeo> {
            override fun onResponse(
                call: Call<MyRecommadPeo>,
                response: Response<MyRecommadPeo>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@RecommendedLeadActivity,response.body()?.message.toString())

                        bottomSheetExitRecommendPersonList(
                            response.body()?.data?.get(0)?.alreadyExist!!,
                            response.body()?.data?.get(0)?.created!!
                        )
                        dialog.dismiss()
                    }else{
                        PermissionDialog(response.body()?.message.toString())
                        displayToast(this@RecommendedLeadActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<MyRecommadPeo>, t: Throwable) {
                dismissLoader();

                displayToast(this@RecommendedLeadActivity, resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun bottomSheetExitRecommendPersonList(exitdata:List<MyRecommadPeo.DataLeadSt.AlreadyExist>,Created:List<MyRecommadPeo.DataLeadSt.Created>) {
        // val dialog = BottomSheetDialog(this, R.style.CustomBottomSheet)
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: RecommandExitListpeopleBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.recommand_exit_listpeople, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        if(exitdata.size==0){
            mBsRecommendPersonListBinding.listexit.visibility=View.GONE
        }else{
            mBsRecommendPersonListBinding.listexit.visibility=View.VISIBLE
        }

        if(Created.size==0){
            mBsRecommendPersonListBinding.createdlist.visibility=View.GONE
        }else{
            mBsRecommendPersonListBinding.createdlist.visibility=View.VISIBLE
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBsRecommendPersonListBinding.rvAlreadyExist.layoutManager = layoutManager

        val mAdapter = AdapterRecommendExitList(this,
            exitdata as MutableList<MyRecommadPeo.DataLeadSt.AlreadyExist>
        )
        mBsRecommendPersonListBinding.rvAlreadyExist.adapter = mAdapter
        (mBsRecommendPersonListBinding.rvAlreadyExist.adapter as AdapterRecommendExitList).notifyDataSetChanged()

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBsRecommendPersonListBinding.rvRCreated.layoutManager = layoutManager1

        val mAdapter1 = AdapterRecommendCreatedList(this,
            Created as MutableList<MyRecommadPeo.DataLeadSt.Created>
        )
        mBsRecommendPersonListBinding.rvRCreated.adapter = mAdapter1
        (mBsRecommendPersonListBinding.rvRCreated.adapter as AdapterRecommendCreatedList).notifyDataSetChanged()

        mBsRecommendPersonListBinding.btdOk.setOnClickListener {
            val returnIntent = Intent()
            intent.putExtra("type", type)
            intent.putExtra("id", requireid)
            setResult(RESULT_OK, returnIntent)
            finish()
            dialog.dismiss()
        }
        dialog.show()
    }


    class ContactFiltershareHelper(productList: MutableList<AllBuddies>, productlistRecycleviewAdapter: AdapterLeadAllBuddies) : Filter() {
        var productList: MutableList<AllBuddies>
        private val imageAdapter: AdapterLeadAllBuddies
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterResults = FilterResults()
            if (constraint != null && constraint.length > 0) {
                constraint.toString().toUpperCase()
                val filteredList: MutableList<AllBuddies> = ArrayList<AllBuddies>()
                for (i in productList.indices) {
                    val content: AllBuddies = productList[i] as AllBuddies
                    if (content.full_name.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(content)
                    }
                }
                filterResults.count = filteredList.size
                filterResults.values = filteredList
            } else {
                filterResults.count = productList.size
                filterResults.values = productList
            }
            return filterResults
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            imageAdapter.setProduct(results.values as MutableList<AllBuddies>)
            imageAdapter.refresh()
        }

        init {
            this.productList = productList
            imageAdapter = productlistRecycleviewAdapter
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
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

}