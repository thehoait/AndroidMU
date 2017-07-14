package com.example.hoaht.androidmu.api.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Api Error.
 *
 * @author HoaHT
 */
@Data
@AllArgsConstructor
public class ApiError {
    private int code;
    private String message;
}
