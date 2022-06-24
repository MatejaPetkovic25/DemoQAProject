package Pages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SidebarPage {

    //Sidebar stranicu tretiramo kao zasebnu stranicu koja sadrzi pristup za sve ostale stranice na kojima ce se raditi testovi
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    //---------------
    //Elements
    WebElement textBoxItem;
    WebElement checkBoxItem;
    WebElement radioButtonItem;
    WebElement webTablesItem;
    WebElement buttonsItem;
    WebElement linksItem;
    WebElement brokenLinksImagesItem;
    WebElement uploadAndDownloadItem;
    WebElement dynamicPropertiesItem;
    //--------------------
    //Forms
    WebElement formsItem;
    //--------------------

    String elementsMenu;
    String formsMenu;
    String alertsFrameWindowsMenu;
    String widgetsMenu;
    String interactionsMenu;
    String bookStoreAppMenu;

    public SidebarPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        elementsMenu = excelReader.getStringData("ButtonNames", 1, 0);
        formsMenu = excelReader.getStringData("ButtonNames", 2, 0);
        alertsFrameWindowsMenu = excelReader.getStringData("ButtonNames", 3, 0);
        widgetsMenu = excelReader.getStringData("ButtonNames", 4, 0);
        interactionsMenu = excelReader.getStringData("ButtonNames", 5, 0);
        bookStoreAppMenu = excelReader.getStringData("ButtonNames", 6, 0);

        //Prosledjujem nazive glavnih opcija u meniju na slican nacin kako je to odradjeno na pocetnoj stranici
    }

    //Zatim pravim listu elemenata gde ubacujem te glavne opcije koje sadrze podmenije u sidebar-u, a dole se nalaze
    //metode koje klikcu na te opcije

    public List<WebElement> sidebarHeaderMenuButtons() {
        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.className("header-text")));
        return list;
    }

    //Na isti nacin mogao sam da napisem da se dobijaju i meni opcije koje se nalaze u pod-meniju. One takodje nemaju
    //unikatne lokatore, ali posto sam prepoznao da u svakom podmeniju ipak imaju jedinstvene id-jeve i da dva podmenija
    //ne mogu u isto vreme biti otvorena ipak sam odlucio da te elemente pronalazim preko id-eva. Ispod se nalaze geteri
    //za svaku opciju iz pod-menija

    public WebElement getTextBoxItem() {
        return driver.findElement(By.id("item-0"));
    }

    public WebElement getCheckBoxItem() {
        return driver.findElement(By.id("item-1"));
    }

    public WebElement getRadioButtonItem() {
        return driver.findElement(By.id("item-2"));
    }

    public WebElement getWebTablesItem() {
        return driver.findElement(By.id("item-3"));
    }

    public WebElement getButtonsItem() {
        return driver.findElement(By.id("item-4"));
    }

    public WebElement getLinksItem() {
        return driver.findElement(By.id("item-5"));
    }

    public WebElement getBrokenLinksImagesItem() {
        return driver.findElement(By.id("item-6"));
    }

    public WebElement getUploadAndDownloadItem() {
        return driver.findElement(By.id("item-7"));
    }

    public WebElement getDynamicPropertiesItem() {
        return driver.findElement(By.id("item-8"));
    }




    //-------------------------------------------------------------------------------------

    public void scrollToBottomofThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Napravio sam metodu za skrolovanje do dna stranice, gde program moze da uhvati sve potrebne elemente koji se
        //na njoj nalaze. Stavio sam to u zasebnu metodu zato sto ce za svaki element morati da se primeni ista metoda
    }

    public void clickOnElementsMenu(){

        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(elementsMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }

    }

    public void clickOnFormsMenu(){
        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(formsMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }
    }

    public void clickOnAlertsFrameWindowsMenu(){
        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(alertsFrameWindowsMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgetsMenu(){
        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(widgetsMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }
    }

    public void clickOnInteractionsMenu(){
        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(interactionsMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }
    }

    public void clickOnBookStoreAppMenu(){
        scrollToBottomofThePage();
        for(int i = 0; i < sidebarHeaderMenuButtons().size(); i++) {
            if (sidebarHeaderMenuButtons().get(i).getText().equals(bookStoreAppMenu)) {
                sidebarHeaderMenuButtons().get(i).click();
                break;
            }
        }
    }

    //Ovde pocinju metode za kliktanje na opcije iz svakog podmenija koje vode svaki na svoju specificnu stranicu
    public void clickOnTextBoxMenuItem() {
        getTextBoxItem().click();
    }

    public void clickOnCheckBoxMenuItem() {
        getCheckBoxItem().click();
    }

    public void clickOnRadioButtonMenuItem() {
        getRadioButtonItem().click();
    }

    public void clickOnWebTablesMenuItem() {
        getWebTablesItem().click();
    }

    public void clickOnButtonsMenuItem(){
        getButtonsItem().click();
    }

    public void clickOnLinksMenuItem() {
        getLinksItem().click();
    }

    public void clickOnBrokenLinksImagesMenuItem() {
        getBrokenLinksImagesItem().click();
    }

    public void clickOnUploadAndDownloadMenuItem() {
        getUploadAndDownloadItem().click();
    }

    public void clickOnDynamicPropertiesMenuItem() {
        getDynamicPropertiesItem().click();
    }



}
