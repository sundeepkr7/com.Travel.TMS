package Admin_package;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TMS.GenericUtilities.DatabaseUtility;
import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.JavaUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class Manage_Package {

	public static void main(String[] args) throws Throwable  {
		
		FileUtility fLib = new FileUtility();
        ExcelUtility eLib = new ExcelUtility();
        WebDriverUtility wLib = new WebDriverUtility();
        try 
        {
        String URL= fLib.readDataFromPropertyFile("url");
        String USER= fLib.readDataFromPropertyFile("un");
		String UPASS= fLib.readDataFromPropertyFile("pwd");
		String ADMIN= fLib.readDataFromPropertyFile("uname");
		String APASS= fLib.readDataFromPropertyFile("pass");
		String PackageName = eLib.readdataFromExcel("Tour", 1, 0);
		String PackagePrice = eLib.readdataFromExcel("ManagePackage", 1, 1);
		 
		//WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		wLib.maximizeWindow(driver );
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
	
		driver.findElement(By.name("username")).sendKeys(ADMIN);
		driver.findElement(By.name("password")).sendKeys(APASS);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
        driver.findElement(By.xpath("//a[.='Manage']")).click();
        
        HashMap<String, String> map = eLib.readMultipleData(PackagePrice);
           for(Entry<String,String>entry:map.entrySet())
           {
        	 if(entry.getKey().equalsIgnoreCase(PackagePrice))
        	  {
        	   driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
        		System.out.println(entry.getKey()+ " " +entry.getValue());
    		  }
           }
           WebElement submit = driver.findElement(By.xpath("(//tr/descendant::span[contains(.,'Nandi Hills')])[last()]/../following-sibling::td/descendant::button"));
           wLib.scrollAction(driver, submit);
           submit.click();
           WebElement update = driver.findElement(By.xpath("//button[.='Update']"));
           wLib.scrollAction(driver, update);
           update.click();
		   String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		   System.out.println(res); 
        }
        catch(Exception e) 
        {

        }
	}
}