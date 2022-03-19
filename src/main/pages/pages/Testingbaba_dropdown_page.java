package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baselibrary.Baselibrary;

public class Testingbaba_dropdown_page extends Baselibrary

{
	public Testingbaba_dropdown_page()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;
	
	@FindBy(xpath = "//body/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/select[1]")
    WebElement ele1;
	
	@FindBy(xpath = "//*[@id=\"enroll\"]")
    WebElement Regestir;
	
	
	
	

	public void getdropdown()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertEquals(closebtn.isDisplayed(),true);
		closebtn.click();
		Select sel = new Select(ele1);
		sel.selectByVisibleText("Manual Testing");	
		Regestir.click();
	}
	
	
}
