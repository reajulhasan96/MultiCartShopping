package multicart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseresources.BaseUtillities;

public class ForgotPassword extends BaseUtillities {

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	private By emailAddress = By.xpath("//input[@placeholder='Registered Email']");
	private By submit = By.xpath("//input[@name='btnResetPassword']");
	private By text = By.xpath("//div[@class='text_information']");
	
	public void enterUserEmail(String email) {
		sendKeysTo(emailAddress, email);
	}
	
	public void resetPasscode() {
		clickOn(submit);
	}
	
	public void textInfo() {
		String msg = getText(text);
		log.info("Forget Password User Validation: "+msg);
	}
	
	

}
