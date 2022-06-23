package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement simpleNewTabLink;
    WebElement dynamicNewTabLink;
    WebElement apiCreated;
    WebElement apiNoContent;
    WebElement apiMoved;
    WebElement apiBadRequest;
    WebElement apiUnauthorized;
    WebElement apiForbidden;
    WebElement apiNotFound;
    WebElement responseMessage;
    public String apiCreatedMessage;
    public String apiNoContentMessage;
    public String apiMovedMessage;

    public LinksPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        apiCreatedMessage = excelReader.getStringData("Messages", 1, 2);
        apiNoContentMessage = excelReader.getStringData("Messages", 2, 2);
        apiMovedMessage = excelReader.getStringData("Messages", 3, 2);
    }

    public WebElement getSimpleNewTabLink() {
        return driver.findElement(By.id("simpleLink"));
    }

    public WebElement getDynamicNewTabLink() {
        return driver.findElement(By.id("dynamicLink"));
    }

    public WebElement getApiCreated() {
        return driver.findElement(By.id("created"));
    }

    public WebElement getApiNoContent() {
        return driver.findElement(By.id("no-content"));
    }

    public WebElement getApiMoved() {
        return driver.findElement(By.id("moved"));
    }

    public WebElement getApiBadRequest() {
        return driver.findElement(By.id("bad-request"));
    }

    public WebElement getApiUnauthorized() {
        return driver.findElement(By.id("unauthorized"));
    }

    public WebElement getApiForbidden() {
        return driver.findElement(By.id("forbidden"));
    }

    public WebElement getApiNotFound() {
        return driver.findElement(By.id("invalid-url"));
    }

    public WebElement getResponseMessage() {
        return driver.findElement(By.id("linkResponse"));
    }

    //---------------------------------------------------


    public void clickOnSimpleNewTabLink(){
        getSimpleNewTabLink().click();
    }

    public void clickOnDynamicNewTabLink(){
        getDynamicNewTabLink().click();
    }

    public void apiCallCreated() {
        getApiCreated().click();
    }

    public void apiCallNoContent() {
        getApiNoContent().click();
    }

    public void apiCallMoved() {
        getApiMoved().click();
    }

    public void apiCallBadRequest() {
        getApiBadRequest().click();
    }

    public void apiCallUnauthorized() {
        getApiUnauthorized().click();
    }

    public void apiCallNotFound() {
        getApiNotFound().click();
    }

    public void apiCallForbidden() {
        getApiForbidden().click();
    }
}
