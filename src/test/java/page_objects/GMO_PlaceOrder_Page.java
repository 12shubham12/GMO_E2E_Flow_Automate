package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class GMO_PlaceOrder_Page {

    @FindBy(xpath = "//input[@type='submit' and @value='Proceed With Order']") private WebElement proceed_with_order_btn;

    //clicking on proceed with order button
    public void click_Proceed_with_Order(int sec){
        Helper.wait_pageLoadTimeout(sec);
        Helper.single_click(proceed_with_order_btn);
    }
}
