package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.DataProvider.DataProviders;
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
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

public class CreatePurchaseOrder_DDTC1 extends BaseClass
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
	
	@Test(dataProvider = "purchaseProduct", dataProviderClass = DataProviders.class, groups = {"Regression"})
	public void CreatePurchaseOrder_Test(String TestID, String uname, String pword, String Product, String qty, String Size, String UnitCost, String subTotal, String ShippingCosts, String ShippingMethod, String ccType, String ccNumber, String TotalPrice) throws Throwable
	{
		indexPageobj = new IndexPage();
		addToCartPageobj = new AddToCartPage();
		WebShopHomePageobj = new WebShopHomePage(); 
		loginPageobj = new LoginPage(); 
		//String prd1 = "ROCKABILLY POLKA DOT TOP";
		System.out.println(uname+", "+ pword+", "+ Product+", "+ qty+", "+ Size+", "+ UnitCost+", "+ subTotal+", "+ ShippingCosts+", "+ ShippingMethod+", "+ ccType+", "+ ccNumber+", "+ TotalPrice);	
		Log.startTestCase("CreatePurchaseOrder_Test DDT Record "+TestID);
		
		loginPageobj=indexPageobj.clickOnloginlink();
		//loginPageobj.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPageobj.login(uname, pword);
		searchResultPageobj = indexPageobj.searchProduct(Product);
		addToCartPageobj = searchResultPageobj.clickOnProduct();
		addToCartPageobj.typeQuantity(qty);
		addToCartPageobj.selectSize(Size);		
		addToCartPageobj.clickaddToCartBtn();
		String addToCartMsgConfirmation = addToCartPageobj.getpopupaddToCartMessageText();

		if (addToCartMsgConfirmation.equals("The product has been added to your shopping cart"))
		{
			Assert.assertTrue(true);
			//System.out.println("Product has been added to cart confirmation "+ addToCartMsgConfirmation);
			Log.info("Product has been added to cart confirmation "+ addToCartMsgConfirmation);

		}
		else
		{
			//System.out.println("Product has NOT been added to cart "+ addToCartMsgConfirmation);
			Log.error("Product has NOT been added to cart: "+ addToCartMsgConfirmation, driver);
			//captureScreen(driver, "Fail-searchPrdResult");
			Assert.assertTrue(false);
		}

	
		//indexPageobj = new IndexPage();

						
		//loginPageobj=indexPageobj.clickOnloginlink();
		//WebShopHomePageobj = loginPageobj.login(prop.getProperty("email"), prop.getProperty("password"));
		
		WebShopHomePageobj.mouseHovershoppingCartLnk();
		Thread.sleep(5000);
		estimateShippingPageobj = WebShopHomePageobj.clickshoppingCartLnk();
		System.out.println("Estimate Shipping Costs");
		estimateShippingPageobj.selectCountry("Canada");
		estimateShippingPageobj.selectProvince("Alberta");
		estimateShippingPageobj.clickEstimateshipping();
		estimateShippingPageobj.typePostalCode("T2V 1X1");
		estimateShippingPageobj.clicktermsofServiceChkbx();
		Checkout_BillingAddrPage1obj = estimateShippingPageobj.clickcheckoutBtn();
		String steptitle = Checkout_BillingAddrPage1obj.getsteptitle();

		if (steptitle.equals("Billing Address"))
		{
			Assert.assertTrue(true);
			System.out.println("Billing address page opened: "+ steptitle);
		}
		else
		{
			//System.out.println("Billing address page has NOT opened: "+ steptitle);
			Log.error("Billing address page has NOT opened: "+ steptitle, driver);
			//captureScreen(driver, "Fail-BillingAddressPage");
			Assert.assertTrue(false);
		}
				
		//Checkout_BillingAddrPageobj = new Checkout_BillingAddrPage1();
		System.out.println("Create Billing Address");
		Checkout_BillingAddrPage1obj.selectAddress("New Address");
		Checkout_ShippingAddrPage2obj = Checkout_BillingAddrPage1obj.selectBillingAddrPage1obj();
		System.out.println("Create Shipping Address");
		Checkout_ShippingMethodPage3obj = Checkout_ShippingAddrPage2obj.continueShippingBtn();
		
		System.out.println("Shipping Option");	
		Checkout_PaymentMethodPage4obj = Checkout_ShippingMethodPage3obj.clickshippingoptionBtn(ShippingMethod);
	
		System.out.println("Select Payment Method");
		Checkout_PaymentInfoPage5obj = Checkout_PaymentMethodPage4obj.clickPaymentMethodoptionBtn("CreditCard");
		Checkout_ConfirmOrderPage6obj = Checkout_PaymentInfoPage5obj.checkoutPaymentInfo(ccType, "Test Name", ccNumber, "04", "2027", "123");
		Double dsubtotalUnitPrice = Checkout_ConfirmOrderPage6obj.getsubtotalUnitPrice();
		Double dshippingTotal = Checkout_ConfirmOrderPage6obj.getshippingTotal();
		Double dTotalExpectedPrice =(dsubtotalUnitPrice+dshippingTotal);
		
		Double dTotalPrice = Checkout_ConfirmOrderPage6obj.getTotalPrice();
		System.out.println("Expected total price: "+ dTotalExpectedPrice);
		System.out.println("Actual total price: "+ dTotalPrice);
		Assert.assertEquals(dTotalExpectedPrice, dTotalPrice);
		
		//if (dTotalExpectedPrice.equals(33.00))
		//{
		//	Assert.assertTrue(true);
		//	System.out.println("Found expected total price: "+ dTotalExpectedPrice);
		//	captureScreen(driver, "Pass-ExpectedTotalPrice");
			
		//}
		//else
		//{
		//	Assert.assertTrue(false);
		//	System.out.println("Did NOT find expected total price: "+ dTotalExpectedPrice);
		//	captureScreen(driver, "Fail-BillingAddressPage");
		//	String alertsmg = driver.switchTo().alert().getText();
		//	driver.switchTo().alert().accept();//close alert
		//	System.out.println("alert error: "+ alertsmg);
		//}
		
		Checkout_OrderSuccessPage7obj = Checkout_ConfirmOrderPage6obj.clickonConfirm();
		String strorderSuccessmsg = Checkout_OrderSuccessPage7obj.getconfirmMsg();
		Assert.assertEquals(strorderSuccessmsg, "Your order has been successfully processed!");
		String strOrderNumber = Checkout_OrderSuccessPage7obj.getOrderNumber();
		System.out.println("Order Number: "+ strOrderNumber);
		WebShopHomePageobj = Checkout_OrderSuccessPage7obj.clickSuccessContinueBtn();
		boolean flag = WebShopHomePageobj.validateWelcomeMsg();
		Assert.assertEquals(flag, true);
		String strMsg = WebShopHomePageobj.getWelcomeMsg();
		if (strMsg.equals("Welcome to our store"))
		{
			Assert.assertTrue(true);
			Log.info("Found label title: "+ strMsg);
		}
		else
		{
			Log.error("Fail-Did not find label title "+ strMsg, driver);
			Assert.assertTrue(false);
		}
		loginPageobj.clickLogoutLnk();
		Log.endTestCase("CreatePurchaseOrder_Test");
	}
	
	
	
}
