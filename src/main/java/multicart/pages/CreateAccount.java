package multicart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class CreateAccount extends BaseUtillities{

	public CreateAccount(WebDriver driver) {
		super(driver);
	}

	private By emailAddress = By.id("txtEmail");
	private By uName = By.id("txtUserName");
	private By createPassword = By.id("txtPassword");
	private By cnfPassword = By.id("txtCnfPassword");
	private By fName = By.id("txtFirstName");
	private By lName = By.id("txtLastName");
	private By location = By.xpath("//input[@placeholder='Address *']");
	private By notifaction = By.xpath("//input[@name='check_news']");
	private By createAccount = By.id("btnRegister");


	public void enterEmail(String email) {
		sendKeysTo(emailAddress, email);
	}

	public void enterUserName(String userName) {
		sendKeysTo(uName, userName);
	}

	public void enterPassword(String password) {
		sendKeysTo(createPassword, password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		sendKeysTo(cnfPassword, confirmPassword);
	}

	public void enterFirstName(String firstName) {
		sendKeysTo(fName, firstName);
	}

	public void enterLastName(String lastName) {
		sendKeysTo(lName, lastName);
	}

	public void enterAddress(String address) {
		sendKeysTo(location, address);
	}

	public void uncheckNotifications() {
		clickOn(notifaction);
	}

	public void clickOnCreateAccount() {
		clickOn(createAccount);
	}

}
