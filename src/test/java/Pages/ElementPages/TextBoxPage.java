package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement fullNameTextbox;
    WebElement emailTextbox;
    WebElement currentAddressTextbox;
    WebElement permanentAddressTextbox;
    WebElement submitButton;
    WebElement message;
    WebElement displayedName;
    WebElement displayedEmail;
    WebElement displayedCurrentAddress;
    WebElement displayedPermanentAddress;
    WebElement errorEmailTextbox;

    public TextBoxPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
    }

    public WebElement getFullNameTextbox() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailTextbox() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressTextbox() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressTextbox() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("output"));
    }

    public WebElement getDisplayedName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getDisplayedEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getDisplayedCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getDisplayedPermanentAddress() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getErrorEmailTextbox() {
        return driver.findElement(By.cssSelector(".mr-sm-2.field-error.form-control"));
    }

    //-----------------------------------------------------

    public void enterFullName(String fullname) {
        getFullNameTextbox().clear();
        getFullNameTextbox().sendKeys(fullname);
    }

    public void enterEmail(String email) {
        getEmailTextbox().clear();
        getEmailTextbox().sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        getCurrentAddressTextbox().clear();
        getCurrentAddressTextbox().sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        getPermanentAddressTextbox().clear();
        getPermanentAddressTextbox().sendKeys(address);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }



}
