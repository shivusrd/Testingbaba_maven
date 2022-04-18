package jenkins;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Jenkins_launch_page;
import pages.Testingbaba_launch_page;
import propertyutility.PropertyUtility;

public class Jenkins_launch_test extends Baselibrary


{

	Jenkins_launch_page ob;
	@Parameters({ "browser" })
	@BeforeTest

	public void launchFB(String browser) 
	
	{
		String url = PropertyUtility.getreadproperty("makemytrip");
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
		ob = new Jenkins_launch_page();
	    
	}
	
	@Test
   public void LaunchTestingBaba_test01() throws Exception
   {
		
		ob.Launch_Jenkins();
		
   }



}
