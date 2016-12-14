package pack4.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Admin on 12.12.2016.
 */
public class ActionPage {



    @FindBy(id = "drop")
    private WebElement targetElement;

    @FindBy(id = "sortable")
    private static WebElement sourceElement;




    private WebDriver driver;
    private final static String URL = "file:///C:/Users/Admin/Desktop/js/drag_and_drop2/drag_and_drop2/index.html";



    public ActionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void dragAndDrop() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement.findElement(By.xpath(".//li[text()='1']")), targetElement)
                .perform();
    }

    public void clickOnDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void clickOnAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public boolean isElementDelete() {
       return driver.findElements(By.xpath("//*[@id='sortable']/li[text()='1']")).isEmpty() ;
    }

    public void refresh() {
        driver.navigate().refresh();

    }

    public void sortIncrease() {

        Actions action = new Actions(driver);

        int[] list = new int[7];
        for (int i =0; i < list.length; i++) {
            int j = i + 1;
            list[i] = Integer.parseInt(sourceElement.findElement(By.xpath(".//li[" + j + "]")).getText());
        }

        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    int current = j+1;
                    int next = j+2;
                    action.dragAndDrop(sourceElement.findElement(By.xpath(".//li[" + current + "]")), sourceElement.findElement(By.xpath(".//li[" + next + "]"))).perform();
                    action.dragAndDrop(sourceElement.findElement(By.xpath(".//li[" + next + "]")), sourceElement.findElement(By.xpath(".//li[" + current + "]"))).perform();
                    int t = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = t;
                }
            }
        }
    }

    public void sortDecrease() {
        Actions action = new Actions(driver);
        int[] list = new int[7];
        for (int i =0; i < list.length; i++) {
            int j = i + 1;
            list[i] = Integer.parseInt(sourceElement.findElement(By.xpath(".//li[" + j + "]")).getText());
        }

        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[j + 1]) {
                    int current = j+1;
                    int next = j+2;
                    action.dragAndDrop(sourceElement.findElement(By.xpath(".//li[" + current + "]")), sourceElement.findElement(By.xpath(".//li[" + next + "]"))).perform();
                    action.dragAndDrop(sourceElement.findElement(By.xpath(".//li[" + next + "]")), sourceElement.findElement(By.xpath(".//li[" + current + "]"))).perform();
                    int t = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = t;
                }
            }
        }
    }

    public String getCurrentPosition(String elementNumber) {
        int elemNumbr = Integer.parseInt(elementNumber);
        return   sourceElement.findElement(By.xpath(".//li[" + elemNumbr + "]")).getText();

    }
}

