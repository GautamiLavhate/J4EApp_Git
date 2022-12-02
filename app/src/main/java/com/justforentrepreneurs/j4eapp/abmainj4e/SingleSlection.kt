package com.justforentrepreneurs.j4eapp.abmainj4e


import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory

interface SingleSlection {
    fun addMultiSelection(multiModel:MutableList<Eventcategory.Eventdata>,pos:Int)
    fun removeMultiSelection(multiModel:MutableList<Eventcategory.Eventdata>,id: String,pos:Int)
}