package pom.po;

import Utility.PageEl;
import base.ExtentReport;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class ProductsPage {

    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    PageEl product =  new PageEl(By.className("title"));

    PageEl items =  new PageEl(By.className("inventory_item_name"));

    public void waitForProduct(){
        product.waitForElement(10);
    }

    public int getItemsSize(){
        ExtentReport.getTest().log(Status.INFO, "returning product size");
        logger.info("returning product size from log4j");
        return items.size();
    }

}
