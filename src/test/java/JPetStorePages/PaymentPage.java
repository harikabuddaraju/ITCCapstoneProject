package JPetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class PaymentPage {
	WebDriver driver;

	// constructor

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement continueButton;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebElement orderConfirmButton;
	@FindBy(xpath = "//div[@id='MessageBar']/p")
	public WebElement orderConfirmMsg;

	// methods

	public void clickOnContinueButton() throws InterruptedException {
		continueButton.click();
		Thread.sleep(3000);
	}

	public void clickOnorderConfirmButton() throws InterruptedException {
		orderConfirmButton.click();
		Thread.sleep(3000);
	}
	
	public void validateOrderCofirmMsg() {
		String msg=orderConfirmMsg.getText();
		Assert.assertEquals(msg, "Thank you, your order has been submitted.");
		Assert.assertTrue(orderConfirmMsg.isDisplayed(), "Thank you, your order has been submitted.");
		Reporter.log("Thank you, your order has been submitted.");
	}

}
