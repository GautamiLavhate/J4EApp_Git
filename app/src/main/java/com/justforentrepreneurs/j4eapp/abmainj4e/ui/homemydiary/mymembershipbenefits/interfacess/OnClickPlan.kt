package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan

interface OnClickPlan {
    fun onClickPos(pos:Int, mdata:MutableList<Dataplan>,cost:String,membership_type:String)
}