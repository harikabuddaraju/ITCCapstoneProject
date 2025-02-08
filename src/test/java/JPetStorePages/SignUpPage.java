package JPetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SignUpPage {

	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(xpath = "//a[text()='Sign Up']")
	public WebElement signIn;
	@FindBy(xpath = "//*[text()='User Information']")
	public WebElement formTitle;
	@FindBy(name = "username")
	public WebElement uname;
	@FindBy(name = "password")
	public WebElement pwd;
	@FindBy(name = "repeatedPassword")
	public WebElement confirmPwd;
	@FindBy(name = "firstName")
	public WebElement firstName;
	@FindBy(name = "lastName")
	public WebElement lastName;
	@FindBy(name = "email")
	public WebElement email;
	@FindBy(name = "phone")
	public WebElement phone;
	@FindBy(name = "address1")
	public WebElement address1;
	@FindBy(name = "address2")
	public WebElement address2;
	@FindBy(name = "city")
	public WebElement city;
	@FindBy(name = "state")
	public WebElement state;
	@FindBy(name = "zip")
	public WebElement zip;
	@FindBy(name = "country")
	public WebElement country;
	@FindBy(xpath = "//button[text()='Save Account Information']")
	public WebElement submitBtn;
	@FindBy(xpath = "//p[text()='Your account has been created. Please try login.']")
	public WebElement accountCreationMsg;
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginbtn;
	@FindBy(id = "WelcomeContent")
	public WebElement welcomeMsg;

	// methods

	public void clickSignIn() throws InterruptedException {
		Thread.sleep(1000);
		signIn.click();
		Reporter.log("SignIn is clicked");
		Thread.sleep(2000);
		Assert.assertTrue(formTitle.isDisplayed(), "Form title not displayed");
	}

	public static String generateRandomString(int length) {
		// Define the characters that can be used in the random string
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		// StringBuilder for efficiently building the random string
		StringBuilder sb = new StringBuilder(length);
		// Loop to generate each character of the random string
		for (int i = 0; i < length; i++) {
			// Generate a random index between 0 and characters.length() - 1
			int index = (int) (Math.random() * characters.length());
			// Append the character at the generated index to the StringBuilder
			sb.append(characters.charAt(index));
		}
		// Convert the StringBuilder to a String and return it
		return sb.toString();
	}

	public String fillUserInformation() {
		uname.clear();
		int length = 10; // Length of the random string
		String randomString = "admin" + generateRandomString(length); // Generate random string
		System.out.println("Random String: " + randomString); // Print the random string
		uname.sendKeys(randomString);
		pwd.clear();
		pwd.sendKeys("admin");
		confirmPwd.clear();
		confirmPwd.sendKeys("admin");
		return randomString;
	}

	public void fillAccountInformation() throws InterruptedException {
		firstName.sendKeys("Michael");
		lastName.sendKeys("Cole");
		email.sendKeys("michaelcole@abc.com");
		phone.sendKeys("9988776655");
		address1.sendKeys("Pretige Park");
		address2.sendKeys("Newland");
		city.sendKeys("Miami");
		state.sendKeys("FLorida");
		zip.sendKeys("32003");
		country.sendKeys("US");
		submitBtn.click();
		Thread.sleep(3000);
		Assert.assertTrue(accountCreationMsg.isDisplayed(), "Account not created");
		Reporter.log("Account Successfully Created");
	}

	public void signIn(String username) throws InterruptedException {
		uname.clear();
		uname.sendKeys(username);
		pwd.clear();
		pwd.sendKeys("admin");
		loginbtn.click();
		Thread.sleep(2000);
		String expectedMsg = "Welcome Michael!";
		expectedMsg = expectedMsg.trim();
		String actualMsg = welcomeMsg.getText().trim();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("ActualMsg:: " + actualMsg + " :: +" + " ExpectedMsg:: " + expectedMsg);
		Reporter.log("ActualMsg:: " + actualMsg + " :: +" + " ExpectedMsg:: " + expectedMsg);
		Thread.sleep(1000);
	}
}
