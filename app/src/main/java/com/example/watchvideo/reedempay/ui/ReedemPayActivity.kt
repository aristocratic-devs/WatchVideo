package com.example.watchvideo.reedempay.ui

import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityReedemPayBinding

class ReedemPayActivity : BaseActivity<ActivityReedemPayBinding>(R.layout.activity_reedem_pay) {

    var type = ""

    override fun init() {
        type = intent.getStringExtra("is_from").toString()

        when (type) {
            "Amazon" -> {
                binding.iv1.setImageResource(R.drawable.amazon)
                binding.iv2.setImageResource(R.drawable.amazon)
                binding.iv3.setImageResource(R.drawable.amazon)
                binding.iv4.setImageResource(R.drawable.amazon)
                binding.iv5.setImageResource(R.drawable.amazon)
                binding.iv6.setImageResource(R.drawable.amazon)
                binding.iv7.setImageResource(R.drawable.amazon)
                binding.iv8.setImageResource(R.drawable.amazon)
                binding.iv9.setImageResource(R.drawable.amazon)
                binding.iv10.setImageResource(R.drawable.amazon)

                binding.atv1.setText(R.string.amazon_gift_card)
                binding.atv2.setText(R.string.amazon_gift_card)
                binding.atv3.setText(R.string.amazon_gift_card)
                binding.atv4.setText(R.string.amazon_gift_card)
                binding.atv5.setText(R.string.amazon_gift_card)
                binding.atv6.setText(R.string.amazon_gift_card)
                binding.atv7.setText(R.string.amazon_gift_card)
                binding.atv8.setText(R.string.amazon_gift_card)
                binding.atv9.setText(R.string.amazon_gift_card)
                binding.atv10.setText(R.string.amazon_gift_card)

            }
            "Xbox" -> {
                binding.iv1.setImageResource(R.drawable.xbox)
                binding.iv2.setImageResource(R.drawable.xbox)
                binding.iv3.setImageResource(R.drawable.xbox)
                binding.iv4.setImageResource(R.drawable.xbox)
                binding.iv5.setImageResource(R.drawable.xbox)
                binding.iv6.setImageResource(R.drawable.xbox)
                binding.iv7.setImageResource(R.drawable.xbox)
                binding.iv8.setImageResource(R.drawable.xbox)
                binding.iv9.setImageResource(R.drawable.xbox)
                binding.iv10.setImageResource(R.drawable.xbox)

                binding.atv1.setText(R.string.xbox_gift_card)
                binding.atv2.setText(R.string.xbox_gift_card)
                binding.atv3.setText(R.string.xbox_gift_card)
                binding.atv4.setText(R.string.xbox_gift_card)
                binding.atv5.setText(R.string.xbox_gift_card)
                binding.atv6.setText(R.string.xbox_gift_card)
                binding.atv7.setText(R.string.xbox_gift_card)
                binding.atv8.setText(R.string.xbox_gift_card)
                binding.atv9.setText(R.string.xbox_gift_card)
                binding.atv10.setText(R.string.xbox_gift_card)
            }
            "Paypal" -> {
                binding.iv1.setImageResource(R.drawable.paypal)
                binding.iv2.setImageResource(R.drawable.paypal)
                binding.iv3.setImageResource(R.drawable.paypal)
                binding.iv4.setImageResource(R.drawable.paypal)
                binding.iv5.setImageResource(R.drawable.paypal)
                binding.iv6.setImageResource(R.drawable.paypal)
                binding.iv7.setImageResource(R.drawable.paypal)
                binding.iv8.setImageResource(R.drawable.paypal)
                binding.iv9.setImageResource(R.drawable.paypal)
                binding.iv10.setImageResource(R.drawable.paypal)

                binding.atv1.setText(R.string.paypal_gift_card)
                binding.atv2.setText(R.string.paypal_gift_card)
                binding.atv3.setText(R.string.paypal_gift_card)
                binding.atv4.setText(R.string.paypal_gift_card)
                binding.atv5.setText(R.string.paypal_gift_card)
                binding.atv6.setText(R.string.paypal_gift_card)
                binding.atv7.setText(R.string.paypal_gift_card)
                binding.atv8.setText(R.string.paypal_gift_card)
                binding.atv9.setText(R.string.paypal_gift_card)
                binding.atv10.setText(R.string.paypal_gift_card)
            }
            "Itunes" -> {
                binding.iv1.setImageResource(R.drawable.itunes)
                binding.iv2.setImageResource(R.drawable.itunes)
                binding.iv3.setImageResource(R.drawable.itunes)
                binding.iv4.setImageResource(R.drawable.itunes)
                binding.iv5.setImageResource(R.drawable.itunes)
                binding.iv6.setImageResource(R.drawable.itunes)
                binding.iv7.setImageResource(R.drawable.itunes)
                binding.iv8.setImageResource(R.drawable.itunes)
                binding.iv9.setImageResource(R.drawable.itunes)
                binding.iv10.setImageResource(R.drawable.itunes)

                binding.atv1.setText(R.string.itunes_gift_card)
                binding.atv2.setText(R.string.itunes_gift_card)
                binding.atv3.setText(R.string.itunes_gift_card)
                binding.atv4.setText(R.string.itunes_gift_card)
                binding.atv5.setText(R.string.itunes_gift_card)
                binding.atv6.setText(R.string.itunes_gift_card)
                binding.atv7.setText(R.string.itunes_gift_card)
                binding.atv8.setText(R.string.itunes_gift_card)
                binding.atv9.setText(R.string.itunes_gift_card)
                binding.atv10.setText(R.string.itunes_gift_card)
            }
            "Google_Play" -> {
                binding.iv1.setImageResource(R.drawable.google_play)
                binding.iv2.setImageResource(R.drawable.google_play)
                binding.iv3.setImageResource(R.drawable.google_play)
                binding.iv4.setImageResource(R.drawable.google_play)
                binding.iv5.setImageResource(R.drawable.google_play)
                binding.iv6.setImageResource(R.drawable.google_play)
                binding.iv7.setImageResource(R.drawable.google_play)
                binding.iv8.setImageResource(R.drawable.google_play)
                binding.iv9.setImageResource(R.drawable.google_play)
                binding.iv10.setImageResource(R.drawable.google_play)

                binding.atv1.setText(R.string.google_play_gift_card)
                binding.atv2.setText(R.string.google_play_gift_card)
                binding.atv3.setText(R.string.google_play_gift_card)
                binding.atv4.setText(R.string.google_play_gift_card)
                binding.atv5.setText(R.string.google_play_gift_card)
                binding.atv6.setText(R.string.google_play_gift_card)
                binding.atv7.setText(R.string.google_play_gift_card)
                binding.atv8.setText(R.string.google_play_gift_card)
                binding.atv9.setText(R.string.google_play_gift_card)
                binding.atv10.setText(R.string.google_play_gift_card)
            }
            "Play_Station" -> {
                binding.iv1.setImageResource(R.drawable.play_station)
                binding.iv2.setImageResource(R.drawable.play_station)
                binding.iv3.setImageResource(R.drawable.play_station)
                binding.iv4.setImageResource(R.drawable.play_station)
                binding.iv5.setImageResource(R.drawable.play_station)
                binding.iv6.setImageResource(R.drawable.play_station)
                binding.iv7.setImageResource(R.drawable.play_station)
                binding.iv8.setImageResource(R.drawable.play_station)
                binding.iv9.setImageResource(R.drawable.play_station)
                binding.iv10.setImageResource(R.drawable.play_station)

                binding.atv1.setText(R.string.play_station_gift_card)
                binding.atv2.setText(R.string.play_station_gift_card)
                binding.atv3.setText(R.string.play_station_gift_card)
                binding.atv4.setText(R.string.play_station_gift_card)
                binding.atv5.setText(R.string.play_station_gift_card)
                binding.atv6.setText(R.string.play_station_gift_card)
                binding.atv7.setText(R.string.play_station_gift_card)
                binding.atv8.setText(R.string.play_station_gift_card)
                binding.atv9.setText(R.string.play_station_gift_card)
                binding.atv10.setText(R.string.play_station_gift_card)
            }
            "Steam_Wallet" -> {
                binding.iv1.setImageResource(R.drawable.steam_wallet)
                binding.iv2.setImageResource(R.drawable.steam_wallet)
                binding.iv3.setImageResource(R.drawable.steam_wallet)
                binding.iv4.setImageResource(R.drawable.steam_wallet)
                binding.iv5.setImageResource(R.drawable.steam_wallet)
                binding.iv6.setImageResource(R.drawable.steam_wallet)
                binding.iv7.setImageResource(R.drawable.steam_wallet)
                binding.iv8.setImageResource(R.drawable.steam_wallet)
                binding.iv9.setImageResource(R.drawable.steam_wallet)
                binding.iv10.setImageResource(R.drawable.steam_wallet)

                binding.atv1.setText(R.string.steam_wallet_gift_card)
                binding.atv2.setText(R.string.steam_wallet_gift_card)
                binding.atv3.setText(R.string.steam_wallet_gift_card)
                binding.atv4.setText(R.string.steam_wallet_gift_card)
                binding.atv5.setText(R.string.steam_wallet_gift_card)
                binding.atv6.setText(R.string.steam_wallet_gift_card)
                binding.atv7.setText(R.string.steam_wallet_gift_card)
                binding.atv8.setText(R.string.steam_wallet_gift_card)
                binding.atv9.setText(R.string.steam_wallet_gift_card)
                binding.atv10.setText(R.string.steam_wallet_gift_card)

            }
            "Visa" -> {
                binding.iv1.setImageResource(R.drawable.visa)
                binding.iv2.setImageResource(R.drawable.visa)
                binding.iv3.setImageResource(R.drawable.visa)
                binding.iv4.setImageResource(R.drawable.visa)
                binding.iv5.setImageResource(R.drawable.visa)
                binding.iv6.setImageResource(R.drawable.visa)
                binding.iv7.setImageResource(R.drawable.visa)
                binding.iv8.setImageResource(R.drawable.visa)
                binding.iv9.setImageResource(R.drawable.visa)
                binding.iv10.setImageResource(R.drawable.visa)

                binding.atv1.setText(R.string.visa_gift_card)
                binding.atv2.setText(R.string.visa_gift_card)
                binding.atv3.setText(R.string.visa_gift_card)
                binding.atv4.setText(R.string.visa_gift_card)
                binding.atv5.setText(R.string.visa_gift_card)
                binding.atv6.setText(R.string.visa_gift_card)
                binding.atv7.setText(R.string.visa_gift_card)
                binding.atv8.setText(R.string.visa_gift_card)
                binding.atv9.setText(R.string.visa_gift_card)
                binding.atv10.setText(R.string.visa_gift_card)
            }
            "Paytm" -> {
                binding.iv1.setImageResource(R.drawable.paypal)
                binding.iv2.setImageResource(R.drawable.paypal)
                binding.iv3.setImageResource(R.drawable.paypal)
                binding.iv4.setImageResource(R.drawable.paypal)
                binding.iv5.setImageResource(R.drawable.paypal)
                binding.iv6.setImageResource(R.drawable.paypal)
                binding.iv7.setImageResource(R.drawable.paypal)
                binding.iv8.setImageResource(R.drawable.paypal)
                binding.iv9.setImageResource(R.drawable.paypal)
                binding.iv10.setImageResource(R.drawable.paypal)

                binding.atv1.setText(R.string.paypal_gift_card)
                binding.atv2.setText(R.string.paypal_gift_card)
                binding.atv3.setText(R.string.paypal_gift_card)
                binding.atv4.setText(R.string.paypal_gift_card)
                binding.atv5.setText(R.string.paypal_gift_card)
                binding.atv6.setText(R.string.paypal_gift_card)
                binding.atv7.setText(R.string.paypal_gift_card)
                binding.atv8.setText(R.string.paypal_gift_card)
                binding.atv9.setText(R.string.paypal_gift_card)
                binding.atv10.setText(R.string.paypal_gift_card)
            }
        }

        val ammount = getSharedPrefs().getAmount()
        binding.atvCoinValue.text = ammount.toString()

        setClickListener()
    }

    private fun setClickListener() {
        binding.rl1.setOnClickListener {
            moveForward(60000)
        }

        binding.rl2.setOnClickListener {
            moveForward(70000)
        }

        binding.rl3.setOnClickListener {
            moveForward(80000)
        }

        binding.rl4.setOnClickListener {
            moveForward(90000)
        }

        binding.rl5.setOnClickListener {
            moveForward(100000)
        }

        binding.rl6.setOnClickListener {
            moveForward(110000)
        }

        binding.rl7.setOnClickListener {
            moveForward(120000)
        }

        binding.rl8.setOnClickListener {
            moveForward(130000)
        }

        binding.rl9.setOnClickListener {
            moveForward(140000)
        }

        binding.rl10.setOnClickListener {
            moveForward(150000)
        }

    }

    private fun moveForward(points: Int) {
        showErrorDialog("Must At Least $points Coin")
    }


}