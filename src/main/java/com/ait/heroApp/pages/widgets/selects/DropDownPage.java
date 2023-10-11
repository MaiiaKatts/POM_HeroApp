package com.ait.heroApp.pages.widgets.selects;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[2]")
    WebElement option1;
    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[3]")
    WebElement option2;
    public DropDownPage selectDropdownOption(String option) {
        if (option.equals("option 1")) {
            option1.click();
        }
        if (option.equals("option 2")) {
            option2.click();
        }
        return this;



    }
}
