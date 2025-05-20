package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;


public class DashboardPage {

    private final TestContext context;

    private final By logoutButton = By.xpath("//button[.//span[text()='Выйти']]");
    private final By header = By.xpath("//h1[contains(text(), 'Панель управления')]");
    private final By testsSectionButton = By.xpath("//div[contains(text(), 'Тесты')]");
    private final By candidatesSectionButton = By.xpath("//div[contains(text(), 'Кандидаты')]");
    private final By settingsSectionButton = By.xpath("//div[contains(text(), 'Настройки')]");

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

    public void clickCandidateByName(String fullName) {
        By candidateLink = By.xpath("//a[text()='" + fullName + "']");
        context.wait.until(ExpectedConditions.elementToBeClickable(candidateLink)).click();
    }

    public boolean isCandidatePresent(String fullName) {
        try {
            String xpath = "//a[contains(@href, '/dashboard/candidates') and contains(normalize-space(.), \"" + fullName + "\")]";
            WebElement element = context.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
