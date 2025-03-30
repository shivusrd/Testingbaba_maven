package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyEventListener implements WebDriverListener


{
	
	
	@Override
    public void beforeClick(WebElement element) {
        System.out.println("Before clicking: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("After clicking: " + element);
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to: " + url);
    }

    // Override other methods as needed (e.g., beforeFindBy, afterFindBy, etc.)

}
