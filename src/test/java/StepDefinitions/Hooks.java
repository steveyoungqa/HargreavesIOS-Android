package StepDefinitions;

import Appium.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;

public class Hooks extends DriverFactory {

    @Before
    public void before() throws Exception {
        System.out.println("BEFORE HOOK");
    }

    @After
    public void after(Scenario scenario) throws Throwable {

        Runtime.getRuntime().exec("mvn test verify -DskipTests");
        String localDir = System.getProperty("user.dir");
//        JOptionPane.showMessageDialog(null,"Cucumber Report being Generated");
        File reports = new File(localDir + "/target/site/cucumber-reports/");
        Runtime.getRuntime().exec("open --fresh " + reports);
//        Runtime.getRuntime().exec("mvn test verify -DskipTests");

//        System.out.println("\033[0;1m" + "Platform = " + platform);
        System.out.println("\n\033[0;1m" + "Test Report generated and located at = " + reports);

        if (scenario.isFailed()) {
            System.out.println("" + platform + "Test Failed screenshot generated");
            iTakeScreenshot(platform);
        }

        if (platform.equals("IOS")) {
            closeDownIOSsimulator();
            String clean = localDir + "/src/test/Screenshots/ios/";
            FileUtils.cleanDirectory(new File(clean));
        }

        if (platform.equals("Android")) {
            closeDownAndroidSimulator();
            String clean = localDir + "/src/test/Screenshots/android/";
            FileUtils.cleanDirectory(new File(clean));
        }
    }
}

