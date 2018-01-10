package com.example.sergi.erasmusapp;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
        switch (mPage){
            case 1:
                    //API REQUEST
                filterMovie = new FilterMovie(getActivity().getApplicationContext());
                String url = filterMovie.getNowPlaying();

                JsonObjectRequest jsObjRequest = new JsonObjectRequest
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



                String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonObjectRequest";
                // Access the RequestQueue through your singleton class.
                AppSingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest, REQUEST_TAG);
                break;
            case 2:
                break;
            case 3:
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