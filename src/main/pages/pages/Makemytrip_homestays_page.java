package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Makemytrip_homestays_page extends Baselibrary


{


	public  Makemytrip_homestays_page() 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closebtn;
	
	@FindBy(css = ".makeFlex.hrtlCenter.font10.makeRelative.lhUser.userLoggedOut")
	private WebElement login3;
	
	@FindBy(xpath ="(//*[@class=\"false chNavText darkGreyText\"])[3]")
	WebElement homestay;
	
	
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
	
	@FindBy(xpath = "//input[@id='checkin']")
	private WebElement checkin;
	
	@FindBy(xpath = "//input[@id='checkout']")
	private WebElement checkout;
	
	@FindBy(xpath="//input[@id='checkin']")
	WebElement departureDrop;
	
	@FindBy(xpath="//input[@id='checkout']")
	WebElement returnDrop;
	
	String departureDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	String returnDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	
	@FindBy(xpath="//button[@id='hsw_search_button']")
	WebElement searchBtnn;
	
	
	
	public void ClickOnHomestay() throws InterruptedException 
	{
		
		closebtn.click();
		login3.click();
		homestay.click();

		
	}
	
	public void enterDepartureDate() throws InterruptedException {
		departureDrop.click();
	
		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		driver.findElement(Applicationutility.customXpath(departureDate,date.departureDate)).click();
	}
	
	public void enterReturnDate() {
		returnDrop.click();
		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		driver.findElement(Applicationutility.customXpath(returnDate, date.returnDate)).click();
	}

	
	
	public void  clicksearch () {
		searchBtnn.click();
		driver.manage().deleteAllCookies();
		
	}
	
	


}
