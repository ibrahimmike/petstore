package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.List;
import java.util.Timer;

public class HomePage extends BasePage{

    private  WebElement slideShowContainer = driver.findElement(By.id("Slideshow-1524768368258"));

    private WebElement slideShow = driver.findElement(By.xpath("//div[@class='slideshow-wrapper']//div[@class='slick-list draggable']/div[@role='listbox']"));

    private WebElement dataSection = driver.findElement(By.xpath("//div[@class='flex-grid flex-grid--gutters flex-grid--1525969132569']"));

    private List<WebElement> productsInTheDataSection = dataSection.findElements(By.xpath("//div[contains(@class,'type-product__wrapper')]"));

    private WebElement dataSectionVideo = dataSection.findElement(By.xpath("//div[@id='shopify-section-1595305281731']//div[@class='background-media-text__video']/video"));

    private WebElement getOneBtnOnTheFirstProduct = driver.findElement(By.xpath("//div[@class='promo-grid__text type-product__content'][1]//a"));

            //productsInTheDataSection.get(0).findElement(By.xpath("//a[@class='btn']"));



    private WebElement getPetCategories = driver.findElement(By.id("shopify-section-1525290496166"));
    private WebElement getPetCategoriesTitle = getPetCategories.findElement(By.xpath("//h2[@class='section-header__title']"));
    private List<WebElement> petCategoriesList =
            getPetCategories.findElements(By.xpath("//div[@class='grid grid--uniform']//div[@class='grid__item small--one-half medium-up--one-third']"));
    private WebElement dogCategory = driver.findElement(By.xpath("//span[contains(text(), 'Dog')]"));
    private WebElement catCategory = driver.findElement(By.xpath("//span[contains(text(), 'Cat')]"));
    private WebElement birdCagtegory = driver.findElement(By.xpath("//span[contains(text(), 'Bird')]"));
    private WebElement aquariumAndPondCategory =  driver.findElement(By.xpath("//span[contains(text(), 'Aquarium & Pond')]"));
    private WebElement smallPetCategory = driver.findElement(By.xpath("//span[contains(text(), 'Small Pet')]"));
    private WebElement reptilePetCategory = driver.findElement(By.xpath("//span[contains(text(), 'Reptile')]"));
    private WebElement becomeAsellerContainer = driver.findElement(By.xpath("//div[@data-section-id='1595361991903']"));
    //div[@data-section-id='1595361991903']
    private WebElement makersWelcome = becomeAsellerContainer.findElement(By.xpath("//p[contains(text(),'makers welcome')]"));
   // private WebElement makersMarketBackgroundPicture = driver.findElement(By.xpath("//div[@data-section-id='1595361991903']//picture/img"));
    private WebElement makerWelcomeTitle = becomeAsellerContainer.findElement(By.xpath("//p[contains(text(),'Sell Homemade Pet Products')]"));
    private WebElement makersWelcomMessage = becomeAsellerContainer.findElement(By.xpath("//p[contains(text(),'supporting pet charities')]"));
    private WebElement becomeASellerBtn = becomeAsellerContainer.findElement(By.xpath("//a[contains(text(),'become a seller')]"));
    private WebElement sellerSubscriptionSection = driver.findElement(By.id("shopify-section-1526048519234"));
    private WebElement subscriptionSectionTitle = sellerSubscriptionSection.findElement(By.xpath("//p"));
    private WebElement emailInput = driver.findElement(By.id("Email-1526048519234"));
    private WebElement sellerSubscriptionBtn = sellerSubscriptionSection.findElement(By.xpath("//div[@class='input-group-btn']//button[@name='commit']//span[contains(text(),'Subscribe')]"));
    private WebElement blogSection = driver.findElement(By.id("shopify-section-1526048620689"));

    private WebElement blogSectionTitle = blogSection.findElement(By.xpath("//header/h2"));
    private WebElement blogSectionViewBtn = blogSection.findElement(By.xpath("//header/a"));
    private List<WebElement> blogs = blogSection.findElements(By.xpath("//a[@class='article__grid-image']"));
    public HomePage(WebDriver driver){
        super(driver);

    }

    public NewsLetterSubscriptionNotification getNewsLetterSubscription(){
        return new NewsLetterSubscriptionNotification(driver);
    }

    public boolean theSubscriptionIsShowingAndThePageIsBlurred(){
        NewsLetterSubscriptionNotification nls = new NewsLetterSubscriptionNotification(driver);
        boolean subscription = nls.subscriptionBoxIsVisible();
        if(subscription){
            System.out.println("Background color background function : " + nls.backgroundColor());
            return true;
        }
        return false;


    }



    public HomePage enterSubscriptionData() {
        NewsLetterSubscriptionNotification nls = new NewsLetterSubscriptionNotification(driver);
        System.out.println("Background color new letter : "+ nls.backgroundColor());
        nls.subscriptionBox().enterUserEmailToSubscriptionBox("ijgr@iji.com").clickOnBtnX();
        wait.until(ExpectedConditions.invisibilityOf(nls.subscriptionBoxElement()));

        return new HomePage(driver);
    }
    public HeaderAnnouncement checkHeader(){
        return new HeaderAnnouncement(driver);
    }
    public Header getHeader(){
        return new Header(driver);
    }

    public Footer getFooter(){
        Footer footer = new Footer(driver);
        if(footer.footerISVisble()){
            return footer;
        }
        return null;
    }

    public int theSizeOfTheProducts(){
        elementsAreVisible(productsInTheDataSection);
        return productsInTheDataSection.size();
    }

    public SingleProductPage clickOnTheFirstGetOneBtn(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", getOneBtnOnTheFirstProduct);

        elementsAreVisible(productsInTheDataSection);
        clickOnElement(getOneBtnOnTheFirstProduct);
        return new SingleProductPage(driver);
    }
    public boolean checkIfDataSectionVideoIsPlaying(){
        waitForElementTobeVisible(dataSectionVideo);
        return Float.parseFloat(dataSectionVideo.getAttribute("currentTime").trim()) > 0.1;
    }

    public CartPage getCart(){
       return getHeader().clickOnCartItem();
    }

    public ProductsCollectionPage clickOnDogCategory(){
        dogCategory.click();
        return new ProductsCollectionPage(driver);
    }
    public boolean slideShowContainerIsVisible(){
        waitForElementTobeVisible(slideShow);

        return slideShow.isDisplayed();
    }
    public boolean petCategoriesAreVisible(){
       return elementsAreVisible(petCategoriesList);
    }

    public boolean becomeAMakerSeller(){
      waitForElementTobeVisible(makersWelcome);
        return  makersWelcome.isDisplayed() && becomeASellerBtn.isDisplayed();
    }


    public boolean sellerSubscriptionSection(){
        return emailInput.isDisplayed() &&  sellerSubscriptionBtn.isDisplayed();
    }
    public boolean blogPartIsVisible(){
        waitForElementTobeVisible(blogSection);
        elementsAreVisible(blogs);
        return  blogSectionTitle.isDisplayed() && blogSectionViewBtn.isDisplayed();
    }
    public String getScreenSize(){
        return driver.manage().window().getSize().toString();
    }








}
