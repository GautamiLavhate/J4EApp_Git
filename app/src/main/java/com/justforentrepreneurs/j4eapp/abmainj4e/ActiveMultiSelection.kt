package com.justforentrepreneurs.j4eapp.abmainj4e


import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies

interface ActiveMultiSelection {
    fun addMultiSelection(multiModel: AllBuddies)
    fun removeMultiSelection(multiModel: AllBuddies,id:String)
}