package com.example.hoaht.androidmu.api;

import com.example.hoaht.androidmu.model.Song;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Api Service
 *
 * @author HoaHT
 */
public interface ApiService {

    @GET("getsonginfo")
    Call<Song> getSongDetail(@Query("requestdata") String id);
}
