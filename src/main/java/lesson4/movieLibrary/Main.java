package lesson4.movieLibrary;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());

        String jsonString = FileUtils.readFileToString(new File("src/main/java/lesson4/movieLibrary/jsonFiles/movies"), StandardCharsets.UTF_8);
        JSONArray jsonArrayMovies = new JSONObject(jsonString).getJSONArray("movies");

        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            String movieJsonString = jsonArrayMovies.get(i).toString();

            JSONObject jsonObject = jsonArrayMovies.getJSONObject(i);
            String title = jsonObject.getString("title");
            String genre = jsonObject.getString("genre");
            int year = jsonObject.getInt("year");

            JSONArray jsonArrayActors = new JSONObject(movieJsonString).getJSONArray("actors");
            ArrayList<Actor> actorArrayList = new ArrayList<>();
            for (int j = 0; j < jsonArrayActors.length(); j++) {
                String name = jsonArrayActors.getJSONObject(j).getString("name");
                String surname = jsonArrayActors.getJSONObject(j).getString("surname");
                actorArrayList.add(new Actor(name, surname));
            }

            JSONArray jsonArrayDirectors = new JSONObject(movieJsonString).getJSONArray("directors");
            ArrayList<Director> directorArrayList = new ArrayList<>();
            for (int j = 0; j < jsonArrayDirectors.length(); j++) {
                String name = jsonArrayDirectors.getJSONObject(j).getString("name");
                String surname = jsonArrayDirectors.getJSONObject(j).getString("surname");
                directorArrayList.add(new Director(name, surname));
            }

            movieLibrary.addMovie(new Movie(title, genre, year, actorArrayList, directorArrayList));
        }

        while (true) {
            System.out.print("\n What do you wish to do now? \n" +
                             "1. Display movies from period \n" +
                             "2. Display info about random movie \n" +
                             "3. Type actor name and display his movies \n" +
                             "4. End program \n" +
                             "Enter the number:");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.print("\nYear from: ");
                    int yearFrom = new Scanner(System.in).nextInt();
                    System.out.print("Year to: ");
                    int yearTo = new Scanner(System.in).nextInt();
                    for (Movie m: movieLibrary.getMovieArrayList()) {
                        if(m.getYear()>=yearFrom&&m.getYear()<=yearTo)
                            System.out.println(m.getTitle());
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println(movieLibrary.getMovie(new Random().nextInt(movieLibrary.getMovieArrayList().size())));
                    break;
                case 3:
                    System.out.print("\nActor name: ");
                    String firstName = new Scanner(System.in).next();
                    System.out.print("Actor surname: ");
                    String lastName = new Scanner(System.in).next();
                    for (Movie m: movieLibrary.getMovieArrayList()) {
                        for (Actor a : m.getActors()) {
                            if (firstName.equals(a.getName()) && lastName.equals(a.getSurname())) {
                                System.out.println(m.getTitle());
                            }
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Out of range");
                    continue;
            }
        }
    }
}