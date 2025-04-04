package applicationutility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;
import waitutility.Waitutility;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Applicationutility extends Baselibrary

{
	/**************************************
	 * Function Name: All Generic actions for Website Author: Shivam Created Date:
	 * 2019-07-10 Purpose: Insert a java variable to xpath Prerequisites: Call these
	 * methods by Classname Applicationutility Change History:
	 **************************************/

	public static String departureDate;
	public static String returnDate;

	// 1. Element Interaction Methods

	public static void clickme(WebElement ele) {
		Waitutility.visibilityOfElement(10, ele);
		ele.click();
		logger.info("Clicked element: " + ele);
	}

	public void enterText(WebElement element, String text) {
		Waitutility.visibilityOfElement(10, element);
		element.clear();
		element.sendKeys(text);
		logger.info("Entered text: " + text + " into element: " + element);
	}

	public static void clickElementJS(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		logger.info("Clicked element using JS: " + element);
	}

	public String getAttributeValue(WebElement element, String attributeName) {
		Waitutility.visibilityOfElement(10, element);
		String attributeValue = element.getAttribute(attributeName);
		logger.info("Attribute " + attributeName + " value of element " + element + " is : " + attributeValue);
		return attributeValue;
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			boolean isDisplayed = element.isDisplayed();
			logger.info("Element " + element + " is displayed: " + isDisplayed);
			return isDisplayed;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.warn("Element not found: " + element);
			return false;
		}
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		logger.info("Selected by visible text: " + text);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		logger.info("Selected by value: " + value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		logger.info("Selected by index: " + index);
	}

	public void clear(WebElement element) {
		element.clear();
		logger.info("Cleared element: " + element);
	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		logger.info("Current URL: " + currentUrl);
		return currentUrl;
	}

	public String getCurrentTitle() {
		String currentTitle = driver.getTitle();
		logger.info("Current title: " + currentTitle);
		return currentTitle;
	}

	public List<String> getAllTextFromElements(List<WebElement> elements) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			textList.add(element.getText());
		}
		logger.info("Got all text from elements: " + textList);
		return textList;
	}

	// 2. Mouse Actions

	public static void doubleclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele);
		logger.info("Double clicked element: " + ele);
	}

	public static void rightclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
		logger.info("Right clicked element: " + ele);
	}

	public static void mousehover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		logger.info("Mouse hovered over element: " + ele);
	}

	public static void mousehoverclick(WebElement ele, String linktext) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(linktext)).click();
		logger.info("Mouse hovered and clicked link: " + linktext);
	}

	// 3. Navigation and Window Handling

	public static void changewindow(int tabno) {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(set);
		driver.switchTo().window(tabs.get(tabno));
		logger.info("Switched to tab: " + tabno);
	}

	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		logger.info("Switched to frame: " + frameElement);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		logger.info("Switched to default content.");
	}

	public void switchToWindowByTitle(String title) {
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().contains(title)) {
				logger.info("Switched to window with title: " + title);
				return;
			}
		}
		driver.switchTo().window(originalWindow); // Switch back if not found
		logger.warn("Window with title: " + title + " not found.");
	}

	// 4. Scrolling

	public static void getscroll(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
			logger.info("Scrolled to element: " + ele);
		} catch (Exception e) {
			logger.error("Issue in Getscroll: " + e.getMessage());
		}
	}

	public static void scrollToBottom() throws InterruptedException {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		try {
			long currentHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());
			while (true) {
				jsDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(300);
				long newHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());
				if (currentHeight == newHeight)
					break;
				currentHeight = newHeight;
			}
			logger.info("Scrolled to bottom of page.");
		} catch (Exception e) {
			logger.error("Issue in scrollToBottom: " + e.getMessage());
		}
	}

	public static void ScrollToTop() {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		logger.info("Scrolled to top of page.");
	}

	public static void scrollToView(WebElement element) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
		logger.info("Scrolled to view element: " + element);
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
		logger.info("Scrolled to element: " + element);
	}

	// 5. File Upload

	public static void fileupload(String filename) {
		try {
			StringSelection sel = new StringSelection(filename);
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(sel, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("File uploaded: " + filename);
		} catch (Exception e) {
			logger.error("Issue in fileupload: " + e.getMessage());
		}
	}

	// 6. Date Handling

	/**************************************
	 * Function Name: getCurrentAndReturnDates Author: Shivam Created Date:
	 * 2019-07-10 Purpose: Get the current date and another date that is x(from
	 * property file) days from today Prerequisites: numeric value for x Change
	 * History: getCurrentAndReturnDates() should be called to assign the values to
	 * departureDate and returnDate
	 **************************************/
	public static Applicationutility getCurrentAndReturnDates() {
		Applicationutility date = new Applicationutility();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1); // added for test the tomorrow date.
		String[] dateArr = cal.getTime().toString().split(" ");
		Applicationutility.departureDate = dateArr[0] + " " + dateArr[1] + " " + dateArr[2] + " " + dateArr[5];
		cal.add(Calendar.DATE, Integer.parseInt(PropertyUtility.getreadproperty("NoOfdays")));
		dateArr = cal.getTime().toString().split(" ");
		Applicationutility.returnDate = dateArr[0] + " " + dateArr[1] + " " + dateArr[2] + " " + dateArr[5];
		logger.info("Departure date: " + departureDate + ", Return date: " + returnDate);
		return date;
	}

	// 7. Dynamic Xpath

	public static By customXpath(String xpath, String param) {
		String rawPath = xpath.replaceAll("%replace%", param);
		logger.info("Created custom xpath: " + rawPath);
		return By.xpath(rawPath);
	}

	// 8. Alert Handling

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
		logger.info("Alert Accepted");
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
		logger.info("Alert Dismissed");
	}

	public static String getAlertText() {
		String alertText = driver.switchTo().alert().getText();
		logger.info("Alert text: " + alertText);
		return alertText;
	}

	// 9. Relative Locators

	public WebElement findElementNear(WebElement element, By locator) {
		return driver.findElement(with(locator).near(element));
	}

	public WebElement findElementAbove(WebElement element, By locator) {
		return driver.findElement(with(locator).above(element));
	}

	public WebElement findElementBelow(WebElement element, By locator) {
		return driver.findElement(with(locator).below(element));
	}

	public WebElement findElementToLeftOf(WebElement element, By locator) {
		return driver.findElement(with(locator).toLeftOf(element));
	}

	public WebElement findElementToRightOf(WebElement element, By locator) {
		return driver.findElement(with(locator).toRightOf(element));
	}

	// 10. Shadow DOM Handling

	public WebElement getShadowRootElement(WebElement shadowHost, By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
		return shadowRoot.findElement(locator);
	}

	// 11. Full Page Screenshots

	public void captureFullPageScreenshot(String filePath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) new Augmenter().augment(driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		FileUtils.copyFile(source, destination);
		logger.info("Full page screenshot captured: " + filePath);
	}
}
