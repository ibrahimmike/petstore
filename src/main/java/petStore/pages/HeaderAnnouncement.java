package petStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class HeaderAnnouncement extends BasePage{

    WebElement headerSection = driver.findElement(By.id("shopify-section-header"));
    WebElement anouncementBar = headerSection.findElement(By.className("announcement-bar"));

    WebElement annoucementBarText = anouncementBar.findElement(By.id("AnnouncementSlide-1594783635669"));


    WebElement header = headerSection.findElement(By.xpath("//div[@class='site-header-sticky']"));

    public HeaderAnnouncement(WebDriver driver) {
        super(driver);
    }

    public HeaderAnnouncement getAnnouncementHeader(){
        return new HeaderAnnouncement(driver);
    }
    private boolean announcementHeaderIsVisible(){
        return anouncementBar.isDisplayed();
    }
    private boolean headerIsVisible(){
        return header.isDisplayed();
    }
    public boolean headerSectionIsVisible(){
        return headerSection.isDisplayed() && anouncementBar.isDisplayed() && announcementHeaderIsVisible();

    }
    public void verifyHeaderCss(){
        System.out.println("Announcement bar side : " + anouncementBar.getSize());
        String color = anouncementBar.getCssValue("background-color");
        String c = Color.fromString(color).asHex();
        System.out.println("Header is visible "+ headerIsVisible());
        System.out.println( "background color : "+ c);
        System.out.println();
    }

    public String getAnnouncementHeaderText(){
        return annoucementBarText.findElement(By.className("announcement-text")).getText();
    }
    public String getAnnouncementHeaderLinkText(){
        return annoucementBarText.findElement(By.className("announcement-link-text")).getText();
    }
    public String getAnnouncementHeaderBackgroundColor(){
        return anouncementBar.getCssValue("background-color");
    }
    public String getHeaderAnnouncementBackgroundColor(){
        String color = anouncementBar.getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
    public String getAnnouncementHeaderTextFontSize(){
        return anouncementBar.findElement(By.className("announcement-text")).getCssValue("font-size");
       // return anouncementBar.getCssValue("font-size").trim();
    }
    public String getAnnouncementHeaderLinkFontSize(){
        return anouncementBar.findElement(By.className("announcement-link-text")).getCssValue("font-size");
    }





}
