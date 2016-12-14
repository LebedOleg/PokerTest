package pack3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pack3.pages.InsertPlayerPage;

import java.util.Random;

/**
 * Created by Admin on 04.12.2016.
 */


public class EditPlayerPage {

    @FindBy(id = "ff14642ac1c__us_email")
    private WebElement emailCreate;

    @FindBy(id = "ff14642ac1c__us_fname")
    private WebElement firstnameCreate;

    @FindBy(id = "ff14642ac1c__us_lname")
    private WebElement lastNameCreate;

    @FindBy(id = "ff14642ac1c__us_city")
    private WebElement cityCreate;

    @FindBy(id = "ff14642ac1c__us_address")
    private WebElement addressCreate;

    @FindBy(id = "ff14642ac1c__us_phone")
    private WebElement phoneCreate;

    @FindBy(xpath = ".//*[@class='form_actions_container']/input[@name='button_save']")
    private WebElement editSaveButton;



    private WebDriver driver;

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnSaveButton() {
        editSaveButton.click();
    }

    public String getCurrentFieldData(String fieldData) {
        return driver.findElement(By.xpath(".//*[@id='" + fieldData +"']")).getAttribute("value");

    }


    public void setEmail(String email) {
        emailCreate.clear();
        emailCreate.sendKeys(email); //entry random string  in E-mail field
    }

    public void setFirstName(String firstname) {
        firstnameCreate.clear();
        firstnameCreate.sendKeys(firstname); //entry random string  in First Name field
    }

    public void setLastName(String lastname) {
        lastNameCreate.clear();
        lastNameCreate.sendKeys(lastname); //entry random string  in Last Name field
    }

    public void setCity(String city) {
        cityCreate.clear();
        cityCreate.sendKeys(city); //entry random string  in City field
    }

    public void setAddress(String address) {
        addressCreate.clear();
        addressCreate.sendKeys(address); //entry random string  in Address field
    }

    public void setPhone(String phone) {
        phoneCreate.clear();
        phoneCreate.sendKeys(phone); //entry random string  in Phone field

    }

}
