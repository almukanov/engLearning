package ru.almukanov.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Dao.TranslateDao;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller

public class NewsControllers {

    private final NewsDao newsDao;
    private final TranslateDao translateDao;
    public NewsControllers(NewsDao newsDao, TranslateDao translateDao) {
        this.newsDao = newsDao;
        this.translateDao = translateDao;
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


    @PostMapping ("/check")
    public String translateEnRu(Model model, @ModelAttribute("myTranslate") String str) throws UnirestException, IOException {
        model.addAttribute("translateEnRu", translateDao.translate(newsDao.takeNewsFromList().getSummary()));
        model.addAttribute("getOneNews", newsDao.takeNewsFromList());
        //encoding to ISO_8859_1
        InputStream inputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1));
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        // end encoding
        String string = br.readLine();
        model.addAttribute("getMyTranslate", string);

      return "check";
    }

}
