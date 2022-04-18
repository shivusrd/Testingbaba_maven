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
	
	@Parameters({ "browser" })
	@BeforeTest
	public void launchtestingbaba(String browser) throws InterruptedException 
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
		ob = new Testingbaba_textbox_page();
		ob.closebtn();
	}

	@Test(priority = 0)

	public void TextboxTestingBaba_test01() throws Exception {
		reporter.log("inside test01");
		ob.gettitle();
		

	}

	@Test(priority = 1)
	public void TextboxTestingBaba_test02()

	{
		reporter.log("inside test01");
		ob.clickonelements();
	}

	@Test (priority = 2)

	public void TextboxTestingBaba_test03() 
	
	{reporter.log("inside test01");
		ob.filldetails();

	}

	@Test(priority = 3)
	public void TextboxTestingBaba_test04() 
	{
		reporter.log("inside test01");
		ob.getverify_textboxdata();
	}

}
