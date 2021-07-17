package com.example.googlemapstevzasan

import android.Manifest
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.scaleMatrix
import androidx.lifecycle.lifecycleScope
import com.example.googlemapstevzasan.misc.CameraAndViewport
import com.example.googlemapstevzasan.misc.CustomInfoAdapter
import com.example.googlemapstevzasan.misc.Shapes
import com.example.googlemapstevzasan.misc.TypeAndStyle
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnPolylineClickListener,
    GoogleMap.OnMyLocationButtonClickListener {

    private lateinit var mMap: GoogleMap
    var locationmanager: LocationManager? = null
    lateinit var fusedLocationClient: FusedLocationProviderClient
    val newYork = LatLng(40.71, -74.00)
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }
    private val shapes by lazy { Shapes() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        locationmanager = getSystemService(LOCATION_SERVICE) as LocationManager?
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    private fun showGPSDisabledAlertToUser() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage("GPS is disabled in your device.Would you like to enable it")
            .setCancelable(false)
            .setPositiveButton("Goto settings Page to Enable GPS",
                object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        val intent =
                            Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                        startActivity(intent)
                    }
                })
            .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.cancel()
                }
            })
        val alert: AlertDialog = alertDialog.create()
        alert.show()
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

//        int height = 100;
//        int width = 100;
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable. marker);
//        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
//        BitmapDescriptor smallMarkerIcon = BitmapDescriptorFactory.fromBitmap(smallMarker)
        val b: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.taxi)
        val smallMarker: Bitmap = Bitmap.createScaledBitmap(b, 90, 90, false)
        val smallMarkerIcon: BitmapDescriptor = BitmapDescriptorFactory.fromBitmap(smallMarker)

        mMap.setInfoWindowAdapter(CustomInfoAdapter(this))
        val sydneyMarker =
            mMap.addMarker(MarkerOptions().position(shapes.losAngeles).title("Marker in Margilan"))
                // .setIcon(fromVectorToBitmap(R.drawable.ic_baseline_directions_car_24,Color.parseColor("#000099")))
                .setIcon(smallMarkerIcon)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(shapes.losAngeles, 6f))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
        //mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.losAngeles))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newYork, 10f))
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isZoomGesturesEnabled = true
            isScrollGesturesEnabled = true
            isRotateGesturesEnabled = true
            isMyLocationButtonEnabled = true
            isMapToolbarEnabled = false
            isMyLocationButtonEnabled = true
        }


//        lifecycleScope.launch {
//        shapes.addPolyline(mMap)
//        }
//        mMap.setOnMarkerDragListener(this)
//        mMap.setOnMarkerClickListener(this)
//        lifecycleScope.launch {
//            shapes.addPolyline(mMap)
//        }
//        mMap.setOnPolylineClickListener(this)
        // mMap.setOnMarkerClickListener(this)
        mMap.setOnMyLocationButtonClickListener(this)

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

//        lifecycleScope.launch {
//            delay(4000L)
////            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(cameraAndViewport.margilanBounds,100),2000,null)
////            mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.margilanBounds)
//            mMap.animateCamera(
//                CameraUpdateFactory.newCameraPosition(cameraAndViewport.newyork),
//                2000,
//                object : GoogleMap.CancelableCallback {
//                    override fun onFinish() {
//                        Toast.makeText(this@MapsActivity, "Finished", Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onCancel() {
//                        Toast.makeText(this@MapsActivity, "Cancelled", Toast.LENGTH_SHORT).show()
//
//                    }
//
//                })
//        }
        //typeAndStyle.setMapStyle(mMap, this)
//        mMap.setMinZoomPreference(15f)
//        mMap.setMaxZoomPreference(17f)
//        onMapClicked()
//        onMapLongClicked()
        checkLocationPermision()
    }

    fun requestPermision() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            1
        )
    }


    fun checkLocationPermision() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
            Toast.makeText(this, "Already enabled", Toast.LENGTH_SHORT).show()
        } else {
            requestPermision()
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != 1) {
            return
        }
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
        } else {
            Toast.makeText(this, "We need your permission", Toast.LENGTH_SHORT).show()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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
    private fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
        val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(resources, id, null)
        if (vectorDrawable == null) {
            Log.d("MapsActivity", "Resource not found")
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        DrawableCompat.setTint(vectorDrawable, color)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onMarkerClick(mmarker: Marker?): Boolean {
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20f), 3000, null)
        return false
    }


    override fun onPolylineClick(p0: Polyline?) {
        Toast.makeText(this, p0?.color.toString(), Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("MissingPermission")
    override fun onMyLocationButtonClick(): Boolean {
        if (locationmanager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            Toast.makeText(this, "GPS is enabled in your device", Toast.LENGTH_SHORT).show()
            fusedLocationClient.lastLocation.addOnSuccessListener {
                val location=LatLng(it.latitude.toFloat().toDouble(),
                    it.longitude.toFloat().toDouble()
                )
                lifecycleScope.launch {

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,10f),5000,null)
                }
            }
            return true
        } else {
            showGPSDisabledAlertToUser()
            return true
        }
    }
}