package com.example.googlemapstevzasan.misc

import android.graphics.Color
import com.example.googlemapstevzasan.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay

class Shapes {
    val losAngeles = LatLng(34.09, -118.24)
    val newYork = LatLng(40.71, -74.00)
    val margilan = LatLng(40.481318651799825, 71.72316750007317)

    val p1=LatLng(45.17246318933695, 57.663534822373045)
    val p2=LatLng(37.53380839626406, 56.60884732824672)
    val p3=LatLng(48.303394577301496, 65.92525352636257)
    val p4=LatLng(40.00038424579706, 70.14400350286786)

    val mangolia = LatLng(46.77191876254289, 104.72199165627387)
    val russian = LatLng(62.277139217497016, 99.32069459795063)

    suspend fun addPolyline(mMap: GoogleMap) {
    val pattern= listOf(Dot(),Gap(30f),Dash(50f))
        val polyline = mMap.addPolyline(
            PolylineOptions().apply {
                add(losAngeles, newYork, margilan)
                width(50f)
                pattern(pattern)
                color(Color.BLUE)
                geodesic(true)
                clickable(true)
            }
        )
        delay(5000)
        val newList = listOf(losAngeles, mangolia, russian)
        polyline.points = newList
    }
    fun addPoLygon(map:GoogleMap){
        val polygon=map.addPolygon(
            PolygonOptions().apply {
                add(p1,p2,p3,p4)
                fillColor(Color.BLUE)
                strokeColor(Color.RED)
            }
        )
    }
    suspend fun addCircle(map:GoogleMap){
        val circle=map.addCircle(
            CircleOptions().apply {
                center(losAngeles)
                radius(50000.0)
                fillColor(R.color.purple_500)
                strokeColor(R.color.purple_500)
            }
        )
        delay(4000L)
        circle.fillColor=R.color.black
    }
}