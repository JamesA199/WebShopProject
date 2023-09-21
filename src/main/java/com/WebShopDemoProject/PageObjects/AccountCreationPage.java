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
public class AccountCreationPage extends BaseClass
{
	@FindBy(xpath = "//h1[normalize-space()='Register']")
	WebElement registerHeaderTitle;

	@FindBy(id = "gender-male")
	WebElement maleOpt;

	@FindBy(name = "FirstName")
	WebElement firstName;
	
	@FindBy(name = "LastName")
	WebElement lastName;
	
	@FindBy(name = "Email")
	WebElement email;	

	@FindBy(name = "Password")
	WebElement password;
	
	@FindBy(name = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
	WebElement registrationErrors;
		
	@FindBy(name = "register-button")
	WebElement registerBtn;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatePage() throws Throwable
	{
		Log.info("Register header title is dislayed: "+registerHeaderTitle);
		return Action.isDisplayed(driver, registerHeaderTitle);
	}
		
	public void clickGenderOpt() throws Throwable
	{
		Action.click(driver, maleOpt, "optButton");

	}
	
	public void typeFirstName(String fName) throws Throwable
	{
		Action.type(firstName, fName);
	}
	
	public void typeLastName(String lName) throws Throwable
	{
		Action.type(lastName, lName);
	}	
	public void typeEmail(String Email) throws Throwable
	{
		Action.type(email, Email);
	}

	public void typePassword(String Password) throws Throwable
	{
		Action.type(password, Password);
	}
	
	public void typeConfirmPassword(String ConfirmPassword) throws Throwable
	{
		Action.type(confirmPassword, ConfirmPassword);
	}
	
	public RegistrationCompletedPage clickRegisterBtn() throws Throwable
	{
		Action.click(driver, registerBtn, "Button");
		System.out.println("Clicked on Register button.");
		return new RegistrationCompletedPage();
	}
	public String validateRegistrationPass()
	{
		String RegistrationPass = registrationErrors.getText();
		return RegistrationPass;
		
	}	
}
