package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {
    private static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(10);
    public static WebDriver driver;
    public final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT_IN_SECONDS);
        Actions actions = new Actions(driver);
    }

    // Wait utilities
    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickability(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Element interactions
    public void click(By locator) {
        waitForClickability(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public WebElement getElement(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        waitForPresence(locator);
        return driver.findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void enterText(WebElement element, String text) {
        element.clear(); // Clear any existing text
        element.sendKeys(text); // Send new text
    }
    public String getAttribute(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }


    public void scrollIntoView(By locator) {
        WebElement element = getElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
