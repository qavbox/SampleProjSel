package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageDriverFactory {

    public static void openBrowser(String browserName, String url) {
        WebDriver driver = null;

        //Log.info("browserName - "+browserName +"-------" +"URL - " +url);
        System.out.println("browserName - "+browserName +"-------" +"URL - " +url);

        if (browserName.toLowerCase().contains("firefox")) {
            //System.out.println("browserName "+browserName);
            //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/BrowserDriver/geckodriver");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(url);
            //Log.info("browser opened");
            System.out.println("Browser launched wth url");
        }

        /*if (browserName.toLowerCase().contains("internet")) {
            //System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/BrowserDriver/IEDriverServer");
            //driver = new InternetExplorerDriver();
        }*/

        if (browserName.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("chrome.switches","--disable-extensions");
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/chromedriver");
            driver = new ChromeDriver(options);
            driver.get(url);
            System.out.println("Browser launched wth url");
            //Log.info("browser opened");
            //driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        PageDriver.setWebDriver(driver);

    }
}
