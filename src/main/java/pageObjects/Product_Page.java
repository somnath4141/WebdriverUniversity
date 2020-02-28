package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_Page extends BasePage {

	public @FindBy(css = "#container-special-offers") WebElement button_specialoffer;
	public @FindBy(css = "#container-product2") WebElement button_laptop;
	public @FindBy(xpath = ".//*[@id='myModal']//b[contains(text(),'NEWCUSTOMER')]") WebElement vovucherNo;
	public @FindBy(xpath = ".//button[text()='Proceed']") WebElement button_proceed_popup;
	public Product_Page() throws IOException {
	super();
	}
	public Product_Page clickOnProceedButton_Popup() throws IOException, InterruptedException {
		waitAndClickElement(button_proceed_popup);
		return new Product_Page();
	}
	public String printSpecialOffersVoucherCode() throws InterruptedException {
		WaitUntilWebElementIsVisible(vovucherNo);
		String voucherCodeValue = vovucherNo.getText();
		System.out.println("Voucher Code: " + vovucherNo.getText());
		return voucherCodeValue;
	}
}
