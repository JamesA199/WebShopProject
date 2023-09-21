package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

public class Checkout_OrderSuccessPage7 extends BaseClass    
{

	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")
	WebElement confirmMsgLbl;

	//strong[normalize-space()='Your order has been successfully processed!']
	@FindBy(xpath = "//div[@class='page-body checkout-data']//ul[@class='details']/li")
	WebElement orderNumberLbl;

	@FindBy(xpath = "//input[@onclick=\"setLocation('/')\"]")
	WebElement successContinueBtn;	
	//input[@onclick="setLocation('/')"]
	//initialize the elements
	public Checkout_OrderSuccessPage7() 
	{
		PageFactory.initElements(driver, this);
	}

	public String getconfirmMsg()
	{
		String confirmMsg=confirmMsgLbl.getText();
		return confirmMsg;
	}
	
	public String getOrderNumber()
	{
		String orderNumber=orderNumberLbl.getText();
		return orderNumber;
	}
	
	public WebShopHomePage clickSuccessContinueBtn() throws Throwable
	{
		System.out.println("successContinueBtn");
		Thread.sleep(2000);
		Action.click(driver, successContinueBtn, "Button");
		return new WebShopHomePage();		
	}
	
}
