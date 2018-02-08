//package com.example.sergi.erasmusapp;
//
//import android.support.v7.widget.RecyclerView;
//
///**
// * Created by Sergi on 07/02/2018.
// */
//
//public class ScrollListener extends RecyclerView.OnScrollListener {
//
//    private int visibleThreshold = 5;
//    private int currentPage = 0;
//    private int previousTotal = 0;
//    private boolean loading = true;
//
//    public ScrollListener() {
//    }
//    public ScrollListener(int visibleThreshold) {
//        this.visibleThreshold = visibleThreshold;
//    }
//
//    @Override
//    public void onScroll(RecyclerView recyclerView, int firstVisibleItem,
//                         int visibleItemCount, int totalItemCount) {
//        if (loading) {
//            if (totalItemCount > previousTotal) {
//                loading = false;
//                previousTotal = totalItemCount;
//                currentPage++;
//            }
//        }
//        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
//            // LOAD MORE DATA
//            loading = true;
//        }
//    }
//
//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//    }
//}