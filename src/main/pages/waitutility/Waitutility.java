package waitutility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baselibrary.Baselibrary;

public class Waitutility extends Baselibrary

{
	static WebDriverWait wait = null;

	public static void alertIsPresent(int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void visibilityOfElement(int timeInSeconds, WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

}
