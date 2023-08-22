package com.qa.opencart.Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {

		getElement(locator).click();
	}

	public String getText(By locator) {

		return getElement(locator).getText();
	}

	public boolean checkElementDisplayed(By locator) {

		return getElement(locator).isDisplayed();
	}

	public boolean checkElementEnabled(By locator) {

		return getElement(locator).isEnabled();
	}

	public String getElementAttribute(By locator, String atrName) {

		return getElement(locator).getAttribute(atrName);
	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public void getElementTextlink(By locator, String text) {

		List<WebElement> langLink = getElements(locator);
		System.out.println(langLink);
//		List <String> arrayLinks=new ArrayList<String>();
		for (WebElement e : langLink) {
			String links = e.getText();
			System.out.println(links);
//		arrayLinks.add(links);

			if (links.equals(text)) {
				e.click();
				break;
			}
		}

	}

	public WebElement getEleByLinkText(String Linktext) {

		return driver.findElement(By.linkText(Linktext));
	}

	public void multiLevelMenuHandling(By level1locator, String level2, String level3, String level4)
			throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(level1locator)).perform();
		Thread.sleep(2000);

		act.moveToElement(getEleByLinkText(level2)).perform();
		Thread.sleep(2000);
		act.moveToElement(getEleByLinkText(level3)).perform();
		Thread.sleep(2000);
		getEleByLinkText(level4).click();

	}
	
	public  String checkPresenceofTitle(String titleFraction, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if( wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		else {
			System.out.println(titleFraction + "not present");
			return null;
		}
	}
	
	public  String checkPresenceofTitle2(String titlevalue, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if( wait.until(ExpectedConditions.titleContains(titlevalue))) {
			return driver.getTitle();
		}
		else {
			System.out.println(titlevalue + "not present");
			return null;
		}
	}
	
	public  String checkPresenceofUrl(String urlFraction, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if( wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		else {
			System.out.println(urlFraction + "not present");
			return null;
		}
	}
	
	
	public  String checkPresenceofUrl2(String urlvalue, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if( wait.until(ExpectedConditions.urlContains(urlvalue))) {
			return driver.getCurrentUrl();
		}
		else {
			System.out.println(urlvalue + "not present");
			return null;
		}
	}
	public  WebElement checkPresenceOfElement(By locator, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public  WebElement checkPresenceOfElementWithPolling(By locator, int timeout, int pollongTime) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(pollongTime));
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
