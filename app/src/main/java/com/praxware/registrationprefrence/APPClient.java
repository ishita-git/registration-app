package com.praxware.registrationprefrence;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APPClient {

    private static final String BASEURL="https://rahulandroidrai.000webhostapp.com/";

    public static Retrofit getclient()
    {
        Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
