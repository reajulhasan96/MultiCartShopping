package multicart.pages.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseresources.OpenBrowser;
import multicart.pages.HomePage;
import multicartalldata.GetDataProperties;


public class HomePageTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(HomePageTest.class.getName());
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}
	
	@Test
	public void homePage() {

		HomePage hp = new HomePage(driver);
		hp.clickOnLogInIcon();
		hp.clickOnSignUp();
		Assert.assertTrue(hp.logoValidation());
		// Assert.assertFalse(hp.logoValidation());
		driver.navigate().back();
		hp.clickOnLogInIcon();
		log.info("\nHome Page Tested Succesfully");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
