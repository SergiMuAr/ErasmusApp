package com.example.sergi.erasmusapp;

/**
 * Created by Sergi on 29/12/2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    List<Movie> movies;
    Context mContext;
    FilterMovie filterMovie;

    RVAdapter(List<Movie> movies, Context context){
        this.movies = movies;
        this.mContext = context;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView titleTxtView;
        TextView yearTxtView;
        ImageView photoTxtView;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            titleTxtView = (TextView)itemView.findViewById(R.id.title);
            yearTxtView = (TextView)itemView.findViewById(R.id.year);
            photoTxtView = (ImageView)itemView.findViewById(R.id.photo);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.titleTxtView.setText(movies.get(i).title);
        personViewHolder.yearTxtView.setText(movies.get(i).year);
        Picasso.with(mContext).load(movies.get(i).photoPath).into(personViewHolder.photoTxtView);
//        personViewHolder.photoTxtView.setImageResource(movies.get(i).photoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void updateList (ArrayList<Movie> newList){
        movies = new ArrayList<>();
        movies.addAll (newList);
        notifyDataSetChanged();

    }

}