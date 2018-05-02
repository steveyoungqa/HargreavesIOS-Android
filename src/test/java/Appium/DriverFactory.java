package Appium;

import StepDefinitions.AndroidStepDefs;
import StepDefinitions.iosStepdefs;
import cucumber.api.java.gl.E;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DriverFactory {

    protected static IOSDriver iosDriver;
    protected static AndroidDriver androidDriver;
    protected static String platform;

    public static IOSDriver createNewIOSDriverInstance() throws IOException {
        iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), iosStepdefs.caps);
        platform = "IOS";
        return iosDriver;
    }

    public static AndroidDriver createNewAndroidDriverInstance() throws IOException {
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), AndroidStepDefs.caps);
        platform = "Android";
        return androidDriver;
    }


    public void iTakeScreenshot(String platform) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-H-m-ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        Date date = new Date();

        if (platform.equals("IOS")) {
            File scrFile = ((TakesScreenshot) iosDriver).getScreenshotAs(OutputType.FILE);
            String localDir = System.getProperty("user.dir");
            File screenshot = new File(localDir + "/src/test/Screenshots/ios/" + "Screenshot" + dateFormat.format(date) + ".png");
            FileUtils.copyFile(scrFile, screenshot);
//            Runtime.getRuntime().exec("open " + screenshot);
        }
        if (platform.equals("Android")) {

            File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
            String localDir = System.getProperty("user.dir");
            File screenshot = new File(localDir + "/src/test/Screenshots/android/" + "Screenshot" + dateFormat.format(date) + ".png");
            FileUtils.copyFile(scrFile, screenshot);
//            Runtime.getRuntime().exec("open " + screenshot);
        }
    }

    public void closeDownIOSsimulator () throws Exception {
        iosStepdefs.appiumStartStop.appiumStop();
        Runtime.getRuntime().exec("killall iOS Simulator");
        Runtime.getRuntime().exec("killall iOS Simulator");
    }

    public void closeDownAndroidSimulator() throws Exception {
        iosStepdefs.appiumStartStop.appiumStop();
        Runtime.getRuntime().exec("adb emu kill");
        Runtime.getRuntime().exec("adb emu kill");
    }

    public IOSElement findIOSElementWithTimeout(By by, int timeOutInSeconds) throws IOException {

        // Output screenshot if Element is not found
        try {
            return (IOSElement) (new WebDriverWait(iosDriver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {

        }
        return null;
    }

    public void getDeviceTime() throws IOException {

        String time = iosDriver.getDeviceTime();
        System.out.println(time);
    }

    public void setLocation(Integer Latitude, Integer Longitude, Integer Altitude) throws IOException {
        Location location = new Location(Latitude, Longitude, Altitude);
        iosDriver.setLocation(location);
        System.out.println(location);
    }

    public void ouputSessionCapabilities() throws IOException {
        Map<String, Object> testCaps = iosDriver.getSessionDetails();
        System.out.println(testCaps);
    }
}
