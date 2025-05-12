package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.TestContext;

import static utils.ConfigurationReader.get;

public class NavigateToSettingsPageSteps {
    private final TestContext context;
    private SkillMainPage loginPage;
    private DashboardPage dashboardPage;

    public NavigateToSettingsPageSteps(TestContext context) {
        this.context = context;
    }

    @When("I log in and open the Settings section")
    public void iLogInAndOpenSettingsSection() {
        context.driver.get(get("url"));
        loginPage = new SkillMainPage(context);
        dashboardPage = loginPage.login();
        dashboardPage.openSettingsSection();
    }

    @Then("I should be redirected to the Settings page")
    public void iShouldBeRedirectedToSettingsPage() {
        String currentUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue("Expected URL to contain '/dashboard/settings'", currentUrl.contains("/dashboard/settings"));
    }
}