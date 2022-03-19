package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baselibrary.Baselibrary;


public class Testingbaba_menu_page extends Baselibrary


{
	@FindBy(xpath= "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
	
	private WebElement practiceform;
    
	@FindBy(xpath ="//*[@id=\\\"v-pills-tab\\\"]/a[8]")
	private WebElement menu;
    
    
    
    public void gettitle() throws Exception
	{
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	public void closebtn()
	{
		
		closebtn.click();
		practiceform.click();
	}
	
	public void menuclick()
	{
		assertEquals(menu.isDisplayed(),true);
		menu.click();
		
	}
	
	
	
	
}
