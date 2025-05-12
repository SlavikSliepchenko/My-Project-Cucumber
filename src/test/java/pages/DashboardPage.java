package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;

public class DashboardPage {

    private final TestContext context;

    private final By logoutButton = By.xpath("//button[.//span[text()='Выйти']]");
    private final By header = By.tagName("h1");

    public DashboardPage(TestContext context) {
        this.context = context;
    }

    public String getHeaderText() {
        return context.driver.findElement(header).getText();
    }

    public void logout() {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        context.driver.findElement(logoutButton).click();
    }
}