package Pages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Homepage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    String elementsPage;
    String formsPage;
    String alertsFrameWindowsPage;
    String widgetsPage;
    String interactionsPage;
    String bookStoreAppPage;
    WebElement homepageBanner;

    public Homepage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader){
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        elementsPage = excelReader.getStringData("ButtonNames", 1, 0);
        formsPage = excelReader.getStringData("ButtonNames", 2, 0);
        alertsFrameWindowsPage = excelReader.getStringData("ButtonNames", 3, 0);
        widgetsPage = excelReader.getStringData("ButtonNames", 4, 0);
        interactionsPage = excelReader.getStringData("ButtonNames", 5, 0);
        bookStoreAppPage = excelReader.getStringData("ButtonNames", 6, 0);
    }

    public WebElement getHomepageBanner() {
        return driver.findElement(By.className("banner-image"));
    }

    public List<WebElement> cardBodyList() {
        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.className("card-body")));
        return list;
    }

    //Na homepage-u nalazi se vise dugmica koje vode na razlicite stranice, ali nijedna nema jedinstven lokator po kojoj
    //se moze pretrazivati. Zbog toga je iznad napravljena lista tih elemenata kroz koju ce program ubuduce prolaziti
    //kako bi izvlacio specificne dugmice koji ce u tom trenutku biti potrebni

    //---------------------------------------------------------------------------

    public void scrollToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Napravio sam metodu za skrolovanje do dna stranice, gde program moze da uhvati sve potrebne elemente koji se
        //na njoj nalaze. Stavio sam to u zasebnu metodu zato sto ce za svaki element morati da se primeni ista metoda
    }

    //Ispod su metode za klik na dugmice koje vode ka stranicama ponudjenim na homepage-u. U njima su petlje koje
    //prolaze kroz listu elemenata i traze onaj sa specificnim tekstom koji odgovara tekstu dugmeta koje treba da se klikne
    //Kada na taj tekst naidje program treba da klikne na to dugme a zatim i da izadje iz petlje

    public void clickOnElementsPageButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(elementsPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }

    public void clickOnFormsPageButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(formsPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }

    public void clickOnAlertsFrameWindowsPageButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(alertsFrameWindowsPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgetsPageButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(widgetsPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }

    public void clickOnInteractionsPageButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(interactionsPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }

    public void clickOnBookStoreAppButton() {
        scrollToBottomOfThePage();
        for (int i = 0; i < cardBodyList().size(); i++) {
            if (cardBodyList().get(i).getText().equals(bookStoreAppPage)) {
                cardBodyList().get(i).click();
                break;
            }
        }
    }


}
