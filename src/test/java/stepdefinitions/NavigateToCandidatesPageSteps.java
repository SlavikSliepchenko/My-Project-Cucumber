package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.TestContext;

import static utils.ConfigurationReader.get;

public class NavigateToCandidatesPageSteps {
    private final TestContext context;
    private DashboardPage dashboardPage;

    public NavigateToCandidatesPageSteps(TestContext context) {
        this.context = context;
    }

    @When("I log in and open the Candidates section")
    public void iLogInAndOpenCandidatesSection() {
        context.driver.get(get("url"));
        SkillMainPage loginPage = new SkillMainPage(context);
        dashboardPage = loginPage.login();
        dashboardPage.openCandidatesSection();
    }

    @Then("I should be redirected to the Candidates page")
    public void iShouldBeRedirectedToCandidatesPage() {
        String currentUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue("Expected URL to contain '/dashboard/candidates'", currentUrl.contains("/dashboard/candidates"));
    }
}