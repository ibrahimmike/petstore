package driverFactory.drivers;

import frameworkProperties.ReadPropertiesFiles;
import frameworkconstants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import net.bytebuddy.asm.MemberSubstitution;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Opera {

    public static WebDriver setGetDriver(String runMode) throws MalformedURLException {
        if (runMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(Browser.OPERA.browserName());
            String hubHost = ReadPropertiesFiles.getPropertyValue(Constants.GRID_HUB_HOST);
            String urlFormat = ReadPropertiesFiles.getPropertyValue(Constants.GRID_URL_FORMAT);
            String url = String.format(hubHost,urlFormat);
            return new RemoteWebDriver(new URL(url), cap);
        } else {
            WebDriverManager.operadriver().setup();
            return new OperaDriverManager().getWebDriver();
        }
    }
    }