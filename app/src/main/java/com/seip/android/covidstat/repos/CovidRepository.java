package com.seip.android.covidstat.repos;

import android.util.Log;

import com.seip.android.covidstat.callback.OnDataLoadListener;
import com.seip.android.covidstat.models.Country;
import com.seip.android.covidstat.network.CovidNetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidRepository {
    public void getData(String country, OnDataLoadListener dataLoadListener) {
        // TODO: 2/6/2022 create the end url and make the network call
        // TODO: 2/6/2022 pass the loaded data to CovidViewModel using the dataLoadListener
    }
}
