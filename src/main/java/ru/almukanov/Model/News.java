package ru.almukanov.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties (ignoreUnknown = true)
@Component
public class News {
    private String text;
    private String title;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public News(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public News() {
    }

    public News(String message) {
        this.message = message;
    }

    public News(String title, String text) {
        this.text = text;
        this.title = title;
    }
}
