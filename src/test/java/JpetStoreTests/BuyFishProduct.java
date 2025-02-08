package JpetStoreTests;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import JPetStorePages.FishPage;
import JPetStorePages.HomePage;
import JPetStorePages.LoginPage;
import JPetStorePages.PaymentPage;
import JPetStorePages.ShoppingCartPage;
import JPetStorePages.WelcomePage;

public class BuyFishProduct extends BaseTest {
	HomePage hp;
	LoginPage lp;
	WelcomePage wp;
	FishPage fs;
	ShoppingCartPage sc;
	PaymentPage pp;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		getWebDriver();
	}

	@Test(priority = 0)

	public void loginAndClickOnFishProduct() throws InterruptedException, IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		wp = new WelcomePage(driver);
		fs = new FishPage(driver);
		sc = new ShoppingCartPage(driver);
		pp = new PaymentPage(driver);
		hp.click();
		lp.login();
		wp.clickOnFish();
		fs.validateFishPage();
	}

	@Test(priority = 1)

	public void addAngelFishToCart() throws InterruptedException {
		fs = new FishPage(driver);
		sc = new ShoppingCartPage(driver);
		pp = new PaymentPage(driver);
		fs.clickOnAngelFish();
		fs.clickOnLargeAngelFish();
		sc.clickOnProceedToCheckout();
		pp.clickOnContinueButton();
		pp.clickOnorderConfirmButton();
		pp.validateOrderCofirmMsg();
	}

	@AfterTest

	public void close() throws InterruptedException {
		closeBrowser();
	}
}
