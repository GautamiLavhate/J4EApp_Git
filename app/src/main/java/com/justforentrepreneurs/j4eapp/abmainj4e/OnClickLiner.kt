package com.justforentrepreneurs.j4eapp.abmainj4e

import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived
import com.google.android.material.floatingactionbutton.FloatingActionButton


interface OnClickLiner {
    fun onClickPos(pos:Int,value:String,btd: FloatingActionButton,mdata:MutableList<DataReceived>)
    fun onClickDcline(pos:Int,mdata:MutableList<DataReceived>)
}