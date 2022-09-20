package com.bethehero.test;

import com.bethehero.utils.PropertyHelper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public static Properties properties;
    @BeforeTest(alwaysRun = true)
    public void loadBasicData(){
       //load the property file (config file)
        properties =  PropertyHelper.loadPropertiesFile();
    }
    @BeforeClass(alwaysRun = true)
    //sets the URL
    public void setBaseURL(){
        RestAssured.baseURI = properties.getProperty("url");
    }
}
