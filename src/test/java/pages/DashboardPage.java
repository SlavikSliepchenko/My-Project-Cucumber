package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;

public class DashboardPage {

    private final TestContext context;

    private final By logoutButton = By.xpath("//button[.//span[text()='Выйти']]");
    private final By header = By.xpath("//h1[contains(text(), 'Панель управления')]");
    private final By testsSectionButton = By.xpath("//a[@href='/dashboard/tests']//div[contains(text(), 'Тесты')]");
    private final By candidatesSectionButton = By.xpath("//a[@href='/dashboard/candidates']//div[contains(text(), 'Кандидаты')]");
    private final By settingsSectionButton = By.xpath("//a[@href='/dashboard/settings']//div[contains(text(), 'Настройки')]");

    public DashboardPage(TestContext context) {
        this.context = context;
    }

    public String getHeaderText() {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return context.driver.findElement(header).getText();
    }

    public void logout() {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        context.driver.findElement(logoutButton).click();
    }

    public void openTestsSection() {
        context.wait.until(ExpectedConditions.elementToBeClickable(testsSectionButton));
        context.driver.findElement(testsSectionButton).click();
    }

    public String getCurrentUrl() {
        return context.driver.getCurrentUrl();
    }

    public void openCandidatesSection() {
        context.wait.until(ExpectedConditions.elementToBeClickable(candidatesSectionButton));
        context.driver.findElement(candidatesSectionButton).click();
    }

    public void openSettingsSection() {
        context.wait.until(ExpectedConditions.elementToBeClickable(settingsSectionButton));
        context.driver.findElement(settingsSectionButton).click();
    }
}
