package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Makemytrip_hotel_page;

import baselibrary.Baselibrary;

import propertyutility.PropertyUtility;

public class Makemytrip_hotel_test extends Baselibrary


{

	Makemytrip_hotel_page ob;
	@Parameters({ "browser","url" })
	@BeforeTest

	public void launchFB(String browser,String url) 
	{
		String makemytrip = PropertyUtility.getreadproperty("makemytrip");

		if(url.equalsIgnoreCase(makemytrip))
		{
			 
		     //Initializing the firefox driver (Gecko)
			 driver.get(makemytrip);

		  }
		
		else { 

			  //Initialize the chrome driver

			logger.error("Wrong url used for Testing");
			driver.quit();
		  }
		
        ob = new Makemytrip_hotel_page();
        
	}

	
	@Test(priority = 0,groups ="Functional testing")
	public void SearchHomestay() throws InterruptedException
	{
		ob.ClickOnHotel();
		ob.enterDepartureDate();
		ob.enterReturnDate();
		ob.clicksearch();
		
	}
}
