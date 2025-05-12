package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {
    public WebDriver driver;
    public WebDriverWait wait;

    public TestContext() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void cleanUp() {
        DriverFactory.quitDriver();
    }

}
