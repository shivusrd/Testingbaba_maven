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
		ob = new Testingbaba_links_page();
		ob.closebtn();
	}
	
	
	
	@Test(priority =1)

	public void LinksTestingBaba_test01() throws Exception

	{
		ob.clickonelements();

	}
	
	@Test(priority =2,groups ="Functional testing")

	public void LinksTestingBaba_test02() throws Exception

	{
		ob.clickonlinks();

	}
	
	

}
