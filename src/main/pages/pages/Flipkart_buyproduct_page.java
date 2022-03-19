package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;

public class Flipkart_buyproduct_page extends Baselibrary

{
	public Flipkart_buyproduct_page()

	{
		PageFactory.initElements(driver, this);

	}

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

	public void login() throws InterruptedException

	{
		email.sendKeys(PropertyUtility.getreadproperty("user"));
		password.sendKeys(PropertyUtility.getreadproperty("password"));
		login.click();
		assertEquals(search.isDisplayed(),true);
		search.sendKeys("iphone", Keys.ENTER);
		Thread.sleep(2000);
		
		driver.navigate().back();

		String title = driver.getTitle();
		System.out.println(title);

	}

}
