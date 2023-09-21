/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.DataProvider.DataProviders;
import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.PageObjects.LoginPage;
import com.WebShopDemoProject.PageObjects.WebShopHomePage;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class LoginPage_DDTC extends BaseClass 
{
	IndexPage indexPageobj;
	LoginPage loginPageobj;
	WebShopHomePage homePageobj;
	
	
	@Test(dataProvider = "CredentialsDP", dataProviderClass = DataProviders.class, groups = {"Smoke"})
	public void loginTest(String uname, String pword) throws Throwable
	{
		Log.startTestCase("loginTest");
		indexPageobj=new IndexPage();
		loginPageobj=indexPageobj.clickOnloginlink();
		//homePageobj = loginPageobj.login(prop.getProperty("email"), prop.getProperty("password"));
		homePageobj = loginPageobj.login(uname, pword);
		
		String actualURL=homePageobj.getUrl();
		System.out.println("actualURL: "+actualURL);
		Assert.assertEquals(actualURL, prop.getProperty("url"));
		
		if (driver.getTitle().equals("Demo Web Shop"))
		{
			Assert.assertTrue(true);
			Log.info("Found title page: Demo Web Shop");
			//System.out.println("Found title page: Demo Web Shop");
		}
		else
		{
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Log.error("Did-not-find-title-page", driver);
			//System.out.println("Did not find title page: Demo Web Shop");
		}
		loginPageobj.clickLogoutLnk();
		Log.endTestCase("loginTest");
	}
}
