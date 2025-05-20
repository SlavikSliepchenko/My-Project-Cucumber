package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SkillMainPage;
import utils.TestContext;

import static org.junit.Assert.assertTrue;

public class EmptyLoginSteps {
    private final TestContext context;
    private SkillMainPage loginPage;

    public EmptyLoginSteps(TestContext context) {
        this.context = context;
        this.loginPage = new SkillMainPage(context);
    }

    @When("I submit the login form with empty fields")
    public void iSubmitEmptyLoginForm() {
        loginPage.submitEmptyLoginForm();
    }

    @Then("I should see validation messages for username and password")
    public void iShouldSeeValidationMessages() {
        WebElement usernameError = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[text()='Некорректная электронная почта']")));
        WebElement passwordError = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[text()='Пароль обязателен']")));

        assertTrue("Ожидалась ошибка под полем логина", usernameError.isDisplayed());
        assertTrue("Ожидалась ошибка под полем пароля", passwordError.isDisplayed());
    }
}