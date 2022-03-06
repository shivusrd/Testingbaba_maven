package test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_buttons_page;

import propertyutility.PropertyUtility;

public class Testingbaba_buttons_test extends Baselibrary

{
	Testingbaba_buttons_page ob;

	@BeforeTest
	public void launchtestingbaba() 
	{
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_buttons_page();
		ob.closebtn();
	}
	
	@Test(priority = 0)

	public void getelement() throws Exception
	{
		ob.clickonelements();
       
	}
	
	@Test(priority = 1)

	public void getbuttn() throws Exception
	{
		ob.clickbuttn();
       
	}
	
	@Test(priority=2)
	
	public void doble() 
	{
		ob.doubleclick();
		
	}

}
