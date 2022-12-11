package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;


public class Testingbaba_menu_page extends Baselibrary


{
	@FindBy(xpath= "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;
	
	@FindBy(xpath="//a[@class='kbt'][normalize-space()='Practice']")
	
	private WebElement practiceform;
    
	@FindBy(xpath ="//*[@id=\\\"v-pills-tab\\\"]/a[8]")
	private WebElement menu;
    
    
    
    public void gettitle() throws Exception
	{
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	public void closebtn() throws InterruptedException
	{
		
		closebtn.click();
		Thread.sleep(4000);
		Applicationutility.clickme(practiceform);
		driver.navigate().refresh();
		Thread.sleep(4000);
		closebtn.click();
		Thread.sleep(4000);
		Applicationutility.clickme(practiceform);
	}
	
	public void menuclick()
	{
		assertEquals(menu.isDisplayed(),true);
		menu.click();
		
	}
	
	
	
	
}
