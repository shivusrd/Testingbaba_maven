package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_mousehover_page;

import propertyutility.PropertyUtility;

public class Testingbaba_mousehover_test extends Baselibrary

{

	Testingbaba_mousehover_page ob;

	@BeforeTest
	public void launchtestingbaba() 
	{
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_mousehover_page();
		ob.closebtn();
	}

	

	@Test(priority = 1)

	public void MousehoverTestingBaba_test01() throws InterruptedException {

		ob.clicauto();

	}

	@Test(priority = 2)

	public void MousehoverTestingBaba_test02() throws InterruptedException {

		ob.hoverfunction();
	}

}
