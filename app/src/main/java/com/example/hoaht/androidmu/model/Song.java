package com.example.hoaht.androidmu.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Value;

/**
 * Song.
 *
 * @author HoaHT
 */
@Value
public class Song {
    @SerializedName("song_id")
    private int songId;
    @SerializedName("song_id_encode")
    private String songIdEncode;
    @SerializedName("link_download")
    private LinkDownload linkDownload;

    /**
     * LinkDownload
     */
    @Getter
    private static class LinkDownload {
        @SerializedName("128")
        private String link128;
    }
}
