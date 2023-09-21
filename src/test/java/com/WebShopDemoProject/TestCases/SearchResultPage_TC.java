/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.PageObjects.SearchResultPage;
import com.WebShopDemoProject.PageObjects.WishListPage;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class SearchResultPage_TC extends BaseClass
{
	IndexPage indexPageobj;
	WishListPage wishListPageobj;
	SearchResultPage searchResultPageobj;
	
	@Test(groups = {"Smoke"})
	public void searchForProduct_Test() throws Throwable
	{
		indexPageobj=new IndexPage();
		String prd1 = "rrFiction EX";
		Log.startTestCase("searchForProduct_Test");
		searchResultPageobj = indexPageobj.searchProduct(prd1);
		String prdTitle = searchResultPageobj.getproductTitle();
		
		if (prdTitle.equals(prd1))
		{
			Assert.assertTrue(true);
			Log.info("Found custom product "+ prd1);
		}
		else
		{
			Assert.assertTrue(false);
			Log.info("Did not find product "+prd1);

		}
		Log.endTestCase("searchForProduct_Test");
	}
}
