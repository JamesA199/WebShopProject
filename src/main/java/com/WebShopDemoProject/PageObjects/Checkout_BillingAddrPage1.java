/**
 * 
 */
package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class Checkout_BillingAddrPage1 extends BaseClass
{
	
	@FindBy(xpath = "//div[@class='step-title']/h2")
	WebElement steppagetitlelbl;
	
	@FindBy(name = "billing_address_id")
	WebElement addressSelectlb;	
	
	@FindBy(name = "BillingNewAddress.FirstName")
	WebElement firstName_Billingtxt;
	
	@FindBy(name = "BillingNewAddress.LastName")
	WebElement lastName_Billingtxt;
	
	@FindBy(name = "BillingNewAddress.Email")
	WebElement email_Billingtxt;
	
	@FindBy(name = "BillingNewAddress.Company")
	WebElement company_Billingtxt;

	@FindBy(name = "BillingNewAddress.CountryId")
	WebElement CountryId_Billinglb;	
	
	@FindBy(name = "BillingNewAddress.StateProvinceId")
	WebElement StateProvinceId_Billinglb;
	
	@FindBy(name = "BillingNewAddress.City")
	WebElement City_Billingtxt;	

	@FindBy(name = "BillingNewAddress.Address1")
	WebElement Address1_Billingtxt;		

	@FindBy(name = "BillingNewAddress.ZipPostalCode")
	WebElement ZipPostalCode_Billingtxt;
	
	@FindBy(name = "BillingNewAddress.PhoneNumber")
	WebElement PhoneNumber_Billingtxt;
	
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement continueBtn;
	
	//initialize the elements
	public Checkout_BillingAddrPage1() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void selectAddress(String address)
	{
		Action.selectByVisibleText(addressSelectlb, address, "Combobox");

	}

	public String getsteptitle() throws Throwable
	{
		String steppagetitle = steppagetitlelbl.getText();
		Log.info("Retrieved step titile: "+steppagetitle);
		return steppagetitle;
	}		
	
	public Checkout_ShippingAddrPage2 selectBillingAddrPage1obj() throws Throwable
	{
		Action.fluentWait(driver, firstName_Billingtxt, 10);
		Action.type(firstName_Billingtxt, "fname");
		Action.type(lastName_Billingtxt, "lname");
		Action.type(email_Billingtxt, "test1@email.com");
		Action.type(company_Billingtxt, "company");	
		Action.selectByVisibleText(CountryId_Billinglb, "Canada", "Combobox");
		Action.selectByVisibleText(StateProvinceId_Billinglb, "Alberta", "Combobox");		
		Action.type(City_Billingtxt, "city1");	
		Action.type(Address1_Billingtxt, "address123");
		Action.type(ZipPostalCode_Billingtxt, "t2v1x1");
		Action.type(PhoneNumber_Billingtxt, "1234567890");		
		Action.click(driver, continueBtn, "Button");
		Log.info("Added shipping address.");
		return new Checkout_ShippingAddrPage2();
		
	}
	
	
}
