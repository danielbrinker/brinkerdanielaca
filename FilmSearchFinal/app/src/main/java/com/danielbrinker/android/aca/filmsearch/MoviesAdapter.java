package com.danielbrinker.android.aca.filmsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielbrinker on 10/17/16.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;


    public MoviesAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ? 0 : mMovieList.size();
        /*
        The return above contains a ternary operator.
        It basically does the same things as an if/else statement.
        So if mMovieList is null, 0 will be returned, otherwise, the size of mMovieList will be returned.
         */

    }

    public void setMovieList(List<Movie> movieList) {
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed.
        // If we don't call this, app will crash.
        notifyDataSetChanged();
    }


    public List<Movie> getMovieList() {
        return mMovieList;
    }
}
