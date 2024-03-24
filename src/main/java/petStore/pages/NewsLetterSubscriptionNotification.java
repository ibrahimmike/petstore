package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class NewsLetterSubscriptionNotification extends BasePage{
    public NewsLetterSubscriptionNotification(WebDriver driver){
        super(driver);
    }
    private WebElement newsLetterSubscription = driver.findElement(By.id("NewsletterPopup-newsletter-popup"));
    private WebElement enterEmailInput = newsLetterSubscription.findElement(By.id("Email-newsletter-popup"));
    private WebElement subscribeCommitBtn = newsLetterSubscription.findElement(By.name("commit"));
    private WebElement closeBtnX = newsLetterSubscription.findElement(By.cssSelector(".modal__close.js-modal-close.text-link"));

    private WebElement notTodayBtn = newsLetterSubscription.findElement(By.cssSelector(".js-modal-close.text-close"));
    public NewsLetterSubscriptionNotification enterUserEmailToSubscriptionBox(String userEmail){
        writeToElement(enterEmailInput, userEmail);
        return new NewsLetterSubscriptionNotification(driver);
    }
    public HomePage clickOnSubscribeBtn(){
        clickOnElement(subscribeCommitBtn);
        return new HomePage(driver);
    }
    public HomePage clickOnBtnX(){
        clickOnElement(closeBtnX);
        return new HomePage(driver);
    }
    public HomePage clickOnNotTodayBtn(){
        clickOnElement(notTodayBtn);
        return new HomePage(driver);
    }
    protected boolean subscriptionBoxIsVisible(){
        waitForElementTobeVisible(enterEmailInput);
        return enterEmailInput.isEnabled();
    }
    protected NewsLetterSubscriptionNotification subscriptionBox(){
        subscriptionBoxIsVisible();
        return  new NewsLetterSubscriptionNotification(driver);
    }
    protected String backgroundColor(){
       if(waitForElementTobeVisible(newsLetterSubscription)) {
         //  String color = newsLetterSubscription.getCssValue("background-color");
        String color = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0],':before').getPropertyValue('background-color');",
                newsLetterSubscription).toString();
           return  Color.fromString(color).asHex();
       }
       return null;
               //Color.fromString(color).asHex();
    }
    protected WebElement subscriptionBoxElement(){
        return newsLetterSubscription;
    }


}
