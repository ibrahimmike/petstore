package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsCollectionPage extends BasePage{

    public ProductsCollectionPage(WebDriver driver) {
        super(driver);
    }
    private WebElement imagePage = driver.findElement(By.xpath("//div[@class='collection-hero']/img"));
    private WebElement orderSelect = driver.findElement(By.xpath("//select[@id='SortBy']"));
    private List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='grid grid--uniform grid--collection small--grid--flush']//div[contains(@class,'grid__item grid-product')]"));
    private WebElement paginationPage = driver.findElement(By.xpath("//div[@class='pagination']"));
    private WebElement paginationNext = driver.findElement(By.xpath("//div[@class='pagination']//span[@class='next']/a"));
    private WebElement paginationCurrentPage = driver.findElement(By.xpath("//div[@class='pagination']//span[@class='page current']"));
   // private WebElement paginationPreviousPage = driver.findElement(By.xpath("//div[@class='pagination']//span[@class='prev']"));


    public boolean allProductsAreShowing(){
        ArrayList<Integer> checks = new ArrayList<>();
        elementsAreVisible(listOfProducts);


        for (WebElement product: listOfProducts.subList(2,7)){
           boolean imageIsVisible =  product.findElement(By.xpath("//div[@class='grid-product__content']//div[@class='grid-product__image-mask']")).isDisplayed();
           boolean productDescription = product.findElement(By.xpath("//div[@class='grid-product__content']//div[@class='grid-product__title grid-product__title--heading']")).isDisplayed();
           boolean vendorName =  product.findElement(By.xpath("//div[@class='grid-product__content']//div[@class='grid-product__vendor']")).isDisplayed();
           boolean price = product.findElement(By.xpath("//div[@class='grid-product__price']")).isDisplayed();
           if (imageIsVisible && productDescription && vendorName && price){
               checks.add(0);
           }else{
               checks.add(1);
           }

        }
        return checks.contains(1);
    }
    public Header getHeader(){
        return new Header(driver);
    }
    public Footer getFooter(){
        return new Footer(driver);
    }
    public SingleProductPage clickOnProduct(){
        listOfProducts.get(10).click();
        return new SingleProductPage(driver);
    }
    public boolean headerIsVisible(){
       return getHeader().headerIsVisble();
    }
    public boolean FooterIsVisible(){
        return getFooter().footerISVisble();
    }
    public ProductsCollectionPage clickOnNextPaginationPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",paginationPage);
        waitForElementTobeVisible(paginationNext);
        paginationNext.click();
        return new ProductsCollectionPage(driver);
    }

    public boolean checkTheSelectButton(){
        waitForElementTobeVisible(orderSelect);
        Select select = new Select(orderSelect);
        select.selectByValue("best-selling");
        elementsAreVisible(listOfProducts);
        System.out.println(select.getFirstSelectedOption().getText());
        return driver.getCurrentUrl().contains("sort_by=best-selling");
    }











}
