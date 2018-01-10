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

    public void setTopRated(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/top_rated?api_key="+apik+"&language=en-US&page=1";
    }

    public void setMostPopular(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/popular?api_key="+apik+"&language=en-US&page=1";
    }

    public void setNowPlaying(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/now_playing?api_key="+apik+"&language=en-US&page=1";
    }

    public void setUpcoming(){
        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
        String apik = currentContext.getResources().getString(R.string.movies_api_key);
        urlNow = baseUrl+"/upcoming?api_key="+apik+"&language=en-US&page=1";
    }

    public String getUrlNow(){
        return urlNow;
    }


}
