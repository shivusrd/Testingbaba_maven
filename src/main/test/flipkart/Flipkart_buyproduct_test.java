package flipkart;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Flipkart_buy_page;
import pages.Flipkart_buyproduct_page;
import propertyutility.PropertyUtility;

public class Flipkart_buyproduct_test extends Baselibrary


{
	Flipkart_buyproduct_page ob;
	
	@BeforeTest

	public void launchFB() {
		String url1 = PropertyUtility.getreadproperty("url1");
		getlaunch();
		driver.get(url1);

		ob = new Flipkart_buyproduct_page();
	}

	@Test
	public void FlipkartLoginInvalidCred_Test01() throws InterruptedException

	{

		ob.login();
	}
	
}
