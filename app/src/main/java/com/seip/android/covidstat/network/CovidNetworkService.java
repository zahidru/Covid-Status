package com.seip.android.covidstat.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidNetworkService {
    private static final String BASE_URL = "https://corona.lmao.ninja/v2/countries/";
    public static CovidServiceApi getService() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(CovidServiceApi.class);
    }
}
