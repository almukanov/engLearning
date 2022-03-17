package ru.almukanov.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.almukanov.Dao.NewsDao;

import java.io.IOException;

@Controller
public class NewsControllers {
    private final NewsDao newsDao;
    public NewsControllers(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

@GetMapping("/check")
    public String checkResult(Model model){
        return "check";
    }

    @GetMapping("/engNews")
    public String startPage(Model model) throws IOException, UnirestException {
        model.addAttribute("getEngNews", newsDao.takeEngNews());
        return "engNews";
    }
}
