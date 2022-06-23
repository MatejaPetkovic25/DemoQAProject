package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadAndDownloadPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement downloadButton;
    WebElement uploadButton;
    WebElement uploadedFilePath;
    public String downloadPath;
    public String uploadPath;

    public UploadAndDownloadPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        downloadPath = excelReader.getStringData("Files", 1, 0);
        uploadPath = excelReader.getStringData("Files", 1, 1);
    }

    public WebElement getDownloadButton() {
        return driver.findElement(By.id("downloadButton"));
    }

    public WebElement getUploadButton() {
        return driver.findElement(By.id("uploadFile"));
    }

    public WebElement getUploadedFilePath() {
        return driver.findElement(By.id("uploadedFilePath"));
    }
    //-----------------------------------------------------------------

    public void downloadFile() {
        getDownloadButton().click();
    }

    public void uploadFile(String filePath) {
        getUploadButton().sendKeys(filePath);
    }
}
