package Utility;

import base.PageDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

    public static String captureScreen(String screenShotName) {
        Date date = new Date();
        String fileName = screenShotName + "_" + dateFormat.format(date);
        String dest = null;
        try {
            File src = ((TakesScreenshot) PageDriver.getDriver()).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/TestScreenShots/" + fileName + ".png";
            FileUtils.copyFile(src, new File(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest;
    }
}
