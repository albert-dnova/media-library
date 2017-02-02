package com.lasalle.second.part.medialibrary.data;

import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;

import java.util.List;

/**
 * Created by albert.denova on 02/02/17.
 */
public interface LibraryData {
    void addItem(Movie movie);

    void addItem(TvShow tvShow);

    List<Movie> getMovieList();

    List<TvShow> getShowList();
}
