package pages;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import log4j_demo.HelloWorld;
import propertyutility.PropertyUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Makemytrip_launch_page extends Baselibrary

{
	
	
	
	public Makemytrip_launch_page()

	{
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")
	private WebElement homepage;

	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closebtn;

	@FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")
	private WebElement popup;
	@FindBy(xpath = "//span[contains(text(),'Login with Google')]")
	private WebElement google;

	@FindBy(xpath = "//span[@class='chNavIcon appendBottom2 chSprite chBuses active']")
	private WebElement bus;

	@FindBy(xpath = "//p[normalize-space()='Login or Create Account']")
	private WebElement acount;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter Mobile number')]")
	private WebElement applink;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div[5]/div/div[1]/div/div/button")
	private WebElement submit;

	@FindBy(xpath = "//h3[@class='appDnldCnt__heading']")
	private WebElement scroll;

	@FindBy(xpath = "//p[@class='messageSentStatusText']")
	private WebElement invalid;

	public void makemytrip_login() throws InterruptedException

	{	
		
		closebtn.click();
		Thread.sleep(2000);
		
		Applicationutility.getscroll(scroll);
		
		Thread.sleep(2000);
		assertEquals(applink.isDisplayed(),true);
		applink.sendKeys(PropertyUtility.getreadproperty("number"));
		
		Applicationutility.clickme(submit);
		
		String text2 = invalid.getText();
		assertEquals(text2, "Link sent successfully to 8532015889, please check your SMS");
		System.out.println(text2);


		String compare = driver.getTitle();
		

		System.out.println(compare);
		assertEquals(compare, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");

	}

	public void makemytrip_booking() throws InterruptedException {
		homepage();
		Applicationutility.getscroll(scroll);
		
		Thread.sleep(2000);
		assertEquals(applink.isDisplayed(),true);
		applink.sendKeys("");

		Applicationutility.clickme(submit);
		String text = invalid.getText();
		assertEquals(text, "Incomplete phone number, please check");
		System.out.println(text);

		Thread.sleep(5000);

		String compare = driver.getTitle();
		

		System.out.println(compare);
		assertEquals(compare, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");

	}
	
	
}
