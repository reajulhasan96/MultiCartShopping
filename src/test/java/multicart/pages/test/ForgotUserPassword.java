package multicart.pages.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseresources.OpenBrowser;
import multicart.pages.*;
import multicartalldata.GetDataProperties;

public class ForgotUserPassword extends GetDataProperties {

	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}
	
	@Test
	public void forgotPassword() throws Exception {

		HomePage hp = new HomePage(driver);
		ForgotPassword fp = hp.resetPassword();
		fp.enterUserEmail(email());
		fp.resetPasscode();
		fp.textInfo();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
