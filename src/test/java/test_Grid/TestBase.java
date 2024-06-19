package test_Grid;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utility.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase extends BaseClass {


    @BeforeTest
    @Parameters({"hubAddress","platform","browser", "version"})
    public void startDriver(String hubAddress,String platform, String browser, String version) throws
            MalformedURLException {

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
            driver = new RemoteWebDriver(new URL(hubAddress), options);
        }
        else if(browser.equalsIgnoreCase("Chrome"))  {
            ChromeOptions options = new ChromeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URL(hubAddress), options);
        }
        else if(browser.equalsIgnoreCase("MicrosoftEdge"))  {
            EdgeOptions options = new EdgeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
//			options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URL(hubAddress), options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        System.out.println(((RemoteWebDriver)driver).getSessionId());
    }

    @AfterTest
    public void stopDriver() {
        driver.quit();
        driver = null;
    }
}
