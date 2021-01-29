package baseresources;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtillities extends OpenBrowser {

	public Logger log = LogManager.getLogger(BaseUtillities.class.getName());
	
	
	public BaseUtillities(WebDriver driver) {
		OpenBrowser.driver = driver;
	}
	
	public void closeBrowser() {
		driver.close();
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void clickOn(By locator) {
		getElement(locator).click();
	}
	
	public void clearElement(By locator) {
		getElement(locator).clear();
	}

	public void sendKeysTo(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}
	
	public String getText(By locator) {
		String text = getElement(locator).getText();
		return text;
	}

	public void timeWait(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void selectDropDown(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public boolean validationElementDisplay(By locator) {
		boolean bl = getElement(locator).isDisplayed();
		return bl;
	}
	
	public boolean validationElementEnable(By locator) {
		boolean bl = getElement(locator).isEnabled();
		return bl;
	}

	public void getSize(By locators) {
		List<WebElement> options = driver.findElements(locators);
		int count = options.size();
		log.info("Total Count: " + count);
	}

	public void multiClick(By locator, int count) {
		for (int i = 0; i < count; i++) {
			clickOn(locator);
		}
	}

	public static String screenShotPath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
//		FileUtils.copyFile(src, new File("C:\\Users\\hasan//ScreenShot.png"));
		return destinationFile;
	}
	
	public void getSingleElementFromMultiple(By locators, String value) {
		List<WebElement> options = driver.findElements(locators);
		for (WebElement option : options) {
			if (option.getText().contains(value)) {
				option.click();
				break;
			}
		}
	}

	public void getMouseMovementElement(By firstLocator, String value, By secondLocator){
		List<WebElement> options = driver.findElements(firstLocator);
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			if (option.contains(value)) {
				WebElement element = driver.findElements(secondLocator).get(i);
				Actions act = new Actions(driver);
				act.moveToElement(element).click().build().perform();
				
				break;
			}
		}
	}

	public void getMultiCheckBox(By locator, String... value) {
		List<WebElement> allCheckBoxs = driver.findElements(locator);

		for (WebElement singleCheckBox : allCheckBoxs) {
			for (int i = 0; i < value.length; i++) {
				if (singleCheckBox.getText().equalsIgnoreCase(value[i])) {
					singleCheckBox.click();
					break;
				}
			}
		}
	}
}
