package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

import static utility.BaseClass.driver;


public class BrowserListener extends BrowserSetup implements WebDriverListener{

	
	public void afterGet(WebDriver driver, String url) {
		MessageLogger.info("(BrowserListener)Navigated to : "+url);
	}
	
	public void afterGetTitle(WebDriver driver, String result) {
		MessageLogger.info("(BrowserListener)Page title : "+result);
	}
	public void afterQuit(WebDriver driver) {
		MessageLogger.info("(BrowserListener)Browser Closed : "+driver.getClass());
		MessageLogger.warn("Driver not quit properly");
	}
	public void beforeClick(WebElement element) {
		MessageLogger.info("(BrowserListener)clicking : "+element.getAttribute("value"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('Style','background: orange; border: 2px solid blue;');",element);
	}
	
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
	}
	
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		MessageLogger.info("(BrowserListener)Entered data : "+Arrays.toString(keysToSend)+"into"+element.getAttribute("name"));
	}
	
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		MessageLogger.info("(BrowserListener)Element is clicked successfully");
	}

}
