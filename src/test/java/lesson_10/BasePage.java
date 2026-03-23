package lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        Duration delay = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, delay);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public void setInputText(By locator, String text) {
        waitForElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        waitForElement(locator).click();
    }

    public String getAttribute(By locator, String attribute) {
        return waitForElement(locator).getAttribute(attribute);
    }
}
