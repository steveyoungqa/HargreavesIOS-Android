package StepDefinitions;


import Appium.AppiumServer;
import Appium.DriverFactory;
import PageObjects.androidPageObjects;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidStepDefs extends DriverFactory{

    public static DesiredCapabilities caps = new DesiredCapabilities();
    androidPageObjects androidPageObjects = new androidPageObjects();
    public static String deviceName = null;

    @Given("^I am using Appium for device \"([^\"]*)\" and Android version \"([^\"]*)\"$")
    public void iAmUsingAppiumForDeviceAndAndroidVersion(String device, String version) throws Throwable {
        deviceName = device;
        caps.setCapability("fullReset", "true");
        caps.setCapability("deviceName", "Android");
        caps.setCapability("avd", device);
        caps.setCapability("platformVersion", version);
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformName", "Android");
    }

    @Given("^I am using Appium for Physical device UDID \"([^\"]*)\" and Android version \"([^\"]*)\"$")
    public void iAmUsingAppiumForPhysicalDeviceUDIDAndAndroidVersion(String udid, String version) throws Throwable {
        caps.setCapability("fullReset", "true");
        caps.setCapability("deviceName", "Android");
        caps.setCapability("platformVersion", version);
//        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", udid);
    }

    @And("^using Android I am using the app directory of \"([^\"]*)\" and app \"([^\"]*)\"$")
    public void usingAndroidIAmUsingTheAppDirectoryOfAndApp(String dir, String app) throws Throwable {
        File appDir = new File(dir);
        File appPath = new File(appDir, app);
        caps.setCapability("app", appPath);
    }

    @Then("^I launch the App on the Android Device$")
    public void iLaunchTheAppOnTheAndroidDevice() throws Throwable {
        Runtime.getRuntime().exec("killall -9 node");
        appiumServer.appiumStop();
        appiumServer.appiumStart();
        caps.setCapability("waitForAppScript","$.delay(100); true;");
        caps.setCapability("appWaitActivity", "com.mubaloo.android.hargreaveslansdown.activity.WalkthroughActivity");
        createNewAndroidDriverInstance();
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Then("^I launch the App on the Android Device and unlock using Pin \"([^\"]*)\"$")
    public void iLaunchTheAppOnTheAndroidDeviceAndUnlockUsingPin(String PIN) throws Throwable {
        Runtime.getRuntime().exec("killall -9 node");
        appiumServer.appiumStop();
        appiumServer.appiumStart();
        createNewAndroidDriverInstance();
        swipe(1399,1378,2199,0,1);
        caps.setCapability("unlockType","pin");
        caps.setCapability("unlockKey",PIN);
    }

    @And("^the Splash Screen is displayed$")
    public void theSplashScreenIsDisplayed() throws Throwable {
        new WebDriverWait(androidDriver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath(androidPageObjects.HLSplashLogo())));
    }

    @Then("^the HL Welcome screen is displayed$")
    public void theHLWelcomeScreenIsDisplayed() throws Throwable {
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.findElement(By.id(androidPageObjects.swipeIconsHomepage())).isDisplayed();
    }

    @When("^I Android Swipe from Right to Left for Galaxy S(\\d+) Edge$")
    public void iAndroidSwipeFromLeftToRightForGalaxySEdge(int arg0) throws Throwable {
        swipe(1399, 2199, 1378, 0, 3); //Galaxy S7 Edge
    }

    @When("^I Android Swipe from Right to Left$")
    public void iAndroidSwipeFromLeftToRightFor() throws Throwable {
        int xFrom = 0;
        int xTo = 0;
        int yFrom = 0;
        int yTo = 0;

        switch (deviceName) {
            case "Galaxy_S7_Edge_Oreo":
                xFrom = 1399; xTo = 1378; yFrom = 2199; yTo =0;
                break;

            case "Nexus_5_API_22":
                xFrom = 1030; xTo = 200; yFrom = 900; yTo =900;
                break;
        }
            swipe(xFrom, yFrom, xTo, yTo, 1);

    }

    @Then("^the HL Fingerprint info screen is displayed$")
    public void theHLFingerprintInfoScereenIsDisplayed() throws Throwable {
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.findElement(By.id(androidPageObjects.fingerPrintIcon())).isDisplayed();
    }

    @And("^then I click on the Get Started button$")
    public void thenIClickOnTheGetStartedButton() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.getStarted())).click();
    }

    @Then("^I view the Android Terms & Conditions$")
    public void iViewTheAndroidTermsConditions() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.viewTermsAndConditions())).click();
    }

    @Then("^I Accept the Terms and Conditions$")
    public void iAcceptTheTermsAndConditions() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.acceptTermsAndConditions())).click();
    }

    @And("^I Android Swipe from Down to Up (\\d+) times$")
    public void iAndroidSwipeFromDownToUpTimes(int times) throws Throwable {
        int amount;
        int xFrom = 0;
        int xTo = 0;
        int yFrom = 0;
        int yTo = 0;

        switch (deviceName) {
            case "Galaxy_S7_Edge_Oreo":
                xFrom = 1399; xTo = 1378; yFrom = 2199; yTo =0;
                break;

            case "Nexus_5_API_22":
                xFrom = 1030; xTo = 200; yFrom = 900; yTo =900;
                break;
        }
        for (amount = 0; amount < times; amount ++) {
            swipe(xFrom, yFrom, xTo, yTo, 1);
        }

    }

    @Then("^I should see Android Markets homepage$")
    public void iShouldSeeAndroidMarketsHomepage() throws Throwable {
        androidDriver.findElementById(androidPageObjects.accountIcon()).isDisplayed();
        androidDriver.findElementById(androidPageObjects.watchlistIcon()).isDisplayed();
        androidDriver.findElementById(androidPageObjects.searchIcon()).isDisplayed();
        androidDriver.findElementById(androidPageObjects.newsIcon()).isDisplayed();
        androidDriver.findElementById(androidPageObjects.marketsIcon()).isDisplayed();
    }

