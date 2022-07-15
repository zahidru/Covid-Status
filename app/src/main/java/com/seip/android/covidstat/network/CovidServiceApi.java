package com.seip.android.covidstat.network;

import com.seip.android.covidstat.models.Country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CovidServiceApi {
    @GET
    Call<Country> getCountryCovidData(@Url String endUrl);
}
