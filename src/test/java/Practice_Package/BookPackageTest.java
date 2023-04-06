package Practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TMS.GenericUtilities.Baseclass;
import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.WebDriverUtility;
import com.TMS.ObjectRepository.PackageDetailsPage;
import com.TMS.ObjectRepository.PackageListPage;
import com.TMS.ObjectRepository.TMSHomePage;
import com.TMS.ObjectRepository.UserHomePage;
import com.TMS.ObjectRepository.UserSignInPage;

public class BookPackageTest  extends Baseclass{

	public static void main(String[] args)
	{
		try {
		FileUtility fLib = new FileUtility();
	    ExcelUtility eLib = new ExcelUtility();
	    WebDriverUtility wLib = new WebDriverUtility();
	    
	    String URL= fLib.readDataFromPropertyFile("url");
        String USER= fLib.readDataFromPropertyFile("un");
		String UPASS= fLib.readDataFromPropertyFile("pwd");
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		wLib.maximizeWindow(driver );
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		
		TMSHomePage TMSHome = new TMSHomePage(driver);
        TMSHome.clickOnsignin();
        
		UserSignInPage usersignin = new UserSignInPage(driver);
		usersignin.UserLogin(USER, UPASS);
		
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
		
		}
		catch(Exception e) {
			
		}
	}
}
