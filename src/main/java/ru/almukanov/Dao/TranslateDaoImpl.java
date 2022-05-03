package ru.almukanov.Dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class TranslateDaoImpl implements TranslateDao{

    public String translate(String string) throws UnirestException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        HttpResponse<String> response = Unirest.post("https://text-translator2.p.rapidapi.com/translate")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Host", "text-translator2.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a69f474044msh1879edf3376dcc5p16dc40jsn099b78a44dd9")
                .body("source_language=en&target_language=ru&text="+stringBuilder.toString())
                .asString();
        JSONObject jsonObject = new JSONObject(response.getBody());
        return jsonObject.getJSONObject("data").getString("translatedText");
    }
}
