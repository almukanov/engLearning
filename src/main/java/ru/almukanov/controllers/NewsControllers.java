package ru.almukanov.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.almukanov.Model.AutoTranslate;
import ru.almukanov.Model.News;
import ru.almukanov.Model.UserTranslate;
import ru.almukanov.Service.NewsService;

import java.io.*;

@Controller

public class NewsControllers {
    @Autowired
private  News news;
    @Autowired
    private AutoTranslate autoTranslate;
    @Autowired
    private UserTranslate userTranslate;
    private final NewsService newsService;
    @Autowired
    public NewsControllers(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }
    @PostMapping("get-article")
    public String index(@RequestParam("url") String url,  Model model) throws UnirestException, IOException {
        news.setTitle(newsService.response(url).getString("title"));
        news.setText(newsService.response(url).getString("text"));
       String translateTitle = newsService.translate(newsService.response(url).getString("title"));
       String translateText = newsService.translate(newsService.response(url).getString("text"));
       autoTranslate.setTitle(translateTitle);
       autoTranslate.setText(translateText);
       model.addAttribute("getTranslatedArticle",autoTranslate);
        return "getArticle";
    }

    @PostMapping("check-translate")
    public String checkTranslate(@RequestParam("userText") String userText
            ,@RequestParam("userTitle") String userTitle
            , Model model){
        userTranslate.setTitle(userTitle);
        userTranslate.setText(userText);
        model.addAttribute("translatedText", userTranslate);
        model.addAttribute("originText", news);
        model.addAttribute("autoTranslate",autoTranslate);
        return "checkTranslate";
    }


}
