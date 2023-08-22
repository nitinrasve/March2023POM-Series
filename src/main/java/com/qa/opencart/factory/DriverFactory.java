package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	
	/**
	 * This is used to initialize browser
	 * @param browserName
	 * @return
	 */
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
	switch (browserName.toLowerCase()) {
	case "chrome": driver=new ChromeDriver();
		break;
		
	case "safari": driver=new SafariDriver();
	break;
	
	case "edge": driver=new EdgeDriver();
	break;
	
	

	default: System.out.println("plz pass the right browsername" +browserName);
		break;
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	return driver;
		
	}
	
	/**
	 *  This is used to initialize Properties
	 * @return
	 */
	public Properties initProperty() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/java/config/config.properties");
		prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
