package testingbaba;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import pages.Testingbaba_upload_page;

import propertyutility.PropertyUtility;

public class Testingbaba_upload_test extends Baselibrary

{
	Testingbaba_upload_page ob;

	@BeforeTest
	public void launchtestingbaba() {
		String url = PropertyUtility.getreadproperty("url");
		getlaunch();
		driver.get(url);
		ob = new Testingbaba_upload_page();
		ob.closebtn();
	}

	@Test

	public void UploadFileTestingBaba_test01() throws Exception {

		ob.clickonelements();

	}
	
	@Test
	
	public void UploadFileTestingBaba_test02() throws InterruptedException
	{
		
		
		ob.uploadfile();
	}
	
}
