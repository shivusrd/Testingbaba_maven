package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;

public class Testingbaba_upload_page extends Baselibrary

{

	public Testingbaba_upload_page() 
	{
		PageFactory.initElements(driver, this);

	}
	
	public String fileloc="C:\\Users\\sd47860\\eclipse-workspace\\18october_Framework\\testresult\\1607762829018.jpg";

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;
	
	@FindBy(xpath = "//a[contains(text(),'upload and download')]")
	private WebElement upload;
	
	@FindBy(xpath = "//*[text()='Select a file']")
	private WebElement selectfile;
	
	
	
	
	
	public void closebtn() 
	{
		closebtn.click();
		practiceform.click();
	}

	public void clickonelements()

	{

		elements.click();

	}
	
	public void uploadfile() throws InterruptedException
	
	{
		assertEquals(upload.isDisplayed(),true);
		upload.click();
		
		Thread.sleep(2000);
		selectfile.click();
		
		Applicationutility.fileupload(fileloc);
		Thread.sleep(3000);
	}
	
	
	
	
}
