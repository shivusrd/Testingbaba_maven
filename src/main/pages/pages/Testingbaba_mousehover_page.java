package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_mousehover_page extends Baselibrary

{
	public Testingbaba_mousehover_page() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/h2[1]/button[1]")
	private WebElement widgets;
	
	@FindBy(xpath = "//*[text()='tool tips']")
	private WebElement tooltip;
	
	@FindBy(xpath = "//*[@id=\"tab_22\"]/button")
	private WebElement hoverme;
	
	
	
	
	
	

	public void closebtn()
	{

		closebtn.click();
		Applicationutility.clickme(practiceform);

	}

	public void clicauto() throws InterruptedException

	{
		widgets.click();
	}
	
	public  void hoverfunction() throws InterruptedException
	{
		assertEquals(tooltip.isDisplayed(),true);
		tooltip.click();
		Applicationutility.mousehover(hoverme);
		Thread.sleep(4000);
		String tooltipvalue = hoverme.getAttribute("title");
		
		System.out.println(tooltipvalue);
	}
}
