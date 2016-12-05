package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */
public class InsertPlayerPage {
    private WebDriver driver;
    static Random r = new Random();
     public static String userName = createRandString();
     public static String Email = createRandEmail();
     public static String Password = createRandString();
     public static String ConfirmPsw = Password;
     public static String FirstName = createRandString();
     public static String LastName = createRandString();
     public static String City =  createRandString();
     public static String Address = createRandString();
     public static String Phone = createRandPhone();

    public InsertPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername() {

        WebElement usernameCreate = driver.findElement(By.id("ff14642ac1c__us_login")); //Find username inputfield
        usernameCreate.sendKeys(userName); //entry random string  in field

    }

    public void setEmail() {

        WebElement emailCreate = driver.findElement(By.id("ff14642ac1c__us_email")); //Find E-mail inputfield
        emailCreate.sendKeys(Email); //entry random string  in E-mail field
    }

    public void setPassword() {
        WebElement passwordCreate = driver.findElement(By.id("ff14642ac1c__us_password")); //Find Password inputfield\
        passwordCreate.sendKeys(Password); //entry random string  in Password field
    }

    public void setConfirmPsw() {
        WebElement confirmPasswordCreate = driver.findElement(By.id("ff14642ac1c__confirm_password")); //Find Confirm Password inputfield
        confirmPasswordCreate.sendKeys(ConfirmPsw); //entry random string  in Confirm Password field
    }

    public void setFirstName() {
        WebElement firstnameCreate = driver.findElement(By.id("ff14642ac1c__us_fname")); //Find First Name inputfield
        firstnameCreate.sendKeys(FirstName); //entry random string  in First Name field
    }

    public void setLastName() {
        WebElement lastnameCreate = driver.findElement(By.id("ff14642ac1c__us_lname")); //Find Last Name inputfield
        lastnameCreate.sendKeys(LastName); //entry random string  in Last Name field
    }

    public void setCity() {
        WebElement cityCreate = driver.findElement(By.id("ff14642ac1c__us_city")); //Find City inputfield
        cityCreate.sendKeys(City); //entry random string  in City field
    }

    public void setAddress() {
        WebElement addressCreate = driver.findElement(By.id("ff14642ac1c__us_address")); //Find Address inputfield
        addressCreate.sendKeys(Address); //entry random string  in Address field
    }

    public void setPhone() {
        WebElement phoneCreate = driver.findElement(By.id("ff14642ac1c__us_phone")); //Find Phone inputfield
        phoneCreate.sendKeys(Phone); //entry random string  in Phone field

    }

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.name("button_save"));//Find Save button
        saveButton.click();
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
