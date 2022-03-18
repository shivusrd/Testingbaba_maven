package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;

public class Flipkart_buy_page extends Baselibrary

{

	public Flipkart_buy_page()

	{
		PageFactory.initElements(driver, this);

	}

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
	
	
	
	
	
	
	

	public void login() throws InterruptedException

	{
		email.sendKeys(PropertyUtility.getreadproperty("user"));
		password.sendKeys(PropertyUtility.getreadproperty("password"));
		login.click();
		Thread.sleep(2000);
		
	}

	public void Namechange() throws InterruptedException {
		Thread.sleep(3000);
		Applicationutility.mousehover(hover);
		Thread.sleep(3000);
		myprofile.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		button.click();
		Thread.sleep(3000);
		
		firstname.clear();
		firstname.sendKeys("shivam");
		Thread.sleep(3000);
		save.click();
		Thread.sleep(3000);

	}
	
	

}
