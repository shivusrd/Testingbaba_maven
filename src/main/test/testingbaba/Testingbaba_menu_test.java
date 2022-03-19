package testingbaba;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_menu_page;
import propertyutility.PropertyUtility;





public class Testingbaba_menu_test extends Baselibrary

{
	Testingbaba_menu_page ob ;
	
	@BeforeTest
	public void launchtestingbaba() 
	{   
		String url = PropertyUtility.getreadproperty("url");
	    getlaunch();
	    driver.get(url);
	    
		ob = new Testingbaba_menu_page();
		ob.closebtn();
	}
	
	@Test (priority = 0)

	public void MenuTestingBaba_test01() throws Exception 
	{
		ob.gettitle();
	}

	


}
