package com.herokuapp.com.theinternet.Login_Try;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;


public class Base {

	public static WebDriver driver;

	public static Properties prop;
	
	public static Logger log = Logger.getLogger(Base.class);
		
	// once u declare as static you dont need to create an object of the class, base
	//Logger log = Logger.getLogger(Base.class);
	//PropertyConfigurator.configure("Log4j.properties");
	
	public static WebDriver getDriver() throws IOException {
		
		try
		{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Sharmila\\eclipse-workspace2\\Login_Try\\src\\test\\java\\Com\\herokuapp\\com\\theinternet\\Login_Try\\global.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "c:\\Users\\sharmila\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		String actualUrl = driver.getCurrentUrl();
		log.info("Google Chrome opened url"+actualUrl);
		
		}catch (ExceptionInInitializerError error) {
			 error.printStackTrace();
			
		}
		
		return driver;
	}
	
	
	
	
	
	
}