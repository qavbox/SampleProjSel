package base;

import Utility.PropReader;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

//@Listeners(TestListeners.class)
public class BaseTest {

    String browser, url;

    /*@BeforeClass
    @Parameters({"browser", "url"})
    public void setup(@Optional("chrome") String browser, String url){
        this.browser = browser;
        PageDriverFactory.openBrowser(browser, url);
    }*/

    @BeforeClass
    public void setup(XmlTest xml){
    //https://testng.org/doc/documentation-main.html#native-dependency-injection

        //browser = result.getMethod().getXmlTest().getLocalParameters().get("browser");
        //url = result.getMethod().getXmlTest().getLocalParameters().get("url");

        browser = System.getProperty("browser");
        System.out.println("browser from mvn param - " + browser);
        url = System.getProperty("url");

        if(browser ==null){
            browser = xml.getLocalParameters().get("browser");
            System.out.println("From xml - browser - " + browser);
        }
        if(browser==null)
            browser = PropReader.getValue("browser");

        if(url == null){
            url = xml.getLocalParameters().get("url");
            System.out.println("From xml - url - " + url);
        }
        if(url == null)
            url = PropReader.getValue("url");

        PageDriverFactory.openBrowser(browser, url);
    }


    @AfterClass
    public void tearDown(){
        //ExtentReport.getInstance().flush();
        PageDriver.getDriver().quit();
    }
}
