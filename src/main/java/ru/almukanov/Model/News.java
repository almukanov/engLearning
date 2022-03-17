package ru.almukanov.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.json.JSONArray;

import java.util.ArrayList;
@JsonIgnoreProperties (ignoreUnknown = true)
public class News {

    public News() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    private String summary;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public News(String summary, String title) {
        this.summary = summary;
        this.title = title;
    }
}
