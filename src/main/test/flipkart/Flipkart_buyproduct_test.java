package flipkart;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import baselibrary.Baselibrary;
import pages.Flipkart_buyproduct_page;
import propertyutility.PropertyUtility;

public class Flipkart_buyproduct_test extends Baselibrary

{
	private static final String FLIPKART_URL_KEY = "Flipkart";
	private static final String REGRESSION_GROUP = "Regression";

	private Flipkart_buyproduct_page flipkartBuyProductPage;
	private SoftAssert softAssert;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void launchFlipkart(String browser, String url) {
		try {
			String expectedUrl = PropertyUtility.getreadproperty(FLIPKART_URL_KEY);
			if (url.equalsIgnoreCase(expectedUrl)) {
				driver.get(expectedUrl);
			} else {
				driver.quit();
			}
			flipkartBuyProductPage = new Flipkart_buyproduct_page();
			softAssert = new SoftAssert();
		} catch (Exception e) {
			throw new RuntimeException("Failed to launch Flipkart", e);
		}
	}

	@Test(groups = REGRESSION_GROUP)
	public void verifyProductSearchAfterLogin() {
		try {
			flipkartBuyProductPage.loginAndSearchProduct();
		} catch (Exception e) {
			softAssert.fail("Product search test after login failed: " + e.getMessage());
		}
		softAssert.assertAll();
	}
}
