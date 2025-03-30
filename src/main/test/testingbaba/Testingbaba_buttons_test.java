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
	@Parameters({ "browser","url" })
	@BeforeTest
	public void launchtestingbaba(String browser,String url) throws InterruptedException 
	{
		String testingbaba = PropertyUtility.getreadproperty("Testingbabaurl");
		
		if(url.equalsIgnoreCase(testingbaba))
		{
			 
		     //Initializing the firefox driver (Gecko)
			 driver.get(testingbaba);
			 logger.info(testingbaba, "url is validated");
		  }
		
		else { 

			  //Initialize the chrome driver

			logger.error("Wrong url used for Testing");
			driver.quit();
		  }
		ob = new Testingbaba_buttons_page();
		ob.closebtn();
	}
	
	@Test(priority = 0,groups ="Functional testing")

	public void ButtonsTestingBaba_test01() throws Exception
	{
		ob.clickonelements();
       
	}
	
	@Test(priority = 1,groups ="Functional testing")

	public void ButtonsTestingBaba_test02() throws Exception
	{
		ob.clickbuttn();
       
	}
	 
	@Test(priority=2,groups ="Functional testing")
	
	public void ButtonsTestingBaba_test03() 
	{
		ob.doubleclick();
		
	}

}
