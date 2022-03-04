package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_launch_page;
import propertyutility.PropertyUtility;

public class Testingbaba_launch_test extends Baselibrary

{
	Testingbaba_launch_page ob;
	@BeforeTest
	public void launchtestingbaba()
	{ 	String url = PropertyUtility.getreadproperty("url");
		getlaunch(url);
		ob = new Testingbaba_launch_page();
		ob.closebtn();
	}
	
	@Test
   public void gettitle() throws Exception
   {
		ob.gettitle();
	
   }
	
}