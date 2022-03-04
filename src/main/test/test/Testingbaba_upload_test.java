package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_upload_page;

import propertyutility.PropertyUtility;

public class Testingbaba_upload_test extends Baselibrary

{
	Testingbaba_upload_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch(url);
		ob = new Testingbaba_upload_page();
		ob.closebtn();
	}

	@Test

	public void getweb() throws Exception {

		ob.clickonelements();

	}
	
	@Test
	
	public void uploadfile() throws InterruptedException
	{
		
		
		ob.uploadfile();
	}
	
}
