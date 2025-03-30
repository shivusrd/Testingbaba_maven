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
import org.testng.annotations.AfterSuite;
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
	public static final Logger logger = LogManager.getLogger(Baselibrary.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	static String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

	@BeforeSuite
	public void setupExtentReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Parameters("browser")
	@BeforeTest
	public void setupBrowser(String browser) {
		if ("chrome".equalsIgnoreCase(browser)) {
			logger.info("Starting Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browser)) {
			logger.info("Starting Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("edge".equalsIgnoreCase(browser)) {
			logger.info("Starting Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed.");
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

		test = extent.createTest(methodName);

		if (result.getStatus() == ITestResult.SUCCESS) {
			if (!screenshotPath.equals("Screenshot capture disabled")) {
				test.log(Status.PASS, "Test Passed: " + methodName,
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.log(Status.PASS, "Test Passed: " + methodName);
			}
			logger.info("Test passed: " + methodName);
			test.log(Status.INFO, "Log: " + "Test passed: " + methodName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			if (!screenshotPath.equals("Screenshot capture disabled")) {
				test.log(Status.FAIL, "Test Failed: " + methodName,
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.log(Status.FAIL, "Test Failed: " + methodName);
			}
			test.log(Status.FAIL, result.getThrowable());
			logger.error("Test failed: " + methodName, result.getThrowable());
			test.log(Status.FAIL, "Log: " + "Test failed: " + methodName + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			if (!screenshotPath.equals("Screenshot capture disabled")) {
				test.log(Status.SKIP, "Test Skipped: " + methodName,
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				test.log(Status.SKIP, "Test Skipped: " + methodName);
			}
			logger.warn("Test skipped: " + methodName);
			test.log(Status.WARNING, "Log: " + "Test skipped: " + methodName);
		}
	}

	public String captureScreenshot(String status, String methodName) {
		String destFilePath = null;
		try {
			String captureScreenshotsProperty = PropertyUtility.getreadproperty("captureScreenshots");
			boolean captureScreenshots = Boolean.parseBoolean(captureScreenshotsProperty);

			if (captureScreenshots) {
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
