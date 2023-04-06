package com.TMS.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

  public class Baseclass {

	public DatabaseUtility dLib = new DatabaseUtility();
	public static FileUtility fLib = new FileUtility();
	public static ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public static WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver driver;
	
	
	
	@BeforeSuite
	public void configBS() throws SQLException
	{
		dLib.connectToDb();
		Reporter.log("--connect to DB--",true);
	}
	
	@BeforeClass
	public void configBC() throws IOException
	{
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		}
		else if(BROWSER.equalsIgnoreCase("firebox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			Reporter.log("Invalid Browser", true);
		}
		wLib.maximizeWindow(driver );
	    driver.get(URL);                          
	    //driver.get(fLib.readDataFromPropertyFile("url"));
	    wLib.waitForPageLoad(driver);
	}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
//		String USERNAME = fLib.readDataFromPropertyFile("uname");
//		String PASSWORD = fLib.readDataFromPropertyFile("pass");
//		UserSignInPage usignin = new UserSignInPage(driver);
//		usignin.UserLogin(USERNAME, PASSWORD);
//		
	}
	
	@AfterMethod
	public void configAM()
	{
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws SQLException 
	{
		dLib.closeDb();
	}
}
