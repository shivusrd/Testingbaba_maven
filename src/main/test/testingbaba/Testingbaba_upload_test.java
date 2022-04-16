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
		ob = new Testingbaba_upload_page();
		ob.closebtn();
	}

	@Test

	public void UploadFileTestingBaba_test01() throws Exception {

		ob.clickonelements();

	}
	
	@Test
	
	public void UploadFileTestingBaba_test02() throws InterruptedException
	{
		
		
		ob.uploadfile();
	}
	
}
