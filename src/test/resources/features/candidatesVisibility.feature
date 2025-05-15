Feature: Candidates visibility

  Scenario: Candidate "John Doe" is visible in the list
    Given I am logged in as admin
    When I open the Candidates section
    Then I should see candidate "John Doe" in the list