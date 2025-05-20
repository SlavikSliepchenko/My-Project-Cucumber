Feature: Add new candidate

Scenario: Successful add new Candidate
Given I am on the Candidates page
When I click the "Добавить кандидата" button
And I enter candidate email "ivan@example.com"
And I enter candidate full name "Иван Иванов"
And I enter candidate position "Frontend Developer"
And I click the "Добавить кандидата подтверждение" button
Then I should see candidate email "ivan@example.com"
And I should see candidate position "Frontend Developer"