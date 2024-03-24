package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage{

   private  WebElement brgList = driver.findElement(By.cssSelector(".site-nav__link.site-nav__link--icon.js-drawer-open-nav"));
   private WebElement sellersBtn = driver.findElement(By.xpath("//a[text()='Sellers']"));
   private WebElement sellersLogo = driver.findElement(By.xpath("//a[@class='site-nav__link site-nav__link--icon small--hide']"));
   private WebElement searchIcon = driver.findElement(By.xpath("//a[@class='site-nav__link site-nav__link--icon js-search-header js-no-transition']"));
   private WebElement cartItem = driver.findElement(By.xpath("//a[@class='site-nav__link site-nav__link--icon js-drawer-open-cart js-no-transition']"));









    public Header(WebDriver driver) {

        super(driver);
    }

    public Header getHeader(){
        wait.until(ExpectedConditions.visibilityOf(sellersLogo));
        return  new Header(driver);
    }
    public String sellersTest(){
        System.out.println("The sellers selector : " + sellersBtn.getText());
        return sellersBtn.getText();
    }


    public BrgrList clickOnBrgrList(){
        wait.until(ExpectedConditions.visibilityOf(sellersLogo));
        clickOnElement(brgList);
        return new BrgrList(driver);
    }

    public void clickOnSearchIcon(){

        searchIcon.click();
    }
    public CartPage clickOnCartItem(){
        waitForElementTobeVisible(cartItem);
        cartItem.click();
        return new CartPage(driver);
    }

    public boolean headerIsVisble(){
        return  brgList.isDisplayed();
    }



}
