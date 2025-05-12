Feature: Validation messages for empty login form

  Scenario: User submits login form with empty fields
    Given I open the login page
    When I submit the login form with empty fields
    Then I should see validation messages for username and password

