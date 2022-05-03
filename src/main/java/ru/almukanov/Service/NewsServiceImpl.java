package ru.almukanov.Service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Dao.TranslateDao;
import ru.almukanov.Model.News;

import java.io.IOException;
import java.util.HashMap;

@Service
public class NewsServiceImpl implements NewsService {
    private TranslateDao translateDao;



    private NewsDao newsDao;

    @Autowired
    public NewsServiceImpl(TranslateDao translateDao, NewsDao newsDao) {
        this.translateDao = translateDao;
        this.newsDao = newsDao;
    }

    @Override
    public JSONObject response(String url) throws UnirestException, IOException {
        JSONObject  article = newsDao.response(url);
        return article;
    }

    @Override
    public String translate(String string) throws UnirestException, IOException {
        return translateDao.translate(string);
    }


}
