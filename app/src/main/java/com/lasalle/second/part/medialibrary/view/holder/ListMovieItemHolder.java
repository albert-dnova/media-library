package com.lasalle.second.part.medialibrary.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.model.Movie;

public class ListMovieItemHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView directorTextView;

    public ListMovieItemHolder(View itemView) {
        super(itemView);

        nameTextView = (TextView) itemView.findViewById(R.id.fragment_list_item_movie_name);
        directorTextView = (TextView) itemView.findViewById(R.id.fragment_list_item_movie_director);
    }

    public void display(Movie movie) {
        nameTextView.setText(movie.getName());
        directorTextView.setText(movie.getDirector());
    }
}
