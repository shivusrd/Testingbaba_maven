package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;

import pages.Testingbaba_radio_page;
import propertyutility.PropertyUtility;

public class Testingbaba_radio_test extends Baselibrary

{

	Testingbaba_radio_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_radio_page();

	}

	@Test()

	public void RadioButtonTestingBaba_test01() throws Exception

	{
		ob.getradio();
	}

}
