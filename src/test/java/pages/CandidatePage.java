package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;

public class CandidatePage {
    private final TestContext context;


    public CandidatePage(TestContext context) {
        this.context = context;
    }

    public String getEmail() {
        By emailLocator = By.xpath("//p[contains(text(), '@')]");
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        return context.driver.findElement(emailLocator).getText();
    }

    public String getPosition() {
        return context.driver.findElement(
                By.xpath("//span[text()='Должность']/parent::div/following-sibling::p")
        ).getText();
    }
}