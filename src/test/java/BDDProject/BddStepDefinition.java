package BDDProject;
 
import java.io.FileNotFoundException;
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class BddStepDefinition {
 
    WebDriver driver;
    JPetStoreFunctions jpf;
 
    @When("User launch the Browser and Url")
    public void userlaunchBrowserAndUrl() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Launch the Chrome Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jpetstore.aspectran.com/");
    }
 
    @When("Login to the JPetStore web application")
    public void userLoginToJPetStoreApp() throws InterruptedException, FileNotFoundException {
        jpf = new JPetStoreFunctions(driver);
        jpf.clickOnSignIn();
        jpf.login();
    }
 
    @Then("User validate {string} as page heading in JpetStore Order list page")
    public void userValidatePageHeadingInOrderListPage(String pageHeading)
            throws FileNotFoundException, InterruptedException {
        jpf = new JPetStoreFunctions(driver);
        jpf.validatePageHeading(pageHeading);
    }
 
    @When("User close the Browser")
    public void userCloseBrowser() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }
 
    @When("User login with incorrect credentials in JPetStore web application")
    public void userLoginWithIncorrectCredentials() throws FileNotFoundException, InterruptedException {
        jpf = new JPetStoreFunctions(driver);
        jpf.clickOnSignIn();
        jpf.incorrectLogin();
    }
 
    @Then("User validate {string} as error message in JpetStore login page")
    public void userValidateErrorMessageInLoginPage(String errorMessage)
            throws FileNotFoundException, InterruptedException {
        jpf = new JPetStoreFunctions(driver);
        jpf.validateErrorMessage(errorMessage);
    }
}