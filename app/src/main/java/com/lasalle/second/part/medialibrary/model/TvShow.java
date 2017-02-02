package com.lasalle.second.part.medialibrary.model;

/**
 * Created by albert.denova on 02/02/17.
 */

public class TvShow {

    private String name;
    private Integer numberOfSeasons;
    private Integer startingYear;

    public TvShow(String name, Integer numberOfSeasons, Integer startingYear) {
        this.name = name;
        this.numberOfSeasons = numberOfSeasons;
        this.startingYear = startingYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public Integer getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Integer startingYear) {
        this.startingYear = startingYear;
    }
}
