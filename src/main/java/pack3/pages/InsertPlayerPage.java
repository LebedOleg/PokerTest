package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */
public class InsertPlayerPage {

    @FindBy(id = "ff14642ac1c__us_login")
    private WebElement userNameCreate;

    @FindBy(id = "ff14642ac1c__us_email")
    private WebElement emailCreate;

    @FindBy(id = "ff14642ac1c__us_password")
    private WebElement passwordCreate;

    @FindBy(id = "ff14642ac1c__confirm_password")
    private WebElement confirmPasswordCreate;

    @FindBy(id = "ff14642ac1c__us_fname")
    private WebElement firstNameCreate;

    @FindBy(id = "ff14642ac1c__us_lname")
    private WebElement lastNameCreate;

    @FindBy(id = "ff14642ac1c__us_city")
    private WebElement cityCreate;

    @FindBy(id = "ff14642ac1c__us_address")
    private WebElement addressCreate;

    @FindBy(id = "ff14642ac1c__us_phone")
    private WebElement phoneCreate;

    @FindBy(name = "button_save")
    private WebElement saveButton;


    private WebDriver driver;



    public InsertPlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        userNameCreate.sendKeys(username); //entry random string  in field

    }

    public void setEmail(String email) {
        emailCreate.sendKeys(email); //entry random string  in E-mail field
    }

    public void setPassword(String password) {
        passwordCreate.sendKeys(password); //entry random string  in Password field
    }

    public void setConfirmPsw(String confirmPsw) {
        confirmPasswordCreate.sendKeys(confirmPsw); //entry random string  in Confirm Password field
    }

    public void setFirstName(String firstName) {
        firstNameCreate.sendKeys(firstName); //entry random string  in First Name field
    }

    public void setLastName(String lastName) {
        lastNameCreate.sendKeys(lastName); //entry random string  in Last Name field
    }

    public void setCity(String city) {
        cityCreate.sendKeys(city); //entry random string  in City field
    }

    public void setAddress(String address) {
        addressCreate.sendKeys(address); //entry random string  in Address field
    }

    public void setPhone(String phone) {
        phoneCreate.sendKeys(phone); //entry random string  in Phone field

    }

    public void clickOnSave() {
        saveButton.click();
    }


}
