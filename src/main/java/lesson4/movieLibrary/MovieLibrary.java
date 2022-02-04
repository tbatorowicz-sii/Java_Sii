package lesson4.movieLibrary;

import java.util.ArrayList;

public class MovieLibrary {
    private ArrayList<Movie> movieArrayList;

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }


    public MovieLibrary(ArrayList<Movie> movieArrayList){
        this.movieArrayList = movieArrayList;
    }

    @Override
    public String toString() {
        return movieArrayList.toString().substring(1, movieArrayList.toString().length()-1);
    }

    public Movie getMovie(int index){
        return movieArrayList.get(index);
    }

    public void addMovie(Movie movie){
        this.movieArrayList.add(movie);
    }
}