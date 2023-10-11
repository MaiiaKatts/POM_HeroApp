package com.ait.heroApp.tests.interactions;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.interactions.DragAndDropPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectDragAndDrop();
    }


    @Test
    public void dragAndDropTest() {
        new DragAndDropPage(driver)
                .actionDragA()
                .assertDraggedAndDroppedElement();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
