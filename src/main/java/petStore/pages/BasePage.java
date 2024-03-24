package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    protected boolean waitForElementTobeVisible(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", element);
        return  wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }
    protected void clickOnElement(WebElement element){
        if(waitForElementTobeVisible(element)){
            waitForElementToBeClickable(element);
//            Actions action = new Actions(driver);
//            action.click(element);
            element.click();
        }else{
            System.out.println("Element is not visible");
        }
    }
    protected boolean elementsAreVisible(List<WebElement> elements){
        return !wait.until(ExpectedConditions.visibilityOfAllElements(elements)).isEmpty();
    }
    protected void writeToElement(WebElement element, String text){
         if (waitForElementTobeVisible(element)) {
             element.sendKeys(text);
         }else{
             System.out.println("element not visible");
         }
    }
    protected void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }











}
