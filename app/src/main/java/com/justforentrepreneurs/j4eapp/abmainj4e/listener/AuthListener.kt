package com.justforentrepreneurs.j4eapp.abmainj4e.listener

interface AuthListener {

    fun authData(socialType: String, loginDataHashMap: HashMap<String, String>)

}