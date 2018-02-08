//package com.example.sergi.erasmusapp;
//
//import android.content.Context;
//
///**
// * Created by Sergi on 10/01/2018.
// */
//
//public class FilterBook {
//    private String urlNow;
//    private Context currentContext;
//
//    public FilterBook(Context applicationContext) {
//        currentContext = applicationContext;
//    }
//
//    public String getUrlNow(String url_type){
//        switch (url_type){
//            case AppSingleton.TOP_RATED:
//                getTopRated();
//                break;
//            case AppSingleton.MOST_POPULAR:
//                getMostPopular();
//                break;
//            case AppSingleton.PLAYING:
//                getNowPlaying();
//                break;
//            case AppSingleton.UPCOMING:
//                getUpcoming();
//                break;
//        }
//        return urlNow;
//    }
//
////    private void getTopRated(){
////        String baseUrl = currentContext.getResources().getString(R.string);
////        String apik = currentContext.getResources().getString(R.string.movies_api_key);
////        urlNow = baseUrl+"/top_rated?api_key="+apik+"&language=en-US&page=1";
////    }
////
////    private void getMostPopular(){
////        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
////        String apik = currentContext.getResources().getString(R.string.movies_api_key);
////        urlNow = baseUrl+"/popular?api_key="+apik+"&language=en-US&page=1";
////    }
////
////    private void getNowPlaying(){
////        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
////        String apik = currentContext.getResources().getString(R.string.movies_api_key);
////        urlNow = baseUrl+"/now_playing?api_key="+apik+"&language=en-US&page=1";
////    }
////
////    private void getUpcoming(){
////        String baseUrl = currentContext.getResources().getString(R.string.movie_baseUrl);
////        String apik = currentContext.getResources().getString(R.string.movies_api_key);
////        urlNow = baseUrl+"/upcoming?api_key="+apik+"&language=en-US&page=1";
////    }
//
//
//}
