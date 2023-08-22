package com.qa.opencart.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
 private By userName= By.id("input-email");
 private By password=By.id("input-password");
 private By button=By.xpath("//input[@type='submit']");
 private By forgotPassLink=By.linkText("Forgotten Password");
 
 public LoginPage(WebDriver driver) {
	 this.driver=driver;
 }
 
 public String getLoginPageTitle() {
	 String title=driver.getTitle();
	 System.out.println(title);
	 return title;
 }
 
 public String getLoginPageUrl() {
	 String Url=driver.getCurrentUrl();
	 System.out.println(Url);
	 return Url;
 }
 
public boolean isForgotPassLinkPresent() {
	
return	driver.findElement(forgotPassLink).isDisplayed();
}

public AccountsPage doLogin(String usrname, String pass) {
	driver.findElement(userName).sendKeys(usrname);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(button).click();
	
	return new AccountsPage(driver);
}
 
 

}
