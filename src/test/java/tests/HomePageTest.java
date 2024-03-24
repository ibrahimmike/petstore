package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.pages.HomePage;

public class HomePageTest extends BaseTest{



    @Test
    public void loginPage(){

     //   Assert.assertTrue( hp.newsLetterPopupIsVisible());
    }

    @Test
    public void lo(){
     //   HomePage hp = new HomePage(driver);
      //  Assert.assertTrue( hp.newsLetterPopupIsVisible());
    //  Assert.assertTrue(hp.theSubscriptionIsShowingAndThePageIsBlurred());
    }
    @Test(dependsOnMethods = "lo")
    public void subs(){
        hp.enterSubscriptionData();
    }
    @Test(dependsOnMethods = "subs")
    public void headerVerifier(){
      //  HomePage hp = new HomePage(driver);
       // hp.enterSubscriptionData().checkHeader().verifyHeaderCss();
       // System.out.println(hp.enterSubscriptionData().checkHeader().getAnnouncementHeaderFontSize());
     //   Assert.assertTrue(hp.enterSubscriptionData().checkHeader().headerSectionIsVisible());
      //  System.out.println(hp.enterSubscriptionData().getHeader().sellersTest());
     // hp.enterSubscriptionData().getHeader().clickOnSearchIcon();
       // hp.enterSubscriptionData().clickOnTheFirstGetOneBtn();
    //  hp.enterSubscriptionData().clickOnDogCategory().clickOnNextPaginationPage().allProductsAreShowing();
       System.out.println("Sign up header Text : " + hp.enterSubscriptionData().clickOnDogCategory().clickOnNextPaginationPage().checkTheSelectButton());
    }

}
