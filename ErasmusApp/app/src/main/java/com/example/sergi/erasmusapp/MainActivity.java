package com.example.sergi.erasmusapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ratingbar));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ratingbar));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ratingbar));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeData();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RVAdapter adapter = new RVAdapter(persons);
        mRecyclerView.setAdapter(adapter);


    }
}
