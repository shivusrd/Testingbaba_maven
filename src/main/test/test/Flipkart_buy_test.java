package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Flipkart_baselibrary;
import pages.Flipkart_buy_page;

import propertyutility.PropertyUtility;

public class Flipkart_buy_test extends Flipkart_baselibrary

{

	Flipkart_buy_page ob;

	@BeforeTest

	public void launchtestingbaba() 
	{
		String url1 = PropertyUtility.getreadproperty("url1");
		getflipkarturl(url1);
		ob = new Flipkart_buy_page();

	}

	@Test()
	public void flipkart() throws InterruptedException

	{
		ob.login();

	}
	
	@Test()
	public void hover() throws InterruptedException

	{
		ob.AddtoCart();
	}
	
	
	
	
}
