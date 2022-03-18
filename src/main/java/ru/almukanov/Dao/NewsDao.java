package ru.almukanov.Dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import ru.almukanov.Model.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class NewsDao {

    private final News[] n;

    {
        n = new News[1];

    }

    public JSONArray response() throws UnirestException, IOException {
    HttpResponse<String> response = Unirest.get("https://free-news.p.rapidapi.com/v1/search?q=Elon%20Musk&lang=en")
            .header("x-rapidapi-host", "free-news.p.rapidapi.com")
            .header("x-rapidapi-key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
            .asString();
    BufferedReader br = new BufferedReader(new InputStreamReader(response.getRawBody()));
    String str = br.readLine();
    JSONObject jsonObject = new JSONObject(str);
        return jsonObject.getJSONArray("articles");
}



public News takeNewsFromList(){
    return n[0];
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


