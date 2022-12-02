package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterLeadAllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.BuddiesAll
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class RecommendedEventsActivity : BaseActivity() , ActiveMultiSelection {
    private lateinit var binding: ActivityRecommendedLeadBinding
    var new1st:String= ""
    var new2st:String=""
    lateinit var type:String
    lateinit var eventid:String
    lateinit var eventcatid:String
    lateinit var eventcreate: String

    private lateinit var imageAdapter: AdapterLeadAllBuddies
    var Nodata:String=""
    var Buddesislist: MutableList<AllBuddies> = mutableListOf<AllBuddies>()
    var count_available:Int = -1

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recommended_lead)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.send_to)
        binding.noteTextview.text="Select members to invite"



        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.leaddeatis1.startAnimation(anim)

        recyclerData()

        binding.nextBtd.setOnClickListener {

            if (companyName1.size != 0) {

                    new1st=""
                    new2st=""
                    for (i in companyName1.indices) {
                        new1st =companyName1.get(i).userid
                        new2st = new2st + "," + new1st
                    }
                if(isInternetAvailable(this)) {
                    Recommendeddialogbox(new2st.replaceFirst(",", ""))
                }

            }

        }

        binding.editsearchname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@RecommendedEventsActivity)) {
                        imageAdapter = AdapterLeadAllBuddies(
                            this@RecommendedEventsActivity,
                            Buddesislist,
                            this@RecommendedEventsActivity,count_available)
                        binding.rvAllBuddies.adapter = imageAdapter
                    }
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@RecommendedEventsActivity)) {
                        imageAdapter = AdapterLeadAllBuddies(
                            this@RecommendedEventsActivity,
                            Buddesislist,
                            this@RecommendedEventsActivity,count_available)
                        binding.rvAllBuddies.adapter = imageAdapter
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {

                if (s.length > 0) {
                    binding.rvAllBuddies.setAdapter(null)
                    binding.leaddeatis1.visibility=View.GONE
                    binding.rvAllBuddies.visibility=View.VISIBLE
                    binding.NoLeadInvited.visibility=View.GONE
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedEventsActivity,
                        Buddesislist,
                        this@RecommendedEventsActivity,count_available)
                    binding.rvAllBuddies.adapter = imageAdapter
                    imageAdapter.getEventFilter()?.filter(s)
                } else if (s.length == 0) {
                    binding.rvAllBuddies.setAdapter(null)
                    imageAdapter = AdapterLeadAllBuddies(
                        this@RecommendedEventsActivity,
                        Buddesislist,
                        this@RecommendedEventsActivity,count_available)
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

        eventid=intent.getStringExtra("id").toString()
        type=intent.getStringExtra("type").toString()
        eventcatid=intent.getStringExtra("backType").toString()
        eventcreate=intent.getStringExtra("eventcreate").toString()

        if (isInternetAvailable(this)) {
            getRecommlist()

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

    }

    private fun getRecommlist(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_buddies(readUsingSharedPreference(this, "userid").toString(),"0","0")
       // showLoader(this);
        call.enqueue(object : Callback<BuddiesAll> {
            override fun onResponse(
                    call: Call<BuddiesAll>,
                    response: Response<BuddiesAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            Buddesislist.clear()
                            binding.leaddeatis1.visibility=View.GONE
                            binding.rvAllBuddies.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE

                            for (j in 0 until response.body()?.data!!.size) {

                                if(response.body()?.data?.get(j)?.userid.toString().equals(eventcreate)){

                                }else{
                                    Buddesislist.add(response.body()?.data?.get(j)!!)
                                }

                            }

                            val mAdapter = AdapterLeadAllBuddies(
                                    this@RecommendedEventsActivity,
                                    Buddesislist,
                                    this@RecommendedEventsActivity,count_available)
                            binding.rvAllBuddies.adapter = mAdapter

                        }else{
                            binding.leaddeatis1.visibility=View.GONE
                            binding.rvAllBuddies.visibility=View.GONE
                            binding.NoLeadInvited.visibility=View.VISIBLE
                        }
                    }else{
                    binding.leaddeatis1.visibility=View.GONE
                    binding.rvAllBuddies.visibility=View.GONE
                    binding.NoLeadInvited.visibility=View.VISIBLE
                  }
                }
            }

            override fun onFailure(call: Call<BuddiesAll>, t: Throwable) {
                dismissLoader();

            }
        })

    }


    private fun Recommendeddialogbox(new2st:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())

        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
        val call = request.app_event_invite_byuser(new2st,readUsingSharedPreference(this, "userid").toString(),eventid,currentDate,currentDate1)
        showLoaderf(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@RecommendedEventsActivity,response.body()?.message.toString())
                        val returnIntent = Intent()
                        setResult(RESULT_OK, returnIntent)
                        finish()
                    }else{
                        displayToast(this@RecommendedEventsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

                displayToast(this@RecommendedEventsActivity, resources.getString(R.string.error_something_wrong))
            }
        })
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


}