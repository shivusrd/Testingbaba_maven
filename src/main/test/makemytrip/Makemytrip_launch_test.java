package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Flipkart_buy_page;
import pages.Makemytrip_launch_page;
import propertyutility.PropertyUtility;

public class Makemytrip_launch_test extends Baselibrary


{
	Makemytrip_launch_page ob;
	@Parameters({ "browser", "url"})
	@BeforeTest

	public void launchFB(String browser,String url) 
	
	{
		String makemytrip = PropertyUtility.getreadproperty("makemytrip");
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
		if(url.equalsIgnoreCase(makemytrip))
		{
			 
		     //Initializing the firefox driver (Gecko)
			 driver.get(makemytrip);

		  }
		
		else { 

			  //Initialize the chrome driver

			logger.error("Wrong url used for Testing");

		  }

		ob = new Makemytrip_launch_page();
	}
    
	@Test(priority = 0 ,groups ="Functional testing" )
	public void MakemyTripSendValidNumber_Test01() throws InterruptedException

	{
	   ob.makemytrip_login();
		

	}

	
	@Test(priority = 1,groups ="Functional testing")
	public void MakemyTripSendINValidNumber_Test02() throws InterruptedException

	{
		
		ob.makemytrip_booking();
		

	}



}
