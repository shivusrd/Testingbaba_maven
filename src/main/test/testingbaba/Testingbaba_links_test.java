package testingbaba;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_launch_page;
import pages.Testingbaba_links_page;
import propertyutility.PropertyUtility;

public class Testingbaba_links_test extends Baselibrary

{
	Testingbaba_links_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_links_page();
		ob.closebtn();
	}
	
	
	
	@Test(priority =1)

	public void LinksTestingBaba_test01() throws Exception

	{
		ob.clickonelements();

	}
	
	@Test(priority =2)

	public void LinksTestingBaba_test02() throws Exception

	{
		ob.clickonlinks();

	}
	
	

}
