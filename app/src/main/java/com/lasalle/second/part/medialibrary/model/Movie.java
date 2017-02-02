package com.lasalle.second.part.medialibrary.model;

public class Movie {

    private String name;
    private String director;
    private Integer releaseYear;

    public Movie(String name, String director, Integer releaseYear) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