//    @And("^then I click on the Android FTSE(\\d+) option$")
//    public void thenIClickOnTheAndroidFTSEOption(int ftse) throws Throwable {
//        if (ftse == 100) {
//            androidDriver.findElement(By.xpath(androidPageObjects.ftse100())).click();
//        }
//        if (ftse == 250) {
//            androidDriver.findElement(By.xpath(androidPageObjects.ftse250())).click();
//        }
//    }
//
//    @And("^then I click on the Android FTSE ALL SHARE option$")
//    public void thenIClickOnTheAndroidFTSEALLSHAREOption() throws Throwable {
//        androidDriver.findElement(By.xpath(androidPageObjects.ftseAllShare())).click();
//    }

    @When("^I click on the Android Account Icon$")
    public void iClickOnTheAndroidAccountIcon() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.accountIcon())).click();
    }

    @And("^I click on the Android Log in button$")
    public void iClickOnTheAndroidLogInButton() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.logInButton())).click();
    }

    @When("^I enter the Android Debug Menu$")
    public void iEnterTheAndroidDebugMenu() throws Throwable {
        new TouchAction(androidDriver)
                .longPress(androidDriver
                        .findElementById(androidPageObjects.logInDebugToolbar()),Duration.ofSeconds(5)).perform();
    }

