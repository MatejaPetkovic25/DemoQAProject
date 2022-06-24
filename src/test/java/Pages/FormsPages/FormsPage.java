package Pages.FormsPages;

import Base.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;

    public FormsPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
    }
}
