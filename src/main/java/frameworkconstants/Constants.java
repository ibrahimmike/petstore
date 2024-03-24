package frameworkconstants;

public class Constants {
    private Constants(){}

    private static final String configurations = "src/test/resources/configParams/default.properties";



    public static final String GRID_ENABLED = "selenium.grid.enabled";
    public static final String GRID_URL_FORMAT = "selenium.grid.urlFormat";
    public static final String GRID_HUB_HOST = "selenium.grid.hubHost";
    public static final String BROWSER = "browser";
    public static final String CHROME = "chrome";
    public static final String FIREFOX ="firefox";
    public static final String Production_petStore_URL = "petstore.url";
    public static final String DRIVER = "driver";

    public static final String RUNMODE = "runMode";

    public static final String announcementText = "Sell your homemade pet goods";
    public static final String announcementLink = "find unique pet products";
    public static String getConfigurationsPath(){
        return configurations;
    }
}
