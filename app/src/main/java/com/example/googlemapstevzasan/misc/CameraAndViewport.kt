package com.example.googlemapstevzasan.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {
    val newyork: CameraPosition? = CameraPosition.Builder()
        .target(LatLng(40.71,-74.00))
        .zoom(17f)
        .bearing(45f)
        .tilt(45f)
        .build()
    val margilanBounds = LatLngBounds(
        LatLng(40.42697002875741, 71.68563335190474),//SW
        LatLng(40.50084996385694, 71.79924776786586)//NE
    )
}