package Admin_package;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.TMS.GenericUtilities.Baseclass;
import com.TMS.ObjectRepository.AdminDashboard;
import com.TMS.ObjectRepository.AdminPackageCreation;
import com.TMS.ObjectRepository.AdminSignInPage;
import com.TMS.ObjectRepository.TMSHomePage;

    public class CreateTourPackageTest extends Baseclass {
    	
	
    @Test	
    public void createpackagetest() throws Throwable  
	 {
    
        try {
    	String Username = fLib.readDataFromPropertyFile("uname");
		String Password = fLib.readDataFromPropertyFile("pass");
		
		TMSHomePage TMSHome = new TMSHomePage(driver);
        TMSHome.clickonadminlogin();
        
		AdminSignInPage adminsignin = new AdminSignInPage(driver);
		adminsignin.AdminSignin(Username,Password);
		
		AdminDashboard dashboard = new AdminDashboard(driver);
		dashboard.clickOnTourPackages();
		dashboard.clickOnCreate();		
		
		AdminPackageCreation create = new AdminPackageCreation(driver);
        create.createPackage(eLib, wLib, driver);
      
		String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(res);  
		dashboard.clickonAdministratorDD();
		dashboard.clickonAdminLogout();
        }
        catch (Exception e)
        {
			
		}
   }
}


