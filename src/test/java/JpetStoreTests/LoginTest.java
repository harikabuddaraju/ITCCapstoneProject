package JpetStoreTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import JPetStorePages.HomePage;
import JPetStorePages.LoginPage;
import JPetStorePages.SignUpPage;
import JPetStorePages.WelcomePage;

public class LoginTest extends BaseTest {
	public static ExtentReports extent;
	public static ExtentTest test;
	private ExtentSparkReporter spark;
	HomePage hp;
	LoginPage lp;
	WelcomePage wp;
	SignUpPage sp;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		spark = new ExtentSparkReporter("./target/ExtentReportsGoogle1.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		System.out.println("setup method executed");
		getWebDriver();
	}

	@Test
	public void registrationForm() throws InterruptedException, IOException { // perform sign-up and sign-in
		test = extent.createTest("Google search");// crating an extent step in html
		test.log(Status.INFO, "Launched Browser");
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
