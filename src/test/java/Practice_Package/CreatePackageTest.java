package Practice_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.JavaUtility;
import com.TMS.GenericUtilities.WebDriverUtility;
import com.TMS.ObjectRepository.AdminDashboard;
import com.TMS.ObjectRepository.AdminPackageCreation;
import com.TMS.ObjectRepository.AdminSignInPage;

    public class CreatePackageTest {
	 public static void main(String[] args) throws Throwable {
	   FileUtility fLib = new FileUtility();
       ExcelUtility eLib = new ExcelUtility();
       JavaUtility jLib = new JavaUtility();
       WebDriverUtility wLib = new WebDriverUtility();
    
      try {
        String URL= fLib.readDataFromPropertyFile("url");
		String ADMIN= fLib.readDataFromPropertyFile("uname");
		String APASS= fLib.readDataFromPropertyFile("pass");

		//WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		wLib.maximizeWindow(driver );
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		//driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		
		AdminSignInPage adminsignin = new AdminSignInPage(driver);
		adminsignin.AdminSignin(ADMIN,APASS);
		
		AdminDashboard dashboard = new AdminDashboard(driver);
		dashboard.clickOnTourPackages();
		dashboard.clickOnCreate();		
		
		AdminPackageCreation create = new AdminPackageCreation(driver);
        create.createPackage(eLib, wLib, driver);
      
		String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(res);   
        }
        catch (Exception e)
        {
			
		}
   }
}


