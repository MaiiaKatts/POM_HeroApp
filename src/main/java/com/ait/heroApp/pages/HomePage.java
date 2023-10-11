package com.ait.heroApp.pages;

import com.ait.heroApp.pages.alertWindows.AlertsPage;
import com.ait.heroApp.pages.alertWindows.FramesPage;
import com.ait.heroApp.pages.alertWindows.WindowsPage;
import com.ait.heroApp.pages.interactions.DragAndDropPage;
import com.ait.heroApp.pages.links.BrokenImages;
import com.ait.heroApp.pages.widgets.hovers.HoversPage;
import com.ait.heroApp.pages.widgets.selects.CheckBoxesPage;
import com.ait.heroApp.pages.widgets.selects.DropDownPage;
import com.ait.heroApp.pages.widgets.selects.FileUploadPage;
import com.ait.heroApp.pages.widgets.sliders.HorizontalSliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alerts;

    public AlertsPage getAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement windows;

    public WindowsPage getMultipleWindows() {
        click(windows);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement form;

    public JSExecutor getFormOfAuthentication() {
        click(form);
        return new JSExecutor(driver);
    }
    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public HomePage checkAllLinks() {
        String url;
        System.out.println("Total amount of links on the page: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()){
            url=iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }
    @FindBy(xpath = "//a[.='Broken Images']")
    WebElement brokenImages;

    public BrokenImages getBrokenImages() {
        click(brokenImages);
        return new BrokenImages(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[22]/a")
    WebElement frame;

    public FramesPage selectFrame() {
        frame.click();
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//a[.='Horizontal Slider']")
    WebElement horizontalSlider;

    public HorizontalSliderPage selectHorizontalSlider() {
        click(horizontalSlider);
        return new HorizontalSliderPage(driver);
    }

    //@FindBy(xpath = "//span[.='Checkboxes']")
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[6]/a")
    WebElement checkboxes;

    public CheckBoxesPage selectCheckbox() {
        click(checkboxes);
        return new CheckBoxesPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[11]/a")
    WebElement dropdown;
    public DropDownPage selectDropdown() {
        click(dropdown);
        return new DropDownPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[18]/a")
    WebElement uploadFile;
    public FileUploadPage selectFileUpload() {
        click(uploadFile);
        return new FileUploadPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[25]/a")
    //@FindBy(xpath = "//span[.='Hovers")
    WebElement hovers;
    public HoversPage selectHovers() {
        click(hovers);
        return new HoversPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[10]/a")
    //@FindBy(xpath = "//'Drag and Drop'")
    WebElement dragAndDrop;

    public DragAndDropPage selectDragAndDrop() {
        click(dragAndDrop);
        return new DragAndDropPage(driver);
    }
}
