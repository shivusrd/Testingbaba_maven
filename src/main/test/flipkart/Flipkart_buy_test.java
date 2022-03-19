package flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;

import pages.Flipkart_buy_page;

import propertyutility.PropertyUtility;

public class Flipkart_buy_test extends Baselibrary {

	Flipkart_buy_page ob;

	@BeforeTest

	public void launchFB() {
		String url1 = PropertyUtility.getreadproperty("url1");
		getlaunch();
		driver.get(url1);

		ob = new Flipkart_buy_page();
	}

	@Test
	public void FlipkartLogin_Test01() throws InterruptedException

	{

		ob.login();

	}

	@Test
	public void FlipkartProfileChange_Test02() throws InterruptedException

	{
		ob.Namechange();
		
	}

}
