package com.lasalle.second.part.medialibrary.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.view.activity.AbstractActivity;
import com.lasalle.second.part.medialibrary.view.holder.ListMovieItemHolder;

import java.util.List;

/**
 * Created by albert.denova on 09/02/17.
 */

public class ListMovieItemRecyclerViewAdapter extends RecyclerView.Adapter<ListMovieItemHolder> {

    private AbstractActivity activity;

    public ListMovieItemRecyclerViewAdapter(AbstractActivity activity) {
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        LibraryManager libraryManager = activity.getLibraryManager();
        List<Movie> movieList = libraryManager.getMovieList();
        return movieList.size();
    }

    @Override
    public ListMovieItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(
                R.layout.fragment_list_item_movie,
                parent,
                false);

        return new ListMovieItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ListMovieItemHolder holder, int position) {
        LibraryManager libraryManager = activity.getLibraryManager();
        List<Movie> movieList = libraryManager.getMovieList();
        holder.display(movieList.get(position));
    }
}
