package pom.tc;

import base.BaseTest;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.po.HomePage;
import pom.po.ProductsPage;

public class LoginGetItemsTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductsPage prodPage = new ProductsPage();

    @Test
    public void LoginGetItemsTestMethod() throws InterruptedException {
        //ExtentReport.createTest("Login", "Login Desc");

        ThreadContext.put("routingfilename", "LoginGetItemsTest");
        homePage.login();

        prodPage.waitForProduct();

        //ExtentReport.getTest().pass("Login test Passed");

        System.out.println("Logged in");

        Thread.sleep(2000);

        Assert.assertEquals(prodPage.getItemsSize(), 5);

        System.out.println("prod count 6");

        //ExtentReport.getInstance().flush();

    }


}
