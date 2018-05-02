@login

Feature: Hargreaves Lansdown IOS Login Scenarios

    Scenario Outline:
    Hargreaves Lansdown IOS Incorrect Login
    Correct Login
    Incorrect Master Password
    Correct Master Password

    Given I am using Appium for device "<Device>" and IOS version "<Version>"
    And I am using IOS the app directory of "<Directory>" and app "<APP>"
    Then I launch the App on the IOS Device
    Then the IOS HL Welcome screen is displayed
    Then I IOS Take me back to the App
    And then I IOS swipe to the Left
    Then the IOS HL fingerprint or Face ID info screen is displayed

    And then I click the IOS Get Started button

    When I view the IOS Terms & Conditions
    And I IOS scroll down the Terms & Conditions
    And I IOS Select Accept

    Then I should see the IOS Markets homepage

    Then I enter the IOS Debug menu
    And I choose Stubs and Remote from the Debug menu

    Then I click on the IOS Market Icon
    Then I IOS Take me back to the App

    Then I IOS pull down and refresh the page
    Then I click on the IOS Market Icon

    When I click on the IOS Account Icon
    Then I click on the IOS Log in button
    And I enter IOS a Username of "INCORRECT"
    And I enter IOS a Date of Birth of "<DOB>"
    Then I click on the IOS Continue Log in button
    Then I IOS should see the Login Failed pop-up
    And I accept the IOS Check your data alert

    Then I IOS Clear the Username field
    Then I IOS Clear the Date of Birth field

    And I enter IOS a Username of "<Username>"
    And I enter IOS a Date of Birth of "<DOB>"
    Then I click on the IOS Continue Log in button
    And I IOS Select Accept

    When I IOS enter the Master Password characters of "n" "o" "t"
    Then I click on the IOS Master Password Log In

    Then I IOS should see the Login Failed pop-up
    And I accept the IOS Check your data alert

    When I IOS enter the Master Password characters of "<2nd>" "<4th>" "<7th>"
    Then I click on the IOS Master Password Log In


    Examples:
      | Device   | Version | Directory                           | APP                     | Username    | DOB    | watchlist        | 2nd | 4th | 7th | topup |
#  | iPhone 7 | 10.2    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
      | iPhone 7 | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
#      | iPhone X | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
#  | iPad Air 2 | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
