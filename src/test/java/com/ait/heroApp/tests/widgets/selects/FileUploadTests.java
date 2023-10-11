package com.ait.heroApp.tests.widgets.selects;

import com.ait.heroApp.pages.HomePage;
import com.ait.heroApp.pages.widgets.selects.FileUploadPage;
import com.ait.heroApp.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectFileUpload();
    }
    @Test
    public void selectFileForUploading(){
        new FileUploadPage(driver).chooseAndUploadFile(
                "/Users/mvideo/JavaAIT/Tools/bigVersionDracula.jpeg"
        );
    }
}
