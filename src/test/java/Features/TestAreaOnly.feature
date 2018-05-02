@appium

Feature: Contact Manager Physical Android Device connected

  Scenario Outline: Hargreaves Lansdown Android User Journey
    Given I am using Appium for Physical device UDID "<UDID>" and Android version "<Version>"
    And using Android I am using the app directory of "<Directory>" and app "<APP>"
    Then I launch the App on the Android Device and unlock using Pin "<PIN>"

    Examples:
      | Device              | Version | Directory                           | APP                | UDID               | PIN  |
      | Galaxy_S7_Edge_Oreo | 8.0     | /Users/steveyoung/Documents/Appium/ | ContactManager.apk | 9886334232584b5757 | 1990 |

