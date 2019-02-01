package br.com.caelum.twittelumappweb.gps

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

class GPS(context: Context) : LocationCallback() {

    private val client = LocationServices.getFusedLocationProviderClient(context)

    private var location: Location? = null


    @SuppressLint("MissingPermission")
    fun fazBusca() {

        val request = LocationRequest()

        request.apply {
            smallestDisplacement = 5.0F
            interval = 2000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        client.requestLocationUpdates(request, this, null)
    }

    fun getCoordenadas(): Pair<Double, Double> {
        val latitude = location?.latitude
        val longitude = location?.longitude

        return Pair(latitude ?: 0.0, longitude ?: 0.0)

    }


    override fun onLocationResult(locationResult: LocationResult?) {
        super.onLocationResult(locationResult)

        location = locationResult?.lastLocation
    }
}