package com.ait.heroApp.tests;

import com.ait.heroApp.data.UserData;
import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.JSExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {
    @BeforeMethod
    public  void precondition() {
        new HomePage(driver).getFormOfAuthentication();
    }

    @Test
    public  void jsExecutorTest(){
        new JSExecutor(driver)
                .enterDataWithJSExecutor(
                        UserData.USER_NAME,
                        UserData.USER_PASSWORD)
                .clickWithJS().checkURLwithJS().checkTitleOFPageWithJS();
    }

}
