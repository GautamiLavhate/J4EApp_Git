package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivitySearchHomeBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.model.SearchM
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivityHome : BaseActivity(){
    lateinit var binding: ActivitySearchHomeBinding
    var query:String=""

    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_home)
        binding.lifecycleOwner = this

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.searchrecycler.layoutManager = layoutManager

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.toolbar.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText != "" || newText.length != 0) {
                    query = newText
                    if (isInternetAvailable(this@SearchActivityHome)) {
                        binding.searchrecycler.setAdapter(null)
                        getGetData(query)
                    }
                }else {
                    binding.searchrecycler.setAdapter(null)
                    getGetData("")
                }
                return false
            }
        })
    }

    private fun getGetData(keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_search_data(readUsingSharedPreference(this, "userid").toString(), keyword)
        call.enqueue(object : Callback<SearchM> {
            override fun onResponse(
                    call: Call<SearchM>,
                    response: Response<SearchM>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data?.size != 0) {

                            binding.searchrecycler.visibility = View.VISIBLE
                            binding.NoGuestInvited.visibility = View.GONE

                            val mAdapter = AdapterSearchData(this@SearchActivityHome,
                                    response.body()?.user_data as MutableList<SearchM.UserData>)
                            binding.searchrecycler.adapter = mAdapter

                        }
                    } else {
                        binding.searchrecycler.visibility = View.GONE
                        binding.NoGuestInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<SearchM>, t: Throwable) {
                dismissLoader();
                displayToast(this@SearchActivityHome, this@SearchActivityHome.resources.getString(R.string.error_something_wrong))
            }
        })

    }
}