//    @And("^I enter the Android Environment Selector$")
//    public void iEnterTheAndroidEnvironmentSelector() throws Throwable {
//        androidDriver.findElement(By.xpath(androidPageObjects.environmentSelectorLink())).click();
//    }

    @When("^I click on the Android WatchList Icon$")
    public void iClickOnTheAndroidWatchListIcon() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.watchlistIcon())).click();
    }

    @Then("^I should click the Android Create Watchlist button$")
    public void iShouldSeeTheAndroidCreateWatchlistButton() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.createWatchlist())).click();
    }

    @When("^I click on the Android Search Icon$")
    public void iClickOnTheAndroidSearchIcon() throws Throwable {
        androidDriver.findElement(By.xpath(androidPageObjects.searchIcon())).click();
    }

    @Then("^I should be Android directed to the Search option$")
    public void iShouldBeAndroidDirectedToTheSearchOption() throws Throwable {

    }

    @When("^I click on the Android News Icon$")
    public void iClickOnTheAndroidNewsIcon() throws Throwable {
        androidDriver.findElement(By.xpath(androidPageObjects.newsIcon())).click();
    }

    @Then("^I should be Android directed to the News room$")
    public void iShouldBeAndroidDirectedToTheNewsRoom() throws Throwable {
    }

    @Then("^I launch a Stock browser on the device and visit \"([^\"]*)\"$")
    public void iLaunchAStockBrowserOnTheDeviceAndVisit(String url) throws Throwable {
        caps.setCapability("browserName", "browser");
        appiumServer.appiumStart();
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        androidDriver.get(url);
    }

    @Then("^I launch a Chrome browser on the device and visit \"([^\"]*)\"$")
    public void iLaunchAChromeBrowserOnTheDeviceAndVisit(String url) throws Throwable {
        caps.setCapability("app", "/Users/steveyoung/Documents/Repos/JVMProjects/big-radical-web-qa/android_chrome_64.apk");
        caps.setCapability("browserName", "chrome");
        appiumServer.appiumStart();
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        androidDriver.get(url);
    }

    @Then("^I close down the Android simulator$")
    public void iCloseDownTheSimulator() throws Throwable {
        closeDownAndroidSimulator();
    }

    @Then("^I Android take a Screenshot and Pause for (\\d+) seconds$")
    public void iTakeAScreenshotAndPauseForSeconds(int seconds) throws Throwable {
        Thread.sleep(10000);
        iTakeScreenshot(platform);
    }

    @Then("^I press the Android back button$")
    public void iPressTheAndroidBackButton() throws Throwable {
        androidDriver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @And("^I enter Android Username of \"([^\"]*)\"$")
    public void iEnterAndroidUsernameOf(String username) throws Throwable {
        androidDriver.findElementById(androidPageObjects.username()).sendKeys(username);
    }

    @And("^I enter Android Date of Birth of \"([^\"]*)\"$")
    public void iEnterAndroidDateOfBirthOf(String dob) throws Throwable {
        androidDriver.findElementById(androidPageObjects.dateOfBirth()).sendKeys(dob);
    }

    @Then("^I click on the Android Continue Log in button$")
    public void iClickOnTheAndroidContinueLogInButton() throws Throwable {
        androidDriver.findElementById(androidPageObjects.continueButton()).click();
    }

    @And("^I accept the Android Check your data alert$")
    public void iAcceptTheAndroidCheckYourDataAlert() throws Throwable {
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        androidDriver.findElementById(androidPageObjects.dataErrorOkButton()).click();
    }

    @And("^I create an Android WatchList named \"([^\"]*)\"$")
    public void iCreateAnAndroidWatchListNamed(String watchlist) throws Throwable {
        androidDriver.findElementById(androidPageObjects.watchListName()).sendKeys(watchlist);
    }

    @Then("^I select to change the Environment to Stub$")
    public void iSelectToChangeTheEnvironmentToStub() throws Throwable {
        new WebDriverWait(androidDriver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"Staging\")"))).isDisplayed();
