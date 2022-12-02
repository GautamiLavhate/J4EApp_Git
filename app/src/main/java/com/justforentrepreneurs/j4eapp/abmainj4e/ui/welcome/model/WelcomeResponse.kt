package com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.model

data class WelcomeResponse(
    val `data`: List<Data>,
    val error: String,
    val status: Boolean
)