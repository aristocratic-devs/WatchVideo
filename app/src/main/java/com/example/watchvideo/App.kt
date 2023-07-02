package com.example.watchvideo

import android.app.Application
import com.example.watchvideo.network.retrofit.AdsRetrofitClient
import com.example.watchvideo.network.retrofit.AdsRetrofitService
import com.example.watchvideo.utils.SharedPrefs
import com.facebook.ads.AudienceNetworkAds

class App : Application() {

    var service: AdsRetrofitService? = null

    companion object {
        private lateinit var instance: App

        fun getInstance(): App {
            return instance
        }

        // Initialize the Audience Network SDK
    }


    override fun onCreate() {
        super.onCreate()

        instance = this
        service = AdsRetrofitClient.getService()
        SharedPrefs(this)

        AudienceNetworkAds.initialize(this)
    }


}