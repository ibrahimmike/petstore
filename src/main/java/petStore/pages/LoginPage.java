package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private WebElement loginForm = driver.findElement(By.xpath("//div[@id='CustomerLoginForm']"));
    private WebElement emailElement = loginForm.findElement(By.xpath("//form[@id='customer_login']//input[@id='CustomerEmail']"));
    private WebElement passwordElement = loginForm.findElement(By.xpath("//form[@id='customer_login']//input[@id='CustomerPassword']"));
    private WebElement submit = loginForm.findElement(By.xpath("//p/button[@type='submit']"));


    public OrderConfirmationPage enterEmailAndLogin(String email, String passw){
        waitForElementTobeVisible(submit);
        emailElement.sendKeys(email);
        passwordElement.sendKeys(passw);
        submit.click();
        return new OrderConfirmationPage(driver);

    }
    public boolean loginSuccessfullyRedirected(){
        String url = "";
        return true;
    }


}
