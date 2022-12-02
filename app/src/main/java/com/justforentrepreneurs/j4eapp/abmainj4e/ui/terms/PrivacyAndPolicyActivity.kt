package com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms

import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.model.TandCResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.databinding.ActivityPrivacyAndPolicyBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PrivacyAndPolicyActivity : BaseActivity() {
    private lateinit var binding:ActivityPrivacyAndPolicyBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_privacy_and_policy)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.privacy_policy)
        getPrivacyAndPolicy()
    }

    private fun getPrivacyAndPolicy(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_privacy_policy()
        call.enqueue(object : Callback<TandCResponse> {
            override fun onResponse(
                call: Call<TandCResponse>,
                response: Response<TandCResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        binding.txtTandC.text=
                            HtmlCompat.fromHtml(response.body()?.data.toString(),0)
                    }
                }
            }

            override fun onFailure(call: Call<TandCResponse>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    override fun enablePresence(): Boolean {
        return true
    }
}