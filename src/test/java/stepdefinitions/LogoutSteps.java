package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DashboardPage;
import pages.SkillMainPage;
import utils.TestContext;

import static org.junit.Assert.assertTrue;

public class LogoutSteps {

    private final TestContext context;
    private DashboardPage dashboardPage;

    public LogoutSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAdmin() {
        SkillMainPage loginPage = new SkillMainPage(context);
        context.driver.get("https://skillchecker.tech/");
        dashboardPage = loginPage.login();
    }

    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        dashboardPage.logout();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToLoginPage() {
        By logoutNotification = By.xpath("//*[contains(text(), 'Выход выполнен') or contains(text(), 'Вы вышли из системы')]");
        WebElement message = context.wait.until(ExpectedConditions.visibilityOfElementLocated(logoutNotification));
        assertTrue("Ожидалось уведомление о выходе", message.isDisplayed());
    }
}