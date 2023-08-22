package com.qa.opencart.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementUtils;

public class productInfoPage {
	private WebDriver driver;
	private ElementUtils eleutils;
	
	private By productHeader=By.cssSelector("div#content h1");
	private By productImages=By.cssSelector("ul.thumbnails img");
	private By quantity=By.name("quantity");
	private By addTocartButton=By.id("button-cart");
	
	public productInfoPage(WebDriver driver) {
		this.driver=driver;
		eleutils=new ElementUtils(driver);
		
	}
	
	public String getProductHeaderValue() {
		
	return	eleutils.getText(productHeader);
	}

}
