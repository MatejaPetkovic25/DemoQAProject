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
    //U ovom delu deklarisemo sve elemente, varijable i stranice koje cemo koristiti iz ove klase, deklarisemo ih kao public
    //kako bi one bile vidljive u drugim klasama
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
        //Inicijalizujemo excel reader tako sto prosledjujemo putanju gde se na nasem racunaru nalazi excel file iz kog
        //cemo izvlaciti sve podatke za unos u narednim testovima, na taj nacin svi korisceni podaci bice pregledniji
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

    //Visibility wait je metoda kojom olaksavamo koriscenje WebDriverWait opcije, u ovom konkretnom slucaju u testu
    //dajemo driveru instrukcije da saceka vidljivost proslednjenog elementa
    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    // preko ove metode dajemo instrukcije driveru da saceka da prosledjeni element bude klikabilan
    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //narednom metodom olaksavamo koriscenje skrolovanja, gde metodi prosledjujemo element do cije vidljivosti ce
    //driver skrolovati
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        //tearDown je afterclass koji ce se izvrsiti na kraju svih testova, i sluzi da nakon zavrsetke ugasi Hrom
        //driver.close();
        //driver.quit();

    }


}
