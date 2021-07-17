package com.example.googlemapstevzasan

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay

class Functions {
//    fun onMapClicked() {
//        mMap.setOnMapClickListener {
//            Toast.makeText(this, "Single click", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    fun onMapLongClicked() {
//        mMap.setOnMapLongClickListener {
//            Toast.makeText(this, "${it.longitude} ${it.latitude}", Toast.LENGTH_SHORT).show()
//            mMap.addMarker(MarkerOptions().position(it).title("${it.longitude} ${it.latitude}"))
//        }
//    }
//private fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
//    val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(resources, id, null)
//    if (vectorDrawable == null) {
//        Log.d("MapsActivity", "Resource not found")
//        return BitmapDescriptorFactory.defaultMarker()
//    }
//    val bitmap = Bitmap.createBitmap(
//        vectorDrawable.intrinsicWidth,
//        vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
//    )
//    val canvas= Canvas(bitmap)
//    vectorDrawable.setBounds(0,0,canvas.width,canvas.height)
//    DrawableCompat.setTint(vectorDrawable,color)
//    vectorDrawable.draw(canvas)
//    return BitmapDescriptorFactory.fromBitmap(bitmap)
//}

    //convert png to bitmap
//    val b:Bitmap= BitmapFactory.decodeResource(resources,R.drawable.taxi)
//    val smallMarker:Bitmap= Bitmap.createScaledBitmap(b,150,150,false)
//    val smallMarkerIcon:BitmapDescriptor=BitmapDescriptorFactory.fromBitmap(smallMarker)


    // function create poliline
//    private fun addPolyline() {
//        val polyline=mMap.addPolyline(
//            PolylineOptions().apply {
//                add(losAngeles,newYork)
//                width(5f)
//                color(Color.BLUE)
//            }
//        )
//    }

//    private suspend fun addPolyline() {
//        val polyline=mMap.addPolyline(
//            PolylineOptions().apply {
//                add(losAngeles,newYork,margilan)
//                width(5f)
//                color(Color.BLUE)
//                geodesic(true)
//            }
//        )
//        delay(5000)
//        val newList= listOf(losAngeles,mangolia,russian)
//        polyline.points=newList
//    }
}