package com.lasalle.second.part.medialibrary.manager;

import com.lasalle.second.part.medialibrary.data.MovieData;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;
import com.lasalle.second.part.medialibrary.network.LibraryNetwork;

import java.util.List;

public class LibraryManager {

    private MovieData movieData;
    private LibraryNetwork libraryNetwork;
    private List<Movie> movieList;

    public LibraryManager(MovieData movieData, LibraryNetwork libraryNetwork)
    {
        this.movieData = movieData;
        this.libraryNetwork = libraryNetwork;
    }

    public void addMovie(String name, String director, Integer releaseYear) {
        Movie movie = new Movie(name, director, releaseYear);
        movieData.addItem(movie);


        if(movieList == null)
        {
            movieList = movieData.getMovieList();
        }
        movieList.add(movie);
    }

    public void addTvShow(String name, Integer numberOfSeasons, Integer startingYear) {
        TvShow tvShow = new TvShow(name, numberOfSeasons, startingYear);
        //movieData.addItem(tvShow);
    }

    public List<Movie> getMovieList() {
        if(movieList == null)
        {
            movieList = movieData.getMovieList();
        }

        return movieList;
    }

    public List<TvShow> getShowList() {
        return null;
        //return movieData.getShowList();
    }

}
