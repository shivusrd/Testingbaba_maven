package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;
import waitutility.Waitutility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bikewale_page extends Baselibrary {

	private static final Logger logger = LogManager.getLogger(Bikewale_page.class);

	@FindBy(xpath = "//a[@href='/login/']")
	private WebElement loginlink;

	@FindBy(xpath = "//input[@id='txtLoginid']")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@id='txtPasswd']")
	private WebElement passwordfield;

	@FindBy(xpath = "//button[@id='btnLogin']")
	private WebElement loginbutton;

	@FindBy(xpath = "//div[@class='o-C']//input[@placeholder=\"Search\"]")
	private WebElement searchButton;

	public Bikewale_page() {
		PageFactory.initElements(driver, this);
	}

	public void loginToBikewale() {
		try {

			logger.info("Clicking on login link.");
			test.log(Status.INFO, "Clicking on login link." + loginlink);
			Waitutility.visibilityOfElement(10, loginlink); // Increased wait time
			Applicationutility.clickme(loginlink);

			logger.info("Entering email.");
			test.log(Status.INFO, "Dismiss Alert"); // Log to Extent Report
			test.log(Status.INFO, "Entering email." + emailfield); // Log to Extent Report
			Waitutility.visibilityOfElement(10, emailfield); // Increased wait time
			emailfield.sendKeys(PropertyUtility.getreadproperty("email"));

			logger.info("Entering password.");
			test.log(Status.INFO, "Entering password." + passwordfield); // Log to ExtentReport
			Waitutility.visibilityOfElement(10, passwordfield); // Increased wait time
			passwordfield.sendKeys(PropertyUtility.getreadproperty("password"));

			logger.info("Clicking on login button.");
			test.log(Status.INFO, "Clicking on login button." + loginbutton); // Log to Extent Report
			Waitutility.visibilityOfElement(10, loginbutton); // Use clickable wait
			Applicationutility.clickme(loginbutton);

			// Add assertion to check login success
			logger.info("Verifying login success.");
			test.log(Status.INFO, "Verifying login success." + searchButton); // Log to Extent Report
			Waitutility.visibilityOfElement(10, searchButton); // Use clickable wait
			Assert.assertTrue(searchButton.isDisplayed(), "Login failed. User profile element not found.");
			logger.info("Login successful.");

		} catch (Exception e) {
			logger.error("Login failed: " + e.getMessage(), e); // Log stack trace
			test.log(Status.FAIL, "Login failed: " + e.getMessage()); // Log to ExtentReport
			Assert.fail("Login failed: " + e.getMessage()); // Fail the test with the error
			throw new RuntimeException("Login failed", e);
		}
	}

}
