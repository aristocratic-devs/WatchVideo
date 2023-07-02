package com.example.watchvideo.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AdsData {

    @SerializedName("app_id")
    @Expose
    private Integer appId;
    @SerializedName("ads_btn_back_color")
    @Expose
    private String adsBtnBackColor;
    @SerializedName("ads_btn_text_color")
    @Expose
    private String adsBtnTextColor;
    @SerializedName("ads_show_flag")
    @Expose
    private String adsShowFlag;
    @SerializedName("ads_priority")
    @Expose
    private String adsPriority;
    @SerializedName("splash_ads_flag")
    @Expose
    private String splashAdsFlag;
    @SerializedName("splash_ads_type")
    @Expose
    private String splashAdsType;
    @SerializedName("accident_ads_show")
    @Expose
    private String accidentAdsShow;
    @SerializedName("extra_ad_show")
    @Expose
    private String extraAdShow;
    @SerializedName("extra_features_show")
    @Expose
    private String extraFeaturesShow;
    @SerializedName("delay_click_time")
    @Expose
    private Integer delayClickTime;
    @SerializedName("am_ads_limit")
    @Expose
    private Integer amAdsLimit;
    @SerializedName("fb_ads_limit")
    @Expose
    private Integer fbAdsLimit;
    @SerializedName("adx_ads_limit")
    @Expose
    private Integer adxAdsLimit;
    @SerializedName("am_app_id")
    @Expose
    private String amAppId;
    @SerializedName("fb_app_id")
    @Expose
    private Long fbAppId;
    @SerializedName("am_interstitial")
    @Expose
    private String amInterstitial;
    @SerializedName("fb_interstitial")
    @Expose
    private String fbInterstitial;
    @SerializedName("adx_interstitial")
    @Expose
    private String adxInterstitial;
    @SerializedName("am_native")
    @Expose
    private String amNative;
    @SerializedName("fb_native")
    @Expose
    private String fbNative;
    @SerializedName("adx_native")
    @Expose
    private String adxNative;
    @SerializedName("am_opner")
    @Expose
    private String amOpner;
    @SerializedName("adx_opner")
    @Expose
    private String adxOpner;
    @SerializedName("live_app_versionname")
    @Expose
    private String liveAppVersionname;
    @SerializedName("exit_flow_flag")
    @Expose
    private String exitFlowFlag;
    @SerializedName("update_dialog_flag")
    @Expose
    private String updateDialogFlag;

    @SerializedName("extra_splash")
    @Expose
    private String extraSplash;
    @SerializedName("ads_viol")
    @Expose
    private String adsViol;
    @SerializedName("viol_txt")
    @Expose
    private String violTxt;
    @SerializedName("fb_native_banner")
    @Expose
    private String fbNativeBanner;

    @SerializedName("vpn_base_url")
    @Expose
    private String VpnBaseUrl;
    @SerializedName("vpn_carrier_id")
    @Expose
    private String VpnCarrierId;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAdsBtnBackColor() {
        return adsBtnBackColor;
    }

    public void setAdsBtnBackColor(String adsBtnBackColor) {
        this.adsBtnBackColor = adsBtnBackColor;
    }

    public String getAdsBtnTextColor() {
        return adsBtnTextColor;
    }

    public void setAdsBtnTextColor(String adsBtnTextColor) {
        this.adsBtnTextColor = adsBtnTextColor;
    }

    public String getAdsShowFlag() {
        return adsShowFlag;
    }

    public void setAdsShowFlag(String adsShowFlag) {
        this.adsShowFlag = adsShowFlag;
    }


    public String getAdsPriority() {
        return adsPriority;
    }

    public void setAdsPriority(String adsPriority) {
        this.adsPriority = adsPriority;
    }

    public String getSplashAdsFlag() {
        return splashAdsFlag;
    }

    public void setSplashAdsFlag(String splashAdsFlag) {
        this.splashAdsFlag = splashAdsFlag;
    }

    public String getSplashAdsType() {
        return splashAdsType;
    }

    public void setSplashAdsType(String splashAdsType) {
        this.splashAdsType = splashAdsType;
    }

    public String getAccidentAdsShow() {
        return accidentAdsShow;
    }

    public void setAccidentAdsShow(String accidentAdsShow) {
        this.accidentAdsShow = accidentAdsShow;
    }

    public String getExtraAdShow() {
        return extraAdShow;
    }

    public void setExtraAdShow(String extraAdShow) {
        this.extraAdShow = extraAdShow;
    }

    public String getExtraFeaturesShow() {
        return extraFeaturesShow;
    }

    public void setExtraFeaturesShow(String extraFeaturesShow) {
        this.extraFeaturesShow = extraFeaturesShow;
    }


    public Integer getDelayClickTime() {
        return delayClickTime;
    }

    public void setDelayClickTime(Integer delayClickTime) {
        this.delayClickTime = delayClickTime;
    }



    public Integer getAmAdsLimit() {
        return amAdsLimit;
    }

    public void setAmAdsLimit(Integer amAdsLimit) {
        this.amAdsLimit = amAdsLimit;
    }

    public Integer getFbAdsLimit() {
        return fbAdsLimit;
    }

    public void setFbAdsLimit(Integer fbAdsLimit) {
        this.fbAdsLimit = fbAdsLimit;
    }

    public Integer getAdxAdsLimit() {
        return adxAdsLimit;
    }

    public void setAdxAdsLimit(Integer adxAdsLimit) {
        this.adxAdsLimit = adxAdsLimit;
    }

    public String getAmAppId() {
        return amAppId;
    }

    public void setAmAppId(String amAppId) {
        this.amAppId = amAppId;
    }

    public Long getFbAppId() {
        return fbAppId;
    }

    public void setFbAppId(Long fbAppId) {
        this.fbAppId = fbAppId;
    }

    public String getAmInterstitial() {
        return amInterstitial;
    }

    public void setAmInterstitial(String amInterstitial) {
        this.amInterstitial = amInterstitial;
    }

    public String getFbInterstitial() {
        return fbInterstitial;
    }

    public void setFbInterstitial(String fbInterstitial) {
        this.fbInterstitial = fbInterstitial;
    }

    public String getAdxInterstitial() {
        return adxInterstitial;
    }

    public void setAdxInterstitial(String adxInterstitial) {
        this.adxInterstitial = adxInterstitial;
    }

    public String getAmNative() {
        return amNative;
    }

    public void setAmNative(String amNative) {
        this.amNative = amNative;
    }

    public String getFbNative() {
        return fbNative;
    }

    public void setFbNative(String fbNative) {
        this.fbNative = fbNative;
    }

    public String getAdxNative() {
        return adxNative;
    }

    public void setAdxNative(String adxNative) {
        this.adxNative = adxNative;
    }

    public String getAmOpner() {
        return amOpner;
    }

    public void setAmOpner(String amOpner) {
        this.amOpner = amOpner;
    }

    public String getAdxOpner() {
        return adxOpner;
    }

    public void setAdxOpner(String adxOpner) {
        this.adxOpner = adxOpner;
    }

    public String getLiveAppVersionname() {
        return liveAppVersionname;
    }

    public void setLiveAppVersionname(String liveAppVersionname) {
        this.liveAppVersionname = liveAppVersionname;
    }

    public String getExitFlowFlag() {
        return exitFlowFlag;
    }

    public void setExitFlowFlag(String exitFlowFlag) {
        this.exitFlowFlag = exitFlowFlag;
    }

    public String getUpdateDialogFlag() {
        return updateDialogFlag;
    }

    public void setUpdateDialogFlag(String updateDialogFlag) {
        this.updateDialogFlag = updateDialogFlag;
    }

    public String getExtraSplash() {
        return extraSplash;
    }

    public void setExtraSplash(String extraSplash) {
        this.extraSplash = extraSplash;
    }

    public String getAdsViol() {
        return adsViol;
    }

    public void setAdsViol(String adsViol) {
        this.adsViol = adsViol;
    }

    public String getViolTxt() {
        return violTxt;
    }

    public void setViolTxt(String violTxt) {
        this.violTxt = violTxt;
    }


    public String getFbNativeBanner() {
        return fbNativeBanner;
    }

    public void setFbNativeBanner(String fbNativeBanner) {
        this.fbNativeBanner = fbNativeBanner;
    }

    public String getVpnBaseUrl() {
        return VpnBaseUrl;
    }

    public void setVpnBaseUrl(String vpnBaseUrl) {
        VpnBaseUrl = vpnBaseUrl;
    }

    public String getVpnCarrierId() {
        return VpnCarrierId;
    }

    public void setVpnCarrierId(String vpnCarrierId) {
        VpnCarrierId = vpnCarrierId;
    }
}





