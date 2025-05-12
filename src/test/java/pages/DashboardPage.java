package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;

public class DashboardPage {
    private final TestContext context;

    private final By header = By.cssSelector(" main h1");

    public DashboardPage(TestContext context) {
        this.context = context;
    }

    public String getHeaderText() {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return context.driver.findElement(header).getText();
    }
}