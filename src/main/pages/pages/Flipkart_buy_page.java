package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Log;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;
import waitutility.Waitutility;

public class Flipkart_buy_page extends Baselibrary

{

	private static final Logger logger = LogManager.getLogger(Flipkart_buy_page.class);
	private static final String NEW_FIRST_NAME = "shivam";

	@FindBy(xpath = "//*[@class=\"_1_3w1N\"][text()='Login']")
	private WebElement loginpage;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement email;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	private WebElement password;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	private WebElement login;

	@FindBy(xpath = "//div[@class='exehdJ'][normalize-space()='shivam']")
	private WebElement hover;

	@FindBy(xpath = "//div[normalize-space()='My Profile']")
	private WebElement myprofile;

	@FindBy(xpath = "//span[@class='oKZoMV']")
	private WebElement button;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstname;

	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	private WebElement save;

	@FindBy(xpath = "//div[@class='_3c8nMP']//div[1]//div[1]//div[1]//a[1]")
	private WebElement male;

	@FindBy(xpath = "//span[@class='oKZoMV']")
	private WebElement button2;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailupdate;

	@FindBy(xpath = "//button[@class='_2KpZ6l _25vsmg _1-iOO7']")
	private WebElement save2;

	public Flipkart_buy_page() {
		PageFactory.initElements(driver, this);
	}

	public void loginToFlipkart() {
		try {
			
			logger.info("Navigating to login page");
			Applicationutility.clickme(loginpage);
			
			logger.info("Entering username: " + PropertyUtility.getreadproperty("user"));
			email.sendKeys(PropertyUtility.getreadproperty("user"));

			logger.info("Entering password: " + PropertyUtility.getreadproperty("password"));
			password.sendKeys(PropertyUtility.getreadproperty("password"));

			logger.info("Clicking on login button");
			login.click();

			Waitutility.visibilityOfElement(10, hover);

			logger.info("Login successful");
		} catch (Exception e) {
			logger.error("Login failed: " + e.getMessage());
			throw new RuntimeException("Login failed", e);
		}
	}

	public void changeFirstNameInProfile() {
		try {
			logger.info("Navigating to Flipkart profile");
			Applicationutility.mousehover(hover);
			myprofile.click();

			Waitutility.visibilityOfElement(10,button2);

			driver.navigate().refresh();
			assertTrue(button2.isDisplayed(), "Profile page loaded successfully");

			button.click();

			firstname.clear();
			logger.info("Entering first name: " + NEW_FIRST_NAME);
			firstname.sendKeys(NEW_FIRST_NAME);

			logger.info("Clicking on save button");
			save.click();

			logger.info("First name change successful");
		} catch (Exception e) {
			logger.error("First name change failed: " + e.getMessage());
			throw new RuntimeException("First name change failed", e);
		}
	}

}
