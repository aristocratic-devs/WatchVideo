package com.example.watchvideo.network.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdsRetrofitClient {


    public static AdsRetrofitService getService(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AdsRetrofitService.class);
    }
}
