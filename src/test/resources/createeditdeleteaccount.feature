@SmokeTest
Feature: CreateEditDelete
  Scenario: Create account one
    Given access the site with correct login
    When accessing the accounts tab create an Account called 1
    Then save account and wait for the message <message>

  Scenario: Edit account one
    Given access the site with correct login
    When accessing the accounts tab edit an Account called 1
    Then save account and wait for the message <message>

  Scenario: Delete account one
    Given access the site with correct login
    When accessing the accounts tab delete an Account called 1
    Then save account and wait for the message <message>