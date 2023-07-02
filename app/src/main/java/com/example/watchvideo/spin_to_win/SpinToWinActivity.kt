package com.example.watchvideo.spin_to_win

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivitySpinToWinBinding
import com.example.watchvideo.utils.luck_spin.LuckyWheelView
import com.example.watchvideo.utils.luck_spin.model.LuckyItem

class SpinToWinActivity : BaseActivity<ActivitySpinToWinBinding>(R.layout.activity_spin_to_win) {
    private val rewards: ArrayList<LuckyItem> = arrayListOf()
    var index: Int = 0

    override fun init() {

        for (i in 2..13) {
            rewards.add(LuckyItem(i))
        }

        setData()

        setClickListeners()

    }

    fun setData() {

        binding.luckyWheelNumber.setData(rewards)
        binding.luckyWheelNumber.setRound(10)

        binding.luckyWheelNumber.startLuckyWheelWithTargetIndex(index)

        binding.luckyWheelNumber.setLuckyRoundItemSelectedListener {

            index = it

        }


    }

    fun setClickListeners() {

        binding.btnSinHere.setOnClickListener {
            binding.luckyWheelNumber.startLuckyWheelWithRandomTarget()
        }

    }

}