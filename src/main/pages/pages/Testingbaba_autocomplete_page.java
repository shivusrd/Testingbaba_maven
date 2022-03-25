package pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_autocomplete_page extends Baselibrary

{
	public Testingbaba_autocomplete_page() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/h2[1]/button[1]")
	private WebElement widgets;

	@FindBy(xpath = "//*[text()='auto complete']")
	private WebElement autocompletebutton;

	@FindBy(xpath = "//*[@id=\"myInput\"]")
	private WebElement filldata;

	@FindBy(xpath = "//*[@id=\"tab_17\"]/div/iframe")
	private WebElement frame;
	
	

	public void closebtn() 
	{

		closebtn.click();
		Applicationutility.clickme(practiceform);
		
		
	}

	public void clicauto() throws InterruptedException

	{   
		assertEquals(widgets.isDisplayed(),true);
		widgets.click();
      
		
	}
	
	public void autocomplete() throws InterruptedException
	{    Thread.sleep(1000);
		 autocompletebutton.click();
		
	}

	public void select() throws InterruptedException 
	{
		
		
		
		
		driver.switchTo().frame(frame);
		filldata.click();
		filldata.sendKeys("ind");
		filldata.sendKeys(Keys.ARROW_DOWN);
		filldata.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

	}

}
