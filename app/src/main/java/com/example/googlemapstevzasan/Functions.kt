package com.example.googlemapstevzasan

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions

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
}