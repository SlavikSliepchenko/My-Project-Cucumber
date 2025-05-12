Feature: Navigate to Candidates section

  Scenario: User opens the Candidates section after login
    When I log in and open the Candidates section
    Then I should be redirected to the Candidates page