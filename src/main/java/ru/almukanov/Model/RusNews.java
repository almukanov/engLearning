package ru.almukanov.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RusNews {
    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public RusNews() {
    }

    public RusNews(String translatedText) {
        this.translatedText = translatedText;
    }

    private String translatedText;

}
