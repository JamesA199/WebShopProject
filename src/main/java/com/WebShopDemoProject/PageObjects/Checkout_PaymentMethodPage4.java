/**
 * 
 */
package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class Checkout_PaymentMethodPage4 extends BaseClass 
{
	@FindBy(id = "paymentmethod_0")
	WebElement CashOnDeliveryoptionBtn;

	@FindBy(id = "paymentmethod_1")
	WebElement CheckMoneyOrderoptionBtn;
	
	@FindBy(id = "paymentmethod_2")
	WebElement CreditCardoptionBtn;

	@FindBy(id = "paymentmethod_3")
	WebElement PurchaseOrderoptionBtn;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePaymentMethodBtn;
	//*[@id="payment-method-buttons-container"]/input
	//input[@class='button-1 payment-method-next-step-button']
	
	//initialize the elements
	public Checkout_PaymentMethodPage4() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Checkout_PaymentInfoPage5 clickPaymentMethodoptionBtn(String PaymentMethodoption) throws Throwable
	{
		Thread.sleep(2000);
		if(PaymentMethodoption.equals("CashOnDelivery"))
		{
			Action.click(driver, CashOnDeliveryoptionBtn, "Button");
		}
		else if(PaymentMethodoption.equals("CheckMoneyOrder"))
		{
			Action.click(driver, CheckMoneyOrderoptionBtn, "Button");
		}
		else if(PaymentMethodoption.equals("CreditCard"))
		{
			Action.click(driver, CreditCardoptionBtn, "Button");
		}	
		else if(PaymentMethodoption.equals("PurchaseOrder"))
		{
			Action.click(driver, PurchaseOrderoptionBtn, "Button");
		}
		
		Action.click(driver, continuePaymentMethodBtn, "Button");
		return new Checkout_PaymentInfoPage5();		
	}

	
}
