Feature: Google Cloud

  Background:

    Given I open browser

  Scenario: LogIn to Google Cloud with data table

    When I open Google Cloud platform
    And I login with parameters
      | Email                 | Password  |
      | userfor7777@gmail.com | Superpass |
    Then Verification of successful authorization

  Scenario Outline: LogIn to Google Cloud with examples

    When I open Google Cloud platform
    And I enter account as <email>
    And I enter pass as "<password>"
    Then Verification of successful authorization

    Examples:
      | email                 | password  |
      | userfor7777@gmail.com | Superpass |
      | usernew7799@gmail.com | Superpass |

  Scenario: LogIn Google Cloud with regular expression and cucumber expression

    When I open Google Cloud platform
    And I enter account as userfor7777@gmail.com
    And I enter pass as "Superpass"
    Then Verification of successful authorization