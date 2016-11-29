/**
 * Created by Admin on 23.11.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    public static void main(String[] args) {
        // System.out.println("Hello");
        WebDriver driver = new FirefoxDriver();//OPen FireFox
        String URL = "http://80.92.229.236:81";// Poker URL
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL + "/auth/login");// Open Poker
        WebElement usernameInput = driver.findElement(By.id("username"));//Find username input
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");
        WebElement loginButton = driver.findElement(By.id("logIn"));//Find login button
        loginButton.click();//click on button login
        WebElement insertButton = driver.findElement(By.xpath(".//a/img[@title=\"Insert\"]")); //Find insert button
        insertButton.click(); //click on button insert
        int size = 10;
        String charac = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String s = generateString(r, charac, size);
        WebElement usernameCreate = driver.findElement(By.id("ff14642ac1c__us_login"));
        usernameCreate.sendKeys(s);
        int sizeMail = 6;
        String s5 = generateString(r, charac, sizeMail) + "@my.com";
        WebElement emailCreate = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailCreate.sendKeys(s5);
        System.out.println(s5);
        String s1 = generateString(r, charac, size);
        WebElement passwordCreate = driver.findElement(By.id("ff14642ac1c__us_password"));
        passwordCreate.sendKeys(s1);
        WebElement confirmPasswordCreate = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confirmPasswordCreate.sendKeys(s1);
        int sizeName = 6;
        String s2 = generateString(r, charac, sizeName);
        WebElement firstnameCreate = driver.findElement(By.id("ff14642ac1c__us_fname"));
        firstnameCreate.sendKeys(s2);
        String s3 = generateString(r, charac, sizeName);
        WebElement lastnameCreate = driver.findElement(By.id("ff14642ac1c__us_lname"));
        lastnameCreate.sendKeys(s3);
        String s4 = generateString(r, charac, size);
        WebElement cityCreate = driver.findElement(By.id("ff14642ac1c__us_city"));
        cityCreate.sendKeys(s4);
        String s6 = generateString(r, charac, size);
        WebElement addressCreate = driver.findElement(By.id("ff14642ac1c__us_address"));
        addressCreate.sendKeys(s6);
        String ch1 = "0123456789";
        String s7 = generateString(r, ch1, size);
        WebElement phoneCreate = driver.findElement(By.id("ff14642ac1c__us_phone"));
        phoneCreate.sendKeys(s7);
        int s8 = r.nextInt(250) + 1;
        Select dropdownCreate = new Select(driver.findElement(By.id("ff14642ac1c__us_country")));
        dropdownCreate.selectByIndex(s8);
        WebElement saveButton = driver.findElement(By.name("button_save"));
        saveButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";
        assertText(actualTitle, expectedTitle);
        WebElement nameSearch = driver.findElement(By.id("723a925886__login"));
        nameSearch.sendKeys(s);
        WebElement searchButton = driver.findElement(By.name("search"));
        searchButton.click();
        String i = ".//a[text()=" + "\"" + s + "\"" + "]/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img";
        WebElement userEditButton = driver.findElement(By.xpath(i));
        userEditButton.click();
        assertEditForm(driver, s5, s2, s3, s4, s6, s7);

        changeEditForm(driver, s5, s2, s3, s4, s6, s7, s);
    }
       public static void  assertEditForm(WebDriver sdriver, String mail, String FirstName, String LastName, String City, String Address, String Phone) {

          WebElement assertUserEmail = sdriver.findElement(By.id("ff14642ac1c__us_email"));
           String assertValueEmail = assertUserEmail.getAttribute("value");
           assertUserField(assertValueEmail, mail);
           WebElement assertUserFirstName = sdriver.findElement(By.id("ff14642ac1c__us_fname"));
           String assertValueFirstName = assertUserFirstName.getAttribute("value");
           assertUserField(assertValueFirstName, FirstName);
           WebElement assertUserLastName = sdriver.findElement(By.id("ff14642ac1c__us_lname"));
           String assertValueLastName = assertUserLastName.getAttribute("value");
           assertUserField(assertValueLastName, LastName);
           WebElement assertUserCity = sdriver.findElement(By.id("ff14642ac1c__us_city"));
           String assertValueCity = assertUserCity.getAttribute("value");
           assertUserField(assertValueCity, City);
           WebElement assertUserAddress = sdriver.findElement(By.id("ff14642ac1c__us_address"));
           String assertValueAddress = assertUserAddress.getAttribute("value");
           assertUserField(assertValueAddress,Address );
           WebElement assertUserPhone = sdriver.findElement(By.id("ff14642ac1c__us_phone"));
           String assertValuePhone = assertUserPhone.getAttribute("value");
           assertUserField(assertValuePhone, Phone);
       }
       public static void changeEditForm(WebDriver sdriver, String mail, String FirstName, String LastName, String City, String Address, String Phone, String Name)
       {
           int size = 10;
           String charac = "0123456789abcdefghijklmnopqrstuvwxyz";
           Random r = new Random();
           int sizeMail = 6;
            mail = generateString(r, charac, sizeMail) + "@my.com";
           WebElement emailCreate = sdriver.findElement(By.id("ff14642ac1c__us_email"));
           emailCreate.clear();
           emailCreate.sendKeys(mail);
           int sizeName = 6;
            FirstName = generateString(r, charac, sizeName);
           WebElement firstnameCreate = sdriver.findElement(By.id("ff14642ac1c__us_fname"));
           firstnameCreate.clear();
           firstnameCreate.sendKeys(FirstName);
           LastName = generateString(r, charac, sizeName);
           WebElement lastnameCreate = sdriver.findElement(By.id("ff14642ac1c__us_lname"));
           lastnameCreate.clear();
           lastnameCreate.sendKeys(LastName);
           City = generateString(r, charac, size);
           WebElement cityCreate = sdriver.findElement(By.id("ff14642ac1c__us_city"));
           cityCreate.clear();
           cityCreate.sendKeys(City);
           Address = generateString(r, charac, size);
           WebElement addressCreate = sdriver.findElement(By.id("ff14642ac1c__us_address"));
           addressCreate.clear();
           addressCreate.sendKeys(Address);
           String ch1 = "0123456789";
           Phone = generateString(r, ch1, size);
           WebElement phoneCreate = sdriver.findElement(By.id("ff14642ac1c__us_phone"));
           phoneCreate.clear();
           phoneCreate.sendKeys(Phone);
           WebElement SaveButton = sdriver.findElement(By.name("button_save"));
           SaveButton.click();
           WebElement nameSearch = sdriver.findElement(By.id("723a925886__login"));
           nameSearch.clear();
           nameSearch.sendKeys(Name);
           WebElement searchButton = sdriver.findElement(By.name("search"));
           searchButton.click();
           String i = ".//a[text()=" + "\"" + Name + "\"" + "]/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img";
           WebElement userEditButton = sdriver.findElement(By.xpath(i));
           userEditButton.click();
           assertEditForm(sdriver, mail, FirstName, LastName, City, Address, Phone);
 
       }
    public static void assertText(String actualValue, String expectedValue) //String errorMessage
    {
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed. Expeted title is " + expectedValue + " , but Actual title is" + actualValue);
        }
    }
    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public static void assertUserField(String actualFieldValue, String expectedFieldValue)
    {
        if (actualFieldValue.equals(expectedFieldValue)) {
            System.out.println("Passed");
        }
        else {
            System.out.println("Fail. Expected field value is " + expectedFieldValue + " but Actual field value is " + actualFieldValue);
        }
    }
}
