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

const val NICK_NAME = "nick_name"
const val GENDER = "gender"
const val AGE = "age"
const val EMAIL = "email"
const val MOBILE = "mobile"

const val SCRATCH_CARD_EARNING = "SCRATCH_CARD_EARNING"
const val LUCKY_SLOT_EARNING = "LUCKY_SLOT_EARNING"
const val LUCKY_SPIN_EARNING = "LUCKY_SPIN_EARNING"
const val EXTRA_EARNING = "EXTRA_EARNING"

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

    fun saveNickName(nickName: String) {
        prefs.edit().putString(NICK_NAME, nickName).apply()
    }

    fun getNickName(): String {
        return prefs.getString(NICK_NAME, "").toString()
    }

    fun saveGender(gender: String) {
        prefs.edit().putString(GENDER, gender).apply()
    }

    fun getGender(): String {
        return prefs.getString(GENDER, "Male").toString()
    }

    fun saveAge(age: Int) {
        prefs.edit().putInt(AGE, age).apply()
    }

    fun getAge(): Int {
        return prefs.getInt(AGE, 0)
    }

    fun saveEmail(email: String) {
        prefs.edit().putString(EMAIL, email).apply()
    }

    fun getEmail(): String {
        return prefs.getString(EMAIL, "").toString()
    }

    fun saveMobile(mobile: String) {
        prefs.edit().putString(MOBILE, mobile).apply()
    }

    fun getMobile(): String {
        return prefs.getString(MOBILE, "").toString()
    }

    fun clearPref() {
        prefs.edit().clear().apply()
    }

    // region History Activity

    fun getScratchCardEarning(): Int {
        return prefs.getInt(SCRATCH_CARD_EARNING, 0)
    }

    fun saveScratchCardEarning() {
        prefs.edit().putInt(SCRATCH_CARD_EARNING, 0).apply()
    }

    fun getLuckySlotEarning(): Int {
        return prefs.getInt(LUCKY_SLOT_EARNING, 0)
    }

    fun saveLuckySlotEarning() {
        prefs.edit().putInt(LUCKY_SLOT_EARNING, 0).apply()
    }


    fun getLuckySpinEarning(): Int {
        return prefs.getInt(LUCKY_SPIN_EARNING, 0)
    }

    fun saveLuckySpinEarning() {
        prefs.edit().putInt(LUCKY_SPIN_EARNING, 0).apply()
    }

    fun getExtraEarning(): Int {
        return prefs.getInt(EXTRA_EARNING, 0)
    }

    fun saveExtraEarning() {
        prefs.edit().putInt(EXTRA_EARNING, 0).apply()
    }


    // endregion
}