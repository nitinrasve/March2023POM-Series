package com.qa.opencart.pageclass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtils;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils eleutils;
	
	private By logoutLink=By.linkText("Logout");
	private By accHeaders=By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleutils=new ElementUtils(driver);
	}
	
	public String getAccountsPageTitle() {
		return eleutils.checkPresenceofTitle2("My Account", 10);
	}
	
	public boolean isLogoutLinkExist() {
		return eleutils.checkPresenceOfElement(logoutLink, 10).isDisplayed();
	}
	
	public List<String> getAccountsPageHeaders() {
		
		List <WebElement> accHeader=driver.findElements(accHeaders);
		List <String> accHeadersList=new ArrayList<String>();
		for(WebElement e:accHeader) {
			String header=e.getText();
			accHeadersList.add(header);
		}
		return accHeadersList;
	}
	
	public int getAccountsPageHeadersCount(){
		return getAccountsPageHeaders().size();
	}
	
	public searchResultsPage doSearch(String key) {
		WebElement searchFeild=eleutils.checkPresenceOfElement(search, 10);
		searchFeild.clear();
				searchFeild.sendKeys(key);
		eleutils.doClick(searchIcon);
		return new searchResultsPage(driver);
	}

}
