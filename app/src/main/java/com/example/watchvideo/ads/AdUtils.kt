package com.example.watchvideo.ads

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import com.example.watchvideo.R
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAd
import com.facebook.ads.InterstitialAdListener


object AdUtils {

    private var interstitialAd: InterstitialAd? = null
    private val TAG: String = "FACEBOOK_INTER_AD"

    fun loadFacebookInter(
        context: Context,
        adsId: String = "YOUR_PLACEMENT_ID", onAdLoaded: () -> Unit, onAdDismiss: () -> Unit
    ) {
        interstitialAd = InterstitialAd(context, adsId)

        // Create listeners for the Interstitial Ad
        // Create listeners for the Interstitial Ad
        val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.")
                interstitialAd = null
                onAdDismiss()
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.errorMessage)
                interstitialAd = null
            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
                onAdLoaded()
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!")
            }
        }

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd!!.loadAd(
            interstitialAd!!.buildLoadAdConfig().withAdListener(interstitialAdListener).build()
        )
    }


    fun showInterAd(context: Context, moveToNextThing: () -> Unit) {
        if (interstitialAd == null) {
            moveToNextThing()
            return
        }

        if (!interstitialAd!!.isAdLoaded) {
            moveToNextThing()
            return
        }

        showingAdsDialog(context)

        Handler().postDelayed({
            dismissShowingAdsDialog()

            // Show the ad
            interstitialAd!!.show()
        }, 2000)

    }

    lateinit var dialog: Dialog

    fun showingAdsDialog(context: Context) {
        dialog = Dialog(context, R.style.full_screen_dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_showing_ads)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.setCancelable(false)
        dialog.window?.setFormat(PixelFormat.TRANSLUCENT)
        dialog.show()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

    fun dismissShowingAdsDialog() {
        if (this::dialog.isInitialized) {
            dialog?.let {

                if (it.isShowing) {
                    it.dismiss()
                }
            }

        }

    }

}