package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Makemytrip_Search_Flight;
import propertyutility.PropertyUtility;

public class Makemytrip_Flightsearch_test extends Baselibrary


{
	Makemytrip_Search_Flight ob;
	@Parameters({ "browser" })
	@BeforeTest

	public void launchFB(String browser) 
	{
		String url = PropertyUtility.getreadproperty("makemytrip");
		if(browser.equalsIgnoreCase("firefox")) {
			 
			     //Initializing the firefox driver (Gecko)
				 FirefoxLaunch();

			  }else if (browser.equalsIgnoreCase("chrome")) { 

				  //Initialize the chrome driver

				  ChromeLaunch();

			  } 
		driver.get(url);
        ob = new Makemytrip_Search_Flight();
	}

	
	@Test(priority = 0)
	public void SearchFlightToday() throws InterruptedException
	{
		ob.ClickOnFlight();
		ob.enterDepartureDate();
		ob.enterReturnDate();
		ob.clicksearch();
		
	}
	
	
	
}
