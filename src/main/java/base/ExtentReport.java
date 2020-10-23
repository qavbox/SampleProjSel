package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    //http://www.extentreports.com/docs/versions/4/java/spark-reporter.html
    //http://www.extentreports.com/docs/versions/4/java/index.html - usage - create test & get test


    //static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    //private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void setTest(ExtentTest test) {
        //ExtentTest test = getInstance().createTest(testName, desc);
        //extentTest.set(getInstance().createTest(testName, desc));
        extentTest.set(test);
        //return getTest();
    }

    /*public synchronized static ExtentTest getTest() {

        return extentTestMap.get((int)(long) Thread.currentThread().getId());
    }


    public synchronized static ExtentTest createTest(String testName) {
        return createTest(testName, "");
    }

    public synchronized static ExtentTest createTest(String testName, String desc) {
        ExtentTest test =  getInstance().createTest(testName, desc);
        extentTestMap.put((int) (long) Thread.currentThread().getId(), test);
        return test;
    }*/

}
