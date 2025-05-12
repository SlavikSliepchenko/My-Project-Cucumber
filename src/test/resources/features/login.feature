Feature: User login

  Scenario: Successful login
    Given I open the login page
    When I submit correct login credentials
    Then I should see the dashboard