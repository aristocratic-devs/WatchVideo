package com.example.watchvideo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.example.watchvideo.network.model.Ads
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Calendar

fun isConnectedInternet(context: Context): Boolean {
    return try {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED
        ) {
            //we are connected to a network
            true
        } else {
            Toast.makeText(
                context,
                "Please Check Your Internet Connectivity.. and try Again",
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    } catch (e: Exception) {
        Toast.makeText(
            context,
            "Please Check Your Internet Connectivity.. and try Again",
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}

fun findDaysDiff(unixStartTime: Long, unixEndTime: Long): Int {
    val calendar1 = Calendar.getInstance()
    calendar1.timeInMillis = unixStartTime
    calendar1[Calendar.HOUR_OF_DAY] = 0
    calendar1[Calendar.MINUTE] = 0
    calendar1[Calendar.SECOND] = 0
    calendar1[Calendar.MILLISECOND] = 0
    val calendar2 = Calendar.getInstance()
    calendar2.timeInMillis = unixEndTime
    calendar2[Calendar.HOUR_OF_DAY] = 0
    calendar2[Calendar.MINUTE] = 0
    calendar2[Calendar.SECOND] = 0
    calendar2[Calendar.MILLISECOND] = 0
    return ((calendar2.timeInMillis - calendar1.timeInMillis) / (24 * 60 * 60 * 1000)).toInt()
}
