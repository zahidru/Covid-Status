package com.seip.android.covidstat.callback;

import com.seip.android.covidstat.models.Country;

public interface OnDataLoadListener {
    void onDataLoad(Country country);
}
