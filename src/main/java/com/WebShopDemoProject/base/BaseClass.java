package com.WebShopDemoProject.base;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.WebShopDemoProject.ActionDriver.Action;
//import com.WebShopDemo.Utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver; 
	
	//Declare ThreadLocal Driver Parallel testing using Java ThreadLocal Class
	/*public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver Driver() {
		// TODO Auto-generated method stub
		return null;
	}
	public static WebDriver getDriver()
	{
		//get driver from threadlocalmap
		return driver.get();
	}*/
	/*public static WebDriver Driver() {
		// TODO Auto-generated method stub
		return driver;
	}*/
	@Parameters("browser")	
	@BeforeClass(groups = {"Smoke", "Sanity", "Regression" })
	public void setup(String browser)
	{

		//Logger = org.apache.log4j.Logger.getLogger("DemoShop");
		PropertyConfigurator.configure("Log4j.properties");
		
		DOMConfigurator.configure("log4j.xml");
		//launchApp(browser);
		//WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");	
		if (browser.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("FireFox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("IE")) 
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(url);
		//driver.get(prop.getProperty("url"));		
	}
	
	@AfterClass(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() throws InterruptedException
	{ 
		Thread.sleep(3000);
		driver.quit();
	}
	
	//loadConfig method is to load the configuration property file
	//@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	@BeforeSuite
	public void loadConfig()
	{
		//ExtentManager.setExtent();
		//DOMConfigurator.configure("log4j.xml");

		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+ driver);
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		//ExtentManager.endReport();
	}
	
	/*@Parameters("browser")	
	public static void launchApp(String browserName) 
	{
		//WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("FireFox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
	}*/
		
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}


	public static String getdate() 
	{
	 
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		 
		//get current date time with Date()
		Date date = new Date();
		 
		// Now format the date
		String date1= dateFormat.format(date);
		 
		// Print the Date
		//System.out.println(date1);
		return date1;
	 
	 }
}
