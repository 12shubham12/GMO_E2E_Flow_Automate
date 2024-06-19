package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import page_objects.*;

public class BaseClass {

    public static ConfigDataProvider config;
    public static ExcelDataProvider exceldataProvider;
    public static WebDriver driver;
    public static GMO_HomePage homePage;
    public static GMO_PlaceOrder_Page placeOrderPage;
    public static GMO_OnlineCatalogPage catalogPage;
    public static GMO_Bill_Info_Page billInfoPage;
    public static GMO_Receipt_Page receiptPage;

    @BeforeSuite
    public void setupSuit(){
        config = new ConfigDataProvider();
        exceldataProvider = new ExcelDataProvider();
    }

    //For unit testing or single browser testing, where browser is read from config.properties file
/*
    @BeforeClass
    public void browser_launch(){
        driver = BrowserSetup.launchBrowser(driver, config.getBrowser(),
                config.getURL(),false,true);
    }
*/


    /*For cross browser and parallel testing use below method, which will not read browser from config file,
    instead it will read from value passed in testng_crossBrowserTesting.xml file
     */

    @BeforeClass
    @Parameters("browser")
    public void browser_launch(String browser){
        driver = BrowserSetup.launchBrowser(driver, browser,
                config.getURL(),false,true);
    }


    //for cross platform Testing - Selenium Grid
/*
    @BeforeClass
    @Parameters({"hubAddress","platform","browser", "version"})
    public void browser_launch(String hubAddress,String platform, String browser, String version) throws MalformedURLException, URISyntaxException {

        DesiredCapabilities dc = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("Windows"))
            dc.setPlatform(org.openqa.selenium.Platform.WIN11);
        if (platform.equalsIgnoreCase("Linux"))
            dc.setPlatform(org.openqa.selenium.Platform.LINUX);
        if (platform.equalsIgnoreCase("ANY"))
            dc.setPlatform(org.openqa.selenium.Platform.ANY);

        if(browser.equalsIgnoreCase("Firefox"))  {
            FirefoxOptions options = new FirefoxOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        else if(browser.equalsIgnoreCase("Chrome"))  {
            ChromeOptions options = new ChromeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        else if(browser.equalsIgnoreCase("MicrosoftEdge"))  {
            EdgeOptions options = new EdgeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
//			options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        System.out.println(((RemoteWebDriver)driver).getSessionId());
    }
*/
    @AfterClass
    public void browser_termination(){
      BrowserSetup.quitBrowser(driver);
    }
}
