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

        //Import JSON file to String, then to JSONArray
        //Each array element contains full movie info in JSON 'language'
        String jsonString = FileUtils.readFileToString(new File("src/main/java/lesson4/movieLibrary/jsonFiles/movies"), StandardCharsets.UTF_8);
        JSONArray jsonArrayMovies = new JSONObject(jsonString).getJSONArray("movies");

        //Conversion of JSONArray to ArrayList of Strings
        ArrayList<String> jsonStringMovies = new ArrayList<>();
        for (int i=0;i<jsonArrayMovies.length();i++)
            jsonStringMovies.add(jsonArrayMovies.get(i).toString());

        //Declaration of Arrays, each Array has to contain other kind of information
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> genreList = new ArrayList<>();
        ArrayList<Integer> yearList = new ArrayList<>();
        ArrayList<ArrayList> arrArrActorNames = new ArrayList<>();
        ArrayList<ArrayList> arrArrActorSurnames = new ArrayList<>();
        ArrayList<ArrayList> arrArrDirectorNames = new ArrayList<>();
        ArrayList<ArrayList> arrArrDirectorSurnames = new ArrayList<>();

        //Iterate through "ArrayList of Strings", and assigning all movie information to correct Arrays
        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            titleList.add(jsonArrayMovies.getJSONObject(i).getString("title"));
            genreList.add(jsonArrayMovies.getJSONObject(i).getString("genre"));
            yearList.add(jsonArrayMovies.getJSONObject(i).getInt("year"));

            //Temporary Arrays to temporary hold deeper-level information
            ArrayList<String> actorsNameList = new ArrayList<>();
            ArrayList<String> actorsSurnameList = new ArrayList<>();
            ArrayList<String> directorNameList = new ArrayList<>();
            ArrayList<String> directorSurnameList = new ArrayList<>();

            for (int j = 0; j < new JSONObject(jsonStringMovies.get(i)).getJSONArray("actors").length(); j++) {
                actorsNameList.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("actors").getJSONObject(j).getString("name"));
                actorsSurnameList.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("actors").getJSONObject(j).getString("surname"));
            }
            for (int j = 0; j < new JSONObject(jsonStringMovies.get(i)).getJSONArray("directors").length(); j++) {
                directorNameList.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("directors").getJSONObject(j).getString("name"));
                directorSurnameList.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("directors").getJSONObject(j).getString("surname"));
            }

            arrArrActorNames.add(actorsNameList);
            arrArrActorSurnames.add(actorsSurnameList);
            arrArrDirectorNames.add(directorNameList);
            arrArrDirectorSurnames.add(directorSurnameList);
        }
        //Import finished!
        //Now whole JSON file is distributed to correct arrays!
        //You can make usage of this data by using arrays!


        //Converting Arrays to objects
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());
        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            ArrayList<Director> directorArrayList = new ArrayList<>();
            for (int j = 0; j < arrArrDirectorNames.get(i).size(); j++)
                directorArrayList.add(new Director(arrArrDirectorNames.get(i).get(j).toString(), arrArrDirectorSurnames.get(i).get(j).toString()));

            ArrayList<Actor> actorArrayList = new ArrayList<>();
            for (int j = 0; j < arrArrActorNames.get(i).size(); j++)
                actorArrayList.add(new Actor(arrArrActorNames.get(i).get(j).toString(), arrArrActorSurnames.get(i).get(j).toString()));

            movieLibrary.addMovie(new Movie(titleList.get(i), genreList.get(i), yearList.get(i),actorArrayList,directorArrayList));
        }

        //Display all movies info
        for (int i = 0; i < movieLibrary.getMovieArrayList().size(); i++)
            System.out.println(movieLibrary.getMovie(i).toString());


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

        /*for (int i = 0; i < movieLibrary.getMovieArrayList().size(); i++)
            System.out.println(movieLibrary.getMovie(i).toString());*/
        /*for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            System.out.println("Title: " + titleList.get(i));
            System.out.println("Genre: " + genreList.get(i));
            System.out.println("Year: " + yearList.get(i));
            for (int j = 0; j < arrArrActorNames.get(i).size(); j++)
                System.out.println("Actor: " + arrArrActorNames.get(i).get(j) + " " + arrArrActorSurnames.get(i).get(j));

            for (int j = 0; j < arrArrDirectorNames.get(i).size(); j++)
                System.out.println("Director: " + arrArrDirectorNames.get(i).get(j) + " " + (arrArrDirectorSurnames.get(i).get(j)));

            System.out.println();
            System.out.println();
        }*/ //Display Arrays entry
    }
}