package Admin_package;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TMS.GenericUtilities.DatabaseUtility;
import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.JavaUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class ConfirmBookingTest {

	public static void main(String[] args) {
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
        ExcelUtility eLib = new ExcelUtility();
        JavaUtility jLib = new JavaUtility();
        WebDriverUtility wLib = new WebDriverUtility();
        try {
        String URL= fLib.readDataFromPropertyFile("url");
        String USER= fLib.readDataFromPropertyFile("un");
		String UPASS= fLib.readDataFromPropertyFile("pwd");
		String ADMIN= fLib.readDataFromPropertyFile("uname");
		String APASS= fLib.readDataFromPropertyFile("pass");
		//String PackageName = eLib.readdataFromExcel("Tour", 1, 0);

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
        driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
        driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
        WebElement confirm = driver.findElement(By.xpath("//tr[last()]/td[last()-1]/descendant::a[.='Confirm']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
		int y =confirm.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");
		confirm.click();
        Alert a = driver.switchTo().alert();
        a.accept();
        }
      
        catch(Exception e) {
	}
	}
}
