package multicart.addtocart.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseresources.OpenBrowser;
import multicart.addtocart.resources.SimpleAdding;
import multicart.pages.HomePage;
import multicart.pages.LogOut;
import multicart.pages.SignIn;
import multicartalldata.GetDataProperties;

public class AddToCartSingleUserTest extends GetDataProperties {
	public Logger log = LogManager.getLogger(AddToCartSingleUserTest.class.getName());

	OpenBrowser browser = new OpenBrowser();
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Exception {
		driver = browser.getBrowser(browser());
		browser.getURL(url());
	}

	@Test
	public void addToCart()throws Exception{
		HomePage hp = new HomePage(driver);
		SignIn sp = hp.clickOnLogInIcon();
		sp.enterUsername(userName());
		sp.enterPassword(password());
		sp.clickOnLogIn();
		Assert.assertEquals(sp.nameOfUserReturnFromBrowser(), fullName());
		log.info("\nUser's Profile Name Expected From User: "+fullName()+"\n");
		log.info("\nUser's Profile Name Ret urns From Browser: "+sp.nameOfUserReturnFromBrowser()+"\n");
		
		SimpleAdding sa = new SimpleAdding(driver);
		sa.enterProductName(productName());
		sa.enterQtyOfProductsAndClickBuyNow(quantity());
		Assert.assertEquals(sa.totalAmountReturnsFromBrowser(), totalAmount());
		log.info("\nTotal Amount Expected From User: "+totalAmount()+"\n");
		log.info("\nTotal Amount Returns From Browser: "+sa.totalAmountReturnsFromBrowser()+"\n");
		sa.deleteProductFromCart();
		log.info("\nProducts Deleted From Cart Successfully\n");
		sa.clickOnContinueShopping();

	}
	@AfterClass
	public void logOut() {
		LogOut lp = new LogOut(driver);
		lp.clickOnNameIcon();
		lp.clickOnLogOut();

		driver.close();

	}

}
