package JPetStorePages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	String name, psw;

	public LoginPage(WebDriver driver) throws FileNotFoundException // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		FileInputStream fis = new FileInputStream("./data.properties");
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		name = prop.getProperty("username");
		psw = prop.getProperty("password");
	}

	// web elements

	@FindBy(xpath = "//input[@name='username']")
	public WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//*[contains(text(),'Login')]")
	public WebElement loginButton;

	// methods

	public void login() throws InterruptedException {
		username.clear();
		username.sendKeys(name);
		password.clear();
		password.sendKeys(psw);
		loginButton.click();

	}
}
