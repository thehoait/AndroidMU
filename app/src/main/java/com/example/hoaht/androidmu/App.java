package com.example.hoaht.androidmu;

import android.app.Application;

import com.example.hoaht.androidmu.api.core.ApiClient;
import com.example.hoaht.androidmu.api.core.ApiConfig;

/**
 * App.
 *
 * @author HoaHT
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Retrofit
        createService();
    }

    private void createService() {
        ApiConfig apiConfig = ApiConfig.builder()
                .context(getApplicationContext())
                .baseUrl(getString(R.string.base_url))
                .build();
        ApiClient.getInstance().init(apiConfig);
    }
}
