package StepDefinitions;

import Appium.AppiumServer;
import Appium.DriverFactory;
import PageObjects.iosPageObjects;
import Utils.ZipFiles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class iosStepdefs extends DriverFactory {

    public static DesiredCapabilities caps = new DesiredCapabilities();
    PageObjects.iosPageObjects iosPageObjects = new iosPageObjects();
    public static String deviceName = null;

    @Given("^I am using Appium for device \"([^\"]*)\" and IOS version \"([^\"]*)\"$")
    public void iAmUsingAppiumForDeviceAndIOSVersion(String Device, String IOS) throws Throwable {
        deviceName = Device;
        caps.setCapability("deviceName", Device);
        caps.setCapability("platformVersion", IOS);
        caps.setCapability("automationName", "XCUITest");
    }

    @And("^I am using IOS the app directory of \"([^\"]*)\" and app \"([^\"]*)\"$")
    public void iAmUsingTheAppDirectoryOfAndApp(String dir, String app) throws Throwable {
        File appDir = new File(dir);
        File appPath = new File(appDir, app);
        caps.setCapability("app", appPath);
    }

    @Then("^I launch the App on the IOS Device$")
    public void iLaunchTheAppOnTheDevice() throws Throwable {
        caps.setCapability("useNewWDA", "true");
        caps.setCapability("waitForQuiescence", "false");
        caps.setCapability("shouldUseSingletonTestManager", "false");
        caps.setCapability("clearSystemFiles", "true");
        appiumStartStop.appiumStop();
        Runtime.getRuntime().exec("killall node");
        appiumStartStop.appiumStart();
        DriverFactory.createNewIOSDriverInstance();
        iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    // Mobile browser caps and example
    @Given("^I am using Safari mobile browser to visit \"([^\"]*)\"$")
    public void iAmUsingSafariMobileBrowserToVisit(String url) throws Throwable {
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "11.2");
        caps.setCapability("browserName", "safari");
        iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        iosDriver.get(url);
    }

    @Then("^the IOS HL Welcome screen is displayed$")
    public void theIOSHLWelcomeScreenIsDisplayed() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.iosWelcomeText()).isDisplayed();
    }

    @And("^then I click the IOS Get Started button$")
    public void thenIClickTheIOSGetStartedButton() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.getStartedButton()).click();
    }

    @Then("^the IOS HL fingerprint or Face ID info screen is displayed$")
    public void theIOSHLFingerprintInfoScreenIsDisplayed() throws Throwable {

        try {
            iosDriver.findElementByAccessibilityId(iosPageObjects.fingerPrintScreen()).isDisplayed();
            iosDriver.findElementByAccessibilityId(iosPageObjects.faceIDlogin()).isDisplayed();
            Thread.sleep(1000);

        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
    }

//    @And("^then I IOS swipe to the Left$")
//    public void thenIIOSSwipeToTheLeft(String direction) throws Throwable {
//        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction", "left");
//        js.executeScript("mobile: swipe", scrollObject);
//    }

    @And("^then I IOS swipe to the \"([^\"]*)\"$")
    public void thenIIOSSwipeToThe(String direction) throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: swipe", scrollObject);
    }

    @When("^I view the IOS Terms & Conditions$")
    public void iViewTheIOSTermsConditions() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.termsAndConditions()).click();
    }

    @Then("^I IOS scroll \"([^\"]*)\" the page (\\d+) times$")
    public void iIOSScrollThePageTimes(String direction, int times) throws Throwable {
        int amount;
        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);

        for (amount = 0; amount < times; amount++) {
            js.executeScript("mobile: swipe", scrollObject);
            Thread.sleep(1000);
        }
    }

    @And("^I IOS Select Accept$")
    public void iIOSSelectAccept() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.acceptButton()).click();
    }

    @Then("^I should see the IOS Markets homepage$")
    public void iShouldSeeTheIOSMarketsHomepage() throws Throwable {
        iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId(iosPageObjects.accountIcon()).isDisplayed();
        iosDriver.findElementByAccessibilityId(iosPageObjects.watchlistIcon()).isDisplayed();
        iosDriver.findElementByAccessibilityId(iosPageObjects.searchIcon()).isDisplayed();
        iosDriver.findElementByAccessibilityId(iosPageObjects.newsIcon()).isDisplayed();
    }

    @When("^I click on the IOS Account Icon$")
    public void iSelectTheIOSAccountIcon() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.accountIcon()).click();
    }

    @Then("^I should see the IOS Login Page$")
    public void iShouldSeeTheIOSLoginPage() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.loginButton()).isDisplayed();
        iosDriver.findElementByAccessibilityId(iosPageObjects.openAccountLink()).isDisplayed();
        iosDriver.findElementByAccessibilityId(iosPageObjects.handleSecurityLink()).isDisplayed();
    }

    @And("^then I click on the IOS FTSE ALL SHARE option$")
    public void thenIClickOnTheIOSFTSEALLSHAREOption() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.ftseAllShare()).click();
    }

    @When("^I click on the IOS WatchList Icon$")
    public void iClickOnTheIOSWatchListIcon() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.watchlistIcon()).click();
    }

    @Then("^I click on the IOS Create Watchlist button$")
    public void iClickOnTheIOSCreateWatchlistButton() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.createWatchList()).click();
    }

    @And("^I enter an IOS Watchlist name of \"([^\"]*)\"$")
    public void iEnterAnIOSWatchlistNameOf(String watchlist) throws Throwable {
        iosDriver.findElementByName(iosPageObjects.enterWatchListName()).sendKeys(watchlist);
    }

    @Then("^I click on IOS Create Watchlist$")
    public void iClickOnIOSCreateWatchlist() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.createWatchListButton()).click();
    }

    @When("^I click on the IOS Search Icon$")
    public void iClickOnTheIOSSearchIcon() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.searchIcon()).click();
    }

    @Then("^I should be IOS directed to the Search option$")
    public void iShouldBeIOSDirectedToTheSearchOption() throws Throwable {
        iosDriver.findElementByName(iosPageObjects.searchPageCopy()).isDisplayed();
    }

    @And("^I IOS click on Browse Funds$")
    public void iIOSClickOnBrowseFunds() throws Throwable {
    }

    @When("^I click on the IOS News Icon$")
    public void iClickOnTheIOSNewsIcon() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.newsIcon()).click();
    }

    @Then("^I should be IOS directed to the News room$")
    public void iShouldBeIOSDirectedToTheNewsRoom() throws Throwable {

    }

    @And("^then I click on the IOS FTSE(\\d+) option$")
    public void thenIClickOnTheFTSEOption(int ftse) throws Throwable {
        if (ftse == 100) {
            iosDriver.findElementByAccessibilityId(iosPageObjects.ftse100()).click();
        }
        if (ftse == 250) {
            iosDriver.findElementByAccessibilityId(iosPageObjects.ftse250()).click();
        }
    }

    @Then("^I enter the IOS Debug menu$")
    public void iEnterTheIOSDebugMenu() throws Throwable {
        new TouchAction(iosDriver)
                .longPress(iosDriver
                        .findElementById(iosPageObjects.accountIcon())).perform();
    }

    @And("^I choose Staging and QA from the Debug menu$")
    public void iChooseStagingAndQAFromTheDebugMenu() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.stagingOptionDebugMenu()).click();
        iosDriver.findElementByAccessibilityId(iosPageObjects.qaOptionDebugMenu()).click();
        iosDriver.findElementByAccessibilityId(iosPageObjects.doneButtonFromStaging()).click();
    }

    @And("^I choose Stubs and Remote from the Debug menu$")
    public void iChooseStubsAndRemoteFromTheDebugMenu() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.stagingOptionDebugMenu()).click();
        iosDriver.findElementByAccessibilityId(iosPageObjects.stubsDebugMenu()).click();
        iosDriver.findElementByAccessibilityId(iosPageObjects.remoteDebugMenu()).click();
        iosDriver.findElementByAccessibilityId(iosPageObjects.doneButtonFromStaging()).click();
    }

    @Then("^I Pause for (\\d+) seconds to debug$")
    public void iPauseForSecondsToDebug(int arg0) throws Throwable {
        Thread.sleep(arg0 * 1000);
    }

    @Then("^I click on the IOS Market Icon$")
    public void iClickOnTheIOSMarketIcon() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.marketsIconFromDebugMenu()).click();
    }

    @Then("^I IOS pull down and refresh the page$")
    public void iIOSPullDownAndRefreshThePageSwitch() throws Throwable {
            int xFrom = 0;
            int xTo = 0;
            int yFrom = 0;
            int yTo = 0;

        switch (deviceName) {
            case "iPhone 7":
                xFrom = 188; xTo = 188; yFrom = 70; yTo =670;
                break;

                case "iPhone 8":
                xFrom = 188; xTo = 188; yFrom = 70; yTo =670;
                break;

                case "iPhone X":
                xFrom = 188; xTo = 188; yFrom = 116; yTo =1200;
                break;
            }

        new TouchAction((MobileDriver) iosDriver)
                .press(xFrom, yFrom)
                .waitAction(Duration.ofSeconds(2))
                .moveTo(xTo, yTo).release().perform();
    }

    @Then("^the IOS Quick actions info screen is displayed$")
    public void theIOSQuickActionsInfoScreenIsDisplayed() throws Throwable {
    }

    @Then("^the IOS Top up from your mobile info screen is displayed$")
    public void theIOSTopUpFromYourMobileInfoScreenIsDisplayed() throws Throwable {
    }

    @Then("^the IOS New share dealing options info screen is displayed$")
    public void theIOSNewShareDealingOptionsInfoScreenIsDisplayed() throws Throwable {
    }

    @Then("^I click on the IOS Log in button$")
    public void iClickOnTheIOSLogInButton() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.loginButton()).click();
    }

    @And("^I enter IOS a Username of \"([^\"]*)\"$")
    public void iEnterIOSAUsernameOf(String username) throws Throwable {
        iosDriver.findElementByName(iosPageObjects.usernameTextField()).sendKeys(username);
    }

    @And("^I enter IOS a Date of Birth of \"([^\"]*)\"$")
    public void iEnterIOSADateOfBirthOf(String dob) throws Throwable {
        iosDriver.findElementByName(iosPageObjects.dateOfBirthTextField()).sendKeys(dob);
    }

    @Then("^I IOS Clear the Username field$")
    public void iIOSClearTheUsernameField() throws Throwable {
        iosDriver.findElementByName(iosPageObjects.usernameTextField()).clear();
    }

    @Then("^I IOS Clear the Date of Birth field$")
    public void iIOSClearTheDateOfBirthField() throws Throwable {
        iosDriver.findElementByName(iosPageObjects.dateOfBirthTextField()).clear();
    }

    @Then("^I click on the IOS Continue Log in button$")
    public void iClickOnTheIOSContinueLogInButton() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.continueLoginButton()).click();
    }

    @And("^I accept the IOS Check your data alert$")
    public void iAcceptTheIOSCheckYourDataAlert() throws Throwable {
        iosDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId(iosPageObjects.loginFailOKalert()).click();
    }

    @Then("^I click on the IOS Cancel button$")
    public void iClickOnTheIOSCancelButton() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.cancelLoginLink()).click();
    }

    @Then("^I IOS exit Create Watchlist$")
    public void iIOSExitCreateWatchlist() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.exitCreateWatchList()).click();
    }

    @And("^I IOS click on the \"([^\"]*)\" link$")
    public void iIOSClickOnTheTextLink(String link) throws Throwable {
        iosDriver.findElementByName(link).click();
    }

    @Then("^I IOS go back to the Markets page$")
    public void iIOSGoBackToTheMarketsPage() throws Throwable {
        iosDriver.findElementByName(iosPageObjects.backtoMarketsScreen()).click();
    }

    @When("^I IOS enter the Master Password characters of \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iIOSEnterTheMasterPasswordCharactersOf(String second, String fourth, String seventh) throws Throwable {
//        System.out.println(iosDriver.getPageSource());
        iosDriver.findElement(By.xpath(iosPageObjects.secondCharMasterPassword())).sendKeys(second);
        iosDriver.findElement(By.xpath(iosPageObjects.fourthCharMasterPassword())).sendKeys(fourth);
        iosDriver.findElement(By.xpath(iosPageObjects.seventhCharMasterPassword())).sendKeys(seventh);
    }

    @Then("^I click on the IOS Master Password Log In$")
    public void iClickOnTheIOSMasterPasswordLogIn() throws Throwable {
        iosDriver.findElement(By.name(iosPageObjects.masterPasswordLogIn())).click();
    }

    @When("^I IOS Enter the SIPP Market$")
    public void iIOSEnterTheSIPPMarket() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.sippMarket()).click();
    }

    @And("^I IOS accept the Got it dialogue pop-up$")
    public void iIOSAcceptTheGotItDialoguePopUp() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.gotItDialogue()).click();
    }

    @Then("^I IOS switch view to Prices$")
    public void iIOSSwitchViewToPrices() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.pricesView()).click();
    }

    @And("^I IOS switch view to Details$")
    public void iIOSSwitchViewToDetails() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.detailsView()).click();
    }

    @Then("^I IOS click on Action$")
    public void iIOSClickOnAction() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.actionView()).click();
    }

    @And("^I IOS choose to Top up$")
    public void iIOSChooseToTopUp() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.topUp()).click();
    }

    @Then("^I IOS enter a Top up amount of \"([^\"]*)\"$")
    public void iIOSEnterATopUpAmountOf(String amount) throws Throwable {
//        System.out.println(iosDriver.getPageSource());
        iosDriver.findElement(By.name(iosPageObjects.enterAmount())).sendKeys(amount);
    }

    @And("^I IOS click Top up Continue$")
    public void iIOSClickTopUpContinue() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.topUpContinue()).click();
    }

    @Then("^I IOS choose Amend the Top Up$")
    public void iIOSChooseAmmendTheTopUp() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.amendAmount()).click();
    }

    @And("^I IOS click on Withdraw Money$")
    public void iIOSClickOnWithdrawMoney() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.withdrawMoney()).click();
    }

    @Then("^I IOS enter a trading password of \"([^\"]*)\"$")
    public void iIOSEnterATradingPasswordOf(String password) throws Throwable {
        iosDriver.findElement(By.name(iosPageObjects.tradingPassword())).sendKeys(password);
    }

    @And("^I IOS click on Confirm Withdrawal$")
    public void iIOSClickOnConfirmWithdrawal() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.confirmWithdrawal()).click();
    }

    @And("^I IOS should see the Withdrawal Instruction confirmation screen$")
    public void iIOSShouldSeeTheWithdrawalInstructionConfirmationScreen() throws Throwable {
        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId(iosPageObjects.withdrawalConfirmed()).isDisplayed();
    }

    @Then("^I IOS Return to account$")
    public void iIOSReturnToAccount() throws Throwable {
        iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Have to pause here to wait for success screen, staleElement excpetion if waiting for element present

        iosDriver.findElementByAccessibilityId(iosPageObjects.doneButtonFromStaging()).click();

        // There is a stale element here with Enable in the page source set to False so only navigating Back with the
        // IOS Driver worked
    }

    @And("^I IOS choose to Exit$")
    public void iIOSChooseToExit() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.exit()).click();
    }

    @When("^I take a screenshot$")
    public void iIOSCaptureThePortfolioValue() throws Throwable {
        iTakeScreenshot(platform);
    }

    @Then("^I IOS Take me back to the App$")
    public void iIOSTakeMeBackToTheApp() throws Throwable {

        try {
            iosDriver.findElement(By.name(iosPageObjects.backToApp())).click();
            Thread.sleep(1000);

        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
    }

    @Then("^I close down the IOS simulator$")
    public void iCloseDownTheSimulatorFor() throws Throwable {
        closeDownIOSsimulator();
    }

    @And("^I generate a Test Report and open in the browser$")
    public void iGenerateATestReportAndOpenInTheBrowser() throws Throwable {
        Runtime.getRuntime().exec("mvn test verify -DskipTests");
        String localDir = System.getProperty("user.dir");
        File reports = new File(localDir + "/target/site/cucumber-reports/feature-overview.html");
        Runtime.getRuntime().exec("open " + reports);
    }

    @Then("^I IOS should see the Login Failed pop-up$")
    public void iIOSShouldSeeTheLoginFailedPopUpAndSelectOk() throws Throwable {
        iosDriver.findElementByAccessibilityId(iosPageObjects.loginFailedPopUp()).isDisplayed();
    }

    @Then("^I zip up all of the generated screenshots$")
    public void iZipUpAllOfTheGeneratedScreenshots() throws Throwable {
        ZipFiles.makeZipFile();
    }

    public class appiumStartStop extends AppiumServer {
    }


}
