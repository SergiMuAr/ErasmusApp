package com.example.sergi.erasmusapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ActionBar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Movie> movies = new ArrayList<>();
    private RVAdapter adapter = new RVAdapter(movies, this);
    private MenuItem menuItemS;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);

        //API REQUEST
        String api_key = getResources().getString(R.string.movies_api_key);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+api_key+"&language=en-US&page=1";

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
        AppSingleton.getInstance(this).addToRequestQueue(jsObjRequest, REQUEST_TAG);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menuItemS = menu.findItem(R.id.action_buscar);
//        searchView = (SearchView) MenuItemCompat.getActionView(menuItemS);

        return true;
    }

    private void loadList (ArrayList<Movie> e) {
        if (e.isEmpty()) {
            Toast.makeText(this.getApplicationContext(),"No results",Toast.LENGTH_SHORT).show();
        }
        movies = new ArrayList<>();
        movies = e;
        adapter.updateList(movies);
    }
}