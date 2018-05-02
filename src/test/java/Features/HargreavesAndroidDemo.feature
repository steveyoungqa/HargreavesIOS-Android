@androidDemo @appium

Feature: Hargreaves Lansdown Android

  Scenario Outline: Hargreaves Lansdown Android User Journey
    Given I am using Appium for device "<Device>" and Android version "<Version>"
    And using Android I am using the app directory of "<Directory>" and app "<APP>"
    Then I launch the App on the Android Device

    Then the HL Welcome screen is displayed
    When I Android Swipe from Right to Left
    Then the HL Fingerprint info screen is displayed
    And then I click on the Get Started button

    Then I view the Android Terms & Conditions
    And I Android Swipe from Down to Up 5 times
    Then I Accept the Terms and Conditions

    And I Android Take me back to the app
    Then I should see Android Markets homepage

    When I click on the Android Account Icon
    And I click on the Android Log in button

    When I enter the Android Debug Menu
    Then I Android select the "Environment Selector" option
    Then I select to change the Environment to Stub
    Then I press the Android back button
    Then I press the Android back button
    Then I click the Android blue back arrow

    And I Android Take me back to the app
    When I click on the Android Market Icon
    And I Android Take me back to the app
    And I Android Pull to Refresh

    Then I Android select the "Dow Jones" option
    Then I click the Android blue back arrow
    And I Android Take me back to the app

    When I click on the Android Account Icon
    And I click on the Android Log in button
    And I enter Android Username of "<Username>"
    And I enter Android Date of Birth of "<DOB>"
    Then I click on the Android Continue Log in button

    And I Accept the Terms and Conditions on the Log In page
    When I Android enter the Master Password characters of "<2nd>" "<4th>" "<7th>"
    Then I click on the Android Master Password Log In

    When I Android capture the portfolio value

    Then I Android select the "SIPP" option
    Then I Android select the "OK, GOT IT" option
    Then I Android select the "PRICES" option
    Then I Android select the "DETAILS" option
    And I Android select the Action option
    And I Android select the Top Up button
    Then I Android enter a Top Up amount of "<topup>"
    And I Android select Continue Top Up
    And I Android choose Amend the Top Up
    Then I click the Android blue back arrow
    And I Pause for 3 seconds to debug
    Then I click the Android blue back arrow
    When I click on the Android Market Icon

    Then I Android select the "FTSE 100" option
    And I Android Swipe from Down to Up 7 times

    Then I Android select the "FALLERS" option
    And I Android Swipe from Down to Up 7 times

    Examples:
      | Device                   | Version | Directory                           | APP              | Username    | DOB    | watchlist       | 2nd | 4th | 7th | topup |
      | Galaxy_S7_Edge_Oreo      | 8.0     | /Users/steveyoung/Documents/Appium/ | HLandroidDev.apk | clnt1300107 | 010351 | automation demo | r   | d   | g   | 14500 |
#      | Galaxy_S7_Edge_API_22    | 7.0     | /Users/steveyoung/Documents/Appium/ | HLandroidDev.apk | clnt1300107 | 010351 | automation demo | r   | d   | g   | 14500 |
#      | Nexus_5_API_22           | 7.0     | /Users/steveyoung/Documents/Appium/ | HLandroidDev.apk | clnt1300107 | 010351 | automation demo | r   | d   | g   | 3800  |


