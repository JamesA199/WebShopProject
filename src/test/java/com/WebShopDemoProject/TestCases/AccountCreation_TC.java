/**
 * 
 */
package com.WebShopDemoProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebShopDemoProject.ActionDriver.Action;
import com.WebShopDemoProject.PageObjects.AccountCreationPage;
import com.WebShopDemoProject.PageObjects.IndexPage;
import com.WebShopDemoProject.PageObjects.LoginPage;
import com.WebShopDemoProject.PageObjects.RegistrationCompletedPage;
import com.WebShopDemoProject.Utility.Log;
import com.WebShopDemoProject.base.BaseClass;

/**
 * 
 */
public class AccountCreation_TC extends BaseClass
{
	
	IndexPage indexPageobj;
	AccountCreationPage AcctCreatePageobj;
	RegistrationCompletedPage RegistrationCompletedPageobj;
	LoginPage LoginPageobj;

	@Test(groups = {"Regression"})
	public void registerNewAccount_Test() throws Throwable
	{
		indexPageobj=new IndexPage();
		LoginPageobj=new LoginPage();
		Log.startTestCase("registerNewAccount_Test");
		AcctCreatePageobj=indexPageobj.clickOnregisterlink();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Demo Web Shop. Register"))
		{
			Assert.assertTrue(true);
			Log.info("Found title page: Demo Web Shop. Register");
			System.out.println("Found title page: Demo Web Shop. Register");
			AcctCreatePageobj.clickGenderOpt();
			AcctCreatePageobj.typeFirstName(randomestring());
			AcctCreatePageobj.typeLastName(randomestring());
			AcctCreatePageobj.typeEmail("minniemouse"+randomeNum()+"@gmail.com");
			Thread.sleep(1000);
			AcctCreatePageobj.typePassword("Tester1234");
			AcctCreatePageobj.typeConfirmPassword("Tester1234");
			RegistrationCompletedPageobj=AcctCreatePageobj.clickRegisterBtn();
			Action.implicitWait(driver, 10);
		}
		else
		{
			Assert.assertTrue(false);
			//Logger.info("Did not find web page: Demo Web Shop. Register);
			System.out.println("Did not find web page: Demo Web Shop. Register");
			Log.info("Fail-Did NOT find page-Demo Web Shop. Register");
		}		
		//validate the registration was completed successfully message
		if (RegistrationCompletedPageobj.validateRegisterCompleteMsg().equals("Your registration completed"))
		{
			Assert.assertTrue(true);
			//System.out.println("Registered new user account.");
			Log.info("Pass-Registered new user account.");
			LoginPageobj.clickLogoutLnk();
		}
		else
		{
			//System.out.println("Error-registering a new user.");
			Log.info("Error-registering a new user.");
			Assert.assertTrue(false);
		}
		Log.endTestCase("registerNewAccount_Test");
	}
	
}
