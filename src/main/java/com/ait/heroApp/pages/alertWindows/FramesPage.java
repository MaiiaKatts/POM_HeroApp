package com.ait.heroApp.pages.alertWindows;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@id=\"content\"]/div/ul/li[1]/a")
    WebElement nestedFrames;
    public FramesPage selectNestedFrames() {
        click(nestedFrames);
        return this;
    }



    @FindBy(xpath = "//frame[@name='frame-top']")
    WebElement topFrame;
    @FindBy(xpath = "//frame[@name='frame-left']")
    WebElement leftFrame;
    @FindBy(xpath = "//frame[@name='frame-middle']")
    WebElement middleFrame;
    @FindBy(xpath = "//frame[@name='frame-right']")
    WebElement rightFrame;
    @FindBy(xpath = "//frame[@name='frame-bottom']")
    WebElement bottomFrame;
    @FindBy(tagName = "body")
    WebElement body;

    public FramesPage switchToNestedFrames() {
        System.out.println("On the Nested frames page there are ");//добавить top и bottom frame
        driver.switchTo().frame(topFrame);
        System.out.println("In the top-frame there are: ");

        driver.switchTo().frame(leftFrame);
        System.out.println("1. " + body.getText() + "-frame");
        driver.switchTo().parentFrame();

        driver.switchTo().frame(rightFrame);
        System.out.println("2. " + body.getText() + "-frame");
        driver.switchTo().parentFrame();

        driver.switchTo().frame(middleFrame);
        System.out.println("3. " + body.getText() + "-frame");
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(bottomFrame);
        System.out.println("In the bottom frame there is: "
                + driver.findElement(By.tagName("body")).getText()
                + "-frame");
        driver.switchTo().defaultContent();
        return this;
    }
    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/a")
    WebElement iFrame;

    public FramesPage selectIFrame() {
        iFrame.click();
        return this;
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/a")
    List<WebElement> iFrames;

    public FramesPage returnListOfiFrames() {
        System.out.println("Total amount of iFrames on the page: "
                + iFrames.size());
        return this;
    }

    @FindBy(id="tinymce")
    WebElement iFrameText;

    @FindBy(id="content")
    WebElement mainPageTitle;

    public FramesPage switchToIFrameByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text in iFrame-element: " + iFrameText.getText());
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + mainPageTitle.getText());
        return this;
    }
}
//автоматизировать тестирование "Drag and Drop" и "Hovers"