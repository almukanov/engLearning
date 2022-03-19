package ru.almukanov.Dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class NewsDaoTest {
    NewsDao newsDao;
    @Before
    public void newsDaoObject() throws UnirestException, IOException {
    newsDao = new NewsDao();

    }


    @Test
    public void checkStatus() throws UnirestException, IOException {
        assertTrue(newsDao.response().length()!=0);
    }
}