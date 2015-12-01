package com.jayway.klab.rxandroidlab.jamendo;

import android.net.Uri;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class JamendoApi {

    public static Album.SearchResult searchAlbums(String query) {
        try {
            URL queryUrl = new URL("https://api.jamendo.com/v3.0/albums?client_id=e029116a&format=json&namesearch=" + Uri.encode(query));

            Reader json = new InputStreamReader((InputStream) queryUrl.getContent());

            return new Gson().fromJson(json, Album.SearchResult.class);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
