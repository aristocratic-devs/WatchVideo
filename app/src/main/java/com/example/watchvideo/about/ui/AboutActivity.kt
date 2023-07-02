package com.example.watchvideo.about.ui

import com.example.watchvideo.BuildConfig
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityAboutBinding

class AboutActivity : BaseActivity<ActivityAboutBinding>(R.layout.activity_about) {

    override fun init() {
        binding.ivback.setOnClickListener { onBackPressed() }
        binding.tvVersion.setText(BuildConfig.VERSION_NAME)
    }

}