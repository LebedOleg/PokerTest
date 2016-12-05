package pack3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pack3.pages.LoginPages;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 30.11.2016.
 */
public class LoginTests {


    private WebDriver driver;
    LoginPages loginPages;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver(); //initialize /create object /open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//wait until page loaded
    }
@BeforeMethod
public void beforeMethod() {
    loginPages = new LoginPages(driver);
    loginPages.open(); //open poker URL
}

@Test
    public void positiveTest() {

    loginPages.setUsername("admin");
    loginPages.setPassword("123");
    loginPages.clickOnLogIn();

    Assert.assertEquals(driver.getTitle(),"Players","Wrong title after login");
    Assert.assertNotEquals(driver.getCurrentUrl(),LoginPages.URL, "You are still on login page");
}
@Test
    public void negativeTestWrongPassword() {

    loginPages.setUsername("admin");
    loginPages.setPassword("12345");
    loginPages.clickOnLogIn();
    String expectedMsg = "Invalid username or password";
    String actualMsg = loginPages.getErrorMessage();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
}
@Test
    public void negativeTestWrongLogin() {
    loginPages.setUsername("user");
    loginPages.setPassword("123");
    loginPages.clickOnLogIn();
    String expectedMsg = "Invalid username or password";
    String actualMsg = loginPages.getErrorMessage();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");

}
@Test
public void negativeTestEmptyFields(){
    loginPages.setUsername("");
    loginPages.setPassword("");
    loginPages.clickOnLogIn();
    String expectedMsg = "Value is required and can't be empty Value is required and can't be empty";
    String actualMsg = loginPages.getErrorMessages();
    Assert.assertEquals(driver.getCurrentUrl(), LoginPages.URL, "You are NOT on login page.");
    Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
    Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
}
@AfterTest
    public void afterTest() {
    driver.quit();
}  //close browser





}
