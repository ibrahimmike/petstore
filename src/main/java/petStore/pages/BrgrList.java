package petStore.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrgrList extends BasePage {
    public BrgrList(WebDriver driver) {
        super(driver);
    }

    private WebElement categoryDogList = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-dog1']"));
    private WebElement categoryCatList = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-cat2']"));
    private WebElement categoryAquariumList = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-aquarium-pond3']"));
    private WebElement categoryReptileList = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-reptile4']"));
    private WebElement categoryBirdListCategory = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-bird5']"));
    private WebElement categorySmallPetList = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@id='Label-collections-small-pet6']"));
    private WebElement loginTag = driver.findElement(By.xpath("//div[@class='drawer__scrollable']/ul/li//a[@href='/account']"));


    public ProductsCollectionPage clickOnCatCategory(){
        waitForElementTobeVisible(categoryCatList);
        categoryCatList.click();
        return new  ProductsCollectionPage(driver);
    }
    public ProductsCollectionPage clickOnDogCategory(){
        waitForElementTobeVisible(categoryCatList);
        categoryDogList.click();
        return new  ProductsCollectionPage(driver);
    }
    public ProductsCollectionPage clickOnAquariumCategory(){
        waitForElementTobeVisible(categoryCatList);
        categoryAquariumList.click();
        return new  ProductsCollectionPage(driver);
    }






}
