package JPetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;

	// constructor

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(linkText = "Proceed to Checkout")
	public WebElement proceedToCheckout;

	// methods

	public void clickOnProceedToCheckout() throws InterruptedException {
		proceedToCheckout.click();
		Thread.sleep(3000);
	}

}
