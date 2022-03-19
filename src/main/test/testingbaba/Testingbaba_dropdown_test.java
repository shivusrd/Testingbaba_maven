package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_dropdown_page;
import pages.Testingbaba_radio_page;
import propertyutility.PropertyUtility;

public class Testingbaba_dropdown_test extends Baselibrary

{

	Testingbaba_dropdown_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_dropdown_page();

	}

	@Test()

	public void DropdownTestingBaba_test01() throws Exception

	{
		ob.getdropdown();

	}

}
