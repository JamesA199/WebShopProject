/**
 * 
 */
package com.WebShopDemoProject.DataProvider;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.WebShopDemoProject.Utility.NewExcelLibrary;

/**
 *
 *
 */
public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();
	
//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

	@DataProvider(name = "CredentialsDP")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = NewExcelLibrary.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
	@DataProvider(name = "email")
	public Object[][] getEmail() {
		// Totals rows count
		int rows = obj.getRowCount("Email");
		// Total Columns
		int column = obj.getColumnCount("Email");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = NewExcelLibrary.getCellData("Email", j, i + 2);
			}
		}
		return data;
	}

//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "purchaseProduct")
	public Object[][] getProduct() {
		// Totals rows count
		int rows = obj.getRowCount("PurchaseProduct");
		// Total Columns
		int column = obj.getColumnCount("PurchaseProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = NewExcelLibrary.getCellData("PurchaseProduct", j, i + 2);
			}
		}
		return data;
	}

	
	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = NewExcelLibrary.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(NewExcelLibrary.getCellData("AccountCreationData", j, 1),
						NewExcelLibrary.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

}
