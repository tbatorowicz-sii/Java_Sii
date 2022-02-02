package lesson4.movieLibrary;

import java.util.ArrayList;

public class MovieLibary {
    private ArrayList<Movie> movieArrayList;

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }


    public MovieLibary(ArrayList<Movie> movieArrayList){
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
