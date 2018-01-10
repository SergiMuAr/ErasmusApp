package com.example.sergi.erasmusapp;

import android.content.Context;

/**
 * Created by Sergi on 10/01/2018.
 */

public class FilterMovie {
    private String urlNow;
    private Context currentContext;

    public FilterMovie(Context applicationContext) {
        currentContext = applicationContext;
    }

    public String getTopRated(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/top_rated?api_key="+apik+"&language=en-US&page=1";
        return urlNow;
    }

    public String getMostPopular(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/popular?api_key="+apik+"&language=en-US&page=1";
        return urlNow;
    }

    public String getNowPlaying(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/now_playing?api_key="+apik+"&language=en-US&page=1";
        return urlNow;
    }

    public String getUpcoming(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/upcoming?api_key="+apik+"&language=en-US&page=1";
        return urlNow;
    }


}
