package pack3.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
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
    private SoftAssert softAssert;


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
        softAssert = new SoftAssert();

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
    @DataProvider(name = "userCreate")
    public Object[][] userCreate() {
        return new Object[][]{
                {"a1s2d3f4h2", "a1s2d3e2@my.com", "p1o2i3u4", "p1o2i3u4", "liliqada", "kikiqada", "Kharkiv", "qwaqwa", "12345678"}
        };
    }


    @Test(dataProvider = "userCreate")
    public void userCreate(String username, String email, String password, String confirmPswrd, String firstname, String lastname, String city, String address, String phone) {
        playersPage = new PlayersPage(driver);
        insertPlayerPage = new InsertPlayerPage(driver);
        editPlayerPage = new EditPlayerPage(driver);
        playersPage.clickOnInsert();
        Assert.assertEquals(driver.getTitle(),"Players - Insert", "Wrong title after click on Insert");

        insertPlayerPage.setUsername(username);
        insertPlayerPage.setEmail(email);
        insertPlayerPage.setPassword(password);
        insertPlayerPage.setConfirmPsw(confirmPswrd);
        insertPlayerPage.setFirstName(firstname);
        insertPlayerPage.setLastName(lastname);
        insertPlayerPage.setCity(city);
        insertPlayerPage.setAddress(address);
        insertPlayerPage.setPhone(phone);
        insertPlayerPage.clickOnSave();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        playersPage.searchByName(username);
        playersPage.clickOnEdit(username);
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_login"),username ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_email"),email ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_fname"),firstname ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_lname"),lastname ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_city"),city ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_address"),address ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_phone"),phone ,"Wrong data in the field");
        softAssert.assertAll();
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

    @DataProvider(name = "userEdit")
    public Object[][] userEdit() {
        return new Object[][]{
                { "a1s2d3f4h2", "l1k2j3e2@my.com", "l1l2qada", "k1k2qada", "Kiev", "shasha", "87654321", "Players"}
        };
    }

    @Test(dataProvider = "userEdit",dependsOnMethods = "userCreate",alwaysRun = true)
    public void userEdit(String username, String email, String firstname, String lastname, String city, String address, String phone, String title) {
        playersPage = new PlayersPage(driver);
        editPlayerPage = new EditPlayerPage(driver);

        playersPage.searchByName(username);
        playersPage.clickOnEdit(username);
        Assert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after login");
        editPlayerPage.setEmail(email);
        editPlayerPage.setFirstName(firstname);
        editPlayerPage.setLastName(lastname);
        editPlayerPage.setCity(city);
        editPlayerPage.setAddress(address);
        editPlayerPage.setPhone(phone);
        editPlayerPage.clickOnSaveButton();
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after login");
        playersPage.searchByName(username);
        playersPage.clickOnEdit(username);
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_login"),username ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_email"),email ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_fname"),firstname ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_lname"),lastname ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_city"),city ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_address"),address ,"Wrong data in the field");
        softAssert.assertEquals(editPlayerPage.getCurrentFieldData("ff14642ac1c__us_phone"),phone ,"Wrong data in the field");
        softAssert.assertAll();
        editPlayerPage.clickOnSaveButton();
    }

    /**
     * 1.Enter Username of created user in search field
     * 2.Click on button search
     * 3.Click on button delete near the player
     * 4.Click on Acept in popup window
     * 5.Check that message "Player has been deleted" is displayed
     */

    @DataProvider(name = "userDelete")
    public Object[][] userDelete() {
        return new Object[][]{
                { "a1s2d3f4h2", "Player has been deleted", "Players"}
        };
    }

    @Test(dataProvider = "userDelete",dependsOnMethods = "userEdit", alwaysRun = true)
    public void userDelete(String username, String expectedMsg,String title) {
        playersPage = new PlayersPage(driver);
        Assert.assertEquals(driver.getTitle(), title, "Wrong title after login");
        playersPage.searchByName(username);
        playersPage.clickOnDelete(username);
        playersPage.clickOnAcept();

       // String expectedMsg = "Player has been deleted";
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
