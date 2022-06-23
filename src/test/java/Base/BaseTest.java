package Base;

import Pages.ElementPages.*;
import Pages.Homepage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public Homepage homepage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public UploadAndDownloadPage uploadAndDownloadPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\DemoQA.xlsx");
        homepage = new Homepage(driver, wdwait, excelReader);
        sidebarPage = new SidebarPage(driver, wdwait, excelReader);
        textBoxPage = new TextBoxPage(driver, wdwait, excelReader);
        checkBoxPage = new CheckBoxPage(driver, wdwait);
        radioButtonPage = new RadioButtonPage(driver, wdwait, excelReader);
        webTablesPage = new WebTablesPage(driver, wdwait, excelReader);
        buttonsPage = new ButtonsPage(driver, wdwait, excelReader);
        linksPage = new LinksPage(driver, wdwait, excelReader);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver, wdwait, excelReader);

    }

    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();

    }


}
