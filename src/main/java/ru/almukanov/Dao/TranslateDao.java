package ru.almukanov.Dao;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public interface TranslateDao {
    String translate(String string) throws UnirestException, IOException;
}
