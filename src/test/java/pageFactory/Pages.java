package pageFactory;

import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    /*WebDriver driver;

    Pages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    Pages(){
        PageFactory.initElements(PageDriver.getDriver(), this);
    }
}
