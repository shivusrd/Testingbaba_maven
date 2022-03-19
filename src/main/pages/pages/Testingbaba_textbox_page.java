package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.asserts.SoftAssert;

import baselibrary.Baselibrary;

import propertyutility.PropertyUtility;

public class Testingbaba_textbox_page extends Baselibrary

{
	ArrayList<String> li = null;

	public Testingbaba_textbox_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;

	@FindBy(xpath = "//*[text()='text box']")
	private WebElement textbox;

	@FindBy(xpath = "//*[@id=\"fullname1\"]")
	private WebElement fullname;

	@FindBy(xpath = "//*[@id=\"fullemail1\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"fulladdresh1\"]")
	private WebElement fulladress;

	@FindBy(xpath = "//*[@id=\"paddresh1\"]")
	private WebElement permanentadress;

	@FindBy(xpath = "//*[@id=\"tab_1\"]/div/div[1]/form/input[3]")
	private WebElement submit;

	@FindBy(xpath = "//*[@class=\"col-md-6 mt-5\"]/label")
	private List<WebElement> textboxtabledata;

	public void gettitle() throws Exception 
	{
		String title = driver.getTitle();
		System.out.println(title);

	}

	public void closebtn() {

		closebtn.click();
		practiceform.click();
	}

	public void clickonelements()

	{

		elements.click();
	}

	public void filldetails() 

	{
		
		String name = PropertyUtility.getreadproperty("name");
		String Email = PropertyUtility.getreadproperty("email");
		String cadress = PropertyUtility.getreadproperty("currentadress");
		String padress = PropertyUtility.getreadproperty("permanentadress");

		

		li = new ArrayList<String>();

		li.add(name);
		li.add(Email);
		li.add(cadress);
		li.add(padress);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		textbox.click();
		fullname.sendKeys(name);
		email.sendKeys(Email);
		
		fulladress.sendKeys(cadress);
		permanentadress.sendKeys(padress);
		assertEquals(submit.isDisplayed(),true);
		submit.click();

	}

	public void getverify_textboxdata() 
	
	{
		SoftAssert softassert = new SoftAssert();
		for (int j = 1; j <= 7; j++) {
			for (String dd : li) {
				String actualdata = textboxtabledata.get(j).getText();
				softassert.assertEquals(actualdata, dd);
				// Assert.assertEquals(actualdata,dd);
				j++;
				li.remove(0);
				break;
			}
		}

		softassert.assertAll();

	}

}
