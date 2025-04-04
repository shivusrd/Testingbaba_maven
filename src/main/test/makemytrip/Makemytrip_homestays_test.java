package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Makemytrip_homestays_page;

import baselibrary.Baselibrary;

import propertyutility.PropertyUtility;

public class Makemytrip_homestays_test extends Baselibrary

{
	Makemytrip_homestays_page ob;
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
		
        ob = new Makemytrip_homestays_page();
        
	}

	
	@Test(priority = 0,groups ="Functional testing")
	public void SearchHomestay() throws InterruptedException
	{
		ob.ClickOnHomestay();
		ob.enterDepartureDate();
		ob.enterReturnDate();
		ob.clicksearch();
		
	}
}
