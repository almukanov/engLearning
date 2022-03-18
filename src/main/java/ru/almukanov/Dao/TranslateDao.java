package ru.almukanov.Dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class TranslateDao {
    public String translate(String string) throws UnirestException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("source=en&target=ru&q=").append(string);
        HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "e13bd3ef2bmsh79b544909f8de94p19282ejsn68224b0fe931")
                .body(stringBuilder.toString())
                .asString();
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getRawBody()));
        String str = br.readLine();
        JSONObject jsonObject = new JSONObject(str);
        return jsonObject.getJSONObject("data").getJSONArray("translations").getJSONObject(0).getString("translatedText");
    }
}
