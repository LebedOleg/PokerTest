package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pack3.pages.InsertPlayerPage;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */


public class EditPlayerPage {

    private WebDriver driver;
    static Random r = new Random();

    public static String Email = createRandEmail();
    public static String FirstName = createRandString();
    public static String LastName = createRandString();
    public static String City =  createRandString();
    public static String Address = createRandString();
    public static String Phone = createRandPhone();

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnSaveButton() {
        WebElement editSaveButton = driver.findElement(By.xpath(".//*[@class='form_actions_container']/input[@name='button_save']"));
        editSaveButton.click();
    }

    public void assertPlayerFields(String Name, String Email, String FirstName, String LastName, String City, String Address, String Phone) {
       // SoftAssert asert = new SoftAssert();
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_login")).getAttribute("value"), Name, "Wrong Username ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_email")).getAttribute("value"), Email, "Wrong Email  ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_fname")).getAttribute("value"), FirstName, "Wrong FirstName ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_lname")).getAttribute("value"), LastName, "Wrong Lastname ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_city")).getAttribute("value"), City, "Wrong City ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_address")).getAttribute("value"), Address, "Wrong Address ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_phone")).getAttribute("value"), Phone, "Wrong Phone ");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_login")).getAttribute("value"), Name, "Wrong Username ");
    }


    public void setEmail() {

        WebElement emailCreate = driver.findElement(By.id("ff14642ac1c__us_email")); //Find E-mail inputfield
        emailCreate.clear();
        emailCreate.sendKeys(Email); //entry random string  in E-mail field
    }

    public void setFirstName() {
        WebElement firstnameCreate = driver.findElement(By.id("ff14642ac1c__us_fname")); //Find First Name inputfield
        firstnameCreate.clear();
        firstnameCreate.sendKeys(FirstName); //entry random string  in First Name field
    }

    public void setLastName() {
        WebElement lastNameCreate = driver.findElement(By.id("ff14642ac1c__us_lname")); //Find Last Name inputfield
        lastNameCreate.clear();
        lastNameCreate.sendKeys(LastName); //entry random string  in Last Name field
    }

    public void setCity() {
        WebElement cityCreate = driver.findElement(By.id("ff14642ac1c__us_city")); //Find City inputfield
        cityCreate.clear();
        cityCreate.sendKeys(City); //entry random string  in City field
    }

    public void setAddress() {
        WebElement addressCreate = driver.findElement(By.id("ff14642ac1c__us_address")); //Find Address inputfield
        addressCreate.clear();
        addressCreate.sendKeys(Address); //entry random string  in Address field
    }

    public void setPhone() {
        WebElement phoneCreate = driver.findElement(By.id("ff14642ac1c__us_phone")); //Find Phone inputfield
        phoneCreate.clear();
        phoneCreate.sendKeys(Phone); //entry random string  in Phone field

    }


    public static String createRandString() {
        int size = 10;
        String charac = "0123456789abcdefghijklmnopqrstuvwxyz";
        String s = generateString(r, charac, size);
        return s;
    }
    public static String createRandEmail() {
        int sizeMail = 6;
        String charac = "0123456789abcdefghijklmnopqrstuvwxyz";
        String s = generateString(r, charac, sizeMail) + "@my.com";
        return s;
    }
    public static String createRandPhone() {
        int size = 10;
        String ch1 = "0123456789"; //Create the character set for random string
        String s = generateString(r, ch1, size); //create random string through method "generateString"
        return s;
    }

    public static String generateString(Random rng, String characters, int length) //creating random string
    {
        char[] text = new char[length]; // Create list of chars
        for (int i = 0; i < length; i++) //Creating number of random symbols, size equals  variable length
        {
            text[i] = characters.charAt(rng.nextInt(characters.length())); //For current step create random character and saves in list
        }
        return new String(text);//return list
    }
}
