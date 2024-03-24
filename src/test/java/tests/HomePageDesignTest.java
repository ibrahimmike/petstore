package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageDesignTest extends BaseTest{

    @Test
     public void subscriptionBoxIsVisible(){
      Assert.assertTrue(hp.theSubscriptionIsShowingAndThePageIsBlurred());
        hp.enterSubscriptionData();

    }
    @Test(dependsOnMethods = "subscriptionBoxIsVisible")
    public void headerIsVisible(){
        Assert.assertTrue(hp.getHeader().headerIsVisble());
    }
    @Test(dependsOnMethods = "headerIsVisible")
    public void footerIsVisible(){
        Assert.assertTrue(hp.getFooter().footerISVisble());
    }
    @Test(dependsOnMethods = "footerIsVisible")
    public void slideShowContainerISVisible(){
        Assert.assertTrue(hp.slideShowContainerIsVisible());
    }
    @Test(dependsOnMethods = "slideShowContainerISVisible")
    public void productsAreShowing(){
        Assert.assertEquals(hp.theSizeOfTheProducts(), 3);
    }
    @Test(dependsOnMethods = "productsAreShowing")
    public void videoAddIsPlaying(){
        Assert.assertTrue(hp.checkIfDataSectionVideoIsPlaying());
    }
    @Test(dependsOnMethods = "videoAddIsPlaying")
    public void petCategoriesAreShowing(){
        Assert.assertTrue(hp.petCategoriesAreVisible());
    }
    @Test(dependsOnMethods = "petCategoriesAreShowing")
    public void makersSectionIsDisplayed(){
        Assert.assertTrue(hp.becomeAMakerSeller());
    }
    @Test(dependsOnMethods = "makersSectionIsDisplayed")
    public void sellersSubscriptionSection(){
        Assert.assertTrue(hp.sellerSubscriptionSection());
    }
    @Test(dependsOnMethods = "sellersSubscriptionSection")
    public void blogPartIsVisible(){
        Assert.assertTrue(hp.blogPartIsVisible());
    }
    @Test(dependsOnMethods = "blogPartIsVisible")
    public void whenClickingOnCartTheBackgoroundColorChanges(){
     Assert.assertEquals(hp.getHeader().clickOnCartItem().getBackgroundColorValueWhenTheCartIsOpen(),"#f2efc5");
    }





}
