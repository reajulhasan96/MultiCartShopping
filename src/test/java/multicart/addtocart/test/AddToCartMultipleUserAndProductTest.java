package multicart.addtocart.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseresources.OpenBrowser;
import extra.DataProviders;
import multicart.addtocart.resources.SimpleAdding;
import multicart.pages.HomePage;
import multicart.pages.LogOut;
import multicart.pages.SignIn;
import multicartalldata.GetDataProperties;

public class AddToCartMultipleUserAndProductTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(AddToCartMultipleUserAndProductTest.class.getName());
	
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeTest
	public void homePage() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}

	@Test(priority = 1, dataProvider = ("multidata"), dataProviderClass = DataProviders.class)
	public void signIn(String userName, String password, String profile, String prodName, String Quantity,
			String totalAmount) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		SignIn sp = hp.clickOnLogInIcon();;
		sp.enterUsername(userName);
		sp.enterPassword(password);
		sp.clickOnLogIn();
		Assert.assertEquals(sp.nameOfUserReturnFromBrowser(), profile);
		log.info("\nUser's Profile Name Expected From User: "+profile+"\n");
		log.info("\nUser's Profile Name Returns From Browser: "+sp.nameOfUserReturnFromBrowser()+"\n");

		SimpleAdding sa = new SimpleAdding(driver);
		sa.enterProductName(prodName);
		sa.enterQtyOfProductsAndClickBuyNow(Quantity);
		Assert.assertEquals(sa.totalAmountReturnsFromBrowser(), totalAmount);
		log.info("\nTotal Amount Expected From User: "+totalAmount+"\n");
		log.info("\nTotal Amount Returns From Browser: "+sa.totalAmountReturnsFromBrowser()+"\n");
		sa.deleteProductFromCart();
		log.info("\nProducts Deleted From Cart Successfully\n");
		sa.clickOnContinueShopping();
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();

	}

	@AfterTest
	public void logOut() {
		driver.close();

	}

}
