package Pages.ElementPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBoxPage {
    WebDriver driver;
    WebDriverWait wdwait;

    public CheckBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> collapsedCheckBoxList() {
       return driver.findElements(By.cssSelector(".rct-node.rct-node-parent.rct-node-collapsed"));
    }
    //Ovaj selektor je prisutan kada su checkbox pod-meniji skupljeni, odnosno kada nisu vidljivi sadrzaji unutar drop
    //menija

    public List<WebElement> expandedCheckBoxList() {
        return driver.findElements(By.cssSelector(".rct-node.rct-node-parent.rct-node-expanded"));
    }
    //Ovaj selektor je prisutan kada su otvoreni pod-meniji, konkretan check box ciji su pod meniji otvoreni spada u
    //ovakav css selektor
    //U ove dve liste idu isti elementi, a to su oni koji imaju svoje pod menije

    //--------------------------------------------------------

    public void expandMenu(String name) {
        for (int i = 0; i < collapsedCheckBoxList().size(); i++) {
            if (collapsedCheckBoxList().get(i).getText().equals(name)) {
                collapsedCheckBoxList().get(i).click();
                break;
            }
        }
    }



}
