package ru.almukanov.Dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jdk.nashorn.api.scripting.URLReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.almukanov.Model.News;
import ru.almukanov.Model.RusNews;

import java.io.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class NewsDao {
    private static int count = 0;
    private News newsId;
    private News[] n;

    {
        n = new News[1];

    }
    /*public JSONArray translate(String string) throws UnirestException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("q=").append(string).append("&target=ru&source=en");
        HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
                .body(stringBuilder.toString())
                .asString();
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getRawBody()));
        String str = br.readLine();
        JSONObject jsonObject = new JSONObject(str);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("translations");
        return jsonArray;
    }
   /*
    public static HttpURLConnection connection;
    public static JSONArray conn() throws IOException {
        BufferedReader reader;
        String line;

        StringBuilder responseContent = new StringBuilder();
        try {
            URL url = new URL("http://api.mediastack.com/v1/news?access_key=4e93e8b88d96caaa5c8225b1191f6940");
            connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla");


            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);

                }

                reader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        return jsonArray;
    }
    */
    public JSONArray response() throws UnirestException, IOException {
    HttpResponse<String> response = Unirest.get("https://free-news.p.rapidapi.com/v1/search?q=Elon%20Musk&lang=en")
            .header("x-rapidapi-host", "free-news.p.rapidapi.com")
            .header("x-rapidapi-key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
            .asString();
    BufferedReader br = new BufferedReader(new InputStreamReader(response.getRawBody()));
    String str = br.readLine();
    JSONObject jsonObject = new JSONObject(str);
    JSONArray jsonArray = jsonObject.getJSONArray("articles");
    return jsonArray;
}



public News takeNewsFromList(){
        News news = n[0];
        return news;
}

    public List<News> takeEngNews(int id) throws IOException, UnirestException {
            ObjectMapper mapper = new ObjectMapper();
            List<News> news = new ArrayList<>();
            JSONObject jsonObject = response().getJSONObject(id);
            News engNews = mapper.readValue(jsonObject.toString(),News.class);
            news.add(engNews);
            n[0] = engNews;
            return news;
    }

    public HashMap<Integer, News> takeAllnews() throws IOException, UnirestException {
    ObjectMapper mapper = new ObjectMapper();
    JSONArray jsonArray = response();
        HashMap<Integer,News> news = new HashMap<>();
        int id = 0;
        for (int i = 0; i < 10; i++)
        {
            try {
                JSONObject obj = jsonArray.getJSONObject(i);
                news.put(i,mapper.readValue(obj.toString(),News.class));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return news;
    }

}


