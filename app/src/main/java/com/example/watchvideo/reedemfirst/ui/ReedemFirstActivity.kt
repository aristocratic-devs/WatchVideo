package com.example.watchvideo.reedemfirst.ui

import android.content.Intent
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityReedemFirstBinding
import com.example.watchvideo.reedempay.ui.ReedemPayActivity

class ReedemFirstActivity :
    BaseActivity<ActivityReedemFirstBinding>(R.layout.activity_reedem_first) {

    override fun init() {

        val ammount = getSharedPrefs().getAmount()
        binding.atvCoinValue.text = ammount.toString()

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.rlAmazonGift.setOnClickListener {
            moveToPayActivity("Amazon")
        }
        binding.rlXboxGift.setOnClickListener {
            moveToPayActivity("Xbox")
        }
        binding.rlPaypalGift.setOnClickListener {
            moveToPayActivity("Paypal")
        }
        binding.rlItunesGift.setOnClickListener {
            moveToPayActivity("Itunes")
        }
        binding.rlGooglePlayGift.setOnClickListener {
            moveToPayActivity("Google_Play")
        }
        binding.rlPlayStationGift.setOnClickListener {
            moveToPayActivity("Play_Station")
        }
        binding.rlSteamWalletGift.setOnClickListener {
            moveToPayActivity("Steam_Wallet")
        }
        binding.rlVisaGift.setOnClickListener {
            moveToPayActivity("Visa")
        }
        binding.rlPaytmGift.setOnClickListener {
            moveToPayActivity("Paytm")
        }
    }

    private fun moveToPayActivity(type: String) {
        startActivity(Intent(context, ReedemPayActivity::class.java).putExtra("is_from", type))
    }

}