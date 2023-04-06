package Admin_package;

import java.io.File;
import java.sql.DriverManager;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TourPackage_Module {

	
	public static void main(String[] args) throws InterruptedException {
		//Driver driver = new Driver();1
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
		driver.findElement(By.xpath("//a[.='Create']")).click();
		driver.findElement(By.name("packagename")).sendKeys("Bangkok");
		driver.findElement(By.name("packagetype")).sendKeys("any age individual");
		driver.findElement(By.name("packagelocation")).sendKeys("pataya");
		driver.findElement(By.name("packageprice")).sendKeys("1000");
		driver.findElement(By.name("packagefeatures")).sendKeys("All locations touring places including sea beach,city ride, pubs, night life,etc");
		driver.findElement(By.name("packagedetails")).sendKeys("Complete locations touring places including sea beach,city ride, pubs, night life,etc");
		Thread.sleep(1000);
		File f = new File(".\\src\\test\\resources\\beach.jpg");
		String absolutePath = f.getAbsolutePath();
		driver.findElement(By.id("packageimage")).sendKeys(absolutePath);
			 WebElement submit = driver.findElement(By.xpath("//button[.='Create']"));
			int y=submit.getLocation().getY();
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("window.scrollTo(0,"+y+")");
			 System.out.println("press 1 for create 0 for reset");
			 Scanner sc=new Scanner(System.in);
			 int flag=sc.nextInt();
			 if(flag==1)
			 {
				 submit.click();
			 }
			 else
			 {
				 driver.findElement(By.xpath("//button[.='Reset']")).click();
			 }
			 String res = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			 System.out.println(res);

			 //Thread.sleep(3000);
			 driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
			 driver.findElement(By.xpath("//a[.='Manage']")).click();
			 Thread.sleep(2000);
			 WebElement submit1 = driver.findElement(By.xpath("(//span[contains(.,'2023-03-15')])[last()]/../following-sibling::td/descendant::button"));
			
			 int z=submit1.getLocation().getY(); 
			 //JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("window.scrollTo(0,"+z+")");
			 submit1.click(); 
			 WebElement priceupdate = driver.findElement(By.name("packageprice"));
			 priceupdate.clear();
			 priceupdate.sendKeys("2000");
			 WebElement update = driver.findElement(By.xpath("//button[.='Update']"));
			 z=update.getLocation().getY();
			 js.executeScript("window.scrollTo(0,"+z+")");
			 update.click(); 
			 String result = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			 System.out.println(result);
			 
			 driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
			 driver.findElement(By.xpath("//a[.='Manage']")).click();
			 Thread.sleep(2000);
			 WebElement submit2 = driver.findElement(By.xpath("(//span[contains(.,'2023-03-15')])[last()]/../following-sibling::td/descendant::button"));
			
			 int x=submit2.getLocation().getY(); 
			 js.executeScript("window.scrollTo(0,"+x+")"); 
			 System.out.println();
			 String slno = driver.findElement(By.xpath("(//span[contains(.,'2023-03-15')])[last()]/../ancestor::tr/td[@data-th='#']")).getText();
			 String packagename = driver.findElement(By.xpath("(//span[contains(.,'2023-03-15')])[last()]/../ancestor::tr/td[@data-th='Name']")).getText();
			 System.out.println("SLNO-> "+slno+ " PackageName-> "+packagename);
	}

}
