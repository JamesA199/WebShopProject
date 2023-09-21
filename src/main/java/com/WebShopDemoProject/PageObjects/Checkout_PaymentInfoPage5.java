/**
 * 
 */
package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

//credit card number-4485564059489345
/**
 * 
 */
public class Checkout_PaymentInfoPage5 extends BaseClass  
{
	
	@FindBy(name = "CreditCardType")
	WebElement CreditCardTypeLb;
	
	@FindBy(name = "CardholderName")
	WebElement CardHolderNameTxt;
	
	@FindBy(name = "CardNumber")
	WebElement CardNumberTxt;
	
	@FindBy(name = "ExpireMonth")
	WebElement ExpireMonthLb;
	
	@FindBy(name = "ExpireYear")
	WebElement ExpireYearLb;

	@FindBy(id = "CardCode")
	WebElement CardCodeTxt;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continuePaymentInfoBtn;
	//*[@id="payment-info-buttons-container"]/input
	//initialize the elements
	public Checkout_PaymentInfoPage5() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public Checkout_ConfirmOrderPage6 checkoutPaymentInfo(String ccType, String ccName, String ccNumber, String ccMth, String ccYr, String ccCode) throws Throwable
	{
		Action.selectByVisibleText(CreditCardTypeLb, ccType, "Combobox");
		Action.type(CardHolderNameTxt, ccName);
		Action.type(CardNumberTxt, ccNumber);
		Action.selectByVisibleText(ExpireMonthLb, ccMth, "Combobox");
		Action.selectByVisibleText(ExpireYearLb, ccYr, "Combobox");			
		Action.type(CardCodeTxt, ccCode);	
		Action.click(driver, continuePaymentInfoBtn, "Button");
		Action.fluentWait(driver, continuePaymentInfoBtn, 10);
		return new Checkout_ConfirmOrderPage6();
		
	}
}