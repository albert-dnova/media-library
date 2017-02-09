package com.lasalle.second.part.medialibrary.data.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.lasalle.second.part.medialibrary.data.MovieData;
import com.lasalle.second.part.medialibrary.data.helper.DatabaseHelper;
import com.lasalle.second.part.medialibrary.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albert.denova on 07/02/17.
 */

public class MovieDataDatabase implements MovieData {

    private static final String TABLE_NAME = "movies";

    private Context context;
    private SQLiteDatabase database;
    private List<Movie> movieList;

    public MovieDataDatabase(Context context) {
        this.context = context;
        database = DatabaseHelper.getInstance(context).getDatabase();
        movieList = new ArrayList<>();
        readFromDatabase();
    }

    @Override
    public void addItem(Movie movie) {
        movieList.add(movie);
        addToDatabase(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }

    private void addToDatabase(Movie movie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", movie.getName());
        contentValues.put("director", movie.getDirector());
        contentValues.put("releaseYear", movie.getReleaseYear());

        database.insert(TABLE_NAME, null, contentValues);
    }

    private void readFromDatabase() {
        String name = "a; DROP TABLE XXX; SELECT * From table where name = x";
        Cursor cursor = database.query(
                TABLE_NAME,
                null, // columns
                null, //where clause
                null, // where args
                null, // groupby
                null, // having
                null  // orderby
        );

        MovieCursorWrapper movieCursorWrapper = new MovieCursorWrapper(cursor);
        movieCursorWrapper.moveToFirst();

        while(!movieCursorWrapper.isAfterLast())
        {
            movieList.add(movieCursorWrapper.getMovie());
            movieCursorWrapper.moveToNext();
        }
    }

    private class MovieCursorWrapper extends CursorWrapper {

        private Cursor cursor;
        public MovieCursorWrapper(Cursor cursor) {
            super(cursor);
            this.cursor = cursor;
        }

        public Movie getMovie() {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String director = cursor.getString(cursor.getColumnIndex("director"));
            Integer releaseYear = cursor.getInt(cursor.getColumnIndex("releaseYear"));

            Movie movie = new Movie(name, director, releaseYear);
            return movie;
        }
    }
}
