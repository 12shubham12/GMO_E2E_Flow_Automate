package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Helper extends BaseClass{

    //send keys function
    public static void sendkeys_text(WebElement element, String desiredText){
        element.sendKeys(desiredText);
    }

    //function for single click
    public static void single_click(WebElement element){
        element.click();
    }

    //sendKeys method
    public static void keyToSend(WebElement element, String desiredText){
        element.sendKeys(desiredText);
    }

    public static void click_clear_sendKey(WebElement element, String desiredText){
        element.click();
        element.clear();
        element.sendKeys(desiredText);
    }

    public static void wait_for_seconds(int sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public static void wait_pageLoadTimeout(int sec){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
    }

    public static void select_dropdown_value(WebElement element, int indexValue){
        single_click(element);
        Select select = new Select(element);
        select.selectByIndex(indexValue);
    }

}
