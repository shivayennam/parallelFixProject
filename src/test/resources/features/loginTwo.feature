# src/test/resources/features/login.feature
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I open the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see the dashboard

  Scenario: Login fails with invalid credentials
    Given I open the login page
    When I enter username "invalid_user"
    And I enter password "wrong_password"
    And I click the login button
    Then I should see an error message