//        androidDriver.findElement(By.xpath(androidPageObjects.environmentSelection())).click();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"Staging\")")).click();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"Stub\")")).click();
    }

    @When("^I click on the Android Market Icon$")
    public void iClickOnTheAndroidMarketIcon() throws Throwable {
        androidDriver.findElementById(androidPageObjects.marketsIcon()).click();
    }

    @And("^I Android Pull to Refresh$")
    public void iAndroidPullToRefresh() throws Throwable {
        new WebDriverWait(androidDriver,120).until(ExpectedConditions.elementToBeClickable(By.id(androidPageObjects.noMarketDataText()))).isDisplayed();
        int xFrom = 0;
        int xTo = 0;
        int yFrom = 0;
        int yTo = 0;

        switch (deviceName) {
            case "Galaxy_S7_Edge_Oreo":
                xFrom = 728; xTo = 728; yFrom = 563; yTo =1815;
                break;

            case "Galaxy_S7_Edge_API_22":
                xFrom = 728; xTo = 728; yFrom = 563; yTo =1815;
                break;

            case "NEW DEVICE":
                xFrom = 728; xTo = 728; yFrom = 563; yTo =1815;
                break;
        }
        swipe(xFrom,yFrom,xTo,yTo,4);
    }

    @Then("^I Android select the \"([^\"]*)\" option$")
    public void iAndroidSelectTheOption(String market) throws Throwable {
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"" + market + "\")")).click();
    }

    @Then("^I click the Android blue back arrow$")
    public void iClickTheAndroidBlueBackArrow() throws Throwable {
        androidDriver.findElementByAccessibilityId(androidPageObjects.blueBackArrow()).click();
    }

    @When("^I Android enter the Master Password characters of \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iAndroidEnterTheMasterPasswordCharactersOf(String second, String fourth, String seventh) throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.masterPasswordOne())).sendKeys(second);
        androidDriver.findElement(By.id(androidPageObjects.masterPasswordTwo())).sendKeys(fourth);
        androidDriver.findElement(By.id(androidPageObjects.masterPasswordThree())).sendKeys(seventh);
    }

    @Then("^I click on the Android Master Password Log In$")
    public void iClickOnTheAndroidMasterPasswordLogIn() throws Throwable {
        androidDriver.findElementById(androidPageObjects.loginMasterPassword()).click();
    }

    @And("^I Accept the Terms and Conditions on the Log In page$")
    public void iAcceptTheTermsAndConditionsOnTheLogInPage() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.acceptTermsAndConditionsAtLogIn())).click();
    }

    @When("^I Android capture the portfolio value$")
    public void iCaptureThePortfolioValue() throws Throwable {
        String portfolioValue = androidDriver.findElement(By.id(androidPageObjects.portfolioValue())).getText();
        System.out.println("Portfolio Value is " + portfolioValue);
    }

    @And("^I Android select the Action option$")
    public void iAndroidSelectTheActionOption() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.actionOption())).click();
    }

    @And("^I Android select the Top Up button$")
    public void iAndroidSelectTheTopUpButton() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.topUpMoney())).click();
    }

    @Then("^I Android enter a Top Up amount of \"([^\"]*)\"$")
    public void iAndroidEnterATopUpAmountOf(String topUp) throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.topUpAmount())).sendKeys(topUp);
    }

    @And("^I Android select Continue Top Up$")
    public void iAndroidSelectContinueTopUp() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.continueTopUp())).click();
    }

    @And("^I Android choose Amend the Top Up$")
    public void iAndroidChooseAmendTheTopUp() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.amendTopUp())).click();
    }

    @And("^I Android Take me back to the app$")
    public void iAndroidTakeMeBackToTheApp() throws Throwable {
        try {
            androidDriver.findElementByAccessibilityId(androidPageObjects.backToApp()).click();

        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
    }

    @Then("^I Android select the Withdraw money button$")
    public void iAndroidSelectTheWithdrawMoneyButton() throws Throwable {
        androidDriver.findElement(By.id(androidPageObjects.withdrawMoney())).click();
    }




    public class appiumServer extends AppiumServer {
    }

    protected static void swipe(int startx, int starty, int endx, int endy, int duration) { // Android ONLY!
//        System.out.println("    swipe(" + startx + ", " + starty + ", " + endx + ", " + endy + ")");
        new TouchAction((MobileDriver) androidDriver).press(startx, starty).waitAction(Duration.ofSeconds(duration)).moveTo(endx, endy).release().perform();
    }

}
