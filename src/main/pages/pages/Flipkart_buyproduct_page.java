package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;
import waitutility.Waitutility;

public class Flipkart_buyproduct_page extends Baselibrary

{
	private static final Logger logger = LogManager.getLogger(Flipkart_buyproduct_page.class);
	private static final String PRODUCT_TO_SEARCH = "iphone";

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement email;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	private WebElement password;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	private WebElement login;

	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	private WebElement search;

	@FindBy(xpath = "//a[@title='Pintola All Natural Export Peanut Butter (Creamy) 1 kg']")
	private WebElement iphone;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocart;

	public Flipkart_buyproduct_page() {
		PageFactory.initElements(driver, this);
	}

	public void loginAndSearchProduct() {
        try {
            logger.info("Entering username: " + PropertyUtility.getreadproperty("user"));
            email.sendKeys(PropertyUtility.getreadproperty("user"));

            logger.info("Entering password: " + PropertyUtility.getreadproperty("password"));
            password.sendKeys(PropertyUtility.getreadproperty("password"));

            logger.info("Clicking on login button");
            login.click();

           Waitutility.visibilityOfElement(10, search);

            logger.info("Searching for product: " + PRODUCT_TO_SEARCH);
            search.sendKeys(PRODUCT_TO_SEARCH, Keys.ENTER);

           Waitutility.visibilityOfElement(10, iphone);

            logger.info("Navigating back");
            driver.navigate().back();

            String title = driver.getTitle();
            logger.info("Page title: " + title);

            assertTrue(title.contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"), "Title verification failed");
        } catch (Exception e) {
            logger.error("Login and search failed: " + e.getMessage());
            throw new RuntimeException("Login and search failed", e);
        }
    }

}
