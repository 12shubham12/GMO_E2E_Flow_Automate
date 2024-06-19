package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.*;
import utility.BaseClass;

public class Test_HomePage extends BaseClass {


    @Test(priority =1)
    public void test_GMO_Online(){
        //Assert.assertEquals("Welcome to Green Mountain Outpost", driver.getTitle());
        homePage = PageFactory.initElements(driver, GMO_HomePage.class);
        homePage.click_GMO_Online();
    }

    @Test(priority =2, dependsOnMethods = "test_GMO_Online")
    public void test_sendQuantity(){
        catalogPage = PageFactory.initElements(driver, GMO_OnlineCatalogPage.class);
        catalogPage.enter_quantity_for_Person_Dome_Tent(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",1,1)));
        catalogPage.enter_quantity_for_Backpacks(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",2,1)));
        catalogPage.enter_quantity_for_Glasses(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",3,1)));
        catalogPage.click_Place_Order(10);
    }

    @Test(priority =3, dependsOnMethods = "test_sendQuantity")
    public void test_Proceed_with_Order(){
        //Assert.assertEquals("", driver.getTitle());
        placeOrderPage = PageFactory.initElements(driver, GMO_PlaceOrder_Page.class);
        placeOrderPage.click_Proceed_with_Order(20);
    }
    @Test(priority =4, dependsOnMethods = "test_Proceed_with_Order")
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

    @Test(priority =5, dependsOnMethods = "test_Billing_Details")
    public void test_Receipt_Page(){
        receiptPage = PageFactory.initElements(driver, GMO_Receipt_Page.class);
        receiptPage.click_Return_to_Home();
    }
}
