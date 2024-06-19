package test_Grid;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GMO_HomePage;
import page_objects.GMO_OnlineCatalogPage;
import utility.BaseClass;

public class Test_OnlineCatalogPage extends BaseClass {


    @Test(priority = 1)
    public void test_GMO_Online(){
        Assert.assertEquals("Welcome to Green Mountain Outpost", driver.getTitle());
        homePage = PageFactory.initElements(driver, GMO_HomePage.class);
        homePage.click_GMO_Online();
    }
    @Test(priority = 2, dependsOnMethods = "test_GMO_Online")
    public void test_sendQuantity(){
        catalogPage = PageFactory.initElements(driver, GMO_OnlineCatalogPage.class);
        catalogPage.enter_quantity_for_Person_Dome_Tent(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",1,1)));
        catalogPage.enter_quantity_for_Backpacks(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",2,1)));
        catalogPage.enter_quantity_for_Glasses(String.valueOf(exceldataProvider.getQuantity("OnlineCatalog",3,1)));
        catalogPage.click_Place_Order(10);
    }
}
