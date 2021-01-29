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

public class AddToCartMultipleProductTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(AddToCartMultipleProductTest.class.getName());
	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;

	@BeforeTest
	public void signIn() throws Exception {
		driver=browser.getBrowser(browser());
		browser.getURL(url());
		
		HomePage hp = new HomePage(driver);
		SignIn sp=hp.clickOnLogInIcon();

		sp.enterUsername(userName("userName2"));
		sp.enterPassword(password("password2"));
		sp.clickOnLogIn();
		Assert.assertEquals(sp.nameOfUserReturnFromBrowser(), fullName("fullName2"));
	}

	@Test(dataProvider = ("product"), dataProviderClass = DataProviders.class, priority = 2)
	public void addToCart(String prdName, String Quantity, String Amount) throws Exception  {

		SimpleAdding sa = new SimpleAdding(driver);
		sa.enterProductName(prdName);
		sa.enterQtyOfProductsAndClickBuyNow(Quantity);
		Assert.assertEquals(sa.totalAmountReturnsFromBrowser(), Amount);
		log.info("\nTotal Amount Expected From User: "+Amount+"\n");
		log.info("\nTotal Amount Returns From Browser: "+sa.totalAmountReturnsFromBrowser()+"\n");
		sa.deleteProductFromCart();
		log.info("\nProducts Deleted From Cart Successfully\n");
		sa.clickOnContinueShopping();

	}
	
	@AfterTest
	public void logOut() {
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();

		driver.close();

	}

}
