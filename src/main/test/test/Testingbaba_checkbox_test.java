package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_checkbox_page;
import pages.Testingbaba_textbox_page;
import propertyutility.PropertyUtility;

public class Testingbaba_checkbox_test extends Baselibrary

{

	Testingbaba_checkbox_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch(url);
		ob = new Testingbaba_checkbox_page();
		ob.closebtn();
	}

	@Test(priority = 1)

	public void elements() throws Exception

	{
		ob.clickonelements();

	}

	@Test(priority = 2)

	public void checkbox() {
		ob.checkbox();

	}

	@Test(priority = 3)

	public void mobilecheckbox() throws InterruptedException 
	{
    ob.mobilecheckbox();

	}

}
