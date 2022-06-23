package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

public class ElementsTest extends BaseTest {

    String URL;
    String fullName;
    String validEmail;
    String invalidEmail;
    String address;
    String firstName;
    String lastName;
    String age;
    String salary;
    String department;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        URL = excelReader.getStringData("URLs", 1, 0);
        driver.navigate().to(URL);
        fullName = excelReader.getStringData("Credentials", 1, 0);
        validEmail = excelReader.getStringData("Credentials", 1, 1);
        invalidEmail = excelReader.getStringData("Credentials", 1, 2);
        address = excelReader.getStringData("Credentials", 1, 3);
        firstName = excelReader.getStringData("Credentials", 1, 7);
        lastName = excelReader.getStringData("Credentials", 1, 8);
        age = excelReader.getStringData("Credentials", 1, 9);
        salary = excelReader.getStringData("Credentials", 1, 10);
        department = excelReader.getStringData("Credentials", 1, 11);
    }

    @Test (priority = 10, description = "TextboxPage")
    public void textboxTestWithFullValidInput(){
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnTextBoxMenuItem();
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(address);
        textBoxPage.enterPermanentAddress(address);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.getMessage().isDisplayed());
        Assert.assertEquals(textBoxPage.getDisplayedName().getText(), "Name:" + fullName);
        Assert.assertEquals(textBoxPage.getDisplayedEmail().getText(), "Email:" + validEmail);
    }

    @Test(priority = 20, description = "TextboxPage")
    public void textboxTestWithNoInput() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnTextBoxMenuItem();
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        boolean check = false;

        try {
            check = textBoxPage.getMessage().isDisplayed();
        } catch (Exception e) {

        }

        //Assert.assertFalse(check);
        //Assert.assertTrue(textBoxPage.getErrorEmailTextbox().isDisplayed());
    }

    @Test(priority = 30, description = "TextboxPage")
    public void textboxTestWithInvalidEmailInput() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnTextBoxMenuItem();
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(invalidEmail);
        textBoxPage.enterPermanentAddress(address);
        textBoxPage.enterCurrentAddress(address);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        boolean check = false;

        try {
            check = textBoxPage.getMessage().isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertTrue(textBoxPage.getErrorEmailTextbox().isDisplayed());
        Assert.assertFalse(check);

    }

    @Test (priority = 40, description = "TextboxPage")
    public void textboxTestWithOnlyValidEmailInput() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnTextBoxMenuItem();
        textBoxPage.enterEmail(validEmail);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.getMessage().isDisplayed());
        Assert.assertEquals(textBoxPage.getDisplayedEmail().getText(), "Email:" + validEmail);
    }

   /* @Test (priority = 50)
   Na ovom testu se jos radi
    public void checkboxGoldenPathTest() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnCheckBoxMenuItem();
        //checkBoxPage.expandMenu("Home");
        driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn")).click();
    }*/

    @Test (priority = 60, description = "RadioButtonPage")
    public void radioButtonTest() throws InterruptedException {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnRadioButtonMenuItem();
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.getDisplayedMessage().isDisplayed());

        Assert.assertEquals(radioButtonPage.getRadioButtonMessage().getText(), radioButtonPage.yesRadioButtonName);
        Thread.sleep(1500);
        radioButtonPage.clickOnImpressiveRadioButton();

        Assert.assertEquals(radioButtonPage.getRadioButtonMessage().getText(), radioButtonPage.impressiveRadioButtonName);
        //radioButtonPage.clickOnNoRadioButton();
    }

    @Test (priority = 70, description = "WebTablesPage")
    public void webTableAddNewAndSearchTest() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnWebTablesMenuItem();
        webTablesPage.clickOnAddNewButton();
        webTablesPage.enterFirstName(firstName);
        webTablesPage.enterLastName(lastName);
        webTablesPage.enterEmail(validEmail);
        webTablesPage.enterAge(age);
        webTablesPage.enterSalary(salary);
        webTablesPage.enterDepartment(department);
        webTablesPage.clickOnSubmitButton();

        webTablesPage.search(firstName);
        Assert.assertEquals(webTablesPage.getFirstFirstNameCell().getText(), firstName);
        Assert.assertEquals(webTablesPage.getFirstEmailCell().getText(), validEmail);
    }

    @Test (priority = 80, description = "WebTablesPage")
    public void webTablesDeleteTest() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnWebTablesMenuItem();
        webTablesPage.deleteFirstRow();
        webTablesPage.deleteSecondRow();
        webTablesPage.deleteThirdRow();

        boolean check = false;
        try {
            check = webTablesPage.getFirstNameBox().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertTrue(webTablesPage.getNoRowsMessage().isDisplayed());
        Assert.assertFalse(check);
    }

    @Test (priority = 90, description = "WebTablesPage")
    public void webTablesEditTest() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnWebTablesMenuItem();

        boolean check = false;
        try {
            check = webTablesPage.getFirstFirstNameCell().getText().equals(firstName);
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
        webTablesPage.editFirstRow();
        webTablesPage.enterFirstName(firstName);
        webTablesPage.enterEmail(validEmail);
        webTablesPage.clickOnSubmitButton();

        Assert.assertEquals(webTablesPage.getFirstFirstNameCell().getText(), firstName);
        Assert.assertEquals(webTablesPage.getFirstEmailCell().getText(), validEmail);
    }

    @Test (priority = 100, description = "Buttons")
    public void buttonsTest() {
        homepage.clickOnElementsPageButton();
        sidebarPage.clickOnButtonsMenuItem();
        buttonsPage.rightClick();
        buttonsPage.doubleClick();
        buttonsPage.dynamicClick();

        Assert.assertTrue(buttonsPage.getDoubleClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getRightClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getDynamicClickMessage().isDisplayed());
    }

    @Test (priority = 110, description = "links")
    public void linksPageNewTabLinksTest() {
        //U ovom testu proverava se funkcionalnost dva linka na Links stranici
        homepage.clickOnElementsPageButton();
        scrollIntoView(sidebarPage.getLinksItem());
        sidebarPage.clickOnLinksMenuItem();
        linksPage.clickOnSimpleNewTabLink();
        //Klikne se na link, posto link otvara novi tab kreira se lista tabova uz pomoc .getWindowHandles metode
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Ovde se driver prebacuje na novootvoreni tab
        Assert.assertTrue(homepage.getHomepageBanner().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        //Posto klik na link otvara homepage radi se Assert da je zaista otvoren novi tab i da je on Homepage
        //Zatim se taj tab gasi i driver se prebacuje ponovo na stranicu Links gde se klikce na dinamicni link, pa se
        //kreira nova lista tabova i ponovo rade assert-ovi
        driver.close();
        driver.switchTo().window(tabs.get(0));
        linksPage.clickOnDynamicNewTabLink();

        ArrayList<String> tabsSecond = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabsSecond.get(1));
        Assert.assertTrue(homepage.getHomepageBanner().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

    @Test (priority = 120, description = "Links")
    public void linksPageApiCallsTest() throws InterruptedException {
        homepage.clickOnElementsPageButton();
        scrollIntoView(sidebarPage.getLinksItem());
        sidebarPage.clickOnLinksMenuItem();
        linksPage.apiCallCreated();
        Thread.sleep(1000);
        Assert.assertTrue(linksPage.getResponseMessage().isDisplayed());
        Assert.assertEquals(linksPage.getResponseMessage().getText(), linksPage.apiCreatedMessage);
        linksPage.apiCallMoved();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.getResponseMessage().getText(), linksPage.apiMovedMessage);
        linksPage.apiCallNoContent();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.getResponseMessage().getText(), linksPage.apiNoContentMessage);
    }

    @Test (priority = 130, description = "Upload and Download")
    public void uploadAndDownloadPageDownloadTest() throws InterruptedException {
        //File file = new File("C:\\Users\\Korisnik\\Downloads\\sampleFile.jpeg");
        File file = new File(uploadAndDownloadPage.downloadPath);
        //Prvo sam inicijalizovao File prema putanji tamo gde se download-uje. Zatim ubacujem jedan if koji proverava
        //da li fajl postoji na toj adresi, ako postoji, program ga obrise. Jedino tako mozemo da budemo sigurni da se
        //fajl u testu uspesno skinuo
        if (file.exists()) {
            file.delete();
        }
        homepage.clickOnElementsPageButton();
        scrollIntoView(sidebarPage.getUploadAndDownloadItem());
        sidebarPage.clickOnUploadAndDownloadMenuItem();
        uploadAndDownloadPage.downloadFile();
        Thread.sleep(3000);
        //Program saceka 3 sekunde da bi se download zavrsio, a potom vrsi proveru da li sada postoji fajl na putanji
        //gde treba da bude
        Assert.assertTrue(file.exists());
    }

    @Test (priority = 140, description = "Upload and Download")
    public void uploadAndDownloadPageUploadTest() {
        homepage.clickOnElementsPageButton();
        scrollIntoView(sidebarPage.getUploadAndDownloadItem());
        sidebarPage.clickOnUploadAndDownloadMenuItem();
        uploadAndDownloadPage.uploadFile(uploadAndDownloadPage.uploadPath);
        Assert.assertTrue(uploadAndDownloadPage.getUploadedFilePath().isDisplayed());
    }



    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }
}
