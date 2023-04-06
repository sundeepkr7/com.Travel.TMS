package User_Package;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.TMS.GenericUtilities.Baseclass;
import com.TMS.ObjectRepository.PackageDetailsPage;
import com.TMS.ObjectRepository.PackageListPage;
import com.TMS.ObjectRepository.TMSHomePage;
import com.TMS.ObjectRepository.UserHomePage;
import com.TMS.ObjectRepository.UserSignInPage;

public class BookPackageTest  extends Baseclass{
    
	@Test
	public void bookPackagetest()
	{
		try {
			String USERNAME = fLib.readDataFromPropertyFile("un");
			String PASSWORD = fLib.readDataFromPropertyFile("pwd");
		
		TMSHomePage TMSHome = new TMSHomePage(driver);
        TMSHome.clickOnsignin();
        
		UserSignInPage usersignin = new UserSignInPage(driver);
		usersignin.UserLogin(USERNAME, PASSWORD);
		
		UserHomePage userHP = new UserHomePage(driver);
		userHP.ClickOnTourPackages(driver);
		
		String packageName = eLib.readdataFromExcel("Packagedetails", 1, 0);
		PackageListPage packageList = new PackageListPage(driver);
		packageList.SearchAndClickOnPackage(packageName, driver);
		
		PackageDetailsPage pdetails = new PackageDetailsPage(driver);
		String from = eLib.readdataFromExcel("Packagedetails", 1, 6);
		pdetails.clickonFromDate(from);
		String to = eLib.readdataFromExcel("Packagedetails", 1, 7);
		pdetails.clicOnTodate(to);
		String comment = eLib.readdataFromExcel("Packagedetails", 1, 8);
		pdetails.clickoncomment(comment, driver);
		pdetails.clickOnBook();
		
		String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(res); 
		userHP.clickonUserLogout();
		
		}
		catch(Exception e) {
			
		}
	}
}
