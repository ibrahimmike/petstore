package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SingleProductPage extends BasePage{
    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    private WebElement singleProductPicture = driver.findElement(By.xpath("//div[@class='grid__item medium-up--one-half']//div[contains(@class,'starting-slide')]//img"));
    private WebElement singleProductMeta = driver.findElement(By.xpath("//div[@class='product-single__meta']"));
    private WebElement metaAnchorTagSimilarProduct = singleProductMeta.findElement(By.xpath("//div[@class='product-single__vendor']/a"));
    private WebElement metaProductTitle = singleProductMeta.findElement(By.xpath("//h1[@class='h2 product-single__title']"));
    private WebElement productPrice = singleProductMeta.findElement(By.xpath("//span[@class='product__price']"));
    private WebElement shippingPolicyAnchorTag = singleProductMeta.findElement(By.xpath("//div[@class='product__policies rte small--text-center']//a"));
    private WebElement addToCartBtn = singleProductMeta.findElement(By.xpath("//button[@class='btn btn--full add-to-cart']"));
    private WebElement productDescription = singleProductMeta.findElement(By.xpath("//div[@class='product-single__description rte']"));
    private WebElement reviewsBtn = singleProductMeta.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Reviews')]"));
    private WebElement reviewsSection = singleProductMeta.findElement(By.xpath("//div[@class= 'collapsibles-wrapper collapsibles-wrapper--border-bottom']//div[contains(@class,'collapsible-content ')]"));
    private WebElement socialMediaFb= singleProductMeta.findElement(By.xpath("//div[@class='social-sharing']//a[@title='Share on Facebook']"));
    private WebElement socialMediaTwitter = singleProductMeta.findElement(By.xpath("//div[@class='social-sharing']//a[@title='Tweet on Twitter']"));
    private WebElement getSocialMediaPrintest = singleProductMeta.findElement(By.xpath("//div[@class='social-sharing']//a[@title='Pin on Pinterest']"));
    private WebElement recommendationsSection = driver.findElement(By.xpath("//div[@id='shopify-section-product-recommendations']"));
    private WebElement recommendationsTitle = driver.findElement(By.xpath("//div[@id='shopify-section-product-recommendations']//header[@class='section-header']/h3"));
    private List<WebElement> recomandedProducts = recommendationsSection.findElements(By.xpath("//div[@class='grid-product__content']"));


   public Header getHeader(){
        Header header = new Header(driver);
        return header.getHeader();
    }
    public boolean headerAndAnnouncementAreVisible(){
        HeaderAnnouncement announcement = new HeaderAnnouncement(driver);
        return announcement.headerSectionIsVisible();
    }

    public ShippingPolicyPage clicKOnShippingTag(){
        waitForElementTobeVisible(shippingPolicyAnchorTag);
        shippingPolicyAnchorTag.click();
        return new ShippingPolicyPage(driver);
    }

    public boolean checkIfRecentlyViewedPartIsVisible(){
        WebElement recentlyViewed = driver.findElement(By.id("shopify-section-recently-viewed"));

        return recentlyViewed.isDisplayed();
    }

    public CartPage clickOnAddToCart(){
       waitForElementTobeVisible(addToCartBtn);
       addToCartBtn.click();
       return new CartPage(driver);
    }

    public int testData(){
        return recomandedProducts.size();
    }








}
