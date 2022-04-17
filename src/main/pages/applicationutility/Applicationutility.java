package applicationutility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baselibrary.Baselibrary;
import propertyutility.PropertyUtility;

public class Applicationutility extends Baselibrary

{
	public static String departureDate;
	public static String returnDate;

	/**************************************
	 * Function Name: All Generic actions for Website
	 * Author: Shivam
	 * Created Date: 2019-07-10
	 * Purpose: Insert a java variable to xpath 
	 * Prerequisites: Call these methods by Classname Applicationutility
	 * Change History:	  
	 * 
	 **************************************/

	public static void doubleclick(WebElement ele)

	{
		Actions act = new Actions(driver);
		act.doubleClick(ele);

	}

	public static void rightclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();

	}

	public static void changewindow(int tabno) {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(set);
		driver.switchTo().window(tabs.get(tabno));
	}

	public static void clickme(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();

	}

	public static void mousehover(WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}

	public static void mousehoverclick(WebElement ele, String linktext) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(linktext)).click();
	}

	public static void getscroll(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);

		} catch (Exception e) {
			System.out.println("Issue in Getscroll " + e);
		}

	}

	public static void fileupload(String filename) {
		try

		{
			StringSelection sel = new StringSelection(filename);
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(sel, null);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e)

		{

		}

	}
	/**************************************
	 * Function Name: getCurrentAndReturnDates
	 * Author: Shivam
	 * Created Date: 2019-07-10
	 * Purpose: Get the current date and another date that is x(from property file) days from today
	 * Prerequisites: numeric value for x
	 * Change History:	
	 * getCurrentAndReturnDates() should be called to assign the values to departureDate and returnDate
	 * 
	 **************************************/

	
	public static  Applicationutility getCurrentAndReturnDates() 
	{
		Applicationutility date = new Applicationutility();
		Calendar cal=Calendar.getInstance();
		
		cal.add(Calendar.DATE, 1); // please delete this line. added for test the tomorrow date.
		
		String[] dateArr=cal.getTime().toString().split(" ");
		Applicationutility.departureDate=dateArr[0]+" "+dateArr[1]+" "+dateArr[2]+" "+dateArr[5];
		cal.add(Calendar.DATE, Integer.parseInt(PropertyUtility.getreadproperty("NoOfdays")));
		dateArr=cal.getTime().toString().split(" ");
		Applicationutility.returnDate=dateArr[0]+" "+dateArr[1]+" "+dateArr[2]+" "+dateArr[5];
		return date;
	}
	
	
	
	/**************************************
	 * Function Name: customXpath
	 * Author: Shivam
	 * Created Date: 2019-07-10
	 * Purpose: Insert a java variable to xpath 
	 * Prerequisites: 
	 * Change History:	  
	 * 
	 **************************************/
	public static By customXpath(String xpath, String param) {
		String rawPath = xpath.replaceAll("%replace%", param);
		return By.xpath(rawPath);
	}

}
