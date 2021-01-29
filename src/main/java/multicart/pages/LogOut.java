package multicart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class LogOut extends BaseUtillities {

	public LogOut(WebDriver driver) {
		super(driver);
	}

	private By nameIcon = By.id("dLabel");
	private By logOut = By.xpath("(//div[@class='login_sec2_inner']//a)[2]");


	public void clickOnNameIcon() {
		clickOn(nameIcon);
	}

	public void clickOnLogOut() {
		clickOn(logOut);
	}
	
	public boolean nameIconValidation() {
	boolean bl=	validationElementEnable(nameIcon);
	return bl;
	}

}
