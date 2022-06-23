package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ButtonsPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement doubleClickButton;
    WebElement rightClickButton;
    WebElement dynamicClickButton;
    WebElement dynamicClickMessage;
    WebElement rightClickMessage;
    WebElement regularClickMessage;
    String dynamicClickButtonText;

    public ButtonsPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        dynamicClickButtonText = excelReader.getStringData("ButtonNames", 1, 2);
    }

    public WebElement getDoubleClickButton() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickButton() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public List<WebElement> clickButtonList() {
       return driver.findElements(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getDoubleClickMessage() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getRightClickMessage() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getDynamicClickMessage() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }


    //----------------------------------------------------------

    public void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(getDoubleClickButton()).perform();
    }

    public void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(getRightClickButton()).perform();
    }

    public void dynamicClick() {
        for(int i = 0; i < clickButtonList().size(); i++) {
            if(clickButtonList().get(i).getText().equals(dynamicClickButtonText)) {
                clickButtonList().get(i).click();
                break;
            }
        }
    }
}
