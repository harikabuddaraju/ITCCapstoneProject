package JPetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	WebDriver driver;

	public WelcomePage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(xpath = "//div[@id='WelcomeContent']")
	public WebElement welcomeContent;
	@FindBy(linkText = "My Account")
	public WebElement myAccount;
	@FindBy(linkText = "Fish")
	public WebElement fish;

	// method or function

	public void validateWelcomePage() {
		String text = welcomeContent.getText();
		text.contains("Welcome");
		System.out.println(text);
	}

	public void clickOnFish() throws InterruptedException {
		fish.click();
		Thread.sleep(3000);
	}
}
