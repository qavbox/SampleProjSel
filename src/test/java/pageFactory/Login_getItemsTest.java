package pageFactory;

import base.PageDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_getItemsTest {

    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;
    ProductsPage prodPage;

    @BeforeTest
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        PageDriver.setWebDriver(driver);

        Thread.sleep(2000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //homePage = new HomePage(driver);
        //prodPage = new ProductsPage(driver);

        homePage = new HomePage();
        prodPage = new ProductsPage();
    }

    //@Test
    public void LoginTest1() throws InterruptedException {
        /*HomePage homePage = new HomePage(driver);
        homePage.username.sendKeys("standard_user");
        homePage.password.sendKeys("secret_sauce");
        homePage.login.click();*/

        homePage.login();

        /*ProductsPage prodPage = new ProductsPage(driver);
        ProductsPage prodPage = new ProductsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(prodPage.product));*/

        prodPage.waitForProduct();

        System.out.println("Logged in");

        Thread.sleep(2000);

    }

    //@Test
    public void getListItems() throws InterruptedException {
        /*ProductsPage prodPage = new ProductsPage(driver);

        System.out.println("Items are - ");
        for(WebElement item : prodPage.items){
            System.out.println(item.getText());
        }*/

        prodPage.getListItems();

        Thread.sleep(2000);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
