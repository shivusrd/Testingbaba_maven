package testingbaba;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_buttons_page;

import propertyutility.PropertyUtility;

public class Testingbaba_buttons_test extends Baselibrary

{
	Testingbaba_buttons_page ob;
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
		ob = new Testingbaba_buttons_page();
		ob.closebtn();
	}
	
	@Test(priority = 0)

	public void ButtonsTestingBaba_test01() throws Exception
	{
		ob.clickonelements();
       
	}
	
	@Test(priority = 1)

	public void ButtonsTestingBaba_test02() throws Exception
	{
		ob.clickbuttn();
       
	}
	 
	@Test(priority=2)
	
	public void ButtonsTestingBaba_test03() 
	{
		ob.doubleclick();
		
	}

}
