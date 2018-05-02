package PageObjects;

import java.io.IOException;


public class androidPageObjects {

//    public WebElement splashLogo() throws IOException {
//        return findAndroidElementWithTimeout(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[1]"),10);
//    } //NOT WORKING - TO DO

    public String HLSplashLogo() throws IOException {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[1]";
    }

    public String swipeIconsHomepage() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/walkthrough_viewpager_indicator";
    }

    public String getStarted() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/get_started_button";
    }

    public String fingerPrintIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/walkthrough_image";
    }

    public String blueBackArrow() throws IOException {
        return "Navigate up";
    }

    public String viewTermsAndConditions() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/terms_and_conditions_link";
    }

    public String acceptTermsAndConditions() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/button";
    }

    public String acceptTermsAndConditionsAtLogIn() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/agree_button";
    }

    public String marketsIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/bottom_nav_market";
    }

//    public String ftse100() throws IOException {
//        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]";
//    }
//
//    public String ftse250() throws IOException {
//        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]";
//    }
//
//    public String ftseAllShare() throws IOException {
//        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]";
//    }

    public String accountIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/bottom_nav_portfolio";
    }

    public String logInDebugToolbar() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/toolbar_title";
    }

//    public String environmentSelectorLink() throws IOException {
//        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout";
//    }

    public String watchlistIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/bottom_nav_watchlist";
    }

    public String searchIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/bottom_nav_search";
    }

    public String newsIcon() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/bottom_nav_news";
    }

    public String logInButton() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/portfolio_login_button";
    }

    public String createWatchlist() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/add_a_watchlist_button_empty_list";
    }

    public String watchListName() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/watchlist_input_box";
    }

    public String saveWatchlist() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/add_a_watchlist_button";
    }

    public String username() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_username_edit";
    }

    public String dateOfBirth() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_dob_edit";
    }

    public String continueButton() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_step1_submit_button";
    }

    public String dataErrorOkButton() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/ok_button";
    }

    public String environmentSelection() throws IOException {
        return "Staging";
    }

    public String masterPasswordOne() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_secret_one_edit";
    }

    public String masterPasswordTwo() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_secret_two_edit";
    }

    public String masterPasswordThree() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_secret_three_edit";
    }

    public String loginMasterPassword() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/login_step2_submit_button";
    }

    public String portfolioValue() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/portfolio_header_total_value";
    }

    public String actionOption() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/product_header_action";
    }

    public String topUpMoney() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/product_actions_add_money_button";
    }

    public String topUpAmount() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/payment_amount_edit_text";
    }

    public String continueTopUp() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/payment_amount_next";
    }

    public String amendTopUp() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/cancel_button";
    }

    public String noMarketDataText() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/no_data_text";
    }

    public String backToApp() throws IOException {
        return "Take me back to app";
    }

    public String withdrawMoney() throws IOException {
        return "com.mubaloo.android.hargreaveslansdown.dev:id/product_actions_withdraw_money_button";
    }




}

