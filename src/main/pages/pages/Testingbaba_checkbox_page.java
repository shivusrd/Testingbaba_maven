package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;

public class Testingbaba_checkbox_page extends Baselibrary

{
	public Testingbaba_checkbox_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;

	@FindBy(xpath = "//*[text()='check box']")
	private WebElement checkbox;

	@FindBy(xpath = "//*[@id=\"tab_2\"]/div/iframe")
	private WebElement checkbox_frame;

	@FindBy(xpath = "//*[@onclick=\"myFunction()\"]")
	private WebElement mobile;

	@FindBy(xpath = "//*[@id=\"mylaptop\"]")
	private WebElement laptop;
	
	@FindBy (xpath= "//*[@style=\"display: block;\"]")
	private List <WebElement> checkboxtext;

	public void closebtn() {

		closebtn.click();
		practiceform.click();
	}

	public void clickonelements()

	{

		elements.click();

	}

	public void checkbox() throws InterruptedException
	{
		Thread.sleep(2000);
		assertEquals(checkbox.isDisplayed(),true);
		Thread.sleep(2000);
		checkbox.click();

	}

	public void mobilecheckbox() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(1000);
		driver.switchTo().frame(checkbox_frame);
		Thread.sleep(2000);

		Applicationutility.clickme(mobile);
		Thread.sleep(2000);
		Applicationutility.clickme(laptop);
		String actual1 = checkboxtext.get(0).getText();
		String actual2 = checkboxtext.get(1).getText();
		String excpected1 = PropertyUtility.getreadproperty("mobile");
		String excpected2 = PropertyUtility.getreadproperty("laptop");
		System.out.println(actual1);
		System.out.println(actual2);
		
		softassert.assertEquals(actual1, excpected1);
		softassert.assertEquals(actual2, excpected2);
		
		driver.switchTo().defaultContent();
		softassert.assertAll();
	}

}
