package com.ait.heroApp.tests.widgets.hovers;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.widgets.hovers.HoversPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectHovers();
    }

    @Test
    public void hoversTest() {
        new HoversPage(driver)
                .hoverOver()
                .assertHoverOver("name: user1");
    }
}
