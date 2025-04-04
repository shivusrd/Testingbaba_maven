package flipkart;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import baselibrary.Baselibrary;
import pages.Flipkart_buy_page;
import propertyutility.PropertyUtility;

public class Flipkart_buy_test extends Baselibrary {

	private static final Logger logger = LogManager.getLogger(Flipkart_buy_test.class);
    private static final String FLIPKART_URL_KEY = "Flipkart";
    private static final String SMOKE_GROUP = "smoke";

    private Flipkart_buy_page flipkartBuyPage;
    private SoftAssert softAssert;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void launchFlipkart(String browser, String url) {
        try {
            String expectedUrl = PropertyUtility.getreadproperty(FLIPKART_URL_KEY);
            if (url.equalsIgnoreCase(expectedUrl)) {
                driver.get(expectedUrl);
                logger.info("Navigated to Flipkart URL: " + expectedUrl);
            } else {
                logger.error("Wrong URL used for testing. Expected: " + expectedUrl + ", Actual: " + url);
                driver.quit();
            }
            flipkartBuyPage = new Flipkart_buy_page();
            softAssert = new SoftAssert();
        } catch (Exception e) {
            logger.error("Failed to launch Flipkart: " + e.getMessage());
            throw new RuntimeException("Failed to launch Flipkart", e);
        }
    }

    @Test(groups = SMOKE_GROUP)
    public void verifyFlipkartLogin() {
        try {
            logger.info("Starting Flipkart login test");
            flipkartBuyPage.loginToFlipkart();
            logger.info("Flipkart login test completed");
        } catch (Exception e) {
            logger.error("Flipkart login test failed: " + e.getMessage());
            softAssert.fail("Flipkart login test failed: " + e.getMessage());
        }
        softAssert.assertAll();
    }

    @Test(groups = SMOKE_GROUP)
    public void verifyProfileFirstNameChange() {
        try {
            logger.info("Starting Flipkart profile first name change test");
            flipkartBuyPage.changeFirstNameInProfile();
            logger.info("Flipkart profile first name change test completed");
        } catch (Exception e) {
            logger.error("Flipkart profile first name change test failed: " + e.getMessage());
            softAssert.fail("Flipkart profile first name change test failed: " + e.getMessage());
        }
        softAssert.assertAll();
    }
}
