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
public class EstimateShippingPage extends BaseClass
{
	@FindBy(id = "CountryId") 
	WebElement countryIdLb;
	
	@FindBy(id = "StateProvinceId") 
	WebElement stateProvinceIdLb;
	
	@FindBy(name = "ZipPostalCode") 
	WebElement zipPostalCodeTextBox;
	
	@FindBy(name = "estimateshipping") 
	WebElement estimateshippingBtn;
	
	@FindBy(name = "termsofservice") 
	WebElement termsofserviceChk;
	
	@FindBy(name = "checkout") 
	WebElement clickcheckoutBtn;	
	
	//initialize the elements
	public EstimateShippingPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String Country) throws Throwable
	{
		Action.selectByVisibleText(countryIdLb, Country, "Combobox");
	}
	
	public void selectProvince(String Province) throws Throwable
	{
		Action.selectByVisibleText(stateProvinceIdLb, Province,"Combobox");
	}
	
	public void typePostalCode(String PostalCode) throws Throwable
	{
		Action.type(zipPostalCodeTextBox, PostalCode);
	}
	
	public void clickEstimateshipping() throws Throwable
	{
		Action.click(driver, estimateshippingBtn, "Button");
	}
	
	public void clicktermsofServiceChkbx() throws Throwable
	{
		Action.click(driver, termsofserviceChk, "Checkbox");
	}	
	public Checkout_BillingAddrPage1 clickcheckoutBtn() throws Throwable
	{
		Action.click(driver, clickcheckoutBtn, "Button");
		return new Checkout_BillingAddrPage1();
	}
	
	public LoginPage clickcheckoutwithLoginBtn() throws Throwable
	{
		Action.click(driver, clickcheckoutBtn, "Button");
		return new LoginPage();
	}
}