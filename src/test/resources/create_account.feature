@SmokeTest
Feature: Create account

  Scenario: Create account with success
    Given the user navigate to register page
    When the user fill the fields
    Then account should be create with success

