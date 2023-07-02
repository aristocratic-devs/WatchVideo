package com.example.watchvideo.history.ui

import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityHistoryBinding

class HistoryActivity : BaseActivity<ActivityHistoryBinding>(R.layout.activity_history) {

    override fun init() {

        getSharedPrefs().getScratchCardEarning().toString().also { binding.tvScratchCount.text = it }
        binding.tvSlotCount.text = getSharedPrefs().getLuckySlotEarning().toString()
        binding.tvSpinCount.text = getSharedPrefs().getLuckySpinEarning().toString()
        binding.tvFlipCount.text = getSharedPrefs().getExtraEarning().toString()

        setClickListener()
    }

    private fun setClickListener() {
        binding.ivback.setOnClickListener { onBackPressed() }

        binding.qurekaGif.setOnClickListener {
            // TODO: Open Chrome Browser
        }


    }

}