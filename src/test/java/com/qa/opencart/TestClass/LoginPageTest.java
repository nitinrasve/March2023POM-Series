package com.qa.opencart.TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTestClass.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void LoginPageTitleTest() {
		
		String actTitle=login.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test
	public void LoginPageUrlTest() {
		
		String actUrl=login.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains("route=account/login"));
	}
	@Test
	public void isForgotPassLinkPresentTest() {
	boolean link=	login.isForgotPassLinkPresent();
		Assert.assertTrue(link);
	}
	@Test
	public void doLoginTest() {
	login.doLogin("xyz", "123");
	}

}
