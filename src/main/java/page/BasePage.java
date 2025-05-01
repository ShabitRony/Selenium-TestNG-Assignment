package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(10);
    public static WebDriver driver;
    public final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickBtn(WebElement element) {
        waitUntilElementClickable(element);
        driver.findElement((By) element).click();
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilElementVisible(element);
        driver.findElement((By) element).sendKeys(text);
    }

    public String getText(WebElement element) {
        waitUntilElementVisible(element);
        return driver.findElement((By) element).getText();
    }

    public WebElement getElement(WebElement element) {
        waitUntilElementVisible(element);
        return driver.findElement((By) element);
    }
}
