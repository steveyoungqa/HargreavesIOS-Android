package Appium;

import PageObjects.iosPageObjects;
import io.appium.java_client.android.AndroidDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SampleTest extends DriverFactory {

    private AndroidDriver driver;
    PageObjects.iosPageObjects iosPageObjects = new iosPageObjects();


    @Test
    public void openReport () throws IOException {

        String localDir = System.getProperty("user.dir");
        File reports = new File(localDir + "/target/site/cucumber-reports/feature-overview.html");
        File htmlFile = new File(String.valueOf(reports));

// open the default web browser for the HTML page
        Desktop.getDesktop().browse(htmlFile.toURI());

    }

//    public void iRunSampleExampleTests() throws Throwable {
//        getDeviceTime();
//        iTakeAScreenshot();
//        //        setLocation(45, 45, 100);
////        ouputSessionCapabilities();
//        swipeDown();

        //SLIDER
//        findElementWithTimeout((By.id(appium.durationSlider())), 10).sendKeys("0.9");

//    }

    //

    //
//



//        //Picker element example using XCUI Test and JScript

//        driver.findElement(By.id(appium.backButton())).click();
//        driver.findElement(By.id(appium.pickers())).click();
//        RemoteWebElement elements = (RemoteWebElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        HashMap<String, Object> params = new HashMap<String, Object>();
//        params.put("order", "next");
//        params.put("offset", 0.15);
//        params.put("element", ((RemoteWebElement) elements).getId());
//        js.executeScript("mobile: selectPickerWheelValue", params);

    //Scroll down whole page

//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    HashMap<String, String> swipeObject = new HashMap<String, String>();
//
//        swipeObject.put("direction", "down"); //up for swipe
//        swipeObject.put("startX", "90");
//        swipeObject.put("startY", "400");
//        swipeObject.put("endX", "90"); //"90");
//        swipeObject.put("endY", "350"); //"200");
//        swipeObject.put("duration", "2000");
//        js.executeScript("mobile: scroll", swipeObject);

}

