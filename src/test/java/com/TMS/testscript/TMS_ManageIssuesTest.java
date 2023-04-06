package com.TMS.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.TMS.GenericUtilities.Baseclass;
import com.TMS.ObjectRepository.AdminDashboard;
import com.TMS.ObjectRepository.AdminManageIssues;
import com.TMS.ObjectRepository.AdminSignInPage;
import com.TMS.ObjectRepository.HowCanWeHelpYou;
import com.TMS.ObjectRepository.TMSHomePage;
import com.TMS.ObjectRepository.UpdateRemarkPage;
import com.TMS.ObjectRepository.UserHomePage;
import com.TMS.ObjectRepository.UserSignInPage;

//@Listeners(com.TMS.GenericUtilities.ListenerImplementationClass.class)
  public class TMS_ManageIssuesTest extends Baseclass
   {

		//User Login
	  String USERNAME = fLib.readDataFromPropertyFile("un");
	  String PASSWORD = fLib.readDataFromPropertyFile("pwd");
	    //Admin Login
	  String Username = fLib.readDataFromPropertyFile("uname");
	  String Password = fLib.readDataFromPropertyFile("pass");
	  
	@Test
	public void createIssue() throws Throwable 
	{
		try
		{
		
		  TMSHomePage TMSHome = new TMSHomePage(driver);
          TMSHome.clickOnsignin();
        
		  UserSignInPage usersignin = new UserSignInPage(driver);
		  usersignin.UserLogin(USERNAME, PASSWORD);
		
		  UserHomePage userHP = new UserHomePage(driver);
		  userHP.ClickonWriteUs();
		
		  HowCanWeHelpYou help = new HowCanWeHelpYou(driver);
		  help.selectIssueAndDescription(eLib,wLib);
		  help.writeUs(driver);
		  String result = driver.findElement(By.xpath("//h4[contains(.,'Info successfully submited')]")).getText();
		  System.out.println(result);
		  userHP.clickonUserLogout();
		}
	    catch (Exception e) 
		{
		
	    }
	}
		
	  @Test  
	  public void manageIssue() throws Throwable
		{
		  try
		  {
		  String title = eLib.readdataFromExcel("UpdateRemark", 0, 0);
		  String Title = eLib.readdataFromExcel("ManageIssues", 0, 0);
		  TMSHomePage TMSHome = new TMSHomePage(driver); 
	      TMSHome.clickonadminlogin();
	      AdminSignInPage adminsignin = new AdminSignInPage(driver);
		  adminsignin.AdminSignin(Username,Password);
			
		  AdminDashboard dashboard = new AdminDashboard(driver);
	      dashboard.manageissueslink();
		  AdminManageIssues manageIssues = new AdminManageIssues(driver);
		  manageIssues.searchAndClickOnViewIssues(driver, eLib, USERNAME, wLib);
		  manageIssues.clickOnView();
			
		  wLib.switchToWindow(driver,title);
		  UpdateRemarkPage update = new UpdateRemarkPage(driver);
		  update.updateRemark(eLib);
		  driver.close();
		  wLib.switchToWindow(driver, Title);
		  
				
	    }
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
		
}
