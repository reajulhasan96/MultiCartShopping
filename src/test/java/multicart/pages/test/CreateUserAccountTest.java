package multicart.pages.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import baseresources.OpenBrowser;
import multicart.pages.CreateAccount;
import multicart.pages.HomePage;
import multicart.pages.LogOut;
import multicartalldata.GetDataProperties;

public class CreateUserAccountTest extends GetDataProperties {
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@Test
	public void  createAccount() throws Exception {
	
		driver = browser.getBrowser(browser());
		browser.getURL(url());

		HomePage hp = new HomePage(driver);
		hp.clickOnLogInIcon();
		CreateAccount ca=hp.clickOnSignUp();

		ca.enterEmail(email("email2"));
		ca.enterUserName(userName("userName2"));
		ca.enterPassword(password("password2"));
		ca.enterConfirmPassword(password("password2"));
		ca.enterFirstName(firstName("firstName2"));
		ca.enterLastName(lastName("lastName2"));
		ca.enterAddress(address("address2"));
		ca.uncheckNotifications();
		ca.clickOnCreateAccount();
		
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();

		driver.close();

	}

}

