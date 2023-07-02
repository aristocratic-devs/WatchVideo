package com.example.watchvideo.splash.ui

import android.annotation.SuppressLint
import android.content.Intent
import com.example.watchvideo.MainActivity
import com.example.watchvideo.R
import com.example.watchvideo.ads.AdUtils.loadFacebookInter
import com.example.watchvideo.ads.AdUtils.showInterAd
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivitySplashBinding
import com.example.watchvideo.profile.ui.ProfileActivity
import com.facebook.ads.AdSettings

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun init() {

//        Handler().postDelayed({
//
//            moveNextScreen()
//        }, 1000)

        AdSettings.addTestDevice("5e42273f-8475-47e7-9728-6b65ff07172b");

        loadFacebookInter(context, onAdLoaded = {
            showInterAd(context) {
                moveNextScreen()
            }
        }, onAdDismiss = {
            moveNextScreen()
        })

    }

    private fun moveNextScreen() {
        startActivity(Intent(context, MainActivity::class.java))
        finish()
    }

}