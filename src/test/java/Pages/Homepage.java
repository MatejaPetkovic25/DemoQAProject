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

    //---------------------------------------------------------------------------

    public void scrollToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Napravio sam metodu za skrolovanje do dna stranice, gde program moze da uhvati sve potrebne elemente koji se
        //na njoj nalaze. Stavio sam to u zasebnu metodu zato sto ce za svaki element morati da se primeni ista metoda
    }

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
