package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.GMO_Bill_Info_Page;
import utility.BaseClass;

public class Test_Bill_Info extends BaseClass {

    @Test
    public void test_Billing_Details(){
        //Assert.assertEquals("", driver.getTitle());
        billInfoPage = PageFactory.initElements(driver, GMO_Bill_Info_Page.class);
        billInfoPage.enter_name(exceldataProvider.getStringVal("BillingInfo",1,0));
        billInfoPage.enter_address(exceldataProvider.getStringVal("BillingInfo",1,1));
        billInfoPage.enter_city(exceldataProvider.getStringVal("BillingInfo",1,2));
        billInfoPage.enter_state(exceldataProvider.getStringVal("BillingInfo",1,3));
        billInfoPage.enter_zip(String.valueOf(exceldataProvider.getNumericVal("BillingInfo",1,4)));
        billInfoPage.enter_phone(String.valueOf(exceldataProvider.getNumericVal("BillingInfo",1,5)));
        billInfoPage.enter_email(exceldataProvider.getStringVal("BillingInfo",1,6));
        billInfoPage.select_CC(1);
        billInfoPage.enter_cardNo(String.valueOf(exceldataProvider.getLongVal("BillingInfo",1,7)));
        billInfoPage.enter_expireDate(exceldataProvider.getStringVal("BillingInfo",1,8));
        billInfoPage.click_ShipTo_checkbox();
        billInfoPage.click_PlaceOrder();
    }
}
