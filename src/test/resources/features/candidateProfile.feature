Feature: Candidate profile

  Scenario: Candidate profile displays correctly
    Given I am logged in as admin
    When I open the Candidates section
    And I click on candidate "John Doe"
    Then I should see candidate email "john.doe@example.com"
    And I should see candidate position "Frontend Developer"