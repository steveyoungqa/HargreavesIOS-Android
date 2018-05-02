@appium @iosDemo

Feature: Hargreaves Lansdown IOS

  Scenario Outline: Hargreaves Lansdown IOS User Journey
    Given I am using Appium for device "<Device>" and IOS version "<Version>"
    And I am using IOS the app directory of "<Directory>" and app "<APP>"
    Then I launch the App on the IOS Device

    Then the IOS HL Welcome screen is displayed
    Then I IOS Take me back to the App
    And then I IOS swipe to the "left"
    Then the IOS HL fingerprint or Face ID info screen is displayed
    And then I IOS swipe to the "left"
    Then the IOS Quick actions info screen is displayed
    And then I IOS swipe to the "left"
    Then the IOS Top up from your mobile info screen is displayed
    And then I IOS swipe to the "left"
    Then the IOS New share dealing options info screen is displayed

    And then I click the IOS Get Started button

    When I view the IOS Terms & Conditions
    Then I IOS scroll "up" the page 4 times
    And I IOS Select Accept

    Then I should see the IOS Markets homepage
    Then I take a screenshot
    Then I enter the IOS Debug menu
    And I choose Stubs and Remote from the Debug menu
    Then I take a screenshot
    Then I click on the IOS Market Icon
    Then I IOS Take me back to the App
    Then I take a screenshot
    Then I IOS pull down and refresh the page
    Then I click on the IOS Market Icon

    And I IOS click on the "Xetra DAX" link
    Then I IOS go back to the Markets page
    Then I take a screenshot
    When I click on the IOS Account Icon
    Then I click on the IOS Log in button
    And I enter IOS a Username of "<Username>"
    And I enter IOS a Date of Birth of "<DOB>"
    Then I click on the IOS Continue Log in button
    And I IOS Select Accept
    Then I take a screenshot
    When I IOS enter the Master Password characters of "<2nd>" "<4th>" "<7th>"
    Then I click on the IOS Master Password Log In
    Then I take a screenshot
    When I IOS Enter the SIPP Market
    And I IOS accept the Got it dialogue pop-up
    Then I IOS switch view to Prices
    And I IOS switch view to Details
    Then I IOS click on Action
    And I IOS choose to Top up
    Then I IOS enter a Top up amount of "<topup>"
    And I IOS click Top up Continue
    Then I IOS choose Amend the Top Up
    And I IOS choose to Exit

    Then I IOS click on Action
    And I IOS click on Withdraw Money
    Then I IOS enter a Top up amount of "100"
    And I IOS click Top up Continue
    Then I IOS enter a trading password of "trading123"
    And I IOS click on Confirm Withdrawal
    And I IOS should see the Withdrawal Instruction confirmation screen
    And I Pause for 5 seconds to debug
    Then I take a screenshot
    And I IOS Return to account

    Then I click on the IOS Market Icon

    And I IOS click on the "FTSE 100" link
    Then I IOS scroll "up" the page 4 times

    And I IOS click on the "FALLERS" link
    Then I IOS scroll "down" the page 4 times

    And I IOS click on the "A-Z" link
    Then I IOS scroll "up" the page 4 times

    Then I zip up all of the generated screenshots

    Examples:
      | Device     | Version | Directory                           | APP                     | Username    | DOB    | watchlist        | 2nd | 4th | 7th | topup |
      | iPhone 8   | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
#      | iPhone 7   | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
#      | iPhone X   | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
