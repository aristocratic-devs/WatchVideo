package com.example.watchvideo.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.watchvideo.databinding.DialogFailureBinding
import com.example.watchvideo.databinding.DialogSuccessBinding
import com.example.watchvideo.utils.SharedPrefs
import com.facebook.ads.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes val id: Int) : AppCompatActivity(),
    CoroutineScope {

    lateinit var binding: T

    abstract fun init()

    lateinit var context: Context


    private var adView: AdView? = null
    private val TAG: String = "FACEBOOK_AD"


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@BaseActivity, id) as T
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        context = this

        init()
//

//         This Is how you can Load your InterAds

//        loadFacebookInter("", onAdLoaded = {
//            // Ad Loaded Of you want to do any specific task then do it here
//        }, onAdDismiss = {
//            // Ad Closed you can do next thing
//        })
//

//         This Is how you can Show Inter Ads

//        showInterAd {
//
//        }
    }

    fun getSharedPrefs(): SharedPrefs {
        return SharedPrefs.sharedPrefs
    }

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        job.cancel()

        if (adView != null) {
            adView!!.destroy()
        }

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
            LayoutInflater.from(this), com.example.watchvideo.R.layout.dialog_success, null, false
        )
        dialog.setContentView(binding.root)
        binding.ivGetPoints.setOnClickListener {
            dialog.dismiss()
        }

        binding.tvPointsText.text = "$pointsEarned Points Added Successfully"

        dialog.show()

    }

    fun showErrorDialog(message: String? = null) {

        val dialog = Dialog(this)
        val binding = DataBindingUtil.inflate<DialogFailureBinding>(
            LayoutInflater.from(this), com.example.watchvideo.R.layout.dialog_failure, null, false
        )
        dialog.setContentView(binding.root)

        if (message != null) {
            binding.tvTomorrow.text = message
        }

        binding.clOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setCancelable(false)
        dialog.show()

        val displaymetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val width = (displaymetrics.widthPixels * 0.9).toInt()
        dialog.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun startActivity(activity: Class<*>) {
        startActivity(Intent(this, activity))
    }

    // region Ads


    fun showFacebookBannerAd(
        adContainer: LinearLayout,
        bannerId: String? = resources.getString(com.example.watchvideo.R.string.facebook_banner_ad),
        bannerSize: AdSize = AdSize.BANNER_HEIGHT_50
    ) {
        adView = AdView(this, bannerId, bannerSize)

        // Add the ad view to your activity layout
        adContainer.addView(adView)

        // Request an ad
        adView?.loadAd()
    }

    fun loadNativeAd(
        nativeAdLayout: NativeAdLayout,
        nativeAdId: String? = resources.getString(com.example.watchvideo.R.string.facebook_native_ad)
    ) {
        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        val nativeAd = NativeAd(this, nativeAdId)
        val nativeAdListener: NativeAdListener = object : NativeAdListener {
            override fun onMediaDownloaded(ad: Ad) {
                // Native ad finished downloading all assets
                Log.e(TAG, "Native ad finished downloading all assets.")
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Native ad failed to load
                Log.e(TAG, "Native ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad) {
                // Native ad is loaded and ready to be displayed
                if (nativeAd == null || nativeAd !== ad) {
                    return
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd, nativeAdLayout)
            }

            override fun onAdClicked(ad: Ad) {
                // Native ad clicked
                Log.d(TAG, "Native ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Native ad impression
                Log.d(TAG, "Native ad impression logged!")
            }
        }

        // Request an ad
        nativeAd.loadAd(
            nativeAd?.buildLoadAdConfig()
                ?.withAdListener(nativeAdListener)
                ?.build()
        )
    }

    fun inflateAd(nativeAd: NativeAd, nativeAdLayout: NativeAdLayout) {
        nativeAd.unregisterView()

        // Add the Ad view into the ad container.
        val inflater = LayoutInflater.from(this)
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        val adView = inflater.inflate(
            com.example.watchvideo.R.layout.facebook_ad_container_200,
            nativeAdLayout, false
        ) as ConstraintLayout
        nativeAdLayout.addView(adView)

        // Add the AdOptionsView
        val adChoicesContainer =
            findViewById<LinearLayout>(com.example.watchvideo.R.id.ad_choices_container)
        val adOptionsView = AdOptionsView(this, nativeAd, nativeAdLayout)
        adChoicesContainer.removeAllViews()
        adChoicesContainer.addView(adOptionsView, 0)

        // Create native UI using the ad metadata.
        val nativeAdIcon =
            adView.findViewById<MediaView>(com.example.watchvideo.R.id.native_ad_icon)
        val nativeAdTitle =
            adView.findViewById<TextView>(com.example.watchvideo.R.id.native_advertiser_name)
        val nativeAdMedia =
            adView.findViewById<MediaView>(com.example.watchvideo.R.id.native_ad_media)
        val nativeAdSocialContext =
            adView.findViewById<TextView>(com.example.watchvideo.R.id.native_ad_social_context)
        val nativeAdBody = adView.findViewById<TextView>(com.example.watchvideo.R.id.native_ad_body)
        val sponsoredLabel =
            adView.findViewById<TextView>(com.example.watchvideo.R.id.native_ad_sponsored_label)
        val nativeAdCallToAction: Button =
            adView.findViewById(com.example.watchvideo.R.id.native_ad_call_to_action)

        // Set the Text.
        nativeAdTitle.text = nativeAd.advertiserName
        nativeAdBody.text = nativeAd.adBodyText
        nativeAdSocialContext.text = nativeAd.adSocialContext
        nativeAdCallToAction.visibility =
            if (nativeAd.hasCallToAction()) View.VISIBLE else View.INVISIBLE
        nativeAdCallToAction.text = nativeAd.adCallToAction
        sponsoredLabel.text = nativeAd.sponsoredTranslation

        // Create a list of clickable views
        val clickableViews: MutableList<View> = ArrayList()
        clickableViews.add(nativeAdTitle)
        clickableViews.add(nativeAdCallToAction)

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
            adView, nativeAdMedia, nativeAdIcon, clickableViews
        )
    }


    // endregion


}
