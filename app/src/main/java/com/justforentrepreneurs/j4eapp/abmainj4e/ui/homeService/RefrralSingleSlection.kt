package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Reffralcategory

interface RefrralSingleSlection {
    fun addMultiSelection(multiModel:MutableList<Reffralcategory.ReffralcategoryData>, pos:Int)
    fun removeMultiSelection(multiModel:MutableList<Reffralcategory.ReffralcategoryData>,id: String,pos:Int)
}