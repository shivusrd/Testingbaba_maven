package waitutility;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import baselibrary.Baselibrary;

public class Waitutility extends Baselibrary {

	private static WebDriverWait wait;
	private static FluentWait<WebDriver> fluentWait;
	private static final long DEFAULT_TIMEOUT = 10; // Default timeout in seconds
	private static final long DEFAULT_POLLING_INTERVAL = 1; // Default polling interval in seconds

	// Explicit Wait Methods
	public static void alertIsPresent(int timeInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void visibilityOfElement(int timeInSeconds, WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void elementIsClickable(int timeInSeconds, WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static WebElement waitForElementToBeVisible(By locator, int timeInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForElementToBeClickable(By locator, int timeInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Sets the implicit wait for the WebDriver.
	 *
	 * @param driver  The WebDriver instance.
	 * @param seconds The number of seconds to wait.
	 */
	public static void setImplicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// Fluent Wait Methods
	public static <T> T fluentWaitForCondition(Function<WebDriver, T> condition) {
		return fluentWaitForCondition(condition, DEFAULT_TIMEOUT, DEFAULT_POLLING_INTERVAL);
	}

	public static <T> T fluentWaitForCondition(Function<WebDriver, T> condition, long timeout, long pollingSeconds) {
		fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingSeconds)).ignoring(NoSuchElementException.class);

		return fluentWait.until(condition);
	}

}
