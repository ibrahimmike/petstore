package petStore.pages;

import dev.failsafe.internal.util.Maths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement cartContainer = driver.findElement(By.id("CartContainer"));
    private WebElement cartTitle = driver.findElement(By.xpath("//div[@id='CartDrawer']//div[@class='h2 drawer__title']"));
    private WebElement closeCartBtn = driver.findElement(By.xpath("//div[@class='drawer__fixed-header']//div[@class='drawer__close']/button"));
  //  private WebElement cartScrolList = driver.findElement(By.xpath("//div[@id='CartDrawer']//div[@id='CartContainer']//div[@class='drawer__scrollable']"));
   // private  List<WebElement> itemsInsideTheCart = cartContainer.findElements(By.xpath("//div[@class='drawer__scrollable']//div[@class='ajaxcart__row']"));
//    private WebElement scrollable = driver.findElement(By.xpath("//div[@id='CartDrawer']//div[@id='CartContainer']//div[@class='drawer__scrollable']"));
//    private WebElement emptyCartMessage = driver.findElement(By.xpath("//div[@id='CartContainer']/div/p"));
//    private WebElement checkoutBtn = driver.findElement(By.xpath("//form[@class='drawer__contents']//button[@name='checkout']"));
//     private WebElement noteOnTheShippingExpense = driver.findElement(By.xpath("//form[@class='drawer__contents']//p[@class='ajaxcart__note']"));
//    private WebElement subtotalPriceElement = driver.findElement(By.xpath("//form[@class='drawer__contents']//p[@class='ajaxcart__price']"));

    public boolean cartTitleIsVisible(){
        waitForElementTobeVisible(cartTitle);
        return cartTitle.isDisplayed();
    }
    public void clickOnCloseCartBtn(){
        waitForElementTobeVisible(closeCartBtn);
         clickOnElement(closeCartBtn);
    }
    public boolean itemsAreVisibleOnTheCartAfterBeingAdded(){
        waitForElementTobeVisible(cartContainer);
        List<WebElement> items = cartContainer.findElements(By.xpath("//div[@class='drawer__scrollable']//div[@class='ajaxcart__row']"));
         WebElement checkoutBtn = driver.findElement(By.xpath("//form[@class='drawer__contents']//button[@name='checkout']"));
        if(elementsAreVisible(items)){
            waitForElementTobeVisible(checkoutBtn);
            clickOnCloseCartBtn();
            wait.until(ExpectedConditions.invisibilityOf(cartContainer));
            return true;
        }
        return false;
    }

    public boolean allProductsAreAddedAndCalculatedCorrectly(){
        waitForElementTobeVisible(cartContainer);
        ArrayList<Float> prices = new ArrayList<>();

        List<WebElement> items = cartContainer.findElements(By.xpath("//div[@class='drawer__scrollable']//div[@class='ajaxcart__row']"));
        elementsAreVisible(items);
        for(int i=0; i < items.size(); i++){
            List<WebElement> amountOfUnits = driver.findElements(By.xpath("//div[@class='ajaxcart__quantity']//input[@type='text']"));
            float amount = Float.parseFloat( amountOfUnits.get(i).getAttribute("value"));
            System.out.println(" amount " + amount);
            List<WebElement> pricePerUnit = driver.findElements(By.xpath("//span[@class='ajaxcart__price']"));
            float price = Float.parseFloat( pricePerUnit.get(i).getText().trim().replace('$', ' ').trim());
            float productTotal = amount*price;
            prices.add(productTotal);

        }

        System.out.println("The array of products : " + prices.toString());
        WebElement subtotal = driver.findElement(By.xpath("//p[@class='ajaxcart__price']"));
        waitForElementTobeVisible(subtotal);
        float subtotalAmount = Float.parseFloat(subtotal.getText().replace('$', ' ').trim());
        float calculatedSum = (float) prices.stream().mapToDouble(Float::doubleValue).sum();
        System.out.println("subtotal amount : " + subtotalAmount);
        System.out.println("calculated amount : " +calculatedSum);
        clickOnElement(closeCartBtn);
        wait.until(ExpectedConditions.invisibilityOf(cartContainer));
        return subtotalAmount == calculatedSum;

    }

//    public String emptyCartMessage(){
//        waitForElementTobeVisible(emptyCartMessage);
//        return emptyCartMessage.getText();
//    }
//    public boolean scrollableIsVisible(){
//       return elementsAreVisible(itemsInsideTheCart);
//    }
    public LoginPage loggedOutUserCheckout(){
        waitForElementTobeVisible(cartTitle);
        WebElement checkoutBtn = driver.findElement(By.xpath("//form[@class='drawer__contents']//button[@name='checkout']"));
        checkoutBtn.click();
        return new LoginPage(driver);
    }
    public String getBackgroundColorValueWhenTheCartIsOpen(){
        if(waitForElementTobeVisible(cartContainer)) {
            //  String color = newsLetterSubscription.getCssValue("background-color");
            WebElement mainContent = driver.findElement(By.xpath("//main[@id='MainContent']"));
            String color = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0],':after').getPropertyValue('background-color');",
                    mainContent).toString();
            return  Color.fromString(color).asHex();
        }
        return " ";
    }



}
