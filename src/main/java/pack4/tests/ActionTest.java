package pack4.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pack4.pages.ActionPage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 12.12.2016.
 */
public class ActionTest {

    private WebDriver driver;
    private ActionPage actionPage;
    private SoftAssert softAssert;


    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actionPage = new ActionPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void dragAndDropTest() {
        actionPage.open();
        actionPage.dragAndDrop();
        actionPage.clickOnDismiss();
        softAssert.assertFalse(actionPage.isElementDelete(), "Dismiss failed, box was delete");
        actionPage.dragAndDrop();
        actionPage.clickOnAccept();
        softAssert.assertTrue(actionPage.isElementDelete(), "Drag and drop failed.");
        softAssert.assertAll();
    }
    @Test(dependsOnMethods = "dragAndDropTest", alwaysRun = true)
    public void doubleSortTest() {

        actionPage.refresh();

        actionPage.sortIncrease();
        softAssert.assertEquals(actionPage.getCurrentPosition("1"),"1", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("2"),"2", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("3"),"3", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("4"),"4", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("5"),"5", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("6"),"6", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("7"),"7", "Sort by increase failed" );
        softAssert.assertAll();

        softAssert = new SoftAssert();
        actionPage.sortDecrease();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(actionPage.getCurrentPosition("1"),"7", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("2"),"6", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("3"),"5", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("4"),"4", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("5"),"3", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("6"),"2", "Sort by increase failed" );
        softAssert.assertEquals(actionPage.getCurrentPosition("7"),"1", "Sort by increase failed" );
        softAssert.assertAll();
    }
}
