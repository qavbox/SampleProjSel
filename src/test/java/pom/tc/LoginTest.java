package pom.tc;

import base.BaseTest;
import base.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.Test;
import pom.po.HomePage;
import pom.po.ProductsPage;

public class LoginTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductsPage prodPage = new ProductsPage();

    @Test
    public void LoginTestMethod() throws InterruptedException {
        //ExtentReport.createTest("Login", "Login Desc");
        ThreadContext.put("routingfilename", "LoginTestMethod");

        homePage.login();

        prodPage.waitForProduct();

        //ExtentReport.getTest().pass("Login test Passed");

        System.out.println("Logged in");

        Thread.sleep(2000);

        //ExtentReport.getInstance().flush();

    }


}
