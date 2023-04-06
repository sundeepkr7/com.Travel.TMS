package Practice_Package;

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
import com.TMS.GenericUtilities.DatabaseUtility;
import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.JavaUtility;
import com.TMS.GenericUtilities.WebDriverUtility;
import com.beust.jcommander.Parameter;

public class Base_class {
	public DatabaseUtility dLib = new DatabaseUtility();
	public static FileUtility fLib = new FileUtility();
	public static ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public static WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.connectToDb();
		Reporter.log("--connect to DB--",true);
	}
	@Parameter("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String BROWSER) throws IOException
	{
		
		//String BROWSER = fLib.readDataFromPropertyFile("browser");
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
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException
	{

	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException 
	{
		dLib.closeDb();
	}
}