package com.lasalle.second.part.medialibrary.manager;

import com.lasalle.second.part.medialibrary.data.MovieData;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;

import java.util.List;

public class LibraryManager {

    private MovieData movieData;

    public LibraryManager(MovieData movieData)
    {
        this.movieData = movieData;
    }

    public void addMovie(String name, String director, Integer releaseYear) {
        Movie movie = new Movie(name, director, releaseYear);
        movieData.addItem(movie);
    }

    public void addTvShow(String name, Integer numberOfSeasons, Integer startingYear) {
        TvShow tvShow = new TvShow(name, numberOfSeasons, startingYear);
        movieData.addItem(tvShow);
    }

    public List<Movie> getMovieList() {
        return movieData.getMovieList();
    }

    public List<TvShow> getShowList() {
        return movieData.getShowList();
    }

}
