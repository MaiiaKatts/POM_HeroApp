package com.ait.heroApp.tests.widgets.selects;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.widgets.selects.DropDownPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectDropdown();
    }
    @Test
    public void selectOneOptionDropdown() {
        new DropDownPage(driver)
                .selectDropdownOption("Option 1");
    }
}
