package tests;

import driverFactory.Driver;
import driverFactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import petStore.pages.HomePage;

public class BaseTest {

    WebDriver driver;
    HomePage hp ;
   // HomePage hp ;


    @BeforeTest
    public void setDriver(){

        driver =  Driver.initDriver();
        hp = new HomePage(driver);


    }


    @AfterTest
    public void removeDriver(){
     Driver.driverQuit();

    }
}
