package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMapsEventsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsEventsActivity : BaseActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsEventsBinding

    private lateinit var mMap: GoogleMap
    lateinit var location: String
    lateinit var lat: String
    lateinit var long: String
    lateinit var Backtype:String
    lateinit var position:String

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps_events)
        binding.toolbar.tvTitle.text = "Address"
        Backtype = intent.getStringExtra("Back").toString()
        lat = intent.getStringExtra("lat").toString()
        long = intent.getStringExtra("long").toString()
        position=intent.getStringExtra("position").toString()
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        location=intent.getStringExtra("location").toString()

        binding.toolbar.backImageView.setOnClickListener {
            onBackPressed()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (Backtype == "activity") {

        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("type", "MyEvents")
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val sydney = LatLng(lat.toDouble(), long.toDouble())
        mMap.addMarker(MarkerOptions().position(sydney).title(location))
       /* mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        // For zooming automatically to the location of the marker
        val cameraPosition = CameraPosition.Builder().target(sydney).zoom(12f).build()
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

    }
}