package multicart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class HomePage extends BaseUtillities{


	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By logInIcon = By.xpath("//span[contains(text(),'Login')]");
	private By signUp = By.xpath("//button[contains(text(),'Sign up')]");
	private By logo = By.xpath("//img[@class='img-responsive']");
	private By forgotPass = By.xpath("//a[contains(text(),'Forgot Password ?')]");


	public SignIn clickOnLogInIcon() {
		clickOn(logInIcon);
		return new SignIn(driver);
	}

	public CreateAccount clickOnSignUp() {
		clickOn(signUp);
		return new CreateAccount(driver);
	}
	
	public ForgotPassword resetPassword() {
		clickOn(logInIcon);
		clickOn(forgotPass);
		return new ForgotPassword(driver);
	}

	public boolean logoValidation() {
		boolean bl = validationElementDisplay(logo);
		return bl;
	}

}
