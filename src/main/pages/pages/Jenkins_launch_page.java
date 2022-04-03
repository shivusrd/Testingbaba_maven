package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Jenkins_launch_page extends Baselibrary


{

	public Jenkins_launch_page()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='Submit']")
	private WebElement login;
	
	@FindBy(xpath="//input[@id='j_username']")
	private WebElement user;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pass;
	
	@FindBy(xpath="//a[normalize-space()='RestAssured_demo']")
	private WebElement restassured;
	
	
	@FindBy(xpath="//span[contains(text(),'Build Now')]")
	private WebElement build;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void Launch_Jenkins() throws InterruptedException
	
	{
		user.sendKeys("admin");
		pass.sendKeys("58e7a2423b5046a991edc674821683d9");
		login.click();
		Thread.sleep(5000);
		restassured.click();
		build.click();
	}


}
