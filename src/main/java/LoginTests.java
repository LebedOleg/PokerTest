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

        WebDriver driver = new FirefoxDriver();//OPen FireFox
        String URL = "http://80.92.229.236:81";// Poker URL
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//set timer 20 seconds
        driver.get(URL + "/auth/login");// Open Poker
        WebElement usernameInput = driver.findElement(By.id("username"));//Find username input
        usernameInput.sendKeys("admin");//entry string "admin" in E-mail field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");
        WebElement loginButton = driver.findElement(By.id("logIn"));//Find login button
        loginButton.click();//click on button login
        WebElement insertButton = driver.findElement(By.xpath(".//a/img[@title=\"Insert\"]")); //Find insert button
        insertButton.click(); //click on button insert
        int size = 10;
        String charac = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String s = generateString(r, charac, size); //create random string through method "generateString"
        WebElement usernameCreate = driver.findElement(By.id("ff14642ac1c__us_login")); //Find username inputfield
        usernameCreate.sendKeys(s); //entry random string  in field
        int sizeMail = 6;
        String s5 = generateString(r, charac, sizeMail) + "@my.com"; //create random string through method "generateString" and CONTAMINATION
        WebElement emailCreate = driver.findElement(By.id("ff14642ac1c__us_email")); //Find E-mail inputfield
        emailCreate.sendKeys(s5); //entry random string  in E-mail field
        String s1 = generateString(r, charac, size); //create random string through method "generateString"
        WebElement passwordCreate = driver.findElement(By.id("ff14642ac1c__us_password")); //Find Password inputfield
        passwordCreate.sendKeys(s1); //entry random string  in Password field
        WebElement confirmPasswordCreate = driver.findElement(By.id("ff14642ac1c__confirm_password")); //Find Confirm Password inputfield
        confirmPasswordCreate.sendKeys(s1); //entry random string  in Confirm Password field
        int sizeName = 6; //variable that contains size of random string
        String s2 = generateString(r, charac, sizeName); //create random string through method "generateString"
        WebElement firstnameCreate = driver.findElement(By.id("ff14642ac1c__us_fname")); //Find First Name inputfield
        firstnameCreate.sendKeys(s2); //entry random string  in First Name field
        String s3 = generateString(r, charac, sizeName); //create random string through method "generateString"
        WebElement lastnameCreate = driver.findElement(By.id("ff14642ac1c__us_lname")); //Find Last Name inputfield
        lastnameCreate.sendKeys(s3); //entry random string  in Last Name field
        String s4 = generateString(r, charac, size); //create random string through method "generateString"
        WebElement cityCreate = driver.findElement(By.id("ff14642ac1c__us_city")); //Find City inputfield
        cityCreate.sendKeys(s4); //entry random string  in City field
        String s6 = generateString(r, charac, size); //create random string through method "generateString"
        WebElement addressCreate = driver.findElement(By.id("ff14642ac1c__us_address")); //Find Address inputfield
        addressCreate.sendKeys(s6); //entry random string  in Address field
        String ch1 = "0123456789"; //Create the character set for random string
        String s7 = generateString(r, ch1, size); //create random string through method "generateString"
        WebElement phoneCreate = driver.findElement(By.id("ff14642ac1c__us_phone")); //Find Phone inputfield
        phoneCreate.sendKeys(s7); //entry random string  in Phone field
    //    int s8 = r.nextInt(250) + 1; // Craate random number 1-250
    //    Select dropdownCreate = new Select(driver.findElement(By.id("ff14642ac1c__us_country"))); //Find County DDL
    //    dropdownCreate.selectByIndex(s8); //Select
        WebElement saveButton = driver.findElement(By.name("button_save")); //Find  Save button
        saveButton.click(); //click on Save button
        String actualTitle = driver.getTitle(); //Take current Title
        String expectedTitle = "Players"; //variable with expected title
        assertText(actualTitle, expectedTitle);//method assertText calls with attributes
        WebElement nameSearch = driver.findElement(By.id("723a925886__login")); //Find field Player in page Players
        nameSearch.sendKeys(s); //entry username of player that we create in Address field
        WebElement searchButton = driver.findElement(By.name("search")); //Find Search button
        searchButton.click(); //Click on Search button
        String i = ".//a[text()=" + "\"" + s + "\"" + "]/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img"; // Create string with Xpath which contains username
        WebElement userEditButton = driver.findElement(By.xpath(i)); //Find Edit button near the desired user
        userEditButton.click(); //click on button Edit
        assertEditForm(driver, s5, s2, s3, s4, s6, s7);//method  assertEditForm calls
        changeEditForm(driver, s5, s2, s3, s4, s6, s7, s); //method  changeEditForm calls
    }
       public static void  assertEditForm(WebDriver sdriver, String mail, String FirstName, String LastName, String City, String Address, String Phone) //assert Value of fields
       {
          WebElement assertUserEmail = sdriver.findElement(By.id("ff14642ac1c__us_email"));//Find E-mail field in edit form
           String assertValueEmail = assertUserEmail.getAttribute("value"); //receiving value from field E-mail
           assertUserField(assertValueEmail, mail); //method assertUserField call with current mail and expected
           WebElement assertUserFirstName = sdriver.findElement(By.id("ff14642ac1c__us_fname")); //Find First name field in edit form
           String assertValueFirstName = assertUserFirstName.getAttribute("value"); //receiving value from field First Name
           assertUserField(assertValueFirstName, FirstName); //method assertUserField call with current First Name and expected
           WebElement assertUserLastName = sdriver.findElement(By.id("ff14642ac1c__us_lname")); //Find Last NAme field in edit form
           String assertValueLastName = assertUserLastName.getAttribute("value"); //receiving value from field Last NAme
           assertUserField(assertValueLastName, LastName); //method assertUserField call with current Last NAme and expected
           WebElement assertUserCity = sdriver.findElement(By.id("ff14642ac1c__us_city")); //Find City field in edit form
           String assertValueCity = assertUserCity.getAttribute("value"); //receiving value from field City
           assertUserField(assertValueCity, City); //method assertUserField call with current City and expected
           WebElement assertUserAddress = sdriver.findElement(By.id("ff14642ac1c__us_address")); //Find Address field in edit form
           String assertValueAddress = assertUserAddress.getAttribute("value"); //receiving value from field Address
           assertUserField(assertValueAddress,Address ); //method assertUserField call with current Address and expected
           WebElement assertUserPhone = sdriver.findElement(By.id("ff14642ac1c__us_phone"));//Find Phone field in edit form
           String assertValuePhone = assertUserPhone.getAttribute("value"); //receiving value from field Phone
           assertUserField(assertValuePhone, Phone); //method assertUserField call with current Phone and expected
       }
       public static void changeEditForm(WebDriver sdriver, String mail, String FirstName, String LastName, String City, String Address, String Phone, String Name) //Change fields of user that was created
       {
           int size = 10; // size of random string
           String charac = "0123456789abcdefghijklmnopqrstuvwxyz"; //Create the character set for random string
           Random r = new Random();//Create new number generator
           int sizeMail = 6; // size of random string
            mail = generateString(r, charac, sizeMail) + "@my.com"; //create random string through method "generateString" and CONTAMINATION
           WebElement emailCreate = sdriver.findElement(By.id("ff14642ac1c__us_email")); //Find E-mail field
           emailCreate.clear(); //Clear value in field E-mail
           emailCreate.sendKeys(mail);// //entry random string  in E-mail field
           int sizeName = 6; // size of random string
            FirstName = generateString(r, charac, sizeName); //method generateString call and create random string
           WebElement firstnameCreate = sdriver.findElement(By.id("ff14642ac1c__us_fname")); //Find First Name field
           firstnameCreate.clear(); //Clear value in field First Name
           firstnameCreate.sendKeys(FirstName); //entry random string  in First Name field
           LastName = generateString(r, charac, sizeName); //method generateString call and create random string
           WebElement lastnameCreate = sdriver.findElement(By.id("ff14642ac1c__us_lname")); //Find Last Name field
           lastnameCreate.clear(); //Clear value in field Last Name
           lastnameCreate.sendKeys(LastName); //entry random string  in Last Name field
           City = generateString(r, charac, size); //method generateString call and create random string
           WebElement cityCreate = sdriver.findElement(By.id("ff14642ac1c__us_city"));  //Find City field
           cityCreate.clear(); //Clear value in field City
           cityCreate.sendKeys(City); //entry random string  in City field
           Address = generateString(r, charac, size);
           WebElement addressCreate = sdriver.findElement(By.id("ff14642ac1c__us_address")); //Find Address field
           addressCreate.clear(); //Clear value in field Address
           addressCreate.sendKeys(Address); //entry random string  in Address field
           String ch1 = "0123456789"; //entry random string  in City field
           Phone = generateString(r, ch1, size);
           WebElement phoneCreate = sdriver.findElement(By.id("ff14642ac1c__us_phone")); //Find Phone field
           phoneCreate.clear(); //Clear value in field Phone
           phoneCreate.sendKeys(Phone); //entry random string  in Phone field
           WebElement SaveButton = sdriver.findElement(By.name("button_save")); //Find Save button
           SaveButton.click(); //Click Save button
           WebElement nameSearch = sdriver.findElement(By.id("723a925886__login")); //Find field Player in page Players
           nameSearch.clear(); //Clear value in field Player
           nameSearch.sendKeys(Name); //entry username of player that we create in Address field
           WebElement searchButton = sdriver.findElement(By.name("search")); //Find Search button
           searchButton.click(); //Click on Search button
           String i = ".//a[text()=" + "\"" + Name + "\"" + "]/../../td[@width=" + "\"" + "16" + "\"" + "]/a/img"; // Create string with Xpath which contains username
           WebElement userEditButton = sdriver.findElement(By.xpath(i)); //Find Edit button near the desired user
           userEditButton.click(); //click on button Edit
           assertEditForm(sdriver, mail, FirstName, LastName, City, Address, Phone); //method assertEditForm calls

       }
    public static void assertText(String actualValue, String expectedValue) //String errorMessage
    {
        if (actualValue.equals(expectedValue)) { //compare current Title and Expected
            System.out.println("Passed"); //if it equals shows message
        }
        else { //If not
            System.out.println("Failed. Expeted title is " + expectedValue + " , but Actual title is" + actualValue); // Show message
        }
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
    public static void assertUserField(String actualFieldValue, String expectedFieldValue) //check field
    {
        if (actualFieldValue.equals(expectedFieldValue)) { //compare current value of field and Expected
            System.out.println("Passed"); //if it equals shows message
        }
        else { //if it equals shows message
            System.out.println("Fail. Expected field value is " + expectedFieldValue + " but Actual field value is " + actualFieldValue); // Show message
        }
    }
}
