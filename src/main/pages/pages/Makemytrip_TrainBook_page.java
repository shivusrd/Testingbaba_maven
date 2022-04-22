package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Makemytrip_TrainBook_page extends Baselibrary

{
	
	public Makemytrip_TrainBook_page()

	{
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]/div[3]/div/div[2]/div/p/label")
	private WebElement login;

	@FindBy(css = ".makeFlex.hrtlCenter.font10.makeRelative.lhUser.userLoggedOut")
	private WebElement login3;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//span[normalize-space()='Continue']")
	private WebElement continu;
	@FindBy(xpath = "//a[normalize-space()='or Login via Password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pass;
	@FindBy(xpath = "//button[@class='capText font16']")
	private WebElement login2;

	@FindBy(xpath = "(//*[@class=\"false chNavText darkGreyText\"])[5]")
	private WebElement train_btn;

	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn']")
	private WebElement search_btn;

	@FindBy(xpath = "//input[@id='departureAfter6']")
	private WebElement depaft6_btn;

	@FindBy(xpath = "//*[@class=\"train-name\"]")
	private List<WebElement> trains;
	
	@FindBy(xpath = "//span[normalize-space()='From']")
	private WebElement from;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement from2;

	
	public void booktrain_ticket() throws InterruptedException

	{

		if (closebtn.isDisplayed())

		{
			closebtn.click();
			login3.click();
			train_btn.click();
			Thread.sleep(2000);
			search_btn.click();
			Thread.sleep(2000);
			assertEquals(depaft6_btn.isDisplayed(),true);
			depaft6_btn.click();

			for (int k = 0; k <= 20; k++) {
				String datafill = trains.get(k).getText();

				System.out.println(datafill);

			}

		}

		else

		{

			login3.click();
			Thread.sleep(2000);
		    train_btn.click();
			Thread.sleep(2000);
			search_btn.click();
			Thread.sleep(2000);
			depaft6_btn.click();

			for (int k = 0; k <= 20; k++) {
				String datafill = trains.get(k).getText();

				System.out.println(datafill);

			}

		}

	}

	public static void main(String[] args)

	{

	}

}
