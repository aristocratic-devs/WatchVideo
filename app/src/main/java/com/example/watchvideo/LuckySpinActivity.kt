package com.example.watchvideo

import android.R.attr.data
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.daily_check.ui.DailyCheckActivity
import com.example.watchvideo.databinding.ActivityLuckySpinBinding
import com.example.watchvideo.scratch_card.ScratchActivity
import com.example.watchvideo.spin_to_win.SpinToWinActivity
import com.example.watchvideo.utils.luck_spin.LuckyWheelView.LuckyRoundItemSelectedListener


class LuckySpinActivity : BaseActivity<ActivityLuckySpinBinding>(R.layout.activity_lucky_spin) {


    override fun init() {
        binding.atvCoinValue.text = getSharedPrefs().getAmount().toString()


        setCLickListeners()

    }


    private fun setCLickListeners() {
        binding.rlSpinwin.setOnClickListener {
            startActivity(SpinToWinActivity::class.java)

        }
        binding.rlGift.setOnClickListener {


        }
        binding.rlDailyBonus.setOnClickListener {
            startActivity(DailyCheckActivity::class.java)
        }

        binding.rlScratchCard.setOnClickListener {
            startActivity(ScratchActivity::class.java)
        }
    }

}