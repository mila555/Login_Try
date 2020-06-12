package PageObjects;
import PageObjects.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

public class HomePage extends BasePageObjects {
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	public WebDriver driver;
	//public Logger log;	
	
	//public HomePage(WebDriver driver) {
	public HomePage(WebDriver driver, Logger log) {
		super(driver,log);
		//super(driver);
		//this.driver = driver;
		//this.driver = super(driver);
		//this.log = log;
	}
	/** Open WelcomePage with it's url */	
	/** Open LoginPage by clicking on Form Authentication Link */
	public void clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		//return new LoginPage(driver,log);
		//return new LoginPage(driver);		
	}
}
