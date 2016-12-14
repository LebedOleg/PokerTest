package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */
public class PlayersPage {
    @FindBy(xpath = ".//a/img[@title='Insert']")
    private WebElement insertButton;

    @FindBy(id = "723a925886__login")
    private WebElement nameSearch;

    @FindBy (name = "search")
    private WebElement searchButton;

    @FindBy()
    private WebElement userEditButton;

   // @FindBy(xpath = ".//a[text()='" + username +  "']/../../td[@width='16']/a/img[@title='Delete']")
    //private  WebElement userDeleteButton;

    @FindBy(xpath = ".//div//li[text()='Player has been deleted']")
    private WebElement errorMsgText;

    @FindBy

    private WebDriver driver;
    Random r = new Random();


    public PlayersPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnInsert() {
        insertButton.click();
    }


    public void searchByName(String username) {
        nameSearch.clear();
        nameSearch.sendKeys(username); //entry username of player that we create in Address field
        searchButton.click(); //Click on Search button
    }

    public void clickOnEdit(String username) {
        String i = ".//a[text()='" + username +  "']/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img[@title='Edit']"; // Create string with Xpath which contains username
        WebElement userEditButton = driver.findElement(By.xpath(i)); //Find Edit button near the desired user
        userEditButton.click();
    }

    public  void clickOnDelete(String username) {
        WebElement userDeleteButton = driver.findElement(By.xpath(".//a[text()='" + username +  "']/../../td[@width='16']/a/img[@title='Delete']"));
        userDeleteButton.click();
    }

    public void clickOnAcept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getMessage() {
        return errorMsgText.getText();
    }

   // public String searchPlayerByName() {
     //   WebElement searchPlayerName = driver.findElement(By.xpath(".//a[text()='"+InsertPlayerPage.userName +"']"));
       // String playerName = searchPlayerName.getText();
       // return playerName;
   // }

}
