package com.example.watchvideo.daily_check.ui

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityDailyCheckBinding
import com.example.watchvideo.utils.findDaysDiff
import java.util.Calendar
import java.util.Date


class DailyCheckActivity : BaseActivity<ActivityDailyCheckBinding>(R.layout.activity_daily_check) {

    lateinit var animation: Animation

    override fun init() {

        animation = AnimationUtils.loadAnimation(
            applicationContext, R.anim.bounce
        )


        updateAnimation()
        setClickListeners()
    }

    private fun updateAnimation() {

        binding.atvCoinValue.text = getSharedPrefs().getAmount().toString()

        binding.rlDay1.clearAnimation()
        binding.rlDay2.clearAnimation()
        binding.rlDay3.clearAnimation()
        binding.rlDay4.clearAnimation()
        binding.rlDay5.clearAnimation()
        binding.rlDay6.clearAnimation()
        binding.rlDay7.clearAnimation()

        when (getSharedPrefs().getLastCheckInDay()) {

            1 -> {
                binding.rlDay1.startAnimation(animation)
                binding.rlDay1.isClickable = true
            }

            2 -> {
                binding.rlDay2.startAnimation(animation)
                binding.rlDay2.isClickable = true
            }

            3 -> {
                binding.rlDay3.startAnimation(animation)
                binding.rlDay3.isClickable = true
            }

            4 -> {
                binding.rlDay4.startAnimation(animation)
                binding.rlDay5.isClickable = true
            }

            5 -> {
                binding.rlDay5.startAnimation(animation)
                binding.rlDay5.isClickable = true
            }

            6 -> {
                binding.rlDay6.startAnimation(animation)
                binding.rlDay6.isClickable = true
            }

            7 -> {
                binding.rlDay7.startAnimation(animation)
                binding.rlDay7.isClickable = true
            }

        }

    }

    private fun setClickListeners() {

        binding.rlDay1.setOnClickListener {
            claimRewardForDay(1)
        }
        binding.rlDay2.setOnClickListener {
            claimRewardForDay(2)
        }
        binding.rlDay3.setOnClickListener {
            claimRewardForDay(3)
        }
        binding.rlDay4.setOnClickListener {
            claimRewardForDay(4)
        }
        binding.rlDay5.setOnClickListener {
            claimRewardForDay(5)
        }
        binding.rlDay6.setOnClickListener {
            claimRewardForDay(6)
        }
        binding.rlDay7.setOnClickListener {
            claimRewardForDay(7)
        }

    }

    private fun canClaimToday(): Boolean {
        return (findDaysDiff(getSharedPrefs().getLastCheckInDate().time, Date().time) >= 1)
    }

    private fun claimRewardForDay(day: Int) {

        //todo show ad here

        if (canClaimToday()) {
            showErrorDialog()
            showToast(getString(R.string.cannot_claim_today_please_try_again_tomorrow))
        } else {
            showToast(getString(R.string.reward_claimed))
            showSuccessDialog(day * 100)
            getSharedPrefs().updateCheckInDay(Calendar.getInstance().timeInMillis)
            val nextDay = if (day == 7) {
                1
            } else {
                day + 1
            }

            getSharedPrefs().updateLastCheckInDay(nextDay)
            getSharedPrefs().updateAmountBy(day * 100)
            updateAnimation()

        }
    }


}