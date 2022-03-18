package baselibrary;

import java.io.File;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.w3c.dom.html.HTMLUListElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.Makemytrip_launch_page;
import propertyutility.PropertyUtility;
import screenshotutility.ScreenshotUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;




public class Baselibrary 
{
public static WebDriver driver;
public static Reporter reporter;
public Reporter rep = new Reporter();


	


    public void getlaunch ()
	{
    	
//    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("-- headless");
//    	DesiredCapabilities cap = new DesiredCapabilities();
//    	cap.setCapability(ChromeOptions.CAPABILITY,options);
//    	options.merge(cap);
    	driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
    
    public void homepage()
    {
    	
    	driver.navigate().to(PropertyUtility.getreadproperty("makemytrip"));
    }
	
	@AfterTest
	
	public void Teardown()
	{   
		
		driver.quit();
		System.out.println("$--------------------------------------------------$");
		
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
