package stepDefinitions;
import java.io.IOException;

import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory  {
	
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws InterruptedException {
		getDriver().get(url);
	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String locator) throws InterruptedException {
		basepage.WaitUntilWebElementIsVisibleUsingByLocator(By.cssSelector(locator));
		getDriver().findElement(By.cssSelector(locator)).click();
	}

	@Then("^user should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException, IOException  {
		productpage.printSpecialOffersVoucherCode();
		productpage.clickOnProceedButton_Popup();
	}

}
