@SmokeTest
Feature: Crud

  Scenario: Create account one
    Given access the site with correct login
    When accessing the accounts tab create an Account
    Then save account and wait for the message "Conta adicionada com sucesso!"

  Scenario: Edit account one
    Given access the site with correct login
    When access the accounts page and edit the first item
    Then save account and wait for the message "Conta alterada com sucesso!"

  Scenario: Delete account one
    Given access the site with correct login
    When access the accounts page and delete the first item
    Then save account and wait for the message "Conta removida com sucesso!"