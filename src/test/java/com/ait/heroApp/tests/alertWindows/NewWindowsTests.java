package com.ait.heroApp.tests.alertWindows;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.alertWindows.WindowsPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowsTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getMultipleWindows();
    }
    @Test
    public void newTabTest(){
        new WindowsPage(driver)
                .switchToNewTab(1)
                .assertNewTab("New Window");
    }

}
