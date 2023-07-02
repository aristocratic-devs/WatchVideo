package com.example.watchvideo.start_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityStartAppBinding
import com.example.watchvideo.home.HomeActivity

class StartAppActivity : BaseActivity<ActivityStartAppBinding>(R.layout.activity_start_app) {

    override fun init() {

        setClickListeners()

    }

    private fun setClickListeners() {

        binding.ivStartApp.setOnClickListener {

            startActivity(Intent(this, HomeActivity::class.java))
            finish()

        }

    }

}