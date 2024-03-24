package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingProductsTests extends BaseTest{
    @Test
    public void waitForSubscriptionDataAndCloseIt(){
        hp.enterSubscriptionData();
    }
    @Test(dependsOnMethods ="waitForSubscriptionDataAndCloseIt" )
    public void addProductsFromHomePageToTheCart(){

          Assert.assertTrue(hp.clickOnTheFirstGetOneBtn().clickOnAddToCart().itemsAreVisibleOnTheCartAfterBeingAdded());
    }
    @Test(dependsOnMethods = "addProductsFromHomePageToTheCart")
    public void LoggedOutUserChecksOutAndContinueShopping(){
       Assert.assertTrue(hp.getHeader().clickOnBrgrList().clickOnCatCategory().clickOnProduct().clickOnAddToCart().allProductsAreAddedAndCalculatedCorrectly());
      //  Assert.assertTrue();
    }
    @Test(dependsOnMethods = "LoggedOutUserChecksOutAndContinueShopping")
    public void addMoreItemsToCart(){
       Assert.assertTrue(hp.getHeader().clickOnBrgrList().clickOnAquariumCategory().clickOnProduct().clickOnAddToCart().allProductsAreAddedAndCalculatedCorrectly());
    }
//    @Test(dependsOnMethods = "LoggedOutUserChecksOutAndContinueShopping")
//    public void userLoggInWithFullCart(){
//        Assert.assertTrue(hp.getHeader().clickOnCartItem().loggedOutUserCheckout().enterEmailAndLogin("lala@gmail.com","1234567890").clickOnReturnToStoreBtn().slideShowContainerIsVisible());
//    }
}
