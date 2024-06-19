package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class GMO_HomePage {

    @FindBy(xpath = "//input[@type='button' and @name='bSubmit']") private WebElement enterGMO_Online_btn;
    @FindBy(xpath = "//input[@type='button' and @name='bAbout']") private WebElement aboutGMO_Site_btn;
    @FindBy(xpath = "//input[@type='button' and @name='bBrowserTest']") private WebElement test_Page_btn;
    @FindBy(xpath = "/html/body/h1/font") private WebElement title_text;
    public void click_GMO_Online(){
        Helper.single_click(enterGMO_Online_btn);
    }
    public void click_aboutGMO(){
        Helper.single_click(aboutGMO_Site_btn);
    }
    public void click_Test_Page(){
        Helper.single_click(test_Page_btn);
    }

}
