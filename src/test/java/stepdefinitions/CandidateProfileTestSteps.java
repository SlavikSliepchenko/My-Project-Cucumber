package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CandidatePage;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.ConfigurationReader;
import utils.TestContext;

import static org.junit.Assert.assertEquals;

public class CandidateProfileTestSteps {

    private final TestContext context = new TestContext();
    private DashboardPage dashboardPage;
    private CandidatePage candidatePage;

    @Given("I am logged in as admin")
    public void iAmLoggedInAsAdmin() {
        context.driver.get(ConfigurationReader.get("url"));
        SkillMainPage loginPage = new SkillMainPage(context);
        dashboardPage = loginPage.login(); // выполняется логин
    }

    @When("I open the Candidates section")
    public void iOpenCandidatesSection() {
        dashboardPage.openCandidatesSection();
    }

    @When("I click on candidate {string}")
    public void iClickOnCandidate(String fullName) {
        dashboardPage.clickCandidateByName(fullName);
        candidatePage = new CandidatePage(context);
    }

    @Then("I should see candidate email {string}")
    public void iShouldSeeCandidateEmail(String expectedEmail) {

        assertEquals(expectedEmail, candidatePage.getEmail());
    }

    @Then("I should see candidate position {string}")
    public void iShouldSeeCandidatePosition(String expectedPosition) {

        assertEquals(expectedPosition, candidatePage.getPosition());
    }

    public static class Hooks {

        private final TestContext context;

        public Hooks(TestContext context) {
            this.context = context;
        }

        @Before
        public void setUp() {

        }

        @After
        public void tearDown() {
            context.cleanUp();
        }
    }
}
