@SmokeTest
Feature: Login

  Scenario: Access with invalid password
    Given access navigate to home page
    When the user logs in, will have a problem with user login
    Then the password address incorrect


  Scenario: Access the registered user
    Given access navigate to home page
    When the user logs in, will give a welcome message
    Then the account must be logged in correctly with no errors
