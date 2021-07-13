package com.example.googlemapstevzasan

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.example.googlemapstevzasan.misc.CameraAndViewport
import com.example.googlemapstevzasan.misc.TypeAndStyle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private lateinit var mMap: GoogleMap

    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(40.44631712710847, 71.73140724612104)
        val newYork = LatLng(40.71, -74.00)
        val sydneyMarker =
            mMap.addMarker(MarkerOptions().position(newYork).title("Marker in Margilan"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
        //mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.losAngeles))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newYork, 10f))
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isZoomGesturesEnabled = true
            isScrollGesturesEnabled = true
            isRotateGesturesEnabled = true
            isMyLocationButtonEnabled = true
            isMapToolbarEnabled = true
        }
        mMap.setOnMarkerDragListener(this)
        // mMap.setOnMarkerClickListener(this)
//        lifecycleScope.launch {
//            delay(7000L)
//            mMap.moveCamera(CameraUpdateFactory.zoomBy(3f))
//        }
//        CoroutineScope(Dispatchers.Main).launch {
//            delay(7000L)
//            mMap.moveCamera(CameraUpdateFactory.zoomBy(3f))
//        }
//        lifecycleScope.launch {
//            delay(8000L)
//            mMap.moveCamera(CameraUpdateFactory.scrollBy(100f,0f))
//        }

        lifecycleScope.launch {
            delay(4000L)
//            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(cameraAndViewport.margilanBounds,100),2000,null)
//            mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.margilanBounds)
            mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraAndViewport.newyork),
                2000,
                object : GoogleMap.CancelableCallback {
                    override fun onFinish() {
                        Toast.makeText(this@MapsActivity, "Finished", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCancel() {
                        Toast.makeText(this@MapsActivity, "Cancelled", Toast.LENGTH_SHORT).show()

                    }

                })
        }
        //typeAndStyle.setMapStyle(mMap, this)
//        mMap.setMinZoomPreference(15f)
//        mMap.setMaxZoomPreference(17f)
        onMapClicked()
        onMapLongClicked()
    }

    fun onMapClicked() {
        mMap.setOnMapClickListener {
            Toast.makeText(this, "Single click", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMapLongClicked() {
        mMap.setOnMapLongClickListener {
            Toast.makeText(this, "${it.longitude} ${it.latitude}", Toast.LENGTH_SHORT).show()
            mMap.addMarker(MarkerOptions().position(it).title("${it.longitude} ${it.latitude}"))
        }
    }

    override fun onMarkerDragStart(p0: Marker?) {
        Log.d("Drag", "Start")
    }

    override fun onMarkerDrag(p0: Marker?) {
        Log.d("Drag", "Drag")

    }

    override fun onMarkerDragEnd(p0: Marker?) {

        Log.d("Drag", "End")
    }

    //    override fun onMarkerClick(marker: Marker?): Boolean {
//        if (marker!=null){
//            Log.d("Marker",marker.tag as String)
//        }
//        else{
//            Log.d("Marker","empty")
//        }
//        return true
//    }
//    private fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
//        val vectorDrawable: Drawable? =ResourcesCompat.getDrawable(resources,id,null)
//        if (vectorDrawable==null){
//            Log.d("MapsActivity","Resource not found")
//            return BitmapDescriptorFactory.defaultMarker()
//        }
//    }
}