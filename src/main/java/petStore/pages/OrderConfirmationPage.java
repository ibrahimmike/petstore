package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage extends BasePage{

    private WebElement textElement  = driver.findElement(By.xpath("//div[@class='text-container text-container--main']//h1"));
    private WebElement returnToStoreBtn = driver.findElement(By.xpath("//div[@class='text-container text-container--main']//a"));

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean textIsVisible(){
        waitForElementTobeVisible(textElement);
        return textElement.getText().equalsIgnoreCase("This store isn’t set up to receive orders yet.");
    }
    public HomePage clickOnReturnToStoreBtn(){
        returnToStoreBtn.click();
        return new HomePage(driver);
    }

}
