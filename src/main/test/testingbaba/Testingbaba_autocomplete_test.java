package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_autocomplete_page;
import propertyutility.PropertyUtility;

public class Testingbaba_autocomplete_test extends Baselibrary

{
	Testingbaba_autocomplete_page ob;

	@BeforeTest
	public void launchtestingbaba() 
	{
		String url = PropertyUtility.getreadproperty("Testingbabaurl");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_autocomplete_page();
		ob.closebtn();
	}

	@Test(priority=0,groups = "Regression",description = "This is to test Autocomplete",testName = "testALM219310")

	public void AutocompleteTestingBaba_test01() throws InterruptedException 
	{
		
		ob.clicauto();

	}
	
	@Test (priority=1,groups = "Regression")

	public void AutocompleteTestingBaba_test02() throws InterruptedException 
	{
		
		ob.autocomplete();
	}
	
	@Test(priority=2,groups = "Regression")
	public void AutocompleteTestingBaba_test03() throws InterruptedException
	
	{
		ob.select();
		
	}

}
