package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    private static final String reportFileName = "E2ETestReport.html";
    private static final String macPath = System.getProperty("user.dir")+ "/ExtentTestReport";
    private static final String windowsPath = System.getProperty("user.dir")+ "\\ExtentTestReport";

    //Create an extent report instance
    public static ExtentReports getInstance() {
        if(extentReports == null){
            String fileName = getReportFileLocation();
            System.out.println("Extent report path on Mac - " + fileName);
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
            htmlReporter.config().setDocumentTitle("Example Project");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }

        return extentReports;
    }


    static String getReportFileLocation(){
        String platform = System.getProperty("os.name");

        if(platform.contains("Mac")){
            //System.out.println("Extent report path on Mac - " + macPath);
            return macPath+"/"+reportFileName;
        }else
            return windowsPath+"\\"+reportFileName;
    }
}
