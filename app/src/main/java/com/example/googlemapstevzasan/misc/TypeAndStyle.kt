package com.example.googlemapstevzasan.misc

import android.content.Context
import android.util.Log
import com.example.googlemapstevzasan.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class TypeAndStyle {
     fun setMapStyle(googleMap: GoogleMap,context:Context) {
        try {
            val success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style))
            if (!success) {
                Log.d("Maps", "Failed to add style")
            }
        } catch (e: Exception) {
            Log.d("Maps", e.toString())
        }
    }
}