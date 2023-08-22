package com.qa.opencart.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementUtils;

public class searchResultsPage {
	
	private WebDriver driver;
	private ElementUtils eleutils;
	
	private By productResults=By.cssSelector("div.product-layout");
	
	
	public searchResultsPage(WebDriver driver) {
		this.driver=driver;
		eleutils=new ElementUtils(driver);
	}
	
	public int searchProductCount() {
		
	return	driver.findElements(productResults).size();
	}
	
	public productInfoPage selectProduct(String value) {
		
		driver.findElement(By.linkText(value)).click();
		
		return new productInfoPage(driver);
	}
}
