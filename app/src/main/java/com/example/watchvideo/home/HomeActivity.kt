package com.example.watchvideo.home

import com.example.watchvideo.LuckySpinActivity
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.daily_check.ui.DailyCheckActivity
import com.example.watchvideo.databinding.ActivityHomeBinding
import com.example.watchvideo.great_video.GreatVideo
import com.example.watchvideo.scratch_card.ScratchActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun init() {

        setClickListeners()

    }

    private fun setClickListeners() {

        binding.llDailyCheck.setOnClickListener {
            startActivity(DailyCheckActivity::class.java)
        }
        binding.llGreatVideo.setOnClickListener {
            startActivity(GreatVideo::class.java)

        }
        binding.llWithdraw.setOnClickListener {


        }
        binding.llRandomCall.setOnClickListener {


        }

        binding.llScratchCard.setOnClickListener {
            startActivity(ScratchActivity::class.java)

        }
        binding.llSpinToWin.setOnClickListener {
            startActivity(LuckySpinActivity::class.java)


        }
        binding.llFlipCard.setOnClickListener {


        }
        binding.llExtraCoin.setOnClickListener {


        }
        binding.llLyricalVideo.setOnClickListener {


        }
        binding.llReferalCode.setOnClickListener {


        }
        binding.llInviteFriends.setOnClickListener {


        }
        binding.llRate.setOnClickListener {

        }

    }


}