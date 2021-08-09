@SmokeTest
Feature: Create account

  Scenario: Create account with success
    Given the user navigate to register page
    When the user fill the fields
    Then account should be create with success

  Scenario: Create account with the same email
    Given the user navigate to register page
    When the user fill the email field with a value already registered
    Then account should not be create and raise a message error
