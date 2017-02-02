package com.lasalle.second.part.medialibrary.manager;

import com.lasalle.second.part.medialibrary.data.LibraryData;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;

import java.util.List;

public class LibraryManager {

    private LibraryData libraryData;

    public LibraryManager(LibraryData libraryData)
    {
        this.libraryData = libraryData;
    }

    public void addMovie(String name, String director, Integer releaseYear) {
        Movie movie = new Movie(name, director, releaseYear);
        libraryData.addItem(movie);
    }

    public void addTvShow(String name, Integer numberOfSeasons, Integer startingYear) {
        TvShow tvShow = new TvShow(name, numberOfSeasons, startingYear);
        libraryData.addItem(tvShow);
    }

    public List<Movie> getMovieList() {
        return libraryData.getMovieList();
    }

    public List<TvShow> getShowList() {
        return libraryData.getShowList();
    }

}
