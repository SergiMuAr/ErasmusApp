package com.example.sergi.erasmusapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
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


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView navView;
    private AppSingleton mAppSingletonInstance;
    private DrawerLayout mDrawerLayout;
    private PagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        navView = (NavigationView) findViewById(R.id.navview);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listenersDrawer();
        setupTabLayout();
        mAppSingletonInstance = AppSingleton.getInstance(getApplicationContext());
        mAppSingletonInstance.setUrlType(mAppSingletonInstance.TOP_RATED);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menuItemS = menu.findItem(R.id.action_buscar);
//        searchView = (SearchView) MenuItemCompat.getActionView(menuItemS);

        return true;
    }

    private void setupTabLayout(){

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pageAdapter = new PagerAdapter(getSupportFragmentManager(), getApplication());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void listenersDrawer() {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case R.id.top_rated:
                                mAppSingletonInstance.setUrlType(mAppSingletonInstance.TOP_RATED);
                                viewPager.invalidate();
                                mDrawerLayout.closeDrawer(navView);
                                pageAdapter.refresh();
                                break;
                            case R.id.most_popular:
                                mAppSingletonInstance.setUrlType(mAppSingletonInstance.MOST_POPULAR);
                                viewPager.invalidate();
                                mDrawerLayout.closeDrawer(navView);
                                pageAdapter.refresh();
                                break;
                            case R.id.now_playing:
                                mAppSingletonInstance.setUrlType(mAppSingletonInstance.PLAYING);
                                viewPager.invalidate();
                                mDrawerLayout.closeDrawer(navView);
                                pageAdapter.refresh();
                                break;
                            case R.id.upcoming:
                                mAppSingletonInstance.setUrlType(mAppSingletonInstance.UPCOMING);
                                viewPager.invalidate();
                                mDrawerLayout.closeDrawer(navView);
                                pageAdapter.refresh();
                                break;
//                            case R.id.about_us:
//                                mDrawerLayout.closeDrawer(navView);
//                                Intent intent2 = new Intent(MainActivity.this, AboutUsActivity.class);
//                                startActivity(intent2);
//                                break;
//                            case R.id.help:
//                                mDrawerLayout.closeDrawer(navView);
//                                Intent intent3 = new Intent(MainActivity.this, HelpActivity.class);
//                                startActivity(intent3);
//                                break;
                            default:
                        }
                        return true;
                    }
                });
    }

}