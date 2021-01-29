package multicart.pages.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseresources.OpenBrowser;
import extra.DataProviders;
import multicart.pages.HomePage;
import multicart.pages.LogOut;
import multicart.pages.SignIn;
import multicartalldata.GetDataProperties;

public class SignInMultipleUserTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(SignInMultipleUserTest.class.getName());
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}

	@Test(dataProvider = "userdata", dataProviderClass = DataProviders.class)
	public void signIn(String userName, String password, String profile)  {

		HomePage hp = new HomePage(driver);
		SignIn sp = hp.clickOnLogInIcon();
		sp.enterUsername(userName);
		sp.enterPassword(password);
		sp.clickOnLogIn();
		Assert.assertEquals(sp.nameOfUserReturnFromBrowser(), profile);
		log.info("\nSign In Completed");
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();
	}

	@AfterTest
	public void logOut() {

		driver.close();

	}

}
