package com.example.sergi.erasmusapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.igdb.api_android_java.callback.onSuccessCallback;
import com.igdb.api_android_java.model.APIWrapper;
import com.igdb.api_android_java.model.Parameters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    private FilterMovie filterMovie;



    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Movie> movies = new ArrayList<>();

    private RVAdapter adapter;
    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_tab, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RVAdapter(movies, getActivity());
        mRecyclerView.setAdapter(adapter);
        JsonObjectRequest jsObjRequest;
        String url = "";
        String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonObjectRequest";
        filterMovie = new FilterMovie(getActivity().getApplicationContext());
        switch (mPage){
            case 1:
                    //API REQUEST
                String aux = AppSingleton.getInstance(getActivity()).getUrlType();
                url = filterMovie.getUrlNow(aux);
                jsObjRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray results = response.getJSONArray("results");

                                    Log.i("JSON: ",results.toString());
                                    ArrayList<Movie> aux = new ArrayList<> ();
                                    for (int i = 0;i < results.length();++i) {
                                        JSONObject var = results.getJSONObject(i);
                                        Movie aux2 = new Movie(var.getString("title"), var.getString("release_date"), "https://image.tmdb.org/t/p/w185" + var.getString("poster_path"));
                                        aux.add(aux2);
                                    }
                                    loadList(aux);
                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub

                            }
                        });



                // Access the RequestQueue through your singleton class.
                AppSingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest, REQUEST_TAG);
                break;
            case 2:
                String key = getActivity().getResources().getString(R.string.books_api_key);
                url = "https://www.googleapis.com/books/v1/volumes?q=intitle:&key=" + key;
                jsObjRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray results = response.getJSONArray("items");

                                    Log.i("JSON: ",results.toString());
                                    ArrayList<Movie> aux = new ArrayList<> ();
                                    for (int i = 0;i < results.length();++i) {

                                        JSONObject var = results.getJSONObject(i);
                                        if (var.has("volumeInfo") && !var.isNull("volumeInfo")){
                                            String publishDate = "Not available";
                                            String title = "Not available";
                                            String thumbnail = "http://www.riobeauty.it/images/product_image_not_found.gif";
                                            JSONObject volume = var.getJSONObject("volumeInfo");
                                            if (volume.has("publishedDate") && !volume.isNull("publishedDate"))
                                                publishDate = volume.getString("publishedDate");
                                            if (volume.has("title") && !volume.isNull("title"))
                                                title = volume.getString("title");
                                            if (volume.has("imageLinks") && !volume.isNull("imageLinks")){
                                                JSONObject image = volume.getJSONObject("imageLinks");
                                                thumbnail = image.getString("thumbnail");
                                            }
                                            Movie aux2 = new Movie(title, publishDate, thumbnail);
                                            aux.add(aux2);
                                        }
                                    }
                                    loadList(aux);
                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub

                            }
                        });

                // Access the RequestQueue through your singleton class.
                AppSingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest, REQUEST_TAG);
                break;
            case 3:
                Context context = getActivity().getApplicationContext();
                APIWrapper wrapper = new APIWrapper(context, context.getResources().getString(R.string.games_api_key));
                Parameters params = new Parameters()
                        .addFields("*")
                        .addOrder("published_at:desc");

                wrapper.games(params, new onSuccessCallback(){
                    @Override
                    public void onSuccess(JSONArray result) {
                        // Do something with resulting JSONArray
                        Log.i("JSON: ",result.toString());
                        ArrayList<Movie> aux = new ArrayList<> ();
                        for (int i = 0;i < result.length();++i) {
                            JSONObject var = null;
                            try {
                                var = result.getJSONObject(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Movie aux2 = null;
                            try {
                                String urlNoHash = "https://images.igdb.com/igdb/image/upload/t_cover_big/";
                                JSONObject cover  = var.getJSONObject("cover");
                                String str = var.getString("created_at");
                                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = new Date(Long.parseLong(str));
                                aux2 = new Movie(var.getString("name"), sf.format(date), urlNoHash + cover.getString("cloudinary_id") + ".jpg");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            aux.add(aux2);
                        }
                        loadList(aux);
                    }

                    @Override
                    public void onError(VolleyError error) {
                        // Do something on error
                    }
                });
                break;
        }
        return view;
    }

    private void loadList (ArrayList<Movie> e) {
        if (e.isEmpty()) {
            Toast.makeText(getActivity().getApplicationContext(),"No results",Toast.LENGTH_SHORT).show();
        }
        movies = new ArrayList<>();
        movies = e;
        adapter.updateList(movies);
    }
}