package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by Admin on 30.11.2016.
 */
public class LoginPages {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "logIn")
    private WebElement logInBtn;

    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81/auth/login"; //URL of POKER

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        usernameInput.clear();
        usernameInput.sendKeys(username);

    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogIn() {
        logInBtn.click();
    }
    public String getErrorMessage() {
        return driver.findElement(By.xpath("//ul[@class='errors']/li")).getText();

    }
    public String getErrorMessages() {
    //    WebElement errorMsgElement1 =  driver.findElement(By.xpath(".//*[@id='username-element']/ul/li"));
     //   String errorMsg1 = errorMsgElement1.getText();
      //  WebElement errorMsgElement2 =  driver.findElement(By.xpath(".//*[@id='password-element']/ul/li"));
       // String errorMsg2 = errorMsgElement2.getText();
      //  String errorMsg = errorMsg1 + " " + errorMsg2;
        return driver.findElement(By.xpath(".//*[@id='username-element']/ul/li")).getText()+ " " + driver.findElement(By.xpath(".//*[@id='password-element']/ul/li")).getText();
    }
}

