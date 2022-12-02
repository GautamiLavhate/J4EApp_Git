package com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model

data class AllMemberResponse(
    val count_available: Int,
    val `data`: Data,
    val msg: String,
    val status: Boolean
)