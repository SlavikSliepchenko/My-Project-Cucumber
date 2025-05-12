package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.TestContext;

import static utils.ConfigurationReader.get;

public class NavigateToTestsPageSteps {
    private final TestContext context;
    private SkillMainPage loginPage;
    private DashboardPage dashboardPage;

    public NavigateToTestsPageSteps(TestContext context) {
        this.context = context;
    }

    @When("I log in and open the Tests section")
    public void iLogInAndOpenTestsSection() {
        context.driver.get(get("url"));
        loginPage = new SkillMainPage(context);
        dashboardPage = loginPage.login();
        dashboardPage.openTestsSection();
    }

    @Then("I should be redirected to the Tests page")
    public void iShouldBeRedirectedToTestsPage() {
        String currentUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue("Expected URL to contain '/dashboard/tests'", currentUrl.contains("/dashboard/tests"));
    }
}
