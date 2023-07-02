package com.example.watchvideo.great_video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityGreatVideoBinding

class GreatVideo : BaseActivity<ActivityGreatVideoBinding>(R.layout.activity_great_video) {


    override fun init() {
        binding.atvCoinValue.text = getSharedPrefs().getAmount().toString()
        binding.ivback.setOnClickListener { onBackPressed() }

    }

}