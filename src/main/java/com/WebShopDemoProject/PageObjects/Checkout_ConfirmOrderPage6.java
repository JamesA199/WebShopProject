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
public class Checkout_ConfirmOrderPage6 extends BaseClass   
{
	@FindBy(xpath = "//*[@id=\"checkout-confirm-order-load\"]/div/div[2]/div/div/ul[1]/li[2]")
	WebElement CreditCardNameLbl;
	
	//sub-total
	@FindBy(xpath ="//td[@class='cart-total-right']/span[@class='nobr']/span[@class='product-price']")
	WebElement unitPriceLbl;
	//td[@class='unit-price nobr']/span[@class='product-unit-price']
	
	@FindBy(xpath ="//tr[2]/td[@class='cart-total-right']/span[@class='nobr']/span[@class='product-price']")
	WebElement shippingTotalLbl;
	
	@FindBy(xpath ="//tr[4]//td[@class='cart-total-right']/span[@class='nobr']/span[@class='product-price order-total']/strong")
	WebElement totalPriceLbl;	
	
	@FindBy(xpath ="//input[@value='Confirm']")
	WebElement confirmBtn;
	
	//initialize the elements
	public Checkout_ConfirmOrderPage6() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public boolean validateCCName()
	{
		return Action.isDisplayed(driver, CreditCardNameLbl);
	}
	
	public double getsubtotalUnitPrice()
	{
		String strsubtotalUnitPrice=unitPriceLbl.getText();
		String strsubtotalUnitPrice1=strsubtotalUnitPrice.replaceAll("[^a-zA-Z0-9]", "");
		double dfinalUnitPrice=Double.parseDouble(strsubtotalUnitPrice1);
		return dfinalUnitPrice/100;
	}
	
	public double getshippingTotal()
	{
		String strshippingTotal=shippingTotalLbl.getText();
		String strshippingTotal1=strshippingTotal.replaceAll("[^a-zA-Z0-9]", "");
		double dfinalshippingTotal=Double.parseDouble(strshippingTotal1);
		return dfinalshippingTotal/100;
	}
	
	public double getTotalPrice()
	{
		String strtotalPrice=totalPriceLbl.getText();
		String strtotalPrice1=strtotalPrice.replaceAll("[^a-zA-Z0-9]", "");
		double dfinalTotalPrice=Double.parseDouble(strtotalPrice1);
		return dfinalTotalPrice/100;
	}
	
	public Checkout_OrderSuccessPage7 clickonConfirm()
	{
		Action.click(driver, confirmBtn, "Button");
		return new Checkout_OrderSuccessPage7();
	}
}
