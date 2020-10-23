package pageFactory.old;

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
import java.util.List;

public class SampleSauceTest {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeTest
        public void setup() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.get("https://www.saucedemo.com/");

            Thread.sleep(2000);

            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        //@Test
        public void LoginTest1(){

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product_label")));
            System.out.println("Logged in");
        }

        //@Test
        public void getListItems(){

            List<WebElement> items = driver.findElements(By.className("inventory_item_name"));

            System.out.println("Items are");

            for(WebElement item : items){
                System.out.println(item.getText());
            }
        }

        @AfterTest
        public void tearDown(){
            driver.quit();
        }

}
