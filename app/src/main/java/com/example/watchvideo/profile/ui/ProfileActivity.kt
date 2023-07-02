package com.example.watchvideo.profile.ui

import android.content.Intent
import com.example.watchvideo.BuildConfig
import com.example.watchvideo.R
import com.example.watchvideo.about.ui.AboutActivity
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivityProfileBinding
import com.example.watchvideo.history.ui.HistoryActivity
import com.example.watchvideo.reedemfirst.ui.ReedemFirstActivity
import com.example.watchvideo.setting.ui.SettingActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    override fun init() {
        setClickListener()
    }

    override fun onResume() {
        super.onResume()

        val ammount = getSharedPrefs().getAmount()
        binding.atvCoinValue.text = ammount.toString()

        binding.atvPaytmValue.text = (ammount / 100).toString()

        binding.userName.text = getSharedPrefs().getNickName()
        binding.emailAdd.text = getSharedPrefs().getEmail()
    }

    private fun setClickListener() {
        binding.ivback.setOnClickListener {
            onBackPressed()
        }

        binding.imgHistory.setOnClickListener {
            startActivity(Intent(context, HistoryActivity::class.java))
            // TODO: If you don't want to finish this activity then remove below line rest of all takatak Enjoy buddy
            finish()
        }

        binding.ivShare.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.app_name))
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage = """
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                    """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }
        binding.ivAboutUs.setOnClickListener {
            startActivity(Intent(context, AboutActivity::class.java))
        }

        binding.payoutService.setOnClickListener {
            startActivity(Intent(context, ReedemFirstActivity::class.java))
        }

        binding.ivSetting.setOnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))
        }

        binding.editProfile.setOnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))
        }

    }

}