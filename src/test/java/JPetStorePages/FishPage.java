package JPetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishPage {
	WebDriver driver;

	// constructor

	public FishPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(xpath = "//*[@id='Catalog']/h3")
	public WebElement fishText;
	@FindBy(linkText = "FI-SW-01")
	public WebElement angelFish;
	@FindBy(xpath = "//*[@href=\"/cart/addItemToCart?itemId=EST-1\"]")
	public WebElement largeAngelFish;

	// methods

	public void validateFishPage() {
		String text = fishText.getText();
		Assert.assertEquals(text, "Fish");
	}

	public void clickOnAngelFish() throws InterruptedException {
		angelFish.click();
		Thread.sleep(3000);
	}

	public void clickOnLargeAngelFish() throws InterruptedException {
		largeAngelFish.click();
		Thread.sleep(3000);
	}

}
