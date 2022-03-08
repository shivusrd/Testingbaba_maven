package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Makemytrip_launch_page extends Baselibrary

{

	public Makemytrip_launch_page()

	{
		PageFactory.initElements(driver, this);

	}
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
	
	@FindBy(xpath = "//button[contains(text(),'GET APP LINK')]")
	private WebElement submit;
	
	
	
	
	
	
	

	public void makemytrip_login() throws InterruptedException 
	
	
	{	Reporter rep = new Reporter();
		
		
		closebtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		Applicationutility.getscroll(applink);
		applink.sendKeys("8630597482");
		String compare = driver.getTitle();
		rep.log("adding these steps");
		rep.getClass();
		
	    System.out.println(compare);
		assertEquals(compare,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
	
	}

}
