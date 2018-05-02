package Appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {

    static RunTimeExec appiumObj = new RunTimeExec();

    public static void appiumStart() throws Exception {
        appiumObj.startAppium("appium --address 127.0.0.1");
    }

    public static void appiumStop() throws Exception {
        appiumObj.stopAppium();

    }
}

