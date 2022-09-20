package com.bethehero.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyHelper {
    public PropertyHelper() {

    }
    //to load the data from property file-->stores into RAM as key value pair
    //to read the config file for java(key value)
    //method overloading
    public static Properties loadPropertiesFile(){
        //read the file location
        //user.dir ---> java inbuilt property will be fetch using System.getProperty + fileName
        String path = System.getProperty("user.dir") + "/config.properties";
        Properties prop = new Properties();
        try {
            //load the file
            prop.load(Files.newInputStream(Paths.get(path)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return prop;//return the property
    }
    public static Properties loadPropertiesFile(String path){

        Properties prop = new Properties();
        try {
            prop.load(Files.newInputStream(Paths.get(path)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
