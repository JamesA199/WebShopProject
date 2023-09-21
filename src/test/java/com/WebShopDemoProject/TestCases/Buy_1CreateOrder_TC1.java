/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.PageObjects.AddToCartPage;
import com.WebShopDemoProject.PageObjects.Checkout_BillingAddrPage1;
import com.WebShopDemoProject.PageObjects.Checkout_ConfirmOrderPage6;
import com.WebShopDemoProject.PageObjects.Checkout_OrderSuccessPage7;
import com.WebShopDemoProject.PageObjects.Checkout_PaymentInfoPage5;
import com.WebShopDemoProject.PageObjects.Checkout_PaymentMethodPage4;
import com.WebShopDemoProject.PageObjects.Checkout_ShippingAddrPage2;
import com.WebShopDemoProject.PageObjects.Checkout_ShippingMethodPage3;
import com.WebShopDemoProject.PageObjects.EstimateShippingPage;
import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.PageObjects.LoginPage;
import com.WebShopDemoProject.PageObjects.SearchResultPage;
import com.WebShopDemoProject.PageObjects.WebShopHomePage;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class Buy_1CreateOrder_TC1 extends BaseClass
{
	IndexPage indexPageobj;
	WebShopHomePage WebShopHomePageobj;
	LoginPage loginPageobj;
	SearchResultPage searchResultPageobj;
	AddToCartPage addToCartPageobj;
	EstimateShippingPage estimateShippingPageobj;	
	Checkout_BillingAddrPage1 Checkout_BillingAddrPage1obj;
	Checkout_ShippingAddrPage2 Checkout_ShippingAddrPage2obj;
	Checkout_ShippingMethodPage3 Checkout_ShippingMethodPage3obj;
	Checkout_PaymentMethodPage4 Checkout_PaymentMethodPage4obj;
	Checkout_PaymentInfoPage5 Checkout_PaymentInfoPage5obj;
	Checkout_ConfirmOrderPage6 Checkout_ConfirmOrderPage6obj;
	Checkout_OrderSuccessPage7 Checkout_OrderSuccessPage7obj;
	
	@Test
	public void addToCartTest() throws Throwable
	{
		indexPageobj = new IndexPage();
		addToCartPageobj = new AddToCartPage();
		WebShopHomePageobj = new WebShopHomePage(); 
		
		String prd1 = "ROCKABILLY POLKA DOT TOP";
				
		loginPageobj=indexPageobj.clickOnloginlink();
		loginPageobj.login(prop.getProperty("email"), prop.getProperty("password"));
		
		searchResultPageobj = indexPageobj.searchProduct(prd1);
		addToCartPageobj = searchResultPageobj.clickOnProduct();
		addToCartPageobj.typeQuantity("2");
		addToCartPageobj.selectSize("2X");		
		addToCartPageobj.clickaddToCartBtn();
		String addToCartMsgConfirmation = addToCartPageobj.getpopupaddToCartMessageText();

		if (addToCartMsgConfirmation.equals("The product has been added to your shopping cart"))
		{
			Assert.assertTrue(true);
			System.out.println("Product has been added to cart confirmation "+ addToCartMsgConfirmation);
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Product has NOT been added to cart "+ addToCartMsgConfirmation);
		}
	}
}
