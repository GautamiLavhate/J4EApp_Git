package com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions

data class Data(
    val is_buddy_meet_exhausted: Int,
    val is_post_exhausted: Int,
    val is_requirement_exhausted: Int,
    val is_referral_exhausted: Int,
    val view_permission_msg: String,
    val create_permission_msg: String,
    val view_exhausted_msg: String,
    val create_exhausted_msg: String,
    val permissions: List<Permission>
)