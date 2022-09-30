Feature: Temporary mail

  Background:

    Given I open browser

  Scenario: Creating temporary mail

    When I open temp mail service
    Then Temp email created