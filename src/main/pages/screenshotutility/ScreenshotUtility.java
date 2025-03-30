package screenshotutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import baselibrary.Baselibrary;

public class ScreenshotUtility extends Baselibrary

{

	 public static void getScreenshot(String foldername, String filename) {
	        String location = System.getProperty("user.dir");
	        try {
	            String path = location + "\\Screenshots\\" + foldername + "\\" + filename + ".jpeg";

	            // Use EventFiringDecorator to wrap the WebDriver
	            WebDriver decoratedDriver = new EventFiringDecorator(new MyEventListener()).decorate(driver);

	            File src = ((org.openqa.selenium.TakesScreenshot) decoratedDriver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(src, new File(path));
	        } catch (IOException e) {
	            System.out.println("Issue in getScreenshot: " + e);
	        } catch (ClassCastException e) {
	            System.out.println("WebDriver instance does not support screenshots: " + e);
	        }
	    }

	    //inner class to implement the WebDriverListener
	    public static class MyEventListener implements org.openqa.selenium.support.events.WebDriverListener {

	    }
}
