package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;
public class MasterHooks extends DriverFactory {

	@Before()
	public void setup() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
	}
	@After()
	public void TearDownScreenshotOnFailure(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
//				driver.manage().deleteAllCookies();
//				driver.close();
//				driver.quit();
			}
			if (driver != null) {
//				driver.manage().deleteAllCookies();
//				driver.close();
//				driver.quit();
			}
		} catch (Exception e) {

			System.out.println("Method failed on TearDownScreenshotOnFailure" + e.getMessage());
		}

	}
}
