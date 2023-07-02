package com.example.watchvideo.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.watchvideo.R
import com.example.watchvideo.databinding.DialogFailureBinding
import com.example.watchvideo.databinding.DialogSuccessBinding
import com.example.watchvideo.utils.SharedPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes val id: Int) : AppCompatActivity(),
    CoroutineScope {

    lateinit var binding: T


    abstract fun init()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@BaseActivity, id) as T
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        init()
    }

    fun getSharedPrefs(): SharedPrefs {
        return SharedPrefs.sharedPrefs
    }

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        onUserInteraction()
        return super.onKeyDown(keyCode, event)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showSuccessDialog(pointsEarned: Int) {
        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogSuccessBinding>(
            LayoutInflater.from(this), R.layout.dialog_success, null, false
        )
        dialog.setContentView(binding.root)
        binding.ivGetPoints.setOnClickListener {
            dialog.dismiss()
        }

        binding.tvPointsText.text = "$pointsEarned Points Added Successfully"

        dialog.show()

    }

    fun showErrorDialog() {

        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogFailureBinding>(
            LayoutInflater.from(this), R.layout.dialog_failure, null, false
        )
        dialog.setContentView(binding.root)

        binding.clOk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val width = (displaymetrics.widthPixels * 0.8).toInt()
        dialog.getWindow()!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)


    }

    fun startActivity(activity: Class<*>) {
        startActivity(Intent(this, activity))
    }

}
