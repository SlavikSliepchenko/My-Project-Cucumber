package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.DashboardPage;
import utils.TestContext;

import static org.junit.Assert.assertTrue;

public class CandidateVisibilityTestSteps {

    private final TestContext context = new TestContext();
    private final DashboardPage dashboardPage = new DashboardPage(context);

    @Then("I should see candidate {string} in the list")
    public void iShouldSeeCandidateInTheList(String fullName) {
        assertTrue("Кандидат '" + fullName + "' не найден.",
                dashboardPage.isCandidatePresent(fullName));
    }
}

