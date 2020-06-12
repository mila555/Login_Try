package PageObjects;

import PageObjects.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

public class LoginPage extends BasePageObjects{
	
	//public WebDriver driver;
	//public Logger log;
	//private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	
	//public LoginPage(WebDriver driver, Logger log){		
		//public LoginPage(WebDriver driver) {
		public LoginPage(WebDriver driver, Logger log){
			super(driver,log);
			//this.log = log;
		}		

	public void Login(String username,String password) {
		WebElement username1 = driver.findElement(By.id("username"));
		log.info("username is: "+username);
    	username1.sendKeys(username);
    	
    	 WebElement password1 = driver.findElement(By.name("password"));
    	 password1.sendKeys(password);
    	 log.info("password is: "+password);
		//	enter password
		WebDriverWait  wait= new WebDriverWait(driver, 10);
		//	click login button
		WebElement LoginButton = driver.findElement(By.tagName("button"));
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
		//sleep(1000);
	}

	

	/*
	 * public void Login2(String password) { WebElement password1 =
	 * driver.findElement(By.name("password")); password1.sendKeys(password);
	 * log.info("password is: "+password); // enter password WebDriverWait wait= new
	 * WebDriverWait(driver, 10); // click login button WebElement LoginButton =
	 * driver.findElement(By.tagName("button"));
	 * wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
	 * LoginButton.click(); try { Thread.sleep(3000); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } //
	 * verifications: }
	 */


	

}