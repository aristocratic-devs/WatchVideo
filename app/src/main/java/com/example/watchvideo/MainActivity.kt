package com.example.watchvideo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityMainBinding
import com.example.watchvideo.home.HomeActivity
import com.example.watchvideo.privacy_policy.ui.PrivacyPolicyActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun init() {
        loadNativeAd(binding.nativeAdContainer)
        showFacebookBannerAd(binding.linearBannerAd)

        setClickListeners()
    }

    private fun setClickListeners() {

        binding.ivRateApp.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")
                    )
                )
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
        }

        binding.ivStart.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.ivPrivacy.setOnClickListener {
            startActivity(Intent(this, PrivacyPolicyActivity::class.java))
        }

        binding.ivShareApp.setOnClickListener {

            val intent = Intent("android.intent.action.SEND")
            intent.type = "text/plain"
            val sb = StringBuilder()
            sb.append(applicationContext.getString(R.string.app_name))
            sb.append(" Download From :")
            sb.append("https://play.google.com/store/apps/details?id=" + applicationContext.packageName)
            intent.putExtra("android.intent.extra.TEXT", sb.toString())
            startActivity(Intent.createChooser(intent, "Share Text"))

        }
    }

}