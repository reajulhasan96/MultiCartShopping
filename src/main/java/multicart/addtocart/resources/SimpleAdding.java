package multicart.addtocart.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class SimpleAdding extends BaseUtillities {

	public SimpleAdding(WebDriver driver) {
		super(driver);
	}

	By listOfProducts = By.xpath("//div[@class='products']//h5//a");
	By qtyItem = By.id("txtQty");
	By buyNow = By.xpath("//button[@onclick='addToCart()']");
	By totalPrice = By.xpath("//td[@class='total_td_right']");
	By continueShopping = By.xpath("//input[@value='Continue Shopping']");
	By checkProduct = By.xpath("//input[@name='chkitems[]']");
	By deleteProduct = By.xpath("//input[@name='btnDeleteSelected']");
	
	

	public void enterProductName(String productName) throws InterruptedException {
		getSingleElementFromMultiple(listOfProducts, productName);
		Thread.sleep(2000);
	}
	
	public void enterQtyOfProductsAndClickBuyNow (String productQunatity) {
		clearElement(qtyItem);
		sendKeysTo(qtyItem, productQunatity);
		clickOn(buyNow);
		
	}
	
	public String totalAmountReturnsFromBrowser() {
		String totalAmount =getText(totalPrice);
		return totalAmount;
	}
	
	public void deleteProductFromCart() {
		clickOn(checkProduct);
		clickOn(deleteProduct);
	}
	public void clickOnContinueShopping() {
		clickOn(continueShopping);
	}

}
