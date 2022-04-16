package testingbaba;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_launch_page;
import pages.Testingbaba_links_page;
import propertyutility.PropertyUtility;

public class Testingbaba_links_test extends Baselibrary

{
	Testingbaba_links_page ob;
	@Parameters({ "browser" })
	@BeforeTest
	public void launchtestingbaba(String browser) 
	{
		String url = PropertyUtility.getreadproperty("Testingbabaurl");
		if(browser.equalsIgnoreCase("firefox")) {
			 
		     //Initializing the firefox driver (Gecko)
			 FirefoxLaunch();

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver

			  ChromeLaunch();

		  } 
		driver.get(url);
		ob = new Testingbaba_links_page();
		ob.closebtn();
	}
	
	
	
	@Test(priority =1)

	public void LinksTestingBaba_test01() throws Exception

	{
		ob.clickonelements();

	}
	
	@Test(priority =2)

	public void LinksTestingBaba_test02() throws Exception

	{
		ob.clickonlinks();

	}
	
	

}
