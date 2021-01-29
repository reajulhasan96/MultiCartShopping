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
import multicart.pages.LogOut;
import multicart.pages.SignIn;
import multicartalldata.GetDataProperties;

public class SignInSingleUserTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(SignInSingleUserTest.class.getName());
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}

	@Test()
	public void signIn() throws Exception {
		HomePage hp = new HomePage(driver);
		SignIn sp = hp.clickOnLogInIcon();
		sp.enterUsername(userName());
		sp.enterPassword(password());
		sp.clickOnLogIn();
		Assert.assertEquals(sp.nameOfUserReturnFromBrowser(), fullName());

	}

	@AfterTest
	public void logOut(){
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();

		driver.close();

	}

}
