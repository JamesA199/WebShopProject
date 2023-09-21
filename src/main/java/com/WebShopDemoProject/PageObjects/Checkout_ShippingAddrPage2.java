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
public class Checkout_ShippingAddrPage2 extends BaseClass
{
	@FindBy(xpath = "//div[@class='step-title']/h2")
	WebElement steppagetitlelbl;
	
	@FindBy(name = "billing_address_id")
	WebElement addressSelectlb;	
	
	@FindBy(id = "shipping_address_id")
	WebElement shipping_addressShippinglb;
	
	@FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
	WebElement continueShippingBtn;
	//*[@id="shipping-buttons-container"]/input
	//input[onclick='Shipping.save()
	//initialize the elements
	public Checkout_ShippingAddrPage2() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public Checkout_ShippingMethodPage3 selectShippingAddr(String shippingaddr) throws Throwable
	{

		Action.selectByVisibleText(shipping_addressShippinglb, shippingaddr, "Combobox");
		Action.click(driver, continueShippingBtn, "Button");
		Action.fluentWait(driver, continueShippingBtn, 10);
		return new Checkout_ShippingMethodPage3();
		
	}
	public Checkout_ShippingMethodPage3 continueShippingBtn() throws Throwable
	{
		Action.fluentWait(driver, continueShippingBtn, 10);
		Action.click(driver, continueShippingBtn, "Button");
		return new Checkout_ShippingMethodPage3();
		
	}
	
	
}
