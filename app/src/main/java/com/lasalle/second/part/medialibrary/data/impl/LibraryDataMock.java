package com.lasalle.second.part.medialibrary.data.impl;

import com.lasalle.second.part.medialibrary.data.LibraryData;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class LibraryDataMock implements LibraryData {

    private List<Movie> movieList;
    private List<TvShow> showList;

    public LibraryDataMock() {
        movieList = new ArrayList<>();
        showList = new ArrayList<>();

        fillMovies();
        fillShowList();
    }

    @Override
    public void addItem(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public void addItem(TvShow tvShow) {
        showList.add(tvShow);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public List<TvShow> getShowList() {
        return showList;
    }

    private void fillMovies() {
        movieList.add(new Movie("Movie 1","Director 1",1991));
        movieList.add(new Movie("Movie 2","Director 2",1992));
        movieList.add(new Movie("Movie 3","Director 3",1993));
        movieList.add(new Movie("Movie 4","Director 4",1994));
        movieList.add(new Movie("Movie 5","Director 5",1995));
    }

    private void fillShowList() {
        showList.add(new TvShow("TvShow 1", 1, 1));
        showList.add(new TvShow("TvShow 2", 2, 2));
        showList.add(new TvShow("TvShow 3", 3, 3));

    }

}
