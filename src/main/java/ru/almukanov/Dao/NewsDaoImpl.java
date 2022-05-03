package ru.almukanov.Dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class NewsDaoImpl implements NewsDao{
    public JSONObject response(String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://extract-news.p.rapidapi.com/v0/article?url=" +
                        url)
                .header("X-RapidAPI-Host", "extract-news.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
                .asString();
        String jsonString  = response.getBody();
        JSONObject obj = new JSONObject(jsonString);
        JSONObject article = obj.getJSONObject("article");
        return article;
    }

}
