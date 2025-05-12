package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;
import utils.TestContext;

public class SkillMainPage {
    private final TestContext context;

    private final By emailInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[contains(text(), 'Войти в систему')]");

    public SkillMainPage(TestContext context) {
        this.context = context;
    }

    public void emailInput(String email) {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        context.driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        context.driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        context.driver.findElement(loginButton).click();
    }

    public DashboardPage login() {
        emailInput(ConfigurationReader.get("userEmail"));
        enterPassword(ConfigurationReader.get("userPassword"));
        clickLoginButton();

        context.wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new DashboardPage(context);
    }
}
