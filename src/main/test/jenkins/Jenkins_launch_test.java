package jenkins;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Jenkins_launch_page;
import pages.Testingbaba_launch_page;
import propertyutility.PropertyUtility;

public class Jenkins_launch_test extends Baselibrary

{

	Jenkins_launch_page ob;

	@Parameters({ "browser" })
	@BeforeTest

	public void launchFB(String browser)

	{
		String url = PropertyUtility.getreadproperty("jenkins");
		driver.get(url);
		ob = new Jenkins_launch_page();

	}

	@Test
	public void LaunchTestingBaba_test01() throws Exception {

		ob.Launch_Jenkins();

	}

}
