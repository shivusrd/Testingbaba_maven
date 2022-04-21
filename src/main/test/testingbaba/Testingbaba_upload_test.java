package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_upload_page;

import propertyutility.PropertyUtility;

public class Testingbaba_upload_test extends Baselibrary

{
	Testingbaba_upload_page ob;
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
			 logger.info(testingbaba, "url is validated");
		  }
		
		else { 

			  //Initialize the chrome driver

			logger.error("Wrong url used for Testing");
			driver.quit();

		  }
		ob = new Testingbaba_upload_page();
		ob.closebtn();
	}

	@Test(groups ="Functional testing")

	public void UploadFileTestingBaba_test01() throws Exception {

		ob.clickonelements();

	}
	
	@Test(groups ="Functional testing")
	
	public void UploadFileTestingBaba_test02() throws InterruptedException
	{
		
		
		ob.uploadfile();
	}
	
}
