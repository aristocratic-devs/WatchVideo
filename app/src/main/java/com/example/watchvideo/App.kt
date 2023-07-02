package com.example.watchvideo

import android.app.Application
import com.example.watchvideo.network.retrofit.AdsRetrofitClient
import com.example.watchvideo.network.retrofit.AdsRetrofitService
import com.example.watchvideo.utils.SharedPrefs

class App : Application() {

    var service: AdsRetrofitService? = null

    companion object {
        private lateinit var instance: App

        fun getInstance(): App {
            return instance
        }

    }


    override fun onCreate() {
        super.onCreate()

        instance = this
        service = AdsRetrofitClient.getService()
        SharedPrefs(this)

    }


}