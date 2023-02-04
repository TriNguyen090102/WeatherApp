package com.weatherapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

// TODO (STEP 1 : After creating a project as we are developing a weather app kindly visit the link below.)
// OpenWeather Link : https://openweathermap.org/api

/**
 * The useful link or some more explanation for this app you can checkout this link :
 * https://medium.com/@sasude9/basic-android-weather-app-6a7c0855caf4
 */
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO (STEP 8: Check here whether GPS is ON or OFF using the method which we have created)
        // START
        if (!isLocationEnabled()) {
            Toast.makeText(
                    this,
                    "Your location provider is turned off. Please turn it on.",
                    Toast.LENGTH_SHORT
            ).show()

            // This will redirect you to settings from where you need to turn on the location provider.
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        } else {
            Toast.makeText(
                    this,
                    "Your location provider is already ON.",
                    Toast.LENGTH_SHORT
            ).show()
        }
        // END
    }

    // TODO (STEP 7: Check whether the GPS is ON or OFF)
    // START
    /**
     * A function which is used to verify that the location or GPS is enabled or not.
     */
    private fun isLocationEnabled(): Boolean {

        // This provides access to the system location services.
        val locationManager: LocationManager =
                getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        )
    }
    // END
}
