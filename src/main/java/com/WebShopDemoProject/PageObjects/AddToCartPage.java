package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@type='text']")
	WebElement quantity;
	
	//*[@id="addtocart_63_EnteredQuantity"]
	//html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[5]/div[1]/input[1]
	
	//*[@id="addtocart_5_EnteredQuantity"]
	
	@FindBy(id = "product_attribute_5_7_1")
	WebElement size;
	//product_attribute_5_7_1
	
	@FindBy(id = "add-to-cart-button-5")
	WebElement addToCartBtn;
	
	
	//for shopping cart link found in popup message
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement popupShoppingCartLnk;
	
	//for shopping cart link found on web page
	@FindBy(xpath = "//span[normalize-space()='Shopping cart']")
	WebElement shoppingCartLnk;
	
	@FindBy(xpath = "//p[@class='content']")
	WebElement addToCartMessageText;
	////p[@class='content']
	//*[@id=\"bar-notification\"]/p/text()
	
	//initialize the page
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void typeQuantity(String Quantity1) throws Throwable
	{
		Action.type(quantity, Quantity1);
		System.out.println("typed in quantity: "+Quantity1);
	}
	
	public void selectSize(String Size1) throws Throwable
	{
		Action.selectByVisibleText(size, Size1, "Combobox");
		System.out.println("Selected size :"+Size1);
	}

	public void clickaddToCartBtn() throws Throwable
	{
		Action.click(driver, addToCartBtn, "Button");
		Action.implicitWait(driver, 10);

	}

	public EstimateShippingPage clickshoppingCartLnk() throws Throwable
	{
		Action.click(driver, shoppingCartLnk, "Link");
		System.out.println("Clicked Shopping Cart link");
		return new EstimateShippingPage();
	}	

	public EstimateShippingPage clickpopupShoppingCartLnk() throws Throwable
	{
		Action.click(driver, popupShoppingCartLnk, "Link");
		System.out.println("Clicked msg confirmation Shopping Cart link");
		return new EstimateShippingPage();
	}	
	
	public String getpopupaddToCartMessageText() throws Throwable
	{
			Action.fluentWait(driver, addToCartMessageText, 0);
			String addToCartMsgConfirmation = addToCartMessageText.getText();
			System.out.println("Retrieved text from confirmation popup: "+addToCartMsgConfirmation);
			return addToCartMsgConfirmation;
			
		
	}	
}
