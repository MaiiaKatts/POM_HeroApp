package com.ait.heroApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element) {
        element.click();
    }
    public void type(WebElement element, String text) {
        if (text != null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTextPresent(WebElement element, String message) {
        return element.getText().contains(message);
    }

    public boolean shouldHaveText(
            WebElement element,
            String text,
            int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.
                        textToBePresentInElement(element,text));
    }

    public void verifyLinks(String linkURL) {
        try {
            URL url = new URL(linkURL);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(
                        linkURL + " - "
                                + connection.getResponseMessage()
                                + " is a broken link");
            } else {
                System.out.println(
                        linkURL + " - "
                                + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkURL + " - "
                    + e.getMessage() + " is a broken link");
        }
    }
    public String getValueAttribute(WebElement element, String value) {
        return element.getAttribute(value);
    }
}
