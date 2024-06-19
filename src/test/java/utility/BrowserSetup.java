package utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class BrowserSetup {

    public static WebDriver launchBrowser(WebDriver driver, String browserName,
                                          String appURL, Boolean NoBrowser, Boolean Incognito){

        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            if (NoBrowser==true) chromeOptions.addArguments("--headless");
            if (Incognito==true) chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }

        else if(browserName.equalsIgnoreCase("Firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            if (NoBrowser==true) firefoxOptions.addArguments("--headless");
            if (Incognito==true) firefoxOptions.addArguments("-private");
            driver = new FirefoxDriver(firefoxOptions);
        }

        else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            if (NoBrowser==true) edgeOptions.addArguments("--headless");
            if (Incognito==true) edgeOptions.addArguments("--incognito");
            driver= new EdgeDriver(edgeOptions);
        }
        else{
            System.out.println("No such browser");
        }
        BrowserListener browserListener= new BrowserListener();
        driver= new EventFiringDecorator(browserListener).decorate(driver);

        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
