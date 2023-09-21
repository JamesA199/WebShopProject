package com.WebShopDemoProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.base.BaseClass;

public class SearchResultPage extends BaseClass
{
				 
	@FindBy(xpath = "//div[@class='details']/h2[@class='product-title']")
	WebElement productResult;
	//div[@class='picture']/a/img
	//div[@class='picture']
	@FindBy(xpath = "//div[@class='details']/h2/a")
	WebElement productTitleLnk;
	
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productResult);
	}
	public AddToCartPage clickOnProduct() throws Throwable
	{
	
		Action.click(driver, productResult, "Link");
		Thread.sleep(3000);
		Action.implicitWait(driver, 10);
		return new AddToCartPage();
	}	
	
	public String getproductTitle()
	{
		String productTitle = productTitleLnk.getText();
		return productTitle;
	}	
	
}
