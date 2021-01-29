package multicart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class SignIn extends BaseUtillities {	

	public SignIn(WebDriver driver) {
		super(driver);
	}

	private By uName = By.id("username");
	private By pass = By.id("password");
	private By logIn = By.id("jqLogin");
	private By verifyUser = By.id("dLabel");


	public void enterUsername(String userName) {
		sendKeysTo(uName, userName);
	}

	public void enterPassword(String passcode) {
		sendKeysTo(pass, passcode);
	}
	
	public String nameOfUserReturnFromBrowser() {
		String nameOfUser=getText(verifyUser);
		return nameOfUser;
	}

	public void clickOnLogIn() {
		clickOn(logIn);
	}

}
