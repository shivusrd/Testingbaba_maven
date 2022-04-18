package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_dropdown_page;
import pages.Testingbaba_radio_page;
import propertyutility.PropertyUtility;

public class Testingbaba_dropdown_test extends Baselibrary

{

	Testingbaba_dropdown_page ob;
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
		  else if (browser.equalsIgnoreCase("edge")) { 

			  //Initialize the chrome driver

			 EdgeLaunch();

		  } 
		driver.get(url);
		ob = new Testingbaba_dropdown_page();

	}

	@Test(groups ="Functional testing")

	public void DropdownTestingBaba_test01() throws Exception

	{
		ob.getdropdown();

	}

}
