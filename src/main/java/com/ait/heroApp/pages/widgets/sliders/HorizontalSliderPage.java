package com.ait.heroApp.pages.widgets.sliders;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/input")
    WebElement horizontalSlider;

    public HorizontalSliderPage moveSliderInHorizontalDirection() {
        pause(500);
        new Actions(driver)
                .dragAndDropBy(horizontalSlider,65,0)
                .perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;
    public HorizontalSliderPage assertToMoveHorizontalSlider(String number) {
        Assert.assertTrue(isTextPresent(range,number));
        return this;
    }
}
