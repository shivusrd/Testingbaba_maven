package listeners;

import java.io.IOException;

import org.jsoup.Connection.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baselibrary.Baselibrary;

public class Listners implements ITestListener {
	
	
	
	Baselibrary p=new Baselibrary();

	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			p.getScreenshot(result.getName());
		
		} 
		
		catch (IOException e) 
		
		{
			
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

