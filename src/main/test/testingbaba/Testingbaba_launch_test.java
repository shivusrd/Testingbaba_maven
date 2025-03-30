package testingbaba;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baselibrary.Baselibrary;

import pages.Testingbaba_launch_page;
import propertyutility.PropertyUtility;

public class Testingbaba_launch_test extends Baselibrary

{	
	
	
	Testingbaba_launch_page ob;
	
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
	    ob = new Testingbaba_launch_page();
	    ob.closebtn();
	}

	@Test(groups ="Functional testing")
   public void LaunchTestingBaba_test01() throws Exception
   {
		
		ob.gettitle();
		
   }
	
}