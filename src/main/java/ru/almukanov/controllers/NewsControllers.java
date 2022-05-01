package ru.almukanov.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Dao.TranslateDao;
import ru.almukanov.Model.News;
import ru.almukanov.Service.NewsService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Controller

public class NewsControllers {
    @Autowired
private  News news;
    private final NewsService newsService;
    @Autowired
    public NewsControllers(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String index(Model model) throws UnirestException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        news = objectMapper.readValue(newsService.response().toString(), News.class);

    model.addAttribute("getArticle",news);


        return "index";
    }



}
