package com.example.hoaht.androidmu.api.core;

import android.content.Context;

import lombok.Builder;
import lombok.Value;

/**
 * Api config.
 *
 * @author HoaHT
 */
@Value
@Builder
public class ApiConfig {
    private Context context;
    private String baseUrl;
}
