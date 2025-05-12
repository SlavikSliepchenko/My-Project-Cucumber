Feature: Successful logout

  Scenario: Successful logout
    When I am logged in as an admin
    And I click the logout button
    Then I should be redirected to the login page