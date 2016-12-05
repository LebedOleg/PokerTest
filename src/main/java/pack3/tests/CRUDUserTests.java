package pack3.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pack3.pages.EditPlayerPage;
import pack3.pages.InsertPlayerPage;
import pack3.pages.LoginPages;
import pack3.pages.PlayersPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 04.12.2016.
 */
public class CRUDUserTests {

    WebDriver driver;
    LoginPages loginPages;
    PlayersPage playersPage;
    InsertPlayerPage insertPlayerPage;
    EditPlayerPage editPlayerPage;


    /**
     * 1.Open Firefox
     */
    @BeforeTest
    public  void beforeTest() {
        driver = new FirefoxDriver(); //initialize/create object/open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    /**
     * Preconditions
     * 1. Open application Login Page URL
     * 2. Login with correct data
     * 3. Wait for page load
     * 4. Check that you are on right page
     */
    @BeforeMethod
    public void beforeMethod() {
        loginPages = new LoginPages(driver);
        loginPages.open();
        loginPages.login("admin","123");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");

    }

    /**
     * 1. Click on button Insert
     * 2.Check that you are on Players - Insert page
     * 3.fill  filed Username with random data
     * 4.fill  filed Email with random data
     * 5. fill fields Password and Confirm with random data
     * 7. fill field FirstName with random data
     * 8.fill  filed City with random data
     * 9.fill  filed Address with random data
     * 10.fill  filed Phone with random data
     * 11.Click on button Save
     * 12.Check that page is Player
     * 13.Enter Username of created user in search field
     * 14.Click on button search
     * 15.Check that user fields  Name,  Email,  FirstName,  LastName,  City,  Address,  Phone have correct data
     * 16. Click on Save button
     */
    @Test
    public void userCreate() {
        playersPage = new PlayersPage(driver);
        insertPlayerPage = new InsertPlayerPage(driver);
        editPlayerPage = new EditPlayerPage(driver);
        playersPage.clickOnInsert();
        Assert.assertEquals(driver.getTitle(),"Players - Insert", "Wrong title after click on Insert");

        insertPlayerPage.setUsername();
        insertPlayerPage.setEmail();
        insertPlayerPage.setPassword();
        insertPlayerPage.setConfirmPsw();
        insertPlayerPage.setFirstName();
        insertPlayerPage.setLastName();
        insertPlayerPage.setCity();
        insertPlayerPage.setAddress();
        insertPlayerPage.setPhone();
        insertPlayerPage.clickOnSave();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        playersPage.searchByName();
        playersPage.clickOnEdit();
        editPlayerPage.assertPlayerFields(InsertPlayerPage.userName, InsertPlayerPage.Email, InsertPlayerPage.FirstName, InsertPlayerPage.LastName, InsertPlayerPage.City, InsertPlayerPage.Address, InsertPlayerPage.Phone);
        editPlayerPage.clickOnSaveButton();
    }


    /**
     * 1.Search created player by name
     * 2.Click on button Edit
     * 3.Check that title is Players - Edit
     * 4.Change user filed - Email, FirstNAme, LastName, City, Address, Phone
     * 5.Click on Save button
     * 6. Check that title is Players
     * 7.Enter Username of created user in search field
     * 8.Click on button search
     * 9.Click on button Edit near the Player
     * 10.Check that user fields - Email, FirstNAme, LastName, City, Address, Phone have correct data
     * 11.Click on button Save
     */

    @Test
    public void userEdit() {
        playersPage = new PlayersPage(driver);
        editPlayerPage = new EditPlayerPage(driver);

        playersPage.searchByName();
        playersPage.clickOnEdit();
        Assert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after login");
        editPlayerPage.setEmail();
        editPlayerPage.setFirstName();
        editPlayerPage.setLastName();
        editPlayerPage.setCity();
        editPlayerPage.setAddress();
        editPlayerPage.setPhone();
        editPlayerPage.clickOnSaveButton();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        playersPage.searchByName();
        playersPage.clickOnEdit();
        editPlayerPage.assertPlayerFields(InsertPlayerPage.userName, EditPlayerPage.Email, EditPlayerPage.FirstName, EditPlayerPage.LastName, EditPlayerPage.City, EditPlayerPage.Address, EditPlayerPage.Phone);
        editPlayerPage.clickOnSaveButton();
    }

    /**
     * 1.Enter Username of created user in search field
     * 2.Click on button search
     * 3.Click on button delete near the player
     * 4.Click on Acept in popup window
     * 5.Check that message "Player has been deleted" is displayed
     */
    @Test
    public void userDelete() {
        playersPage = new PlayersPage(driver);
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        playersPage.searchByName();
        playersPage.clickOnDelete();
        playersPage.clickOnAcept();

        String expectedMsg = "Player has been deleted";
        String actualMsg = playersPage.getMessage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(actualMsg, expectedMsg, "Confirm message doesn't display");
    }


    /**
     * Post-conditions
     * 1.Close Firefox
     */
   @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
