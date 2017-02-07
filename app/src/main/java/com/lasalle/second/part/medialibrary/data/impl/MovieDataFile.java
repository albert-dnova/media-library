package com.lasalle.second.part.medialibrary.data.impl;

import android.content.Context;

import com.lasalle.second.part.medialibrary.data.MovieData;
import com.lasalle.second.part.medialibrary.model.Movie;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieDataFile implements MovieData {

    private static final String FILE_NAME = "movies.csv";

    private Context context;

    private List<Movie> movieList;

    public MovieDataFile(Context context) {
        this.context = context;
        this.movieList = new ArrayList<>();
        readFromFile();
    }

    @Override
    public void addItem(Movie movie) {
        movieList.add(movie);
        saveFile();
    }

    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }

    private void saveFile() {
        try {
            OutputStream outputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            String csvList = getListAsCsv();
            outputStream.write(csvList.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            bufferedReader.readLine();

            String lineText;
            while((lineText = bufferedReader.readLine()) != null) {
                String[] fields = lineText.split(",");

                String name = fields[0];
                String director = fields[1];
                Integer releaseYear = Integer.parseInt(fields[2]);

                movieList.add(new Movie(name, director, releaseYear));
            }

            inputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getListAsCsv() {
        String csvList = "name,director,year\n";

        for(Movie movie : movieList) {
            csvList += movie.getName() + ",";
            csvList += movie.getDirector() + ",";
            csvList += movie.getReleaseYear().toString() + "\n";
        }

        return csvList;
    }

}
