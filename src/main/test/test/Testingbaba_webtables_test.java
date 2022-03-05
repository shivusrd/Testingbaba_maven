package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;

import pages.Testingbaba_webtables_page;
import propertyutility.PropertyUtility;

public class Testingbaba_webtables_test extends Baselibrary

{
	Testingbaba_webtables_page ob;

	@BeforeTest
	public void launchtestingbaba() 
	{
		String url = PropertyUtility.getreadproperty("url");
		getlaunch(url);
		ob = new Testingbaba_webtables_page();
		ob.closebtn();
	}

	@Test 

	public void getweb() throws Exception
	{
		
        ob.clickonelements();
		
		ob.getweb();
	}
	
	

}
