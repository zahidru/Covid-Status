package com.seip.android.covidstat.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seip.android.covidstat.models.Country;
import com.seip.android.covidstat.network.CovidNetworkService;
import com.seip.android.covidstat.repos.CovidRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {
    private final CovidRepository repository = new CovidRepository();
    private MutableLiveData<Country> countryMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>();
    private String country = "";

    public MutableLiveData<Country> getCountryMutableLiveData() {
        return countryMutableLiveData;
    }

    public CovidViewModel() {
        getCountryCovidData();
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private void getCountryCovidData() {
        final String endUrl = String.format("%s?yesterday=true&strict=true&query", country);
        CovidNetworkService.getService().getCountryCovidData(endUrl).enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                if (response.code()==200){
                    Log.e("weather_test", ""+response.code() );
                    countryMutableLiveData.postValue(response.body());
                } else if (response.code() == 404){
                    errorMessageLiveData.postValue(response.message());
                    Log.e("weather_test", ""+response.code() );
                }
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.e("weather_test", ""+t.getLocalizedMessage() );
            }
        });

    }

    public MutableLiveData<String> getErrorMessageLiveData() {
        return errorMessageLiveData;
    }

    public void loadData() {
        getCountryCovidData();
    }
}
