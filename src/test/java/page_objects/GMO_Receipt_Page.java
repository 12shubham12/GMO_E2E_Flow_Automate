package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class GMO_Receipt_Page {
    @FindBy(xpath = "//input[@type='button' and @value='Return to Home Page']") private WebElement return_to_home_btn;

    public void click_Return_to_Home(){
        Helper.single_click(return_to_home_btn);
    }
}
