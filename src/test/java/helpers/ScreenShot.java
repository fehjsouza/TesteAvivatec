package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.sql.Timestamp;

public class ScreenShot{
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(SrcFile,  new File(fileWithPath + new Timestamp(System.currentTimeMillis())+ ".png"));
    }
}