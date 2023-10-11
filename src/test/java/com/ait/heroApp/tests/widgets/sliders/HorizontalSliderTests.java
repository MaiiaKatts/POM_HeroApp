package com.ait.heroApp.tests.widgets.sliders;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.widgets.sliders.HorizontalSliderPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectHorizontalSlider();
    }

    @Test
    public void horizontalSliderTest() {
        new HorizontalSliderPage(driver)
                .moveSliderInHorizontalDirection()
                .assertToMoveHorizontalSlider("5");
    }
}
