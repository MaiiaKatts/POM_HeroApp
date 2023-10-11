package com.ait.heroApp.tests.links;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.links.BrokenImages;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public  void precondition(){
        new HomePage(driver)
                .checkAllLinks()
                .getBrokenImages();
    }

    @Test
    public void checkBrokenImagesTest(){
        new BrokenImages(driver).checkBrokenImages();
    }
}
