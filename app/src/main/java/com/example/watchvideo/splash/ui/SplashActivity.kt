package com.example.watchvideo.splash.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivitySplashBinding
import com.example.watchvideo.profile.ui.ProfileActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun init() {
        Handler().postDelayed({
            moveNextScreen()
        }, 1000)
    }

    private fun moveNextScreen() {
        startActivity(Intent(context, ProfileActivity::class.java))
        finish()
    }

}