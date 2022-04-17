package testingbaba;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_menu_page;
import propertyutility.PropertyUtility;





public class Testingbaba_menu_test extends Baselibrary

{
	Testingbaba_menu_page ob ;
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
	    driver.get(url);
	    
		ob = new Testingbaba_menu_page();
		ob.closebtn();
	}
	
	@Test (priority = 0)

	public void MenuTestingBaba_test01() throws Exception 
	{
		ob.gettitle();
	}

	


}
