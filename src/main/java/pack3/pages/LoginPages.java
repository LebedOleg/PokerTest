package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by Admin on 30.11.2016.
 */
public class LoginPages {
    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81/auth/login"; //URL of POKER

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLogIn();
    }

    public void setUsername(String username) {
        WebElement usernameInput = driver.findElement(By.id("username"));//Find username input
        usernameInput.clear();
        usernameInput.sendKeys(username);

    }

    public void setPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogIn() {
        WebElement loginButton = driver.findElement(By.id("logIn"));//Find login button
        loginButton.click();
    }
    public String getErrorMessage() {
 //       WebElement errorMagElement =  driver.findElement(By.xpath(""));
 //       String errorMsg = errorMagElement.getText();
//        return  errorMsg;
        return driver.findElement(By.xpath("//ul[@class='errors']/li")).getText();

    }
    public String getErrorMessages() {
        WebElement errorMsgElement1 =  driver.findElement(By.xpath(".//*[@id='username-element']/ul/li"));
        String errorMsg1 = errorMsgElement1.getText();
        WebElement errorMsgElement2 =  driver.findElement(By.xpath(".//*[@id='password-element']/ul/li"));
        String errorMsg2 = errorMsgElement2.getText();
        String errorMsg = errorMsg1 + " " + errorMsg2;
        return errorMsg;
    }
}

