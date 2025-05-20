package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContext;

public class CandidatePage {
    private final TestContext context;

    private final By emailInput = By.name("email");
    private final By fullNameInput = By.name("fullName");
    private final By positionInput = By.name("position");

    private final By openAddCandidateFormButton = By.xpath("//button[.//span[contains(text(),'Добавить кандидата')]]");
    private final By submitCandidateButton = By.xpath("//button[@type='submit' and contains(.,'Добавить кандидата') and not(@disabled)]");

    public CandidatePage(TestContext context) {
        this.context = context;
    }

    public void openCandidatesPage() {
        context.driver.get(context.getUrl() + "/dashboard/candidates");
    }

    public void clickAddUserButton() {
        try {
            System.out.println("Ожидаем кнопку открытия формы...");
            context.wait.until(ExpectedConditions.elementToBeClickable(openAddCandidateFormButton));
            context.driver.findElement(openAddCandidateFormButton).click();
            System.out.println("Кнопка для открытия формы нажата.");
        } catch (TimeoutException e) {
            System.out.println("Кнопка не найдена или неактивна: " + e.getMessage());
            throw e;
        }
    }

    public void fillEmail(String email) {
        context.driver.findElement(emailInput).sendKeys(email);
    }

    public void fillFullName(String fullName) {
        context.driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void fillPosition(String position) {
        context.driver.findElement(positionInput).sendKeys(position);
    }

    public void clickCreateButton() {
        try {
            System.out.println(" кнопкa 'Добавить кандидата' во всплывающем меню...");
            context.wait.until(ExpectedConditions.elementToBeClickable(submitCandidateButton));

            boolean isEnabled = context.driver.findElement(submitCandidateButton).isEnabled();
            System.out.println("isEnabled: " + isEnabled);

            context.driver.findElement(submitCandidateButton).click();
            System.out.println("Клик по кнопке");
        } catch (TimeoutException e) {
            System.out.println("Кнопки нет " + e.getMessage());
            throw e;
        }
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

