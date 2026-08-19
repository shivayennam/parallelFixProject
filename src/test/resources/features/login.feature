# src/test/resources/features/login.feature
Feature: Test Login functionality

  Scenario: Successful login with valid credentials
    Given I open the login page
    When I enter username "naga.vemuri83@gmail.com"
    And I enter password "Sitarama2018*"
    And I click the login button
#    Then I should see the dashboard

#  Scenario: Login fails with invalid credentials
#    Given I open the login page
#    When I enter username "error_user"
#    And I enter password "wrong_password"
#    And I click the login button
#    Then I should see an error message