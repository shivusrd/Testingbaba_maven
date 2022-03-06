package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import baselibrary.Baselibrary;

import pages.Testingbaba_textbox_page;
import propertyutility.PropertyUtility;

public class Testingbaba_textbox_test extends Baselibrary

{	
	ExtentTest test;
	
	Testingbaba_textbox_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_textbox_page();
		ob.closebtn();
	}

	@Test(priority = 1)

	public void gettitle() throws Exception {
		ob.gettitle();

	}

	@Test(priority = 2)
	public void clickonelements()

	{

		ob.clickonelements();
	}

	@Test (priority = 3)

	public void filldetails() 
	
	{
		ob.filldetails();

	}

	@Test(priority = 4)
	public void getverify() 
	{

		ob.getverify_textboxdata();
	}

}
