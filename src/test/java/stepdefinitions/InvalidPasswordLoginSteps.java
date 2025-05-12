package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SkillMainPage;
import utils.ConfigurationReader;
import utils.TestContext;

import static org.junit.Assert.assertTrue;

public class InvalidPasswordLoginSteps {

    private final TestContext context;
    private SkillMainPage loginPage;

    public InvalidPasswordLoginSteps(TestContext context) {
        this.context = context;
        this.loginPage = new SkillMainPage(context);
    }

    @When("I submit the login form with wrong password")
    public void iSubmitLoginWithWrongPassword() {
        loginPage.emailInput(ConfigurationReader.get("userEmail"));
        loginPage.enterPassword(ConfigurationReader.get("wrongPassword"));
        loginPage.clickLoginButton();
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        WebElement errorHeader = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'font-semibold') and text()='" + expectedMessage + "']")
        ));
        assertTrue("Ожидалось сообщение об ошибке: " + expectedMessage, errorHeader.isDisplayed());
    }
}