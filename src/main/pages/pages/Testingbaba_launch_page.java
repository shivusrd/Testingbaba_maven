package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_launch_page extends Baselibrary
{
	
	
	public Testingbaba_launch_page()
	{
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath= "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
	
	
	
	private WebElement practiceform;
	
	@FindBy(xpath="//*[@class=\"form-control submit\"][@value=\"Subscribe\"]")
	private WebElement scroll;
	
	public void gettitle() 
	{
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	public void closebtn() throws InterruptedException
	{
		closebtn.click();
		assertEquals(practiceform.isDisplayed(),true);
		Thread.sleep(2000);
		practiceform.click();
		Applicationutility.getscroll(scroll);
	}
}

