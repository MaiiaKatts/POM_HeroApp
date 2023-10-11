package com.ait.heroApp.tests.alertWindows;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.alertWindows.AlertsPage;
import com.ait.heroApp.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends TestBase {

    @BeforeMethod
    public  void precondition() {
        new HomePage(driver).getAlerts();
    }


    @Test
    public void acceptAlertTest(){
        new AlertsPage(driver)
                .acceptAlert()
                .assertAcceptAlert("You successfully clicked an alert");
    }

    @Test
    public  void confirmAlertTest(){
        new AlertsPage(driver)
                .confirmAlert("cancel")
                .assertAcceptAlert("Cancel");
    }

    @Test
    public void sendTextToAlertTest(){
        new AlertsPage(driver)
                .sendTextToAlertTest("Good Night and Good Luck")
                .assertAcceptAlert("Good Night and Good Luck");
    }
}
