package com.github.bjanczak.assertjdemo.data;

/**
 * @author Bartłomiej Jańczak
 */
public class Movie {

    private final String title;
    private final String releaseDate;
    private final String duration;

    public Movie(String title, String releaseDate, String duration) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }
}
