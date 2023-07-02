package com.example.watchvideo.setting.ui

import android.app.Dialog
import android.content.Intent
import android.text.InputType
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.watchvideo.BuildConfig
import com.example.watchvideo.R
import com.example.watchvideo.base.BaseActivity
import com.example.watchvideo.databinding.ActivitySettingBinding
import com.example.watchvideo.databinding.DialogDeleteBinding
import com.example.watchvideo.databinding.DialogGenderBinding
import com.example.watchvideo.databinding.DialogUpdateProileBinding
import com.example.watchvideo.splash.ui.SplashActivity
import java.util.regex.Pattern

class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {

    override fun init() {
        binding.tvVersion.text = BuildConfig.VERSION_NAME

        setClickListener()
    }

    private fun setClickListener() {

        binding.relName.setOnClickListener {
            showProfileUpdateDialog("Note: Enter Proper Name",
                "Nick Name",
                getSharedPrefs().getNickName(),
                "NICK_NAME",
                cancelClick = {

                },
                okClick = {
                    getSharedPrefs().saveNickName(it)
                    updateUi()
                })
        }

        binding.relGender.setOnClickListener {
            dialogGender {
                getSharedPrefs().saveGender(it)
                updateUi()
            }
        }

        binding.relAge.setOnClickListener {
            showProfileUpdateDialog("Note: Enter Your Age",
                "Enter Your Age",
                getSharedPrefs().getAge().toString(),
                "AGE",
                cancelClick = {

                },
                okClick = {
                    getSharedPrefs().saveAge(it.toInt())
                    updateUi()

                })
        }

        binding.relEmail.setOnClickListener {
            showProfileUpdateDialog("Note: Enter Proper Email Address",
                "Enter Email",
                getSharedPrefs().getEmail(),
                "EMAIL",
                cancelClick = {

                },
                okClick = {
                    getSharedPrefs().saveEmail(it)
                    updateUi()
                })
        }

        binding.relMobile.setOnClickListener {
            showProfileUpdateDialog("Note: Update Mobile Number",
                "Phone Number",
                getSharedPrefs().getMobile(),
                "PHONE_NUMBER",
                cancelClick = {

                },
                okClick = {
                    getSharedPrefs().saveMobile(it)
                    updateUi()
                })
        }

        binding.relLogout.setOnClickListener {
            dialogDelete(cancelClick = {

            }, okClick = {
                getSharedPrefs().clearPref()
                startActivity(Intent(context, SplashActivity::class.java))
                finishAffinity()
            })
        }
    }

    override fun onResume() {
        super.onResume()

        updateUi()
    }

    private fun updateUi() {
        binding.tvNickName.text = getSharedPrefs().getNickName()
        binding.tvGender.text = getSharedPrefs().getGender()
        binding.tvAge.text = getSharedPrefs().getAge().toString()
        binding.tvEmailadd.text = getSharedPrefs().getEmail()
        binding.tvMobileNumber.text = getSharedPrefs().getMobile()
    }

    private fun showProfileUpdateDialog(
        heading: String,
        hint: String? = null,
        etText: String? = null,
        inputType: String,
        cancelClick: () -> Unit,
        okClick: (String) -> Unit
    ) {
        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogUpdateProileBinding>(
            LayoutInflater.from(this), R.layout.dialog_update_proile, null, false
        )
        dialog.setContentView(binding.root)

        binding.tvHeading.text = heading

        if (inputType == "AGE" || inputType == "PHONE_NUMBER") {
            binding.etText.inputType = InputType.TYPE_CLASS_NUMBER
        }

        binding.etText.hint = hint
        if (etText != null) {
            binding.etText.setText(etText.toString())
        }

        binding.clOk.setOnClickListener {

            if (binding.etText.text.toString().isBlank()) {
                Toast.makeText(context, "Please Update Field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (inputType == "EMAIL" && !isValidEmailId(binding.etText.text.toString())) {
                Toast.makeText(context, "Please Enter Valid Email Address", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (inputType == "AGE" && 16 > Integer.parseInt(binding.etText.text.toString())) {
                Toast.makeText(context, "Age must be 16+", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            dialog.dismiss()
            okClick(binding.etText.text.toString())
        }

        binding.clCancel.setOnClickListener {
            dialog.dismiss()
            cancelClick()
        }

        dialog.show()

        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val width = (displaymetrics.widthPixels * 0.9).toInt()
        dialog.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    private fun dialogDelete(
        cancelClick: () -> Unit, okClick: () -> Unit
    ) {
        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogDeleteBinding>(
            LayoutInflater.from(this), R.layout.dialog_delete, null, false
        )
        dialog.setContentView(binding.root)

        binding.clOk.setOnClickListener {
            dialog.dismiss()
            okClick()
        }

        binding.clCancel.setOnClickListener {
            dialog.dismiss()
            cancelClick()
        }

        dialog.show()

        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val width = (displaymetrics.widthPixels * 0.9).toInt()
        dialog.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    private fun dialogGender(
        confirmButton: (String) -> Unit
    ) {
        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogGenderBinding>(
            LayoutInflater.from(this), R.layout.dialog_gender, null, false
        )
        dialog.setContentView(binding.root)

        if (getSharedPrefs().getGender() == "Male") {
            binding.selectMale.visibility = View.VISIBLE
            binding.selectFemale.visibility = View.GONE
        } else {
            binding.selectMale.visibility = View.GONE
            binding.selectFemale.visibility = View.VISIBLE
        }

        binding.imgFemale.setOnClickListener {
            binding.selectFemale.visibility = View.VISIBLE
            binding.selectMale.visibility = View.GONE
        }

        binding.imgMale.setOnClickListener {
            binding.selectFemale.visibility = View.GONE
            binding.selectMale.visibility = View.VISIBLE
        }

        binding.btnConfirm.setOnClickListener {

            if (binding.selectFemale.visibility == View.VISIBLE) {
                confirmButton("Female")
            } else if (binding.selectMale.visibility == View.VISIBLE) {
                confirmButton("Male")
            }

            dialog.dismiss()
        }

        dialog.show()

        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val width = (displaymetrics.widthPixels * 0.9).toInt()
        dialog.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


}

private fun isValidEmailId(email: String): Boolean {
    return Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@" + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|" + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(email).matches()
}