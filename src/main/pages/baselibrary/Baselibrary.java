package baselibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Baselibrary 
{
public static WebDriver driver;
	
	public void getlaunch (String url)
	{
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterTest
	
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
//	@AfterMethod
//	public void analysis(ITestResult result)
//	
//	{
//		String methodname = result.getMethod().getMethodName();
//		if(result.isSuccess())
//		{
//			
//			ScreenshotUtility.getscreenshot("PASSED", methodname);
//		}
//		
//		else if (result.getStatus()==ITestResult.FAILURE)
//		
//		{
//			ScreenshotUtility.getscreenshot("FAILED", methodname);
//		}
//		
//		else if (result.getStatus()==ITestResult.SKIP)
//			
//		{
//			ScreenshotUtility.getscreenshot("SKIP", methodname);
//		}
//		
//	}
			
	public void getScreenshot(String result) throws IOException {
		// Web Driver take the screenshot as a file and save in virtually in src
		// variable.
		//File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copy the file from src and put in your local machine with the name of failed
		// test class
		FileUtils.copyFile(srcFile, new File("C://screenshotTest//" + result + "screenshot.jpeg"));

	}
	
	
}
