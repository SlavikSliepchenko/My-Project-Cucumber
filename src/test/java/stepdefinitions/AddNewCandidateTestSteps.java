package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CandidatePage;
import utils.TestContext;


public class AddNewCandidateTestSteps {

    private final CandidatePage candidatePage;

    public AddNewCandidateTestSteps(TestContext context) {
        this.candidatePage = new CandidatePage(context);
    }

    @Given("I am on the Candidates page")
    public void iAmOnCandidatesPage() {
        candidatePage.openCandidatesPage();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        if (buttonText.equalsIgnoreCase("Добавить кандидата")) {
            candidatePage.clickAddUserButton(); // формa
        } else if (buttonText.equalsIgnoreCase("Добавить кандидата подтверждение")) {
            candidatePage.clickCreateButton(); // сабмит
        } else {
            throw new IllegalArgumentException("Unknown button: " + buttonText);
        }
    }

    @When("I enter candidate email {string}")
    public void iEnterCandidateEmail(String email) {
        candidatePage.fillEmail(email);
    }

    @When("I enter candidate full name {string}")
    public void iEnterCandidateFullName(String fullName) {
        candidatePage.fillFullName(fullName);
    }

    @When("I enter candidate position {string}")
    public void iEnterCandidatePosition(String position) {
        candidatePage.fillPosition(position);
    }


}
