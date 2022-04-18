package flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;

import pages.Flipkart_buy_page;

import propertyutility.PropertyUtility;

public class Flipkart_buy_test extends Baselibrary {

	Flipkart_buy_page ob;
	@Parameters({ "browser" })
	@BeforeTest

	public void launchFB(String browser) 
	
	{
		String url = PropertyUtility.getreadproperty("Flipkart");
		if(browser.equalsIgnoreCase("firefox")) {
			 
		     //Initializing the firefox driver (Gecko)
			 FirefoxLaunch();

		  }
		else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver

			  ChromeLaunch();

		  } 
		
		else if (browser.equalsIgnoreCase("edge")) { 

			  //Initialize the chrome driver

			 EdgeLaunch();

		  } 
		driver.get(url);

		ob = new Flipkart_buy_page();
	}

	@Test(groups ="smoke")
	public void FlipkartLogin_Test01() throws InterruptedException

	{

		ob.login();

	}

	@Test(groups ="smoke")
	public void FlipkartProfileChange_Test02() throws InterruptedException

	{
		ob.Namechange();
		
	}

}
