package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Flipkart_buy_page;
import pages.Makemytrip_launch_page;
import propertyutility.PropertyUtility;

public class Makemytrip_launch_test extends Baselibrary


{
	Makemytrip_launch_page ob;
	
	@BeforeTest

	public void launchFB() {
		String url = PropertyUtility.getreadproperty("makemytrip");
		getlaunch();
		driver.get(url);

		ob = new Makemytrip_launch_page();
	}

	@Test(priority = 0)
	public void MakemyTripSendValidNumber_Test01() throws InterruptedException

	{
	   ob.makemytrip_login();
		

	}

	
	@Test(priority = 1)
	public void MakemyTripSendINValidNumber_Test02() throws InterruptedException

	{
		
		ob.makemytrip_booking();
		

	}



}
