package com.qa.opencart.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtils {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptExecutorUtils(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)this.driver;
	}
	
	//get title by js
	public String getTitleByJs() {
	return	js.executeScript("return document.title").toString();
	}
	
	public void goBackWithJs() {
		js.executeScript("history.go(-1)");
	}
	
	public void goForwardWithJs() {
		js.executeScript("history.go(1)");
	}
	
	public void refreshWithJs() {
		js.executeScript("history.go(0)");
	}
	
	public void generateAlertbyJs(String msg) {
		js.executeScript("alert('"+msg+"')");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	//text of entire page
	public String getPageIneerText() {
	return	js.executeScript("return document.documentElement.innerText").toString();
	}
	
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	public void scrollPageToMiddle() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");
	}
	
	public void scroolUpTowebElement(WebElement element) {
		
		js.executeScript("aguments[0].scrollIntoView(true)", element);
	}


}
