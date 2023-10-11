package com.ait.heroApp.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    //СMD + O --> Override Methods:
    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);

        logger.info("There is a problem!");
        logger.info("Object target --> " + target.toString());
        logger.info("-----------------------------------------------");

        logger.info("The problem is in method --> " + method.getName());
        logger.info("-----------------------------------------------");

        logger.info("Invocation target exception  --> " + e.getTargetException());
        logger.info("-----------------------------------------------");

        int i = new Random().nextInt(1000) + 1000;
        String link = "screenshots/screen " + i + ".png";
        logger.info("Screen with ERROR --> " + link);

        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));//google
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    //этот метод запустится первым - он выведет
    // какой именно элемент он нашел:
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);

        logger.info("Find element we need --> " + locator);
        logger.info("-----------------------------------------------");
    }
    // этот метод запустится следующим - он выведет отчет
    // вывод элемента, который он нашел:
    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);

        logger.info("Location of element we need --> " + result.getLocation());
        logger.info("-----------------------------------------------");
    }
    // этот метод запустится далее - он выведет отчет
    // вывод списка элементов, с которыми будет работать:
    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);

        logger.info("Find all elements we need --> " + locator);
        logger.info("-----------------------------------------------");
    }

    // этот метод запустится далее - он выведет отчет
    // вывод списка элементов, с которыми отработали:
    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);

        logger.info("List of all elements we looking for is --> " + result.size());
        logger.info("-----------------------------------------------");
    }
}
