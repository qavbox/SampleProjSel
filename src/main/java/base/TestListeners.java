package base;

import Utility.Util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    //public ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    //ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--------- Test case '"+ result.getMethod().getMethodName() +"' started ---------");

        ExtentTest test = ExtentReportManager.getInstance().createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        ExtentReport.setTest(test);

        //make sure to extent.flush()
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Testcase '" + result.getMethod().getMethodName() + "' passed");
        ExtentReport.getTest().pass("Test Passed");
        //ExtentReport.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Testcase '" + result.getMethod().getMethodName() +
                "' failed, because of " + result.getThrowable());

        ExtentReport.getTest().fail("Test Failed");
        //screenshot
        ExtentReport.getTest().addScreenCaptureFromPath(Util.captureScreen(result.getMethod().getMethodName()));
        //ExtentReport.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Testcase '" + result.getMethod().getMethodName() +
                "' skipped, because of " + result.getThrowable());
        ExtentReport.getTest().log(Status.SKIP, result.getThrowable());
        //ExtentReport.getInstance().flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Context start- " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Context finish- " + context.getName());
        ExtentReportManager.getInstance().flush();
    }
}
