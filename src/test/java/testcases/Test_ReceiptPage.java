package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.GMO_Receipt_Page;
import utility.BaseClass;

public class Test_ReceiptPage extends BaseClass {

    @Test(priority =4)
    public void test_Receipt_Page(){
        receiptPage = PageFactory.initElements(driver, GMO_Receipt_Page.class);
        receiptPage.click_Return_to_Home();
    }
}
