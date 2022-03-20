package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import excelutility.Excelutility_automation;

public class Testingbaba_webtables_page extends Baselibrary

{

	public Testingbaba_webtables_page()
	
	{
		PageFactory.initElements(driver, this);

	}

	static String path = "C:\\Users\\POOJA SINGH\\Documents\\GitHub\\Testingbaba_maven\\src\\main\\resources\\Webtabledata.xlsx";

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;

	@FindBy(xpath = " //*[@class=\"nav-link\"][text()='web tables']")
	private WebElement webtables;

	@FindBy(xpath = "//*[text()='Name:']//following::input[@name=\"name\"]")

	private WebElement webname;

	@FindBy(xpath = "//*[text()='Email:']//following::input[@title=\"eg name@gmail.com\"]")
	private WebElement webemail;

	@FindBy(xpath = "//*[@class=\"btn btn-success save-btn\"]")
	private WebElement save;

	@FindBy(xpath = "//*[@id=\"tab_4\"]/div/iframe")
	private WebElement web_frame;
	
	@FindBy(xpath = "//*[@class=\"table table-bordered data-table\"]/tbody/tr/td[1]")
	private  List<WebElement> namedata;
	
	@FindBy(xpath = "//*[@class=\"table table-bordered data-table\"]/tbody/tr/td[2]")
	private List<WebElement> emaildata;

	public void closebtn() 
	{

		closebtn.click();
		practiceform.click();
	}

	public void clickonelements()

	{
		assertEquals(elements.isDisplayed(),true);
		elements.click();

	}

	public void getweb() throws InterruptedException

	{	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		webtables.click();

		driver.switchTo().frame(web_frame);

		for (int i = 0; i <=29 ; i++)

		{

			String name = Excelutility_automation.Getreaddata(i, 0);
			String email = Excelutility_automation.Getreaddata(i, 1);
			webname.sendKeys(name);
			webemail.sendKeys(email);
			save.click();
					

		}
		
		for(int k = 0; k <= 29; k++)
		{
			String datafill = namedata.get(k).getText();
			String datafill2 = emaildata.get(k).getText();
			System.out.println(datafill + " "+ datafill2);
			
		}
		

		driver.switchTo().defaultContent();
		driver.quit();

	}

}
