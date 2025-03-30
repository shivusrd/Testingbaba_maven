package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;

import pages.Testingbaba_radio_page;
import propertyutility.PropertyUtility;

public class Testingbaba_radio_test extends Baselibrary

{

	Testingbaba_radio_page ob;
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
		ob = new Testingbaba_radio_page();

	}

	@Test(groups ="Functional testing")

	public void RadioButtonTestingBaba_test01() throws Exception

	{
		ob.getradio();
	}

}
