package com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.AllPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.SubScribeAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.model.TandCResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.databinding.ActivityTermsAndConditionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TermsAndConditionActivity : BaseActivity() {
    private lateinit var binding:ActivityTermsAndConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_terms_and_condition)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.label_terms_condition)

        getTermsAndCondition()
    }

    private fun getTermsAndCondition(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_terms_and_condition()
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