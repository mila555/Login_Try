package StepDefinitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import PageObjects.HomePage;
import PageObjects.LoginPage;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.apache.logging.log4j.Logger;

import com.herokuapp.com.theinternet.Login_Try.Base;
import com.herokuapp.com.theinternet.Login_Try.TestUtilities;
//import com.herokuapp.com.theinternet.Login_Try.TestUtilities;


@RunWith(Cucumber.class)
public class Login_Try_StepDefinitions extends TestUtilities{
	//private static final String String = null;
	//public WebDriver driver;
	//public Logger log;
	//public org.apache.log4j.Logger log;
	HomePage homepage;
	LoginPage loginpage;
	//private By logOutButton = By.xpath("//a[@class='button secondary radius']");
	
	@Given("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
		driver = Base.getDriver();  
       	log.info("start,Mila");
		//HomePage homepage = new HomePage(driver,(Logger) log);		
    }

    @When("^User clicks on Form Authentication Link$")
    public void user_clicks_on_form_authentication_link() throws Throwable {
    	//driver = Base.getDriver();
    	//HomePage homepage = new HomePage(driver, (Logger) log);
    	//HomePage homepage = new HomePage(driver);
    	    	
    	//homepage = new HomePage(driver);
    	HomePage homepage = new HomePage(driver,log);
    	homepage.clickFormAuthenticationLink();
    	//System.out.println("clicked page");
    	log.info("clicked Form Authentication link successfully");
    	sleep(1000);
    	}
    
    @And("^Enters (.+) and (.+)$")
    public void enters_and(String username, String password) throws Throwable {
        try
        {
    	loginpage = new LoginPage(driver,log);} catch(ExceptionInInitializerError error) {
    		error.printStackTrace();
    	}
        
        loginpage.Login(username,password);
    }

    
	/*
	 * @And("^Enters Username in username field$") public void
	 * enters_username_in_username_field() throws Throwable { try { loginpage = new
	 * LoginPage(driver,log); } catch (ExceptionInInitializerError error) {
	 * error.printStackTrace(); //((LoginPage) loginpage).Login1(username);
	 * //loginpage.Login1("tomsmith"); } //loginpage = new LoginPage(driver);
	 * loginpage.Login1("tomsmith"); }
	 * 
	 * @And("^Enters Password in password field$") public void
	 * enters_password_in_password_field() throws Throwable { try { loginpage = new
	 * LoginPage(driver,log); } catch (ExceptionInInitializerError error) {
	 * error.printStackTrace(); } loginpage.Login2("SuperSecretPassword!"); }
	 */
    
    @Then("^Success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	String expectedUrl = "https://the-internet.herokuapp.com/secure";
    	String actualUrl = driver.getCurrentUrl();
    	Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
    	takeScreenshot("Login_try");

//    	logout button is visible 
    	WebElement LogoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
    	Assert.assertTrue(LogoutButton.isDisplayed(), "Logout button is not visible");

//    	successful login message
    	// WebElement SuccessMessage = driver.findElement(By.cssSelector("#flash"));
    	WebElement SuccessMessage = driver.findElement(By.xpath("//div[@id='flash']"));
    	String expectedMessage = "You logged into a secure area!";
    	String actualMessage = SuccessMessage.getText();
    	// Assert.assertEquals(actualMessage,expectedMessage,"Actual message is not the
    	// same as expected");
    	Assert.assertTrue(actualMessage.contains(expectedMessage),
    			"Actual message does not contain expected message.\nActual Message: " + actualMessage
    					+ "\nExpected Message:" + expectedMessage);       
    	//takeScreenshot("Login_try");
    }
}



