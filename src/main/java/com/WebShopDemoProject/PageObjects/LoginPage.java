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
public class LoginPage extends BaseClass
{
	@FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='account']") 
	WebElement useraccountLnk;
	
	@FindBy(xpath = "//a[@class=\"ico-logout\"]") 
	WebElement logoutLnk;	
	
	@FindBy(id = "Email") 
	WebElement usernameTextBox;

	@FindBy(name = "Password") 
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value='Log in']") 
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@value='Register']") 
	WebElement registerBtn;
	
	//initialize the elements
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public WebShopHomePage login(String uname, String pwd) throws Throwable
	{
		Action.type(usernameTextBox, uname);
		Action.implicitWait(driver, 10);
		Action.type(passwordTextBox, pwd);
		Action.click(driver, loginBtn, "Button");
		Action.implicitWait(driver, 10);
		//System.out.println("Logged into Web Shop with user: "+uname);
		Log.info("Logged into Web Shop with user: "+uname);
		return new WebShopHomePage();
	}
	
	public WebShopHomePage login_ContinueOrder(String uname, String pwd) throws Throwable
	{
		Action.type(usernameTextBox, uname);
		Thread.sleep(1000);
		Action.type(passwordTextBox, pwd);
		Action.click(driver, loginBtn, "Button");
		Action.implicitWait(driver, 10);
		Log.info("Logged into Web Shop with user: "+uname);
		return new WebShopHomePage();
	}
	
	
	public void clickLogoutLnk()throws Throwable
	{
		Action.click(driver, logoutLnk, "Link");

	}
	
	public MyAccountPage clickUserAccountlnk()throws Throwable
	{
		Action.click(driver, useraccountLnk, "Link");
		return new MyAccountPage();
	}
	
	public RegistrationCompletedPage createNewAccount()throws Throwable
	{
		Action.click(driver, registerBtn, "Button");
		return new RegistrationCompletedPage();
	}

}
