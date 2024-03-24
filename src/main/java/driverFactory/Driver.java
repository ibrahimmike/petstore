package driverFactory;

import driverFactory.drivers.Chrome;
import frameworkconstants.Constants;
import frameworkProperties.ReadPropertiesFiles;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;

public class Driver {

    WebDriver driver;

    public static WebDriver initDriver() {




        try {
         //   DriverManager.setDriver(Chrome.setGetDriver("local"));
            DriverManager.setDriver(AssignWebDriver.getWebdriver(ReadPropertiesFiles.getPropertyValue(Constants.BROWSER),
                    ReadPropertiesFiles.getPropertyValue(Constants.RUNMODE)));
        } catch (Exception e) {
            e.getMessage();
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ReadPropertiesFiles.getPropertyValue(Constants.Production_petStore_URL));



        return DriverManager.getDriver();
    }

    public static void driverQuit(){
        DriverManager.getDriver().quit();
        DriverManager.removeDriver();

    }



}
