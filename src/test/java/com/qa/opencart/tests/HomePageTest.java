package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest {
	
		
	
	@Test
	public void homePageTitletest() {
		String actualTitle =homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[] [] getProductData(){
		return new Object[] [] {
			{"Macbook"},
			{"I-Mac"},
			{"Samsung"}
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		String actualSearchheader =homePage.doSearch(productName);
		Assert.assertEquals(actualSearchheader, "Search - "+ productName);
	}
	
	

}
