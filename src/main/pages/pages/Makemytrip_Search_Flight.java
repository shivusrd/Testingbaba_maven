package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Makemytrip_Search_Flight extends Baselibrary


{
	public  Makemytrip_Search_Flight() 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closebtn;
	
	@FindBy(css = ".makeFlex.hrtlCenter.font10.makeRelative.lhUser.userLoggedOut")
	private WebElement login3;
	
	@FindBy(xpath="//a[contains(@href,'www.makemytrip.com/flights')]/span[contains(@class,'chFlights')]")
	WebElement flightsMenu;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	private WebElement chooseplace;
	
	@FindBy(xpath="//button[@id='hsw_search_button']")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//div[@aria-label='Sat Mar 26 2022']")
	private WebElement choosedate;
	
	@FindBy(xpath = "//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--disabled']")
	private WebElement checkoutdate;
	@FindBy(xpath = "//span[normalize-space()='City / Hotel / Area / Building']")
	private WebElement from;
	
	@FindBy(xpath = "//div[@aria-label='Thu Mar 24 2022']")
	private WebElement checkin;
	
	@FindBy(xpath = "//div[@aria-label='Fri Mar 25 2022']")
	private WebElement checkout;
	
	@FindBy(xpath="//span[normalize-space()='DEPARTURE']")
	WebElement departureDrop;
	
	@FindBy(xpath="//span[normalize-space()='RETURN']")
	WebElement returnDrop;
	
	String departureDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	String returnDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	
	@FindBy(xpath="//a[contains(@class,'widgetSearchBtn') and text()='Search']")
	WebElement searchBtnn;
	

	public void ClickOnFlight() throws InterruptedException 
	{
		
		closebtn.click();
		login3.click();
		flightsMenu.click();

		
	}
	
	public void enterDepartureDate() throws InterruptedException {
		
		Thread.sleep(2000);
		departureDrop.click();
	
		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		driver.findElement(Applicationutility.customXpath(departureDate,date.departureDate)).click();
	}
	
	public void enterReturnDate() throws InterruptedException {
		Thread.sleep(2000);		
		returnDrop.click();
		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		driver.findElement(Applicationutility.customXpath(returnDate, date.returnDate)).click();
	}

	
	
	public void  clicksearch () {
		searchBtnn.click();
		driver.manage().deleteAllCookies();
		
	}



}
