package Practice_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.WebDriverUtility;
import com.TMS.ObjectRepository.AdminDashboard;
import com.TMS.ObjectRepository.AdminSignInPage;
import com.TMS.ObjectRepository.AdminManagePackage;

public class ManagePackage 
{
	public static void main(String[] args) throws Throwable
	{
	FileUtility fLib = new FileUtility();
    ExcelUtility eLib = new ExcelUtility();
    WebDriverUtility wLib = new WebDriverUtility();
    
    String URL= fLib.readDataFromPropertyFile("url");

	String ADMIN= fLib.readDataFromPropertyFile("uname");
	String APASS= fLib.readDataFromPropertyFile("pass");

	ChromeOptions option = new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(option);
	
	wLib.maximizeWindow(driver );
	driver.get(URL);
	wLib.waitForPageLoad(driver);
	driver.findElement(By.xpath("//a[.='Admin Login']")).click();
	
	AdminSignInPage adminsignin = new AdminSignInPage(driver);
	adminsignin.AdminSignin(ADMIN,APASS);
	
	AdminDashboard dashboard = new AdminDashboard(driver);
	dashboard.clickOnTourPackages();
	dashboard.clickOnmanage();
	
	AdminManagePackage manage = new AdminManagePackage(driver);
	manage.managePackage(eLib, wLib, driver);

	String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
	System.out.println(res); 
   
    

  }
}
