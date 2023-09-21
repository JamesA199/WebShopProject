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
public class WishListPage extends BaseClass 
{
	
	@FindBy(xpath = "//div[@class='page-body']/div[@class='wishlist-content']") 
	WebElement wishlistcontentLbl;
	
	@FindBy(xpath = "//h1[normalize-space()='Wishlist']") 
	WebElement wishlistLbl;	
	
	//initialize the elements
	public WishListPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateWishListContent()
	{
		return Action.isDisplayed(driver, wishlistcontentLbl);
		
	}
	public String getWishListContent()
	{
		String wishlistisempty = wishlistcontentLbl.getText();
		return wishlistisempty;
		
	}	
	public String getWishListlabel()
	{
		String wishlistisempty = wishlistLbl.getText();
		return wishlistisempty;
		
	}
	public String getUrl()
	{
		String wishListPageURL=driver.getCurrentUrl();
		return wishListPageURL;
		
	}
}
