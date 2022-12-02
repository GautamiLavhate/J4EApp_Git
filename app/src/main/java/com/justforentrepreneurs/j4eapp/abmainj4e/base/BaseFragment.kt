package com.justforentrepreneurs.j4eapp.abmainj4e.base

import androidx.fragment.app.Fragment
import com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager
import org.koin.android.ext.android.get

open class BaseFragment : Fragment() {
    protected val dataManager: DataManager = get()
}
