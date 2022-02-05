package lesson4.movielibrary.functions;

import lesson4.movielibrary.classes.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonMoviesToMovieLibraryObject {

    public JsonMoviesToMovieLibraryObject(MovieLibrary movieLibrary) throws IOException {

        String jsonFilePath = "src/main/java/lesson4/movieLibrary/jsonFiles/movies";
        String jsonString = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        JSONArray jsonArrayMovies = new JSONObject(jsonString).getJSONArray("movies");

        for (int i = 0; i < jsonArrayMovies.length(); i++) {
            String movieJsonString = jsonArrayMovies.get(i).toString();
            JSONObject jsonObject = jsonArrayMovies.getJSONObject(i);

            movieLibrary.addMovie(new Movie(
                    jsonObject.getString("title"),
                    jsonObject.getString("genre"),
                    jsonObject.getInt("year"),
                    returnPersonArrayList(movieJsonString, "actors")
                            .stream().map(Actor::new).collect(Collectors.toCollection(ArrayList::new)),
                    returnPersonArrayList(movieJsonString, "directors")
                            .stream().map(Director::new).collect(Collectors.toCollection(ArrayList::new))));
        }
    }

    public static ArrayList<Person> returnPersonArrayList(String movieJsonString, String key) {
        JSONArray jsonArray = new JSONObject(movieJsonString).getJSONArray(key);
        return IntStream.range(0, jsonArray.length()).mapToObj(i -> new Person(
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("surname")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}