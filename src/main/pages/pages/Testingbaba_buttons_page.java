package pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_buttons_page extends Baselibrary

{
    public Testingbaba_buttons_page()
	
	{
		PageFactory.initElements(driver, this);

	}
	
    @FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;
	
	@FindBy(xpath = "//*[text()='buttons']")
	private WebElement buttons;
	
	@FindBy(xpath = "//*[@id=\"tab_5\"]/div[1]/button")
	private WebElement doubleclick;
	
	@FindBy(xpath = "//button[@id='noContextMenu']")
	private WebElement rightclick;
	
	
	
	
	
	public void closebtn() 
	{

		Applicationutility.clickme(closebtn);
		practiceform.click();
	}

	public void clickonelements()

	{
		assertEquals(elements.isDisplayed(),true);
		Applicationutility.clickme(elements);

	}
	
	public void clickbuttn()
	{   
		Applicationutility.clickme(buttons);
	    
	}	
	
	public void doubleclick()
	{
		Applicationutility.doubleclick(doubleclick);
		Applicationutility.rightclick(rightclick);
		
	}
	
}
