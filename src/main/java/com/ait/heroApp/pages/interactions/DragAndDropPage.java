package com.ait.heroApp.pages.interactions;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;
    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage actionDragA() {
        new Actions(driver)
                .dragAndDrop(columnA,columnB)
                        .perform();
        return this;
    }

    public DragAndDropPage assertDraggedAndDroppedElement() {
        Assert.assertEquals(columnA.getText(), "B");
        Assert.assertEquals(columnB.getText(), "A");
        return this;
    }
}
