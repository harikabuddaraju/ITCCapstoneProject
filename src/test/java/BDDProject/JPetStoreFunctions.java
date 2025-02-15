package BDDProject;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
 
public class JPetStoreFunctions {
    WebDriver driver;
    String uname, pwd;
 
    public JPetStoreFunctions(WebDriver driver) throws FileNotFoundException // constructor
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
        uname = prop.getProperty("username");
        pwd = prop.getProperty("password");
    }
 
    // web elements
    @FindBy(linkText = "Sign In")
    public WebElement signIn;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//*[contains(text(),'Login')]")
    public WebElement loginButton;
    @FindBy(linkText = "My Orders")
    public WebElement myOrderlinkText;
    @FindBy(xpath = "//h3[text()='My Orders']")
    public WebElement myOrdersPageTitle;
    @FindBy(xpath = "//div[@class='panel failed']")
    public WebElement errorMessage;
 
    // methods
    public void clickOnSignIn() {
        signIn.click();
    }
 
    public void login() throws InterruptedException {
        username.clear();
        username.sendKeys(uname);
        Thread.sleep(1000);
        password.clear();
        password.sendKeys(pwd);
        loginButton.click();
    }
 
    public void validatePageHeading(String expectedPageHeading) throws InterruptedException {
        myOrderlinkText.click();
        Reporter.log("Clicked on My Orders link text");
        String actualPageHeading = myOrdersPageTitle.getText();
        Reporter.log("PageHeading :: expected=" + expectedPageHeading + " :: actual=" + actualPageHeading);
        Assert.assertEquals(actualPageHeading, expectedPageHeading);
        Thread.sleep(2000);
    }
 
    public void incorrectLogin() throws InterruptedException {
        username.clear();
        username.sendKeys("IncorrectLoginId");
        Thread.sleep(1000);
        password.clear();
        password.sendKeys("IncorrectLoginPwd");
        loginButton.click();
    }
 
    public void validateErrorMessage(String expectedErrorMessage) throws InterruptedException {
        String actualErrorMessage = errorMessage.getText();
        Reporter.log("ErrorMessage :: expected=" + expectedErrorMessage + " :: actual=" + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Thread.sleep(2000);
    }
}
 