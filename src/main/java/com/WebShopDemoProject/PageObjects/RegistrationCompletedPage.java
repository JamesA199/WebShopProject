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
public class RegistrationCompletedPage extends BaseClass
{
	@FindBy(xpath = "//div[@class='page-body']/div[@class='result']")
	WebElement registerCompletedMsgLbl;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement registerCompletedContinueBtn;
	
	public RegistrationCompletedPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateRegisterCompleteMsg()
	{
		String registerCompletedMsg = registerCompletedMsgLbl.getText();
		return registerCompletedMsg;
		
	}	
	
	public void clickregisterContinueBtn() throws Throwable
	{
		Action.click(driver, registerCompletedContinueBtn, "Button");
	}
}
