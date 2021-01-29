package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportsDemo {
	
	ExtentReports extent;
	
	@BeforeTest

	public void config()

	{

	// ExtentReports , ExtentSparkReporter

	String path =System.getProperty("user.dir")+"\\extent_reports\\index.html";

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	reporter.config().setReportName("Web Automation Results");

	reporter.config().setDocumentTitle("Test Results");

	extent =new ExtentReports();

	
	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "SM Hasan");

	}

	@Test

	public void initialDemo()

	{

	//ExtentTest test= extent.createTest("Initial Demo");
	 extent.createTest("Initial Demo");

	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();

	driver.get("https://www.demo.iscripts.com/multicart/demo/");

	System.out.println(driver.getTitle());

	driver.close();

	//test.fail("Result do not match");

	extent.flush();

	}

}
