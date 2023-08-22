package com.qa.opencart.TestClass;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTestClass.BaseTest;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
	accpage=	login.doLogin("janautomation@gmail.com", "Selenium@12345");
	}
	
	@Test
	public void accountsPageTitleTest() {
		String actTitle=accpage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}
	
	@Test
	public void logoutLinkExistsTest() {
		Assert.assertTrue(accpage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageHeadersCountTest() {

	int headerscount=accpage.getAccountsPageHeadersCount();
	Assert.assertEquals(headerscount, 4);
	}
	
//	@Test
//	public void accPageHeadersTest() {
//
//	List<String> heasersList=accpage.getAccountsPageHeaders();
//Assert.assertEquals(heasersList, "My Account","My Orders","My Affiliate Account","Newsletter");
//	}
	
	@DataProvider
	public Object [] [] getSearchKey() {
		return new Object [] [] {
			
			{"macbook", "MacBook Pro",3},
			{"imac","iMac",3},
			{"samsung","Samsung SyncMaster 941BW" , 1},
			{"samsung","Samsung Galaxy Tab 10.1" , 7}
		};
	}
	@Test(dataProvider="getSearchKey")
	public void searchTest(String searchKey, String productName, int productCount) {
		
		searchpage=accpage.doSearch(searchKey);
		productInfo=	searchpage.selectProduct(productName);
	int countSearch=	searchpage.searchProductCount();
	Assert.assertEquals(countSearch, productCount);
	}
	
	

}
