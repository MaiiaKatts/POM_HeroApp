package com.ait.heroApp.tests.alertWindows;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.alertWindows.FramesPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectFrame();
    }
    // переход к NestedFrames
    @Test
    public void switchToNestedFramesTest() {
        new FramesPage(driver)
            .selectNestedFrames()
            .switchToNestedFrames();
    }
    @Test
    //а сколько всего iframes есть на странице (1):
    public void iFrameAmountTest() {
        new FramesPage(driver)
                .returnListOfiFrames();
    }

    @Test
    //ищем наш единственный iFrame по index(по id не сработало):
    public void switchToIFrameTest() {
        new FramesPage(driver)
                .selectIFrame()
                .switchToIFrameByIndex(0);
    }
}
