package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */
public class PlayersPage {
    private WebDriver driver;
    Random r = new Random();


    public PlayersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnInsert() {
        WebElement insertButton = driver.findElement(By.xpath(".//a/img[@title=\"Insert\"]"));//Find Insert button
        insertButton.click();
    }


    public void searchByName() {
        WebElement nameSearch = driver.findElement(By.id("723a925886__login")); //Find field Player in page Players
        nameSearch.clear();
        nameSearch.sendKeys(InsertPlayerPage.userName); //entry username of player that we create in Address field
        WebElement searchButton = driver.findElement(By.name("search")); //Find Search button
        searchButton.click(); //Click on Search button
    }

    public void clickOnEdit() {
        String i = ".//a[text()=" + "\"" + InsertPlayerPage.userName + "\"" + "]/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img[@title='Edit']"; // Create string with Xpath which contains username
        WebElement userEditButton = driver.findElement(By.xpath(i)); //Find Edit button near the desired user
        userEditButton.click();
    }

    public  void clickOnDelete() {
        WebElement userDeleteButton = driver.findElement(By.xpath(".//a[text()='" + InsertPlayerPage.userName +  "']/../../td[@width='16']/a/img[@title='Delete']"));
        userDeleteButton.click();
    }
    public void clickOnAcept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public String getMessage() {
        WebElement errorMsgText =  driver.findElement(By.xpath(".//div//li[text()='Player has been deleted']"));
        String errorMsg = errorMsgText.getText();
        return errorMsg;
    }
    public String searchPlayerByName() {
        WebElement searchPlayerName = driver.findElement(By.xpath(".//a[text()='"+InsertPlayerPage.userName +"']"));
        String playerName = searchPlayerName.getText();
        return playerName;
    }

}
