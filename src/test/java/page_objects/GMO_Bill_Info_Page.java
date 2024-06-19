package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class GMO_Bill_Info_Page {

    @FindBy(xpath = "//input[@type='text' and @name='billName']") private WebElement name_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billAddress']") private WebElement address_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billCity']") private WebElement city_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billState']") private WebElement state_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billZipCode']") private WebElement zip_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billPhone']") private WebElement phone_bx;
    @FindBy(xpath = "//input[@type='text' and @name='billEmail']") private WebElement email_bx;
    @FindBy(xpath = "//input[@type='text' and @name='CardNumber']") private WebElement cardNo_bx;
    @FindBy(xpath = "//input[@type='text' and @name='CardDate']") private WebElement expiration_bx;
    @FindBy(xpath = "//select[@name='CardType']") private WebElement cc_btn;
    @FindBy(xpath = "//input[@type='checkbox' and @name='shipSameAsBill']") private WebElement same_bill_add_chkbx;
    @FindBy(xpath = "//input[@type='submit' and @value='Place The Order']") private WebElement place_Order_btn;

    public void enter_address(String desiredText){
        Helper.sendkeys_text(address_bx,desiredText);
    }
    public void enter_name(String desiredText){
        Helper.sendkeys_text(name_bx,desiredText);
    }
    public void enter_city(String desiredText){
        Helper.sendkeys_text(city_bx,desiredText);
    }
    public void enter_state(String desiredText){
        Helper.sendkeys_text(state_bx,desiredText);
    }
    public void enter_zip(String desiredText){
        Helper.sendkeys_text(zip_bx,desiredText);
    }

    public void enter_phone(String desiredText){
        Helper.sendkeys_text(phone_bx,desiredText);
    }

    public void enter_email(String desiredText){
        Helper.sendkeys_text(email_bx,desiredText);
    }

    public void enter_cardNo(String desiredText){
        Helper.sendkeys_text(cardNo_bx,desiredText);
    }

    public void enter_expireDate(String desiredText){
        Helper.sendkeys_text(expiration_bx,desiredText);
    }
    public void select_CC(int indexValue){
        Helper.select_dropdown_value(cc_btn, indexValue);
    }

    public void click_ShipTo_checkbox(){
        Helper.single_click(same_bill_add_chkbx);
    }

    public void click_PlaceOrder(){
        Helper.single_click(place_Order_btn);
        Helper.wait_pageLoadTimeout(10);
    }
}
