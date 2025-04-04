package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Makemytrip_launch_page;

import baselibrary.Baselibrary;

import propertyutility.PropertyUtility;

public class Makemytrip_launch_test extends Baselibrary


{
	Makemytrip_launch_page ob;
	@Parameters({ "browser", "url"})
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
