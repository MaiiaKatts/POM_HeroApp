package com.ait.heroApp.pages.links;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImages extends BasePage {

    public BrokenImages(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenImages checkBrokenImages() {
        System.out.println("Amount of broken images: " + images.size());
        for (int index = 0; index < images.size(); index++) {
            WebElement image = images.get(index);
            String imageURL = image.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is " + imageURL);

            verifyLinks(imageURL);
            try {
                 boolean imageDisplayed = (Boolean)((JavascriptExecutor)driver)
                    .executeScript("return(typeof arguments[0].naturalWidth!=undefined" +
                            " && arguments[0].naturalWidth>0);", images);
                 if (imageDisplayed) {
                    System.out.println("Displayed OK");
                    System.out.println("_______________________________________________");
                 } else {
                     System.out.println("Displayed BROKEN");
                     System.out.println("_______________________________________________");
                 }
            } catch (Exception e) {
                System.out.println("ERROR");

            }
        }
        return this;
    }

}
