package baselibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Flipkart_baselibrary


{
    public static WebDriver driver;
	
	public void getflipkarturl (String url1)
	{
		driver = new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		
		
	}
	
	@AfterTest
	
	public void Teardown()
	{
		driver.quit();
		
	}

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
