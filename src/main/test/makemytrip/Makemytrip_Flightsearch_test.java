package makemytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import baselibrary.Baselibrary;
import pages.Makemytrip_Search_Flight;
import propertyutility.PropertyUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Makemytrip_Flightsearch_test extends Baselibrary

{
	private static final Logger logger = LogManager.getLogger(Makemytrip_Flightsearch_test.class);
	Makemytrip_Search_Flight ob;

	@Parameters({ "browser", "url" })
	@BeforeTest

	public void launchMakeMytrip(String browser, String url) {
		String makemytrip = PropertyUtility.getreadproperty("makemytrip");

		if (url.equalsIgnoreCase(makemytrip)) {

			// Initializing the firefox driver (Gecko)
			driver.get(makemytrip);
			logger.info("Starting website");
		}

		else {

			// Initialize the chrome driver

			logger.error("Wrong url used for Testing");
			driver.quit();
		}

		ob = new Makemytrip_Search_Flight();
	}

	@Test(priority = 0, groups = "Functional testing")
	public void SearchFlightToday() throws InterruptedException {
		ob.ClickOnFlight();
		ob.enterDepartureDate();
		ob.enterReturnDate();
		ob.clicksearch();

	}

}
