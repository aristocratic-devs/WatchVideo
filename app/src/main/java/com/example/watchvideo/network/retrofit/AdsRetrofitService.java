package com.example.watchvideo.network.retrofit;



import com.example.watchvideo.network.model.Ads;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdsRetrofitService {

    @GET("exec")
    Call<Ads> doGetAdsIdList();
}
