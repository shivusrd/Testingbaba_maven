package flipkart;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Flipkart_buy_page;
import pages.Flipkart_buyproduct_page;
import propertyutility.PropertyUtility;

public class Flipkart_buyproduct_test extends Baselibrary


{
	Flipkart_buyproduct_page ob;
	@Parameters({ "browser" })
	@BeforeTest

	public void launchFB(String browser) {
		String url1 = PropertyUtility.getreadproperty("Flipkart");
		if(browser.equalsIgnoreCase("firefox")) {
			 
		     //Initializing the firefox driver (Gecko)
			 
			 FirefoxLaunch();

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver

			  ChromeLaunch();

		  } 
		  else if (browser.equalsIgnoreCase("edge")) { 

			  //Initialize the chrome driver

			 EdgeLaunch();

		  } 
		driver.get(url1);

		ob = new Flipkart_buyproduct_page();
	}

	@Test (groups = "Regression")
	public void FlipkartLoginInvalidCred_Test01() throws InterruptedException

	{

		ob.login();
	}
	
}
