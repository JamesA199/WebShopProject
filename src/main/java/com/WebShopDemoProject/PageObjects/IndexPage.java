package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

public class IndexPage extends BaseClass

{
	@FindBy(xpath = "//a[@class='ico-register']") 
	WebElement registerlnk;
	
	@FindBy(xpath = "//a[@class='ico-login']") 
	WebElement logInlnk;

	@FindBy(xpath = "//span[normalize-space()='Shopping cart']") 
	WebElement shoppingcartlnk;
	
	@FindBy(xpath = "//span[normalize-space()='Wishlist']") 
	WebElement wishlistlnk;
	
	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']") 
	WebElement demoWebShopLogo;
	
	@FindBy(id = "small-searchterms") 
	WebElement searchTextBox;

	@FindBy(xpath = "//input[@value='Search']") 
	WebElement searchBtn;
	
	//initialize the elements
	public IndexPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnloginlink() throws Throwable
	{
		Action.fluentWait(driver, logInlnk, 10);
		Action.click(driver, logInlnk, "Link");
		return new LoginPage();
	}

	public WishListPage clickOnwishListlink_IndexPge() throws Throwable
	{
		Action.click(driver, wishlistlnk, "Link");
		return new WishListPage();
	}	
	
	
	public AccountCreationPage clickOnregisterlink() throws Throwable
	{
		Action.click(driver, registerlnk, "Link");
		return new AccountCreationPage();
	}
	
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(driver, demoWebShopLogo);
		
	}
	
	public String getWebPageTitle()
	{
		String WebPageTitle=driver.getTitle();
		return WebPageTitle;
		
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable
	{
		Action.type(searchTextBox, productName);
		Action.click(driver, searchBtn, "Button");
		return new SearchResultPage();
	}
	
	
	
	
}
