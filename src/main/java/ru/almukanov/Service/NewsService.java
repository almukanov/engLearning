package ru.almukanov.Service;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.corba.se.impl.copyobject.JavaStreamObjectCopierImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.almukanov.Dao.NewsDao;
import ru.almukanov.Model.News;

import java.io.IOException;
import java.util.HashMap;

@Service
public interface NewsService {
        JSONObject response(String url) throws UnirestException, IOException;
        String translate(String string) throws UnirestException, IOException;


}
