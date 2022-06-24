package Test;

import Base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsTests extends BaseTest {
    String URL;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        URL = excelReader.getStringData("URLs", 1, 0);
        driver.navigate().to(URL);
    }

    @Test
    public void test1() {
        homepage.clickOnFormsPageButton();
    }

    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

}
