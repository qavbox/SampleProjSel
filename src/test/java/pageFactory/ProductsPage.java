package pageFactory;

import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends Pages{

    WebDriverWait wait;

    /*WebDriver driver;

    ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    /*ProductsPage(WebDriver driver){
        super(driver);
    }*/

    @FindBy(className = "product_label")
    public WebElement product;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> items;


    public void waitForProduct(){
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait = new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(product));
    }

    public void getListItems(){
        for(WebElement item: items){
            System.out.println(item.getText());
        }
    }


}
