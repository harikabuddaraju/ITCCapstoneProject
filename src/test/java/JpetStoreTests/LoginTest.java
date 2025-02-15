package JpetStoreTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import JPetStorePages.HomePage;
import JPetStorePages.LoginPage;
import JPetStorePages.SignUpPage;
import JPetStorePages.WelcomePage;

public class LoginTest extends BaseTest {
	HomePage hp;
	LoginPage lp;
	WelcomePage wp;
	SignUpPage sp;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		getWebDriver();
	}

	@Test
	public void registrationForm() throws InterruptedException, IOException { // perform sign-up and sign-in
		sp = new SignUpPage(driver);
		sp.clickSignIn();
		String userName = sp.fillUserInformation();
		Reporter.log("Username :: " + userName);
		sp.fillAccountInformation();
		sp.signIn(userName);
		takeScreenShot();
	}

	@AfterTest

	public void close() throws InterruptedException {
		closeBrowser();
	}
}
