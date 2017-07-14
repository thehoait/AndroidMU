package com.example.hoaht.androidmu.api.core;

import com.example.hoaht.androidmu.BuildConfig;
import com.example.hoaht.androidmu.api.ApiService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Api Service client.
 *
 * @author HoaHT
 */
public class ApiClient {
    private static final int TIMEOUT_CONNECTION = 15000;

    private static ApiClient sApiClient;
    /**
     * ApiService service
     */
    private ApiService mApiService;
    private Retrofit mRetrofit;

    public static synchronized ApiClient getInstance() {
        if (sApiClient == null) {
            sApiClient = new ApiClient();
        }
        return sApiClient;
    }

    /**
     * method this is request api
     */
    public static ApiService call() {
        return getInstance().mApiService;
    }

    public void init(final ApiConfig apiConfig) {
        // initialize OkHttpClient
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.BUILD_TYPE.equals("release") ? HttpLoggingInterceptor.Level.NONE : HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        builder.readTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS);
        builder.writeTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS);
        builder.connectTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS);
        OkHttpClient okHttpClient = builder.build();

        // Gson rules
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    Retrofit getRetrofit() {
        return mRetrofit;
    }
}
