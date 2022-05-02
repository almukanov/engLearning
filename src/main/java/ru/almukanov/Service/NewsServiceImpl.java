package ru.almukanov.Service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Model.News;

import java.io.IOException;
import java.util.HashMap;

@Service
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;
    @Autowired
    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    @Override
    public JSONObject response() throws UnirestException, IOException {
        JSONObject  article = newsDao.response();
        return article;
    }
}
