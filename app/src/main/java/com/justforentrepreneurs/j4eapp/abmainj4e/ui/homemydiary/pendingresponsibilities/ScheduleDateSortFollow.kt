package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities

import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ScheduleDateSortFollow : Comparator<FollowUp.UserData> {

    open fun getDate(dateInString: String): Date? {
        val formatter = SimpleDateFormat("MMM yyyy", Locale.getDefault())
        val formatter1 = SimpleDateFormat("MMM yyyy", Locale.getDefault())
        try {
            val date = formatter.parse(dateInString)
            return formatter1.parse(formatter.format(date))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    override fun compare(o1: FollowUp.UserData, o2: FollowUp.UserData): Int {
        return if (o1.monthname == null || o2.monthname == null) 0 else getDate(o1.monthname)!!.compareTo(getDate(o2.monthname))
    }
}

