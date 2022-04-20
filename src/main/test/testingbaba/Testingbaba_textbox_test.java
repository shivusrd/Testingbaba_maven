package testingbaba;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import baselibrary.Baselibrary;

import pages.Testingbaba_textbox_page;
import propertyutility.PropertyUtility;

@Listeners(listeners.Report_log.class)
public class Testingbaba_textbox_test extends Baselibrary

{	

	
	Testingbaba_textbox_page ob;
	
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
		ob = new Testingbaba_textbox_page();
		ob.closebtn();
	}

	@Test(priority = 0)

	public void TextboxTestingBaba_test01() throws Exception {
		reporter.log("inside test01");
		ob.gettitle();
		

	}

	@Test(priority = 1,groups ="Functional testing")
	public void TextboxTestingBaba_test02()

	{
		reporter.log("inside test01");
		ob.clickonelements();
	}

	@Test (priority = 2,groups ="Functional testing")

	public void TextboxTestingBaba_test03() 
	
	{reporter.log("inside test01");
		ob.filldetails();

	}

	@Test(priority = 3,groups ="Functional testing")
	public void TextboxTestingBaba_test04() 
	{
		reporter.log("inside test01");
		ob.getverify_textboxdata();
	}

}
