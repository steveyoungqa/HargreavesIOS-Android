package PageObjects;

import Appium.DriverFactory;

import java.io.IOException;


public class iosPageObjects extends DriverFactory {


    public String iosWelcomeText() throws IOException {
        return "Welcome to our new mobile app!";
    }

    public String getStartedButton() throws IOException {
        return "Get Started";
    }

    public String fingerPrintScreen() throws IOException {
        return "Touch ID login option";
    }

    public String faceIDlogin() throws IOException {
        return "Face ID login option";
    }

    public String termsAndConditions() throws IOException {
        return "View Terms & Conditions";
    }

    public String acceptButton() throws IOException {
        return "Accept";
    }

    //Markets Homepage
    public String accountIcon() throws IOException {
        return "Account";
    }

    public String watchlistIcon() throws IOException {
        return "Watchlist";
    }

    public String createWatchList() throws IOException {
        return "Create a watchlist";
    }

    public String createWatchListButton() throws IOException {
        return "Create";
    }


    public String exitCreateWatchList() throws IOException {
        return "exit";
    }


    public String enterWatchListName() throws IOException {
        return "Enter name";
    }

    public String searchIcon() throws IOException {
        return "Search";
    }

    public String searchPageCopy() throws IOException {
        return "Search shares, ETFs or investment trusts or browse funds";
    }

    public String newsIcon() throws IOException {
        return "News";
    }

    public String marketsIconFromDebugMenu() throws IOException {
        return "Markets";
    }

    public String ftse100() throws IOException {
        return "FTSE 100";
    }

    public String risers() throws IOException {
        return "RISERS";
    }

    public String fallers() throws IOException {
        return "FALLERS";
    }

    public String aToZ() throws IOException {
        return "A-Z";
    }

    public String ftse250() throws IOException {
        return "FTSE 250";
    }

    public String ftseAllShare() throws IOException {
        return "FTSE ALL SHARE";
    }

    //Login Section
    public String loginButton() throws IOException {
        return "Log in";
    }

    public String openAccountLink() throws IOException {
        return "open an account now";
    }

    public String handleSecurityLink() throws IOException {
        return "See how we handle your security";
    }

    public String stagingOptionDebugMenu() throws IOException {
        return "Staging";
    }

    public String qaOptionDebugMenu() throws IOException {
        return "QA";
    }


    public String stubsDebugMenu() throws IOException {
        return "Stubs";
    }

    public String remoteDebugMenu() throws IOException {
        return "Remote";
    }

    public String doneButtonFromStaging() throws IOException {
        return "Done";
    }

    public String usernameTextField() throws IOException {
        return "Username";
    }

    public String forgotUsernameLink() throws IOException {
        return "Forgot?";
    }

    public String dateOfBirthTextField() throws IOException {
        return "Date of birth (ddmmyy)";
    }

    public String saveMyUsernameSwitch() throws IOException {
        return "//XCUIElementTypeApplication[@name='Hargreaves Lansdown']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeSwitch";
    }

    public String continueLoginButton() throws IOException {
        return "Continue";
    }

    public String cancelLoginLink() throws IOException {
        return "Cancel";
    }

    public String loginFailOKalert() throws IOException {
        return "Ok";
    }

    public String dowJones() throws IOException {
        return "Dow Jones";
    }

    public String backtoMarketsScreen() throws IOException {
        return "Markets";
    }

    public String secondCharMasterPassword() throws IOException {
        return "//XCUIElementTypeSecureTextField[@value='2nd']";
    }

    public String fourthCharMasterPassword () throws IOException {
        return "//XCUIElementTypeSecureTextField[@value='4th']";
    }

    public String seventhCharMasterPassword () throws IOException {
        return "//XCUIElementTypeSecureTextField[@value='7th']";
    }

    public String masterPasswordLogIn () throws IOException {
        return "Log in";
    }

    public String sippMarket () throws IOException {
        return "SIPP";
    }

    public String gotItDialogue() throws IOException {
        return "Got it";
    }

    public String pricesView() throws IOException {
        return "PRICES";
    }

    public String detailsView() throws IOException {
        return "DETAILS";
    }

    public String actionView() throws IOException {
        return "Action";
    }

    public String topUp() throws IOException {
        return "Top up";
    }

    public String withdrawMoney() throws IOException {
        return "Withdraw money";
    }

    public String enterAmount () throws IOException {
        return "Enter amount";
    }

    public String tradingPassword () throws IOException {
        return "Trading password";
    }

    public String confirmWithdrawal () throws IOException {
        return "Confirm Withdrawal";
    }

    public String withdrawalConfirmed () throws IOException {
        return "Your withdrawal instruction has been placed.";
    }

    public String returnToAccount () throws IOException {
        return "Return to account";
    }

    public String topUpContinue() throws IOException {
        return "Continue";
    }

    public String amendAmount() throws IOException {
        return "Amend";
    }

    public String exit() throws IOException {
        return "exit";
    }

    public String backToApp() throws IOException {
        return "Take me back to app";
    }

    public String loginFailedPopUp() throws IOException {
        return "Please check your data connection, then try again.";
    }


}

