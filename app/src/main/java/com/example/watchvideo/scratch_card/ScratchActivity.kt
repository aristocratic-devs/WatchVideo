package com.example.watchvideo.scratch_card

import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.anupkumarpanwar.scratchview.ScratchView
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityScratchBinding
import java.util.Random
import java.util.concurrent.TimeUnit


class ScratchActivity : BaseActivity<ActivityScratchBinding>(R.layout.activity_scratch) {
    override fun init() {
        val randomCoin = Random().nextInt(301) + 200


        binding.tvValue1.text = "$randomCoin"
        setCoinValue()

        binding
            .ivback.setOnClickListener { onBackPressed() }

        binding.scratchView.setRevealListener(object : ScratchView.IRevealListener {
            override fun onRevealed(scratchView: ScratchView?) {
                showSuccessDialog(randomCoin)
                getSharedPrefs().updateAmountBy(randomCoin)
                setCoinValue()
                binding.rlTime.visibility = View.VISIBLE
                starTimer()
            }

            override fun onRevealPercentChangedListener(scratchView: ScratchView?, percent: Float) {
                if (percent > 50f) {
                    binding.scratchView.reveal()
                }
            }

        })

    }

    private fun setCoinValue() {
        binding.atvCoinValue.text = getSharedPrefs().getAmount().toString()
    }


    val time_in_milliseconds = 25000L
    var countdown_timer = object : CountDownTimer(time_in_milliseconds, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
            binding.atvSecondsValue.text = "Please Wait $seconds Seconds"
        }

        override fun onFinish() {
            binding.scratchView.mask()
            binding.rlTime.visibility = View.GONE
            resetTimer()
        }
    }

    private fun starTimer() {
        countdown_timer.start()
    }


    private fun resetTimer() {
        countdown_timer.cancel()
    }

    override fun onDestroy() {
        resetTimer()
        super.onDestroy()
    }

}