package com.bethehero.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class TestDataUtils {
    //to genarte random numebr
    private static Random randomNumber = new Random();
    public static Integer getInt(){
        return randomNumber.nextInt(9999);
    }

    public static String getRandomName() {
        //it generates random name within 15 characters
        return RandomStringUtils.randomAlphabetic(15);
    }

    public static String getRandomEmail() {
        //it generates random name within 15 characters
        return RandomStringUtils.randomAlphabetic(15) + "@gmail.com";
    }

    public static Long getRandomWhatsappNumber() {
        //it generates random name within 15 characters
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

    }
    //enum: all values should be in caps
    //it keeps constant values
    public enum City{
        MANGALORE,
        BANGALORE,
        UDUPI,
        SHIMOGGA,
        SAGAR;
    }
    public enum Code{
        KA,
        MH,
        TN,
        HR,
        GJ;
    }
    public static String getRandomTitle() {
        return "raising the ticket for " + RandomStringUtils.randomAlphabetic(15);
    }

    public static String getRandomDescription() {
        return "describing the issue " + RandomStringUtils.randomAlphabetic(15);
    }


}
