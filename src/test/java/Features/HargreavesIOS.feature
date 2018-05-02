@appium @ios

Feature: Hargreaves Lansdown IOS (Master Resource)

  Scenario Outline: Hargreaves Lansdown IOS User Journey
    Given I am using Appium for device "<Device>" and IOS version "<Version>"
    And I am using IOS the app directory of "<Directory>" and app "<APP>"
    Then I launch the App on the IOS Device

    Then the IOS HL Welcome screen is displayed
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
#    And then I click on the IOS FTSE250 option
#    And then I click on the IOS FTSE ALL SHARE option
#    And then I click on the IOS FTSE100 option

    Then I enter the IOS Debug menu
#    And I choose Staging and QA from the Debug menu
    And I choose Stubs and Remote from the Debug menu

    Then I click on the IOS Market Icon

    Then I IOS pull down and refresh the page

#    And I IOS click on the "Dow Jones" market
#    Then I IOS go back to the Markets page
    And I IOS click on the "Xetra DAX" link
    Then I IOS go back to the Markets page
#
    When I click on the IOS Account Icon
    Then I click on the IOS Log in button
    And I enter IOS a Username of "<Username>"
    And I enter IOS a Date of Birth of "<DOB>"
    Then I click on the IOS Continue Log in button
    And I IOS Select Accept

    When I IOS enter the Master Password characters of "<2nd>" "<4th>" "<7th>"
    Then I click on the IOS Master Password Log In

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





    Then I close down the IOS simulator

    And I generate a Test Report and open in the browser


#    Then I click on the IOS Market Icon
#
#    Then I IOS pull down and refresh the page
#
#    When I click on the IOS WatchList Icon
#    Then I click on the IOS Create Watchlist button
#    And I enter an IOS Watchlist name of "<watchlist>"
#    Then I click on IOS Create Watchlist
#    Then I IOS exit Create Watchlist


#
#    When I click on the IOS Search Icon
#    Then I should be IOS directed to the Search option
#    And I IOS click on Browse Funds
#
#    When I click on the IOS News Icon
#    Then I should be IOS directed to the News room

    #    When I IOS take a screenshot

#    Then I Pause for 10 seconds to debug





    Examples:
      | Device   | Version | Directory                           | APP                     | Username    | DOB    | watchlist        | 2nd | 4th | 7th | topup |
      | iPhone 7 | 11.3    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app | clnt1300107 | 010351 | steves watchlist | r   | d   | g   | 25000 |
#      | iPad Air 2 | 11.2    | /Users/steveyoung/Documents/Appium/ | Hargreaves Lansdown.app |             |        |                  |     |     |     ||

