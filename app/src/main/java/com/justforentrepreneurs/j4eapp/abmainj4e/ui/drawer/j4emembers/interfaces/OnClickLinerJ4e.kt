package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.interfaces

import android.widget.ImageView
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo


interface OnClickLinerJ4e {
    fun onClickPos(pos:Int, mdata:MutableList<Memberinfo>, img:ImageView)
    fun OnClickpro(position: Int,data:String,is_viewed: Int)
}