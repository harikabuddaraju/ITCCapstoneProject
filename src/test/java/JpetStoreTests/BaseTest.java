package JpetStoreTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;

public class BaseTest {
	public WebDriver driver = null;

	public void webPagesIntialization() {

		driver = getWebDriver();
		// Initialize ExtentReports and attach the reporter
	}

	public WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		} else {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://jpetstore.aspectran.com/");
			return driver;
		}
	}

	public void closeBrowser() throws InterruptedException// close browser function
	{
		Thread.sleep(2000);
		driver.quit();
	}

	public void takeScreenShot() throws IOException {
		File src = null;
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./scrshot/" + "screenshot-" + System.currentTimeMillis() + ".png"));
	}
}
