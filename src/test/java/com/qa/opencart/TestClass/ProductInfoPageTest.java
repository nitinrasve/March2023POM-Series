package com.qa.opencart.TestClass;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTestClass.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void productInfoSetUp() {
		accpage=login.doLogin("janautomation@gmail.com", "Selenium@12345");
	}

	@Test
	public void productHeaderTest() {
		searchpage=accpage.doSearch("macbook");
		productInfo=	searchpage.selectProduct("MacBook Pro");
		String actProductHeader=productInfo.getProductHeaderValue();
		Assert.assertEquals(actProductHeader, "MacBook Pro");
	}
}
