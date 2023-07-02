package com.example.watchvideo.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Ads {

    @SerializedName("adsData")
    @Expose
    private ArrayList<AdsData> adsData = null;

    public ArrayList<AdsData> getAdsData() {
        return adsData;
    }

    public void setAdsData(ArrayList<AdsData> adsData) {
        this.adsData = adsData;
    }


}