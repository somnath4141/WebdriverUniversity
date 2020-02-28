package pageObjects;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import cucumber.api.DataTable;
public class ContactUS_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_submit;
	public ContactUS_Page() throws IOException {
		super();
	}
	public ContactUS_Page getContactUSPage() throws IOException, InterruptedException {
		Thread.sleep(300);
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUS_Page();
	}
	public ContactUS_Page enterFirstName() throws Exception {
		sendKeysToWebElement(textfield_FirstName, "Tom");
		return new ContactUS_Page();
	}
	public ContactUS_Page enterLastName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUS_Page();
	}
	public ContactUS_Page enterEmailAddress(String email) throws Exception {
		sendKeysToWebElement(textfield_EmailAddress, email);
		return new ContactUS_Page();
	}
	
	public ContactUS_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_message, data.get(row).get(column));
		return new ContactUS_Page();
	}
	public ContactUS_Page ClickonSubmitButton() throws Exception {
		waitAndClickElement(button_submit);
		return new ContactUS_Page();
	}
	public ContactUS_Page ConfirmContactUsSuccesfull() throws Exception {
		WebElement thankyouContactUs = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
		WaitUntilWebElementIsVisible(thankyouContactUs);
		Assert.assertEquals("thankyouforyourmessage!",
				thankyouContactUs.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUS_Page();
	}
}