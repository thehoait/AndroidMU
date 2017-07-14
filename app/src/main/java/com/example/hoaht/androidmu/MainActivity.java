package com.example.hoaht.androidmu;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.hoaht.androidmu.api.core.ApiCallback;
import com.example.hoaht.androidmu.api.core.ApiClient;
import com.example.hoaht.androidmu.api.core.ApiError;
import com.example.hoaht.androidmu.model.Song;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity
 *
 * @author HoaHT
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private final List<Song> mListSong = new ArrayList<>();

    @AfterViews
    void init() {
        getData();
    }

    @Background
    void getData() {
        Document doc = null;
        String ulr = "http://mp3.zing.vn/album/Top-100-Bai-Hat-Nhac-Tre-Hay-Nhat-Various-Artists/ZWZB969E.html";
        try {
            doc = Jsoup.connect(ulr).get();
        } catch (IOException e) {
            Log.e("Error parse html", e.toString());
        }

        Elements playList;
        if (doc != null) {
            playList = doc.getElementsByClass("fn-playlist-item fn-song");
            List<String> songList = new ArrayList<>();
            for (Element element : playList) {
                songList.add(element.attr("data-id"));
            }
            getListSong(songList.get(0));
        }
    }

    private void getListSong(String songId) {
        String ulrSongId = getString(R.string.song_id, songId);
        ApiClient.call().getSongDetail(ulrSongId).enqueue(new ApiCallback<Song>(this) {
            @Override
            public void success(Song song) {
                Log.d(TAG, "success: ");
                mListSong.add(song);
            }

            @Override
            public void failure(ApiError apiError) {
                Log.d(TAG, "failure: ");
            }
        });
    }
}
