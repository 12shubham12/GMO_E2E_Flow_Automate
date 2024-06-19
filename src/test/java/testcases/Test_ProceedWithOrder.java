package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.GMO_PlaceOrder_Page;
import utility.BaseClass;

public class Test_ProceedWithOrder extends BaseClass {

    @Test(priority =1)
    public void test_Proceed_with_Order(){
        //Assert.assertEquals("Place Order", driver.getTitle());
        placeOrderPage = PageFactory.initElements(driver, GMO_PlaceOrder_Page.class);
        placeOrderPage.click_Proceed_with_Order(20);
    }
}
