package com.ait.heroApp.tests.widgets.selects;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.widgets.selects.CheckBoxesPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectCheckbox();
    }

    @Test
    public void selectCheckboxes(){
        new CheckBoxesPage(driver).selectCheckboxes(
                new String[]{"checkbox 1"}
        );
    }

    @Test
    public void defaultCheckbox(){}
}
