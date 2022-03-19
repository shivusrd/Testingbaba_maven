package pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_links_page extends Baselibrary

{
   public Testingbaba_links_page()
   {
	   PageFactory.initElements(driver,this);
   }

    @FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;
	
	@FindBy(xpath = "//a[contains(text(),'links')]")
	private WebElement links;

	@FindBy(xpath = "//a[contains(text(),'Demo Page')]")
	private WebElement demopage;

	
	
	public void closebtn() 
	{
		
		closebtn.click();
		practiceform.click();
	}

	public void clickonelements()

	{
		
		elements.click();

	}
	
	public void clickonlinks() throws InterruptedException
	{
		Thread.sleep(1000);
		assertEquals(links.isDisplayed(),true);
		links.click();
		Thread.sleep(1000);
		demopage.click();
		Applicationutility.changewindow(0);
		
	}



}
