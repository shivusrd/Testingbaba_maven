package pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Testingbaba_radio_page extends Baselibrary

{
	public Testingbaba_radio_page()

	{
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")
	private WebElement practiceform;

	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;

	@FindBy(xpath = "//a[contains(text(),'radio buttons')]")
	private WebElement radio;

	@FindBy(xpath = "//input[@id='impressive']")
	private WebElement impressive;

	public void getradio() throws InterruptedException

	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		closebtn.click();
		practiceform.click();
		elements.click();
		Thread.sleep(2000);
		assertEquals(radio.isDisplayed(),true);
		radio.click();
		impressive.click();

	}

}
