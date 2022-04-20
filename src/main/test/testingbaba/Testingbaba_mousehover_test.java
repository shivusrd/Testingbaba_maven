package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_mousehover_page;

import propertyutility.PropertyUtility;

public class Testingbaba_mousehover_test extends Baselibrary

{

	Testingbaba_mousehover_page ob;
	@Parameters({ "browser","url" })
	@BeforeTest
	public void launchtestingbaba(String browser,String url) throws InterruptedException 
	{
		String testingbaba = PropertyUtility.getreadproperty("Testingbabaurl");
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
		if(url.equalsIgnoreCase(testingbaba))
		{
			 
		     //Initializing the firefox driver (Gecko)
			 driver.get(testingbaba);

		  }
		
		else { 

			  //Initialize the chrome driver

			logger.error("Wrong url used for Testing");

		  }
		ob = new Testingbaba_mousehover_page();
		ob.closebtn();
	}

	

	@Test(priority = 0,groups ="Functional testing")

	public void MousehoverTestingBaba_test01() throws InterruptedException {

		ob.clicauto();

	}

	@Test(priority = 1,groups ="Functional testing")

	public void MousehoverTestingBaba_test02() throws InterruptedException {

		ob.hoverfunction();
	}

}
