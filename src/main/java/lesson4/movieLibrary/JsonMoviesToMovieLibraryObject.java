package lesson4.movieLibrary;

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

        String jsonString = FileUtils.readFileToString(new File("src/main/java/lesson4/movieLibrary/jsonFiles/movies"), StandardCharsets.UTF_8);
        JSONArray jsonArrayMovies = new JSONObject(jsonString).getJSONArray("movies");

        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            String movieJsonString = jsonArrayMovies.get(i).toString();
            JSONObject jsonObject = jsonArrayMovies.getJSONObject(i);

            movieLibrary.addMovie(new Movie(
                    jsonObject.getString("title"),
                    jsonObject.getString("genre"),
                    jsonObject.getInt("year"),
                    returnActorArrayList(movieJsonString, "actors"),
                    returnDirectorArrayList(movieJsonString, "directors")));
        }
    }

    public static ArrayList<Actor> returnActorArrayList(String movieJsonString, String key){
        JSONArray jsonArray = new JSONObject(movieJsonString).getJSONArray(key);
        return IntStream.range(0, jsonArray.length()).mapToObj(i -> new Actor(
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("surname")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Director> returnDirectorArrayList(String movieJsonString, String key){
        JSONArray jsonArray = new JSONObject(movieJsonString).getJSONArray(key);
        return IntStream.range(0, jsonArray.length()).mapToObj(i -> new Director(
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("surname")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}