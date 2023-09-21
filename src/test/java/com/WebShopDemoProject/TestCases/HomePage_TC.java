/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.PageObjects.WebShopHomePage;
import com.WebShopDemoProject.PageObjects.WishListPage;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class HomePage_TC extends BaseClass
{
	IndexPage indexPageobj;
	WishListPage wishListPageobj;
	WebShopHomePage homePageobj;
	
	@Test(groups = {"Smoke", "Sanity"})
	public void wishListValidation_Test() throws Throwable
	{
		indexPageobj=new IndexPage();
		
		Log.startTestCase("wishListValidation_Test");
		
		wishListPageobj=indexPageobj.clickOnwishListlink_IndexPge();
		Thread.sleep(3000);
		String actualURL=wishListPageobj.getUrl();
		System.out.println("actualURL: "+actualURL);
		Assert.assertEquals(actualURL, "https://demowebshop.tricentis.com/wishlist");
		
		if (driver.getTitle().equals("Demo Web Shop. Wishlist"))
		{
			Assert.assertTrue(true);
			//Logger.info("Found title page: Demo Web Shop");
			System.out.println("Found Wishlist page");
		}
		else
		{
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			//Logger.info("Did not find title page: "+bankTitlePage);
			System.out.println("Did not find Wishlist page");
		}
		Log.endTestCase("wishListValidation_Test");
	}
		
	@Test(groups = {"Smoke", "Sanity"})
	public void getWishListlabel_Test() throws Throwable
	{
		indexPageobj=new IndexPage();
		Log.startTestCase("getWishListlabel_Test");
		
		wishListPageobj=indexPageobj.clickOnwishListlink_IndexPge();
		Thread.sleep(3000);	
		String wishlabel = wishListPageobj.getWishListlabel();
		System.out.println("getWishListlabel "+wishlabel);
		Assert.assertEquals(wishlabel, "Wishlist");
				
		if (wishlabel.equals("Wishlist"))
		{
			Assert.assertTrue(true);
			//Logger.info("Found title page: Demo Web Shop");
			System.out.println("Wishlist title found.");
		}
		else
		{
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			//Logger.info("Did not find title page: "+bankTitlePage);
			System.out.println("Did not find Wishlist title.");
		}		
		
		Log.endTestCase("getWishListlabel_Test");
	}
	@Test(groups = {"Smoke", "Sanity"})
	public void wishListlabelvalidatecontent_Test() throws Throwable
	{
		indexPageobj=new IndexPage();
		Log.startTestCase("wishListlabelvalidatecontent_Test");
		
		wishListPageobj=indexPageobj.clickOnwishListlink_IndexPge();
		Thread.sleep(3000);	
		String wishcontentlabel = wishListPageobj.getWishListContent();
		System.out.println("wishListlabelvalidatecontent "+wishcontentlabel);
		Assert.assertEquals(wishcontentlabel, "The wishlist is empty!");
		if (wishcontentlabel.equals("The wishlist is empty!"))
		{
			Log.info("Found label: The wishlist is empty!");
			Assert.assertTrue(true);
		}
		else
		{
			Log.info("The wishlist is not empty!. Found this instead" +wishcontentlabel);
			Assert.assertTrue(false);
		}				
		Log.endTestCase("wishListlabelvalidatecontent_Test");
		
	}
	
}
