package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import waitutility.Waitutility;

public class TestingbabaAlerts_Frame_page extends Baselibrary

{
	public TestingbabaAlerts_Frame_page()

	{
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	

	@FindBy(xpath = "//*[@id=\"headingOne\"]/h2/button")
	private WebElement alertsframe;
	
	@FindBy(xpath = "//*[text()='alerts']")
	private WebElement alerts;
	
	
	@FindBy(xpath = "//*[@id=\"tab_12\"]/div[1]/div[2]/button")
	private WebElement clickme1;
	
	@FindBy(xpath = "//*[@id=\"tab_12\"]/div[2]/div[2]/button")
	private WebElement clickme2;
	
	@FindBy(xpath = "//*[@id=\"tab_12\"]/div[3]/div[2]/button")
	private WebElement clickme3;
	
	@FindBy(xpath = "//*[@id=\"tab_12\"]/div[4]/div[2]/button")
	private WebElement clickme4;
	
	

	public void closebtn() 
	{

		closebtn.click();
		practiceform.click();
	}

	
	public void alerts()
	
	{
		alertsframe.click();
		assertEquals(alerts.isDisplayed(),true);
		alerts.click();
	}
	
	public void clickme1()
	{
		Applicationutility.clickme(clickme1);
		driver.switchTo().alert().accept();
	}
	
	public void clickme2()
	{
		Applicationutility.clickme(clickme2);
		Waitutility.alertispresent(6);
		driver.switchTo().alert().accept();
	}
	
	public void clickme3()
	{	
		Applicationutility.clickme(clickme3);
		driver.switchTo().alert().dismiss();
	}
	
	public void clickme4()
	{
		Applicationutility.clickme(clickme4);
		driver.switchTo().alert().sendKeys("45");
		driver.switchTo().alert().accept();
	}
}
