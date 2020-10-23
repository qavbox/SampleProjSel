package cucumbers.stepDef;

import Utility.PropReader;
import Utility.Util;
import base.PageDriver;
import base.PageDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Hooks {
    String browser, url;

    @Before
    public void setup(){
        browser = System.getProperty("browser");
        url = System.getProperty("url");

        if(browser==null)
            browser = PropReader.getValue("browser");

        if(url == null)
            url = PropReader.getValue("url");

        PageDriverFactory.openBrowser(browser, url);
    }

    @BeforeStep
    public void beforeStep(){
        //runs before each step
        //System.out.println("steps");
        //the same, we have @AfterStep
    }

    @Before(order=2)
    public void setup1(){
        //we can have multiple @before
        // to do
    }


    @After
    public void tearDown(Scenario scenario){
        System.out.println(scenario.getName() +" id - " + Thread.currentThread().getId());
        //if(scenario.isFailed()){
            byte[] src=((TakesScreenshot) PageDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png","");
        //}
        PageDriver.getDriver().quit();
    }
}
