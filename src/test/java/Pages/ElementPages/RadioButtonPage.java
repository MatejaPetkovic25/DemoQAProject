package Pages.ElementPages;

import Base.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RadioButtonPage {
    WebDriver driver;
    WebDriverWait wdwait;
    ExcelReader excelReader;
    WebElement yesRadioButton;
    WebElement impressiveRadioButton;
    WebElement noElementButton;
    WebElement displayedMessage;
    WebElement radioButtonMessage;
    String yesButtonName;
    String impressiveButtonName;
    public String yesRadioButtonName;
    public String impressiveRadioButtonName;
    public String noRadioButtonName;

    public RadioButtonPage(WebDriver driver, WebDriverWait wdwait, ExcelReader excelReader) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.excelReader = excelReader;
        yesRadioButtonName = excelReader.getStringData("ButtonNames", 1, 1);
        impressiveRadioButtonName = excelReader.getStringData("ButtonNames", 2, 1);
        noRadioButtonName = excelReader.getStringData("ButtonNames", 3, 1);
    }


   /* public WebElement getYesRadioButton() {
        return driver.findElement(By.className("custom-control-label"));
    }

    public WebElement getImpressiveRadioButton() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getNoRadioButton() {
        return driver.findElement(By.id("noRadio"));
    }*/
    public List<WebElement> radioButtonList() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public WebElement getDisplayedMessage() {
        return driver.findElement(By.className("mt-3"));
    }

    public WebElement getRadioButtonMessage() {
        return driver.findElement(By.className("text-success"));
    }

    //-----------------------------------------------------------------

    public void clickOnYesRadioButton() {
        for(int i = 0; i < radioButtonList().size(); i++) {
            if (radioButtonList().get(i).getText().equals(yesRadioButtonName)) {
                radioButtonList().get(i).click();
                break;
            }
        }
    }

    public void clickOnNoRadioButton() {
        for(int i = 0; i < radioButtonList().size(); i++) {
            if (radioButtonList().get(i).getText().equals(noRadioButtonName)) {
                radioButtonList().get(i).click();
                break;
            }
        }
    }

    public void clickOnImpressiveRadioButton() {
        for(int i = 0; i < radioButtonList().size(); i++) {
            if (radioButtonList().get(i).getText().equals(impressiveRadioButtonName)) {
                radioButtonList().get(i).click();
                break;
            }
        }
    }
}
