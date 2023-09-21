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
public class Checkout_ShippingMethodPage3 extends BaseClass
{
	@FindBy(id = "shippingoption_0")
	WebElement groundoptionBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement nextDayAiroptionBtn;
	
	@FindBy(id = "shippingoption_2")
	WebElement secondDayAiroptionBtn;
	
	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	WebElement continueShippingBtn;
		
	//initialize the elements
	public Checkout_ShippingMethodPage3() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Checkout_PaymentMethodPage4 clickshippingoptionBtn(String shippingoption) throws Throwable
	{
		if(shippingoption.equals("Ground"))
		{
			Action.click(driver, groundoptionBtn, "Button");
		}
		else if(shippingoption.equals("NextDayAir"))
		{
			Action.click(driver, nextDayAiroptionBtn, "Button");
		}
		else if(shippingoption.equals("SecondDayAir"))
		{
			Action.click(driver, secondDayAiroptionBtn, "Button");
		}	
		
		Action.click(driver, continueShippingBtn, "Button");
		return new Checkout_PaymentMethodPage4();
	}
		
}
