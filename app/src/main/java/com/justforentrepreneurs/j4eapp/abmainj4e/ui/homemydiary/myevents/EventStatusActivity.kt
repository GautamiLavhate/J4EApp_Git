package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Filter
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventStatusBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.EventStatusAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EventStatusActivity : BaseActivity() {
    override fun enablePresence(): Boolean {
        return true
    }
    private lateinit var binding: ActivityEventStatusBinding
    lateinit var eventid:String
    private lateinit var imageAdapter: EventStatusAdapter
    var Nodata:String=""
    var productList: MutableList<EventStatus.EventStatusdata> = mutableListOf<EventStatus.EventStatusdata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_status)
        binding.toolbar.tvTitle.text = "Attending Status"
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)
        setEventStatusData()
    }

    private fun setEventStatusData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.eventStatusRecyclerView.layoutManager = layoutManager
        eventid=intent.getStringExtra("id").toString()

        if (isInternetAvailable(this)) {
            gerEventlist()
        }

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText != "" || newText.length != 0) {
                    if (isInternetAvailable(this@EventStatusActivity)) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.eventStatusRecyclerView.setAdapter(null)
                            binding.NoLeadInvited.visibility = View.GONE
                            binding.eventStatusRecyclerView.visibility = View.VISIBLE
                            imageAdapter = EventStatusAdapter(this@EventStatusActivity, productList)
                            binding.eventStatusRecyclerView.adapter = imageAdapter
                            imageAdapter.getFilter()?.filter(newText)

                          /*  if (Nodata.equals("yes")){
                                binding.NoLeadInvited.visibility = View.GONE
                                binding.eventStatusRecyclerView.visibility = View.VISIBLE

                            } else {
                                binding.eventStatusRecyclerView.visibility = View.GONE
                                binding.NoLeadInvited.visibility = View.VISIBLE
                            }*/
                    }
                }else {
                    binding.eventStatusRecyclerView.setAdapter(null)
                    if(isInternetAvailable(this@EventStatusActivity)) {
                        gerEventlist()
                    }
                }
                return false
            }
        })


    }
    private fun gerEventlist(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_event_attending_status_list(eventid)
        call.enqueue(object : Callback<EventStatus> {
            override fun onResponse(
                    call: Call<EventStatus>,
                    response: Response<EventStatus>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            productList.clear()
                            for (i in 0 until (response.body()?.data as MutableList<EventStatus.EventStatusdata>).size) {
                                if (response.body()?.data?.get(i)?.username.equals(null)) {

                                }else{
                                    productList.add(response.body()?.data?.get(i)!!)
                                }
                            }
                            binding.linearlayout1.visibility = View.GONE
                            binding.eventStatusRecyclerView.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            imageAdapter = EventStatusAdapter(this@EventStatusActivity, productList)
                            binding.eventStatusRecyclerView.adapter = imageAdapter

                        }
                    }else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.eventStatusRecyclerView.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<EventStatus>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    class ContactFiltershareHelper(productList: MutableList<EventStatus.EventStatusdata>, productlistRecycleviewAdapter: EventStatusAdapter) : Filter() {
        var productList: MutableList<EventStatus.EventStatusdata>
        private val imageAdapter: EventStatusAdapter
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterResults = FilterResults()
            if (constraint != null && constraint.length > 0) {
                constraint.toString().toUpperCase()
                val filteredList: MutableList<EventStatus.EventStatusdata> = ArrayList<EventStatus.EventStatusdata>()
                for (i in productList.indices) {
                    val content: EventStatus.EventStatusdata = productList[i] as EventStatus.EventStatusdata
                    if (content.username.toLowerCase().contains(constraint.toString().toLowerCase())) {
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
            imageAdapter.setProduct(results.values as MutableList<EventStatus.EventStatusdata>)
            imageAdapter.refresh()
        }

        init {
            this.productList = productList
            imageAdapter = productlistRecycleviewAdapter
        }
    }

}