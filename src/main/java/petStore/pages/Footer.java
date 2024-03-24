package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Footer extends BasePage{

    private WebElement footerContainer = driver.findElement(By.id("shopify-section-footer"));
    private WebElement footerGrid = footerContainer.findElement(By.xpath("//footer//div[@class='grid']"));

    private WebElement signupHeader = footerGrid.findElement(By.xpath("//div[@class='footer__item-padding']//p[@class='h4 footer__title small--hide']"));

    private WebElement subscribeNote = driver.findElement(By.xpath("//div[@id='Footer-1494292487693']//div/div[@class='footer__collapsible']/p"));

    private WebElement emailInput = driver.findElement(By.xpath("//div[@class='footer__collapsible']//div/input[@id='Email-1494292487693']"));

    private WebElement footerLinks = footerContainer.findElement(By.cssSelector(".footer__collapsible.footer_collapsible--disabled"));

    private List<WebElement> fotterLinksList = footerLinks.findElements(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li"));
    private WebElement termsOfUseLink = footerLinks.findElement(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li[1]"));

    private WebElement privacyLink = footerLinks.findElement(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li[2]"));

    private WebElement shippingLink = footerLinks.findElement(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li[3]"));
    private WebElement returnsLink = footerLinks.findElement(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li[4]"));

    private WebElement blogLink = footerLinks.findElement(By.xpath("//div[@class='footer__collapsible footer_collapsible--disabled']/ul/li[5]"));



    public Footer(WebDriver driver) {
        super(driver);
    }
    public boolean footerISVisble(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", footerGrid);
        return signupHeader.isDisplayed();
    }
    public String getTextOfTitleTheSubscriptionPart(){
        return signupHeader.getText();
    }
    public String getTextOfTheSubscribeNote(){
        return waitForElementTobeVisible(subscribeNote)? subscribeNote.getText() : " ";
    }
    public void enterSubscriptionEmail(String email){
        waitForElementTobeVisible(emailInput);
        emailInput.sendKeys(email);
    }
    public boolean footerLinksAreVisible(){
        return elementsAreVisible(fotterLinksList);
    }

    public String testElements(){
        return termsOfUseLink.getText();
    }






}
