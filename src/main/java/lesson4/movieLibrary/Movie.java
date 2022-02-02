package lesson4.movieLibrary;

import java.util.ArrayList;

public class Movie{
    private String title;
    private String genre;
    private int year;
    private ArrayList<Actor> actors;
    private ArrayList<Director> directors;

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public Movie(String title, String genre, int year, ArrayList<Actor> actors, ArrayList<Director> directors) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.actors = actors;
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "title: " + this.title + "\n" +
               "directors: " + this.directors.toString().substring(1, this.directors.toString().length() - 1) + "\n" +
               "genre: " + this.genre + "\n" +
               "date: " + this.year + "\n" +
               "actors: " + this.actors.toString().substring(1, this.actors.toString().length() - 1) + "\n\n";
    }
}
