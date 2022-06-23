package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement addNewButton;
    WebElement firstNameBox;
    WebElement lastNameBox;
    WebElement emailBox;
    WebElement ageBox;
    WebElement salaryBox;
    WebElement departmentBox;
    WebElement submitButton;
    WebElement searchBox;
    WebElement firstFirstNameCell;
    WebElement firstEmailCell;
    WebElement firstDeleteButton;
    WebElement secondDeleteButton;
    WebElement thirdDeleteButton;
    WebElement firstEditButton;
    WebElement noRowsMessage;


    public WebTablesPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
    }

    public WebElement getAddNewButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getFirstNameBox() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastNameBox() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmailBox() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getAgeBox() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSalaryBox() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getDepartmentBox() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getFirstFirstNameCell() {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]"));
    }

    public WebElement getFirstEmailCell() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[4]"));
    }

    public WebElement getFirstDeleteButton() {
        return driver.findElement(By.id("delete-record-1"));
    }

    public WebElement getSecondDeleteButton() {
        return driver.findElement(By.id("delete-record-2"));
    }

    public WebElement getThirdDeleteButton() {
        return driver.findElement(By.id("delete-record-3"));
    }

    public WebElement getFirstEditButton() {
        return driver.findElement(By.id("edit-record-1"));
    }

    public WebElement getNoRowsMessage() {
        return driver.findElement(By.className("rt-noData"));
    }
    //----------------------------------------------------------------------

    public void clickOnAddNewButton() {
        getAddNewButton().click();
    }

    public void enterFirstName(String name) {
        getFirstNameBox().clear();
        getFirstNameBox().sendKeys(name);
    }

    public void enterLastName(String lastName) {
        getLastNameBox().clear();
        getLastNameBox().sendKeys(lastName);
    }

    public void enterEmail(String email) {
        getEmailBox().clear();
        getEmailBox().sendKeys(email);
    }

    public void enterAge(String age) {
        getAgeBox().clear();
        getAgeBox().sendKeys(age);
    }

    public void enterSalary(String salary) {
        getSalaryBox().clear();
        getSalaryBox().sendKeys(salary);
    }

    public void enterDepartment(String department) {
        getDepartmentBox().clear();
        getDepartmentBox().sendKeys(department);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

    public void search(String searchInput) {
        getSearchBox().clear();
        getSearchBox().sendKeys(searchInput);
    }

    public void deleteFirstRow() {
        getFirstDeleteButton().click();
    }

    public void deleteSecondRow() {
        getSecondDeleteButton().click();
    }

    public void deleteThirdRow() {
        getThirdDeleteButton().click();
    }

    public void editFirstRow() {
        getFirstEditButton().click();
    }
}
