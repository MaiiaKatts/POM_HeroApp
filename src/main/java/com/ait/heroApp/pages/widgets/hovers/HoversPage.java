package com.ait.heroApp.pages.widgets.hovers;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img")
    WebElement imgUser1;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/h5")
    WebElement nameUser1;

    public HoversPage hoverOver() {
        new Actions(driver)
                .moveToElement(imgUser1)
                .moveToElement(nameUser1)
                .perform();
        return this;
    }

    public HoversPage assertHoverOver(String value) {
        Assert.assertEquals(nameUser1.getText(), value);
        return this;
    }
}
