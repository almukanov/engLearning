package ru.almukanov.Dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class NewsDaoImpl implements NewsDao{
    public JSONObject response() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://extract-news.p.rapidapi.com/v0/article?url=https%3A%2F%2Fwww.theverge.com%2F2020%2F4%2F17%2F21224728%2Fbill-gates-coronavirus-lies-5g-covid-19")
                .header("X-RapidAPI-Host", "extract-news.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
                .asString();
        String jsonString  = response.getBody();
        JSONObject obj = new JSONObject(jsonString);
        JSONObject article = obj.getJSONObject("article");
        return article;
    }

}
