package test;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import baselibrary.Baselibrary;

import pages.Testingbaba_textbox_page;
import propertyutility.PropertyUtility;

@Listeners(listeners.Report_log.class)
public class Testingbaba_textbox_test extends Baselibrary

{	

	
	Testingbaba_textbox_page ob;
	

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
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
