package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class GMO_OnlineCatalogPage {

    @FindBy(xpath = "//input[@type='text' and @name='QTY_TENTS']") private WebElement quantity_for_Person_Dome_Tent;
    @FindBy(xpath = "//input[@type='text' and @name='QTY_BACKPACKS']") private WebElement quantity_for_Backpacks;
    @FindBy(xpath = "//input[@type='text' and @name='QTY_GLASSES']") private WebElement quantity_for_Glasses;
    @FindBy(xpath = "//input[@type='text' and @name='QTY_SOCKS']") private WebElement quantity_for_Socks;
    @FindBy(xpath = "//input[@type='text' and @name='QTY_BOOTS']") private WebElement quantity_for_Boots;
    @FindBy(xpath = "//input[@type='text' and @name='QTY_SHORTS']") private WebElement quantity_for_Shorts;
    @FindBy(xpath = "//input[@type='submit' and @value='Place An Order']") private WebElement place_Order_btn;

    public void enter_quantity_for_Person_Dome_Tent(String desiredText){
        Helper.click_clear_sendKey(quantity_for_Person_Dome_Tent, desiredText);
    }
    public void enter_quantity_for_Backpacks(String desiredText){
        Helper.click_clear_sendKey(quantity_for_Backpacks, desiredText);
    }
    public void enter_quantity_for_Glasses(String desiredText){
        Helper.click_clear_sendKey(quantity_for_Glasses, desiredText);
    }
    //clicking on place order button
    public void click_Place_Order(int sec){
        Helper.wait_for_seconds(sec);
        Helper.single_click(place_Order_btn);
    }
}
