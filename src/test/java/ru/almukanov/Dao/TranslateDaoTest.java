package ru.almukanov.Dao;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TranslateDaoTest {
    TranslateDao translateDao;
    @Before
    public void translateCreating() throws UnirestException, IOException {
    translateDao   = new TranslateDao();

    }
    @Test
    public void translateNormalData() throws UnirestException, IOException {
        String str1 =  translateDao.translate("Hi");
        String str2 = "Привет";
        Assert.assertEquals(str1, str2);
    }

    @Test
    public void translateAbnormalData() throws UnirestException, IOException {
        String str1 =  translateDao.translate("Hi");
        String str2 = "Пока";
        Assert.assertNotEquals(str1,str2);
    }

}