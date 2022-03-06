package test;

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
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_autocomplete_page();
		ob.closebtn();
	}

	@Test(priority=1)

	public void getweb() throws InterruptedException 
	{
		
		ob.clicauto();

	}
	
	@Test (priority=2)

	public void completeclick() throws InterruptedException 
	{
		
		ob.autocomplete();
	}
	
	@Test(priority=3)
	public void filldetails() throws InterruptedException
	
	{
		ob.select();
		
	}

}
