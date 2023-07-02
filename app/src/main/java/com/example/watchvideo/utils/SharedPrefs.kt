package com.example.watchvideo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.watchvideo.network.model.Ads
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Calendar
import java.util.Date

const val ADS_PREF_KEY = "ads"
const val SHARED_PREF_NAME = "WatchAdPrefs"
const val CHECK_IN_DAY = "check_in_day"
const val LAST_CHECK_IN_DAY = "lastCheckInDay"
const val EARNED_AMOUNT = "earnedAmount"

class SharedPrefs(context: Context) {

    companion object {
        lateinit var sharedPrefs: SharedPrefs
    }

    private var prefs: SharedPreferences

    init {
        sharedPrefs = this
        prefs = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    fun getPres(): SharedPreferences {
        return prefs
    }


    fun updatePrefs(ads: Ads) {
        val gson = Gson()
        val offlineAdsData = gson.toJson(ads)
        prefs.edit().putString(ADS_PREF_KEY, offlineAdsData).apply()
    }

    fun getAds(): Ads {
        val gson = Gson()
        val type = object : TypeToken<Ads?>() {}.type
        return gson.fromJson(prefs.getString(ADS_PREF_KEY, ""), type)
    }

    fun updateCheckInDay(time: Long) {
        prefs.edit().putLong(CHECK_IN_DAY, time).apply()
    }

    fun getLastCheckInDate(): Date {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = prefs.getLong(CHECK_IN_DAY, 0)
        return calendar.time
    }

    fun updateLastCheckInDay(lastCheckInDay: Int) {
        prefs.edit().putInt(LAST_CHECK_IN_DAY, lastCheckInDay).apply()
    }

    fun getLastCheckInDay(): Int {
        return prefs.getInt(LAST_CHECK_IN_DAY, 1)
    }

    fun updateAmountBy(amount: Int) {
        prefs.edit().putInt(EARNED_AMOUNT, getAmount() + amount).apply()
    }

    fun getAmount(): Int {
        return prefs.getInt(EARNED_AMOUNT, 0)
    }

}