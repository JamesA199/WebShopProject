/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class LandingPage_TC extends BaseClass
{

	IndexPage indexPage;
	
	@Test(groups = {"Smoke"})
	public void verifyWebShopLogo_Test() 
	{
		indexPage = new IndexPage();
		Log.startTestCase("verifyWebShopLogo_Test");

		boolean result=indexPage.validateLogo();
		Assert.assertEquals(result, true);
		Log.endTestCase("verifyWebShopLogo_Test");
		
		
	}
	@Test(groups = {"Smoke"})
	public void verifyWebShopWebPageTitle_Test() 
	{
		indexPage = new IndexPage();
		Log.startTestCase("verifyWebShopWebPageTitle_Test");
		String shopTitle=indexPage.getWebPageTitle();
		Assert.assertEquals(shopTitle, "Deo Web Shop");
		Log.endTestCase("verifyWebShopWebPageTitle_Test");
	}	

}
