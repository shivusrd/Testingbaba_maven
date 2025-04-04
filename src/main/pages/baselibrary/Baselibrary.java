package baselibrary;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import propertyutility.PropertyUtility;
import java.time.Duration;


public class Baselibrary {

	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(Baselibrary.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	static String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
	private boolean captureScreenshot;
	private boolean enableLogs;
	
	ChromeOptions options = new ChromeOptions();

	@BeforeSuite
	public void setupExtentReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		if (method.getAnnotation(Test.class) != null) {
			test = extent.createTest(method.getName());

		}
	}

	@Parameters({ "browser", "captureScreenshots", "enableLogs" })
	@BeforeTest
	public void setupBrowser(@Optional String browser,@Optional Boolean captureScreenshots,boolean enableLogs) {
		
		
		if ("chrome".equalsIgnoreCase(browser)) {
			this.captureScreenshot = captureScreenshots;
			this.enableLogs = enableLogs;
			setupLogging();
			logger.info("Starting Chrome Browser");
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if ("firefox".equalsIgnoreCase(browser)) {
			this.captureScreenshot = captureScreenshots;
			this.enableLogs = enableLogs;
			logger.info("Starting Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("edge".equalsIgnoreCase(browser)) {
			this.captureScreenshot = captureScreenshots;
			this.enableLogs = enableLogs;
			logger.info("Starting Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// Check if driver is not null before using it
	    if (driver != null) {
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    } else {
	        logger.info("Driver not initialized. Skipping driver setup.");
	    }
	}

	private void setupLogging() {
		if (enableLogs) {
			Configurator.setRootLevel(Level.INFO); // Or your desired default level
			logger.info("Logging enabled.");
		} else {
			Configurator.setRootLevel(Level.OFF);
			logger.info("Logging disabled.");
		}
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			clearBrowserCache();
			driver.quit();
			logger.info("Browser closed.");
		}
		logger.info("Browser cache cleared after test suite.");
	}

	private void clearBrowserCache() {
		try {
			driver.manage().deleteAllCookies();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.localStorage.clear();");
			js.executeScript("window.sessionStorage.clear();");
			js.executeScript(
					"caches.keys().then(function(keyList) { return Promise.all(keyList.map(function(key) { return caches.delete(key); })); });");
			logger.info("Browser cache cleared successfully.");
		} catch (Exception e) {
			logger.error("Failed to clear browser cache: " + e.getMessage());
		}
	}

	@AfterSuite
	public void tearDownExtentReport() {
		if (extent != null) {
			extent.flush();
		}
	}

	@AfterMethod
	public void recordResult(ITestResult result) {
	    String methodName = result.getMethod().getMethodName();
	    String screenshotPath = captureScreenshot(result.getStatus() == ITestResult.SUCCESS ? "PASSED"
	            : result.getStatus() == ITestResult.FAILURE ? "FAILED" : "SKIPPED", methodName);

	    if (screenshotPath != null && !screenshotPath.equals("Screenshot capture disabled")) { // Add null check
	        if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, "Test Passed: " + methodName,
	                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        } else if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, "Test Failed: " + methodName,
	                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.log(Status.SKIP, "Test Skipped: " + methodName,
	                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        }
	    } else {
	        if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, "Test Passed: " + methodName);
	        } else if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, "Test Failed: " + methodName);
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.log(Status.SKIP, "Test Skipped: " + methodName);
	        }
	    }

	    if (result.getStatus() == ITestResult.SUCCESS) {
	        logger.info("Test passed: " + methodName);
	        test.log(Status.INFO, "Log: " + "Test passed: " + methodName);
	    } else if (result.getStatus() == ITestResult.FAILURE) {
	        test.log(Status.FAIL, result.getThrowable());
	        logger.error("Test failed: " + methodName, result.getThrowable());
	        test.log(Status.FAIL, "Log: " + "Test failed: " + methodName + result.getThrowable());
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        logger.warn("Test skipped: " + methodName);
	        test.log(Status.WARNING, "Log: " + "Test skipped: " + methodName);
	    }
	}

	public String captureScreenshot( String status, String methodName) {
		if (!captureScreenshot) {
			return null; // Don't capture screenshots if disabled
		}
		String destFilePath = null;
		try {

			if (captureScreenshot) {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				destFilePath = System.getProperty("user.dir") + "/Screenshots/" + status + "/" + methodName + "_"
						+ timestamp + ".png";
				File destinationFile = new File(destFilePath);
				destinationFile.getParentFile().mkdirs(); // Ensure directory exists
				FileUtils.copyFile(srcFile, destinationFile);
			} else {
				logger.info("Screenshot capture is disabled in properties.");
				return "Screenshot capture disabled"; // Or any value to indicate no screenshot was taken.
			}

		} catch (IOException e) {
			logger.error("Error capturing screenshot: " + e.getMessage());
		}
		return destFilePath;
	}

	// Navigation Methods
	public void makemytripHomepage() {
		driver.navigate().to(PropertyUtility.getreadproperty("makemytrip"));
	}

	public void testingbabaHomepage() {
		driver.navigate().to(PropertyUtility.getreadproperty("testingbaba"));
	}

	public void flipkartHomepage() {
		driver.navigate().to(PropertyUtility.getreadproperty("flipkart"));
	}

}
