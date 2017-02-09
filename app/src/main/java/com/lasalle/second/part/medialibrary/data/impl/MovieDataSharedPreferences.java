package com.lasalle.second.part.medialibrary.data.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lasalle.second.part.medialibrary.data.MovieData;
import com.lasalle.second.part.medialibrary.model.Movie;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieDataSharedPreferences implements MovieData {

    private static final String PREFERENCES_NAME = "library-movies";

    private static final String ITEMS_KEY_NAME = "items";

    private Context context;
    private List<Movie> movieList;

    public MovieDataSharedPreferences(Context context) {
        this.context = context;
        movieList = new ArrayList<>();
        readFromSharedPreferences();
    }

    @Override
    public void addItem(Movie movie) {
        movieList.add(movie);
        writeToSharedPreferences();
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }


    private void writeToSharedPreferences() {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        Gson gson = new Gson();
        String jsonString = gson.toJson(movieList);

        editor.putString(ITEMS_KEY_NAME, jsonString);
        editor.commit();
    }

    private void readFromSharedPreferences() {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        String content = sharedPreferences.getString(ITEMS_KEY_NAME, "");


        Type collectionType = new TypeToken<List<Movie>>(){}.getType();
        Gson gson = new Gson();
        movieList = gson.fromJson(content, collectionType);
    }

}
