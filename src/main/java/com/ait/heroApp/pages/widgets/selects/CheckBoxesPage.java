package com.ait.heroApp.pages.widgets.selects;

import com.ait.heroApp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends BasePage {
    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    WebElement checkbox1;
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    WebElement checkbox2;

    public CheckBoxesPage selectCheckboxes(String[] checkboxes) {
        for (String checkbox : checkboxes) {
            if (checkbox.equals("checkbox 1")) {
                clickCheckbox(checkbox1);
            }
            else if (checkbox.equals("checkbox 2")) {
                clickCheckbox(checkbox2);
            }
        }
        return this;
    }
}
