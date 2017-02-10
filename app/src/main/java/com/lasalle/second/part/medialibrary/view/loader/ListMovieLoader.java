package com.lasalle.second.part.medialibrary.view.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.lasalle.second.part.medialibrary.manager.LibraryManager;
import com.lasalle.second.part.medialibrary.model.Movie;

import java.util.List;

/**
 * Created by albert.denova on 09/02/17.
 */

public class ListMovieLoader extends AsyncTaskLoader<List<Movie>> {

    private LibraryManager libraryManager;

    public ListMovieLoader(Context context, LibraryManager libraryManager) {
        super(context);
        this.libraryManager = libraryManager;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Movie> loadInBackground() {
        return libraryManager.getMovieList();
    }
}
