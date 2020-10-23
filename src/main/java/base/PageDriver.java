package base;

import org.openqa.selenium.WebDriver;


public class PageDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
        if (webDriver != null) {
            System.out.println("driver is set in pagedriver class");
        }
    }

}
