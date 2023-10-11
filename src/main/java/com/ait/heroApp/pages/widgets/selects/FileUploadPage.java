package com.ait.heroApp.pages.widgets.selects;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    //*[@id="file-upload"]
    WebElement fileUpload;
    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    public FileUploadPage chooseAndUploadFile(String path) {
        fileUpload.sendKeys(path);
        fileSubmit.click();
        return this;
    }
}
