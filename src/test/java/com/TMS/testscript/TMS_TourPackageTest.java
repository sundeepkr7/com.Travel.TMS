package com.TMS.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TMS.GenericUtilities.Baseclass;
import com.TMS.ObjectRepository.AdminDashboard;
import com.TMS.ObjectRepository.AdminPackageCreation;
import com.TMS.ObjectRepository.AdminSignInPage;
import com.TMS.ObjectRepository.AdminManagePackage;
import com.TMS.ObjectRepository.PackageListPage;
import com.TMS.ObjectRepository.TMSHomePage;

//@Listeners(com.TMS.GenericUtilities.ListenerImplementationClass.class)
public class TMS_TourPackageTest extends Baseclass {
	
	    @Test
	    public void CreatePackageTest() throws Throwable  
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
			adminsignin.Backtohome();
			TMSHome.clickonTourPackages();
			
			String packageName = eLib.readdataFromExcel("Packagedetails", 1, 0);
			PackageListPage packageList = new PackageListPage(driver);
			packageList.SearchAndClickOnPackage(packageName, driver);
			SoftAssert s = new SoftAssert();
			s.fail();
			s.assertAll();
	        }
	        catch (Exception e)
	        {
				e.printStackTrace();
			}
	   }
	    @Test  
		public void ManagePackageTest() throws Throwable
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
				dashboard.clickOnmanage();		
				
				AdminManagePackage manage = new AdminManagePackage(driver);
				manage.clickonSidebarIcon();
				manage.clickonViewdetails(wLib, driver);
		        manage.managePackage(eLib, wLib, driver);
		      
				String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
				System.out.println(res);   
				
				dashboard.clickonAdministratorDD();
				dashboard.clickonAdminLogout();
				adminsignin.Backtohome();
				TMSHome.clickonTourPackages();
				
				String packageName = eLib.readdataFromExcel("Packagedetails", 1, 0);
				PackageListPage packageList = new PackageListPage(driver);
				packageList.SearchAndClickOnPackage(packageName, driver);
		        }
			
			catch(Exception e) {
				
			}
	}



}
