package testingbaba;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import baselibrary.Baselibrary;
import extentReports.Extent_report;
import pages.Testingbaba_launch_page;
import propertyutility.PropertyUtility;

public class Testingbaba_launch_test extends Baselibrary

{	
	
	
	Testingbaba_launch_page ob;
	@BeforeTest
	public void launchtestingbaba()
	{ 	
		
		
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_launch_page();
	    ob.closebtn();
	}
	
	@Test
   public void LaunchTestingBaba_test01() throws Exception
   {
		
		ob.gettitle();
		
   }
	
}