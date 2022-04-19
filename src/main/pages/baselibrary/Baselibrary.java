package baselibrary;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.model.Log;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Makemytrip_launch_page;
import propertyutility.PropertyUtility;
import screenshotutility.ScreenshotUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class Baselibrary {

	public static WebDriver driver;
	
    //public static ChromeOptions option;
	public static Reporter reporter;
	public Reporter rep = new Reporter();
	public static Logger logger = LogManager.getLogger(Baselibrary.class);

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;
	static String path = System.getProperty("user.dir");

	
	public void ChromeLaunch() {

		// Initializing the Headless chromebrowser

//    	option=new ChromeOptions();
//    	option.addArguments("headless");
//    	option.setHeadless(true);
//    	driver=new HtmlUnitDriver(BrowserVersion.CHROME);
//    	driver=new HtmlUnitDriver(true);

		logger.info("Starting Chrome Browser");
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

	public void FirefoxLaunch() {

		

		logger.info("Starting Firefox Browser");
		System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette",path + "\\drivers\\geckodriver.exe");  
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
}
	
public void EdgeLaunch() {

		

		logger.info("Starting Edge Browser");
		System.setProperty("webdriver.edge.driver", path + "\\drivers\\msedgedriver.exe");
		//System.setProperty("webdriver.firefox.marionette",path + "\\drivers\\geckodriver.exe");  
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
}
    
	@AfterTest
	
	public void Teardown2()
	{   
		logger.info("Closing Browser");


         driver.manage().deleteAllCookies();
		
		driver.quit();
	}

	public void MakemytripHomepage() {

		driver.navigate().to(PropertyUtility.getreadproperty("makemytrip"));
	}

	
	
	
//	public void Teardown() 
//	{
//		if (browser.equalsIgnoreCase("firefox")) 
//		{
//
//			// Initializing the firefox driver (Gecko)
//			logger.info("Closing Firefox Browser");
//			
//
//		} else if (browser.equalsIgnoreCase("chrome")) 
//		{
//
//			// Initialize the chrome driver
//
//			logger.info("Closing Chrome Browser");
//			
//		}
//		driver.quit();
//		
//	}

//	public void Teardown()
//	{   
//		logger.info("Closing Browser");
//		driver.quit();
//	}

//	//Setup extend report v4
//		public void setExtentReport() {
//			 
//			  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReports/MMTFunctionalTestReport.html");
//			  htmlReporter.config().setDocumentTitle("Makemytrip Automation Report"); // Title
//			  htmlReporter.config().setReportName("Functional Testing"); // Report Name
//			  htmlReporter.config().setTheme(Theme.DARK);
//			  
//			  extent = new ExtentReports();
//			  extent.attachReporter(htmlReporter);
//			  
//			  extent.setSystemInfo("Host name", "localhost");
//			  extent.setSystemInfo("Environemnt", "QA");
//			  extent.setSystemInfo("user", "Kavitha");
//			 }
//		
//	
//		@AfterMethod
//		 public void checkResult(ITestResult result) throws Exception   {
//		  
//			if (result.getStatus() == ITestResult.FAILURE) {
//				
//				childTest.log(Status.FAIL, result.getName()+" Test Case Failed");
//				   test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
//				   test.fail(MarkupHelper.createLabel(result.getName()+" Test case Failed", ExtentColor.RED));

//				   String screenshotPath = utilFunctions.getScreenshot(result.getName());
//				   childTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//				   childTest.addScreenCaptureFromPath(screenshotPath);

//			} else if (result.getStatus() == ITestResult.SKIP) {
//				  //test.log(Status.SKIP, result.getName()+ " Test Case Skipped");
//				childTest.skip(MarkupHelper.createLabel(result.getName()+" Test case Skipped", ExtentColor.YELLOW));
//				childTest.skip(result.getThrowable());
//				  
//			} else if (result.getStatus() == ITestResult.SUCCESS) {
//				  //test.log(Status.PASS, result.getName()+ " Test Case Passed");
//				childTest.pass(MarkupHelper.createLabel(" Test case passed", ExtentColor.GREEN));
//			  }
//		 
//		 }
//	

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
//		if (result.getStatus()==ITestResult.FAILURE)
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

	public static void getScreenshot(String result) throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcFile, new File("C://screenshotTest//" + result + "screenshot.jpeg"));

	}

}
