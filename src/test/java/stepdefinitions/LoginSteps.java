package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.ConfigurationReader;
import utils.TestContext;

public class LoginSteps {

    TestContext context = new TestContext();
    SkillMainPage loginPage;
    DashboardPage dashboardPage;


    @Given("I open the login page")
    public void iOpenLoginPage() {
        context.driver.get(ConfigurationReader.get("url"));
        loginPage = new SkillMainPage(context);
    }

    @When("I submit correct login credentials")
    public void iSubmitLogin() {
        dashboardPage = loginPage.login();
    }

    @Then("I should see the dashboard")
    public void iSeeDashboard() {
        String actualHeader = dashboardPage.getHeaderText();
        System.out.println("Dashboard header: " + actualHeader);
        Assert.assertEquals("Панель управления", dashboardPage.getHeaderText());
    }
}
