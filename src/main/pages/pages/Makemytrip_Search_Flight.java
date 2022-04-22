package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Makemytrip_Search_Flight extends Baselibrary

{
	public Makemytrip_Search_Flight() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closebtn;

	@FindBy(css = ".makeFlex.hrtlCenter.font10.makeRelative.lhUser.userLoggedOut")
	private WebElement login3;

	@FindBy(xpath = "//a[contains(@href,'www.makemytrip.com/flights')]/span[contains(@class,'chFlights')]")
	WebElement flightsMenu;

	@FindBy(xpath = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	private WebElement chooseplace;

	@FindBy(xpath = "//button[@id='hsw_search_button']")
	private WebElement searchbtn;

	@FindBy(xpath = "//span[normalize-space()='City / Hotel / Area / Building']")
	private WebElement from;

	@FindBy(xpath = "//span[normalize-space()='DEPARTURE']")
	WebElement departureDrop;

	@FindBy(xpath = "//span[normalize-space()='RETURN']")
	WebElement returnDrop;

	String departureDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	String returnDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";

	@FindBy(xpath = "//a[contains(@class,'widgetSearchBtn') and text()='Search']")
	WebElement searchBtnn;

	public void ClickOnFlight() throws InterruptedException {

		closebtn.click();
		login3.click();
		flightsMenu.click();

	}

	public void enterDepartureDate() throws InterruptedException {

		departureDrop.click();
		Thread.sleep(2000);

		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		Thread.sleep(2000);
		driver.findElement(Applicationutility.customXpath(departureDate, date.departureDate)).click();
		Thread.sleep(2000);
	}

	public void enterReturnDate() throws InterruptedException {

		returnDrop.click();
		Thread.sleep(2000);
		Applicationutility date = Applicationutility.getCurrentAndReturnDates();
		Thread.sleep(2000);
		driver.findElement(Applicationutility.customXpath(returnDate, date.returnDate)).click();
		Thread.sleep(2000);
	}

	public void clicksearch() {
		searchBtnn.click();
		driver.manage().deleteAllCookies();

	}

}
