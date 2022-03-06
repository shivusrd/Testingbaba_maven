package test;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.TestingbabaAlerts_Frame_page;
import propertyutility.PropertyUtility;

public class TestingbabaAlerts_Frame_test extends Baselibrary

{
	TestingbabaAlerts_Frame_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new TestingbabaAlerts_Frame_page();
		ob.closebtn();
	}

	

	@Test (priority = 1)

	public void getalerts()

	{
		ob.alerts();
	}

	@Test(priority = 2)

	public void getclick()

	{
		ob.clickme1();

	}

	@Test(priority = 3)
	public void getclick2()

	{

		ob.clickme2();

	}

	@Test(priority = 4)
	public void getclick3()

	{

		ob.clickme3();

	}

	@Test(priority = 5)
	public void getclick4()

	{

		ob.clickme4();
	}

}
