package pack3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pack3.pages.LoginPages;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 30.11.2016.
 */
public class LoginTests {


    private WebDriver driver;
    LoginPages loginPages;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeTest() {
        driver = new FirefoxDriver(); //initialize /create object /open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//wait until page loaded
    }


@BeforeMethod
public void beforeMethod() {
    loginPages = new LoginPages(driver);
    loginPages.open(); //open poker URL
    softAssert = new SoftAssert();
}

    @DataProvider(name = "positiveTest")
    public Object[][] positiveTest() {
        return new Object[][]{
                {"admin", "123", "Players" }
        };
    }
@Test(dataProvider = "positiveTest") //
    public void positiveTest(String username, String password, String title) {

    loginPages.setUsername(username);
    loginPages.setPassword(password);
    loginPages.clickOnLogIn();

    Assert.assertEquals(driver.getTitle(),title,"Wrong title after login");
    Assert.assertNotEquals(driver.getCurrentUrl(),LoginPages.URL, "You are still on login page");
}

    @DataProvider(name = "negativeTestWrongPassword")
    public Object[][] negativeTestWrongPassword() {
        return new Object[][]{
                {"admin", "1234", "Login", "Invalid username or password" }
        };
    }
@Test(dataProvider = "negativeTestWrongPassword", dependsOnMethods = "positiveTest",alwaysRun = true) //(dataProvider = "loginData")
    public void negativeTestWrongPassword(String username, String password, String title,String expectedMsg) {

    loginPages.setUsername(username);
    loginPages.setPassword(password);
    loginPages.clickOnLogIn();
    String actualMsg = loginPages.getErrorMessage();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
}


    @DataProvider(name = "negativeTestWrongLogin")
    public Object[][] negativeTestWrongLogin() {
        return new Object[][]{
                {"admmin", "123", "Login", "Invalid username or password" }
        };
    }

@Test(dataProvider = "negativeTestWrongLogin", dependsOnMethods = "negativeTestWrongPassword",alwaysRun = true)
    public void negativeTestWrongLogin(String username, String password, String title,String expectedMsg) {
    loginPages.setUsername(username);
    loginPages.setPassword(password);
    loginPages.clickOnLogIn();
    String actualMsg = loginPages.getErrorMessage();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
}

    @DataProvider(name = "negativeTestEmptyFields")
    public Object[][] negativeTestEmptyFields() {
        return new Object[][]{
                {"", "", "Login", "Value is required and can't be empty Value is required and can't be empty" }
        };
    }

@Test(dataProvider = "negativeTestEmptyFields",dependsOnMethods = "negativeTestWrongLogin",alwaysRun = true)
public void negativeTestEmptyFields(String username, String password, String title,String expectedMsg){
    loginPages.setUsername(username);
    loginPages.setPassword(password);
    loginPages.clickOnLogIn();
   // String expectedMsg = "Value is required and can't be empty Value is required and can't be empty";
    String actualMsg = loginPages.getErrorMessages();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
}


@AfterTest
    public void afterTest() {
    driver.quit();
}  //close browser

}
