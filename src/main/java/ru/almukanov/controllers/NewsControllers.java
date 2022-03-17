package ru.almukanov.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Model.News;

import java.io.IOException;

@Controller

public class NewsControllers {

    private final NewsDao newsDao;
    public NewsControllers(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @GetMapping
    public String index(Model model) throws UnirestException, IOException {
    model.addAttribute("getTitles",newsDao.takeAllnews());
        return "index";
    }

    @GetMapping("/engNews/{id}")
    public String startPage(Model model, @PathVariable("id") int id) throws IOException, UnirestException {
        model.addAttribute("getEngNews", newsDao.takeEngNews(id));
        return "engNews";
    }
    @GetMapping("/check")
    public String checkResult(Model model) throws UnirestException, IOException {
    model.addAttribute("getRusNews", newsDao.takeEngNews(1));
        return "check";
    }
}
