package multicart.addtocart.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAddingRough {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demo.iscripts.com/multicart/demo/");
		Thread.sleep(3000);

		By listOfProducts = By.xpath("//div[@class='products']//h5//a");
		By shopNow = By.xpath("//a[@class='adtocart add_cart_small']");

		List<WebElement> options = driver.findElements(listOfProducts);
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			if (option.contains("CANDY")) {
				Actions act = new Actions(driver);
				act.moveToElement(options.get(i)).click().build().perform();
			WebElement element = driver.findElements(shopNow).get(i);
				act.moveToElement(element).click().build().perform();

				break;
			}

		}
	}
}
