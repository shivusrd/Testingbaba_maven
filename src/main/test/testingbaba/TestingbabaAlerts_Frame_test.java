package testingbaba;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.TestingbabaAlerts_Frame_page;
import propertyutility.PropertyUtility;

public class TestingbabaAlerts_Frame_test extends Baselibrary

{
	TestingbabaAlerts_Frame_page ob;
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
		ob = new TestingbabaAlerts_Frame_page();
		ob.closebtn();
	}

	

	@Test (priority = 1)

	public void AlertsTestingBaba_test01()

	{
		ob.alerts();
	}

	@Test(priority = 2)

	public void AlertsTestingBaba_test02()

	{
		ob.clickme1();

	}

	@Test(priority = 3)
	public void AlertsTestingBaba_test03()

	{

		ob.clickme2();

	}

	@Test(priority = 4)
	public void AlertsTestingBaba_test04()

	{

		ob.clickme3();

	}

	@Test(priority = 5)
	public void AlertsTestingBaba_test05()

	{

		ob.clickme4();
	}

}
