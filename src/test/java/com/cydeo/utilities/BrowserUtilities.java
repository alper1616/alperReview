package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtilities {
    /*
   This class will be storing only the utility that can be used across the project

    */
    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }

    }
    public static void switchWindowAndVerify(WebDriver driver, String expectedUrl , String expectedTitle ){
        Set<String> allwindowhandles= driver.getWindowHandles();



        for(String each: allwindowhandles) {
            driver.switchTo().window(each);
            System.out.println(" current url " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedUrl)) {
                break;

            }
        }
        String expected = expectedTitle;
        String actual = driver.getTitle();
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual,expected);
    }

    public static void verifyTitle (WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public static void verifyTitlecontains (WebDriver driver, String expectedTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }
}

