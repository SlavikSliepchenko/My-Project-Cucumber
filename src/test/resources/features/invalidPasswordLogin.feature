Feature: Invalid login attempt with wrong password

  Scenario: User cannot log in with wrong password
    Given I open the login page
    When I submit the login form with wrong password
    Then I should see an error message "Ошибка входа"