package ExtentTest;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class GoogleDemo {
	public static ExtentReports extent;
    public static ExtentTest test;
    private ExtentSparkReporter spark;
    WebDriver driver;
	@BeforeTest
	public void setup()
	{
		// Initialize ExtentReports and attach the reporter
        spark = new ExtentSparkReporter("./target/ExtentReportsGoogle.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        System.out.println("setup method executed");
	}
	@Test
	public void search() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();//maximize the window size
		test = extent.createTest("Google search");//crating an extent step in html
		driver.get("https://www.google.com/");//enter the url		
		test.log(Status.INFO, "Navigated to Google");
		Thread.sleep(2000);//sleep for 2 seconds
		String title = driver.getTitle();
		test.log(Status.INFO, "Page title is: " + title);
		//Identify the web-element/object search box of google & perform the action
		//WebElement search = driver.findElement(By.name("q"));
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("selenium");//word that you want to search
		//To find all the elements which return more than one
		List<WebElement> suggestions= driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		Thread.sleep(2000);
		System.out.println(suggestions.size());//Total no of suggestions 
		//Print all the suggestions - google
		//for(WebElement sug:suggestions)
		for(int i=0;i<suggestions.size();i++)
		{
			//System.out.println(suggestions.getText());//print the suggestions
			String suggestion=suggestions.get(i).getText();
			System.out.println(suggestion);
			//condition inside the for loop
			if(suggestion.contains("selenium webdriver"))
			{
				suggestions.get(i).click();//click action for the keyword
				 test.log(Status.PASS, "Keyword matched");
				break;
			}
			else
			{
				System.out.println("Keyword is not matching");
				test.log(Status.INFO, "Keyword did not matched");
			}
		}
		//how to identify and click one of the suggestions -> from google 
		//search.sendKeys(Keys.ENTER);//key board enter
	}
	@AfterTest
	public void close() throws InterruptedException {
	    extent.flush();//push all the log steps into the html file
	     Thread.sleep(2000);
		driver.close();
	}
 
	
}