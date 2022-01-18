package Base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage extends BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait ;
    public BasePage(WebDriver driver) {
        this.driver = BaseTest.driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void goUrl(String url){
        driver.get(url);
    }
    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }
    public void waitBySeconds(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void click(By by){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void sendKeys(By by, String text){

        findElement(by).sendKeys(text);
    }

   public List<WebElement> findElements(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
   }

   public void elementIsDisplayed(By by){
        Assert.assertTrue(findElement(by).isDisplayed());
   }
   public void sortElement(By by){
       boolean flag;
       List<WebElement> elements = findElements(by);
       int size = elements.size();
       Integer[] actual = new Integer[size];
       Integer[] sorted = new Integer[size];
       int i = 0;
       for (WebElement elem : elements) {
           actual[i] = sorted[i] = Integer.parseInt(elem.getText().replace(",",""));
           i++;
       }
       Arrays.sort(sorted,Collections.reverseOrder());

       for (i=0; i < size; i++) {
           flag = actual[i].equals(sorted[i]);
           Assert.assertEquals(actual[i],sorted[i]);
           Assert.assertTrue(flag);
       }
   }
   public void assertContainsText(By by,String text){
        Assert.assertTrue(findElement(by).getText().contains(text));
   }
}
