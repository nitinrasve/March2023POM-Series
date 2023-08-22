package com.qa.opencart.BaseTestClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pageclass.AccountsPage;
import com.qa.opencart.pageclass.LoginPage;
import com.qa.opencart.pageclass.productInfoPage;
import com.qa.opencart.pageclass.searchResultsPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage login;
	protected AccountsPage accpage;
	protected searchResultsPage searchpage;
	protected productInfoPage productInfo;
	 DriverFactory df;
	 Properties prop;
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
		prop=df.initProperty();
	driver=	df.initDriver(prop);

	
	login=new LoginPage(driver);
	
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
