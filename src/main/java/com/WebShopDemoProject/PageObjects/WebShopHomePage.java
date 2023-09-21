package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

public class WebShopHomePage extends BaseClass
{
	@FindBy(xpath = "//span[normalize-space()='Wishlist']") 
	WebElement wishlistlnk;
	
	@FindBy(xpath = "//a[normalize-space()='Orders']") 
	WebElement orderslnk;
	
	@FindBy(xpath = "//h2[@class='topic-html-content-header']") 
	WebElement welcomemsglbl;
	
	//for shopping cart link found on web page
	@FindBy(xpath = "//span[normalize-space()='Shopping cart']")
	WebElement shoppingCartLnk;
	
	//initialize the elements
	public WebShopHomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateWishlist()
	{
		return Action.isDisplayed(driver, wishlistlnk);
		
	}
	
	public boolean validateWelcomeMsg()
	{
		return Action.isDisplayed(driver, welcomemsglbl);
		
	}

	public String getWelcomeMsg() throws Throwable
	{
		String steppagetitle = welcomemsglbl.getText();
		return steppagetitle;
	}	
	
	public boolean validateOrders()
	{
		return Action.isDisplayed(driver, orderslnk);
		
	}
	
	public String getUrl()
	{
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
		
	}
	
	public EstimateShippingPage clickshoppingCartLnk() throws Throwable
	{
		Action.click(driver, shoppingCartLnk, "Link");
		System.out.println("Clicked Shopping Cart link");
		return new EstimateShippingPage();
	}	
	public void mouseHovershoppingCartLnk() throws Throwable
	{
		Action.mouseHoverByJavaScript(shoppingCartLnk);
		System.out.println("Hover over Shopping Cart link");
	}	
}
