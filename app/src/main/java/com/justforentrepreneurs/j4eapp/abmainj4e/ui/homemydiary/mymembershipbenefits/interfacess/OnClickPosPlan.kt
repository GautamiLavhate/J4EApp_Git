package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess

import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.google.android.material.bottomsheet.BottomSheetDialog

interface OnClickPosPlan {
    fun onClickPos(pos:Int,mdata:MutableList<Dataplan>,dialog: BottomSheetDialog)
}