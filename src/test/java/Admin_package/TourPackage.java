package Admin_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TourPackage {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/admin/index.php");
        driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\LogCredentials.property");
        Properties p = new Properties();
        p.load(fis);
		String URL= p.getProperty("url");
		String USER= p.getProperty("username");
		String PASS= p.getProperty("password");
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Random ran = new Random();
		int random = ran.nextInt(500);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("username")).sendKeys(USER);
		driver.findElement(By.name("password")).sendKeys(PASS);
        driver.findElement(By.name("login")).click();
        
        driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
        driver.findElement(By.xpath("//a[.='Create']")).click();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Package.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Tour");
		
		int rowcount = sh.getLastRowNum();
		Map<String,String> data = new HashMap<String,String>();
		for(int i=1;i<=rowcount;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			data.put(key, value);
		}
		for(Entry<String,String>entry:data.entrySet()) {
			driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
		}
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
		
		 driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
		 driver.findElement(By.xpath("//a[.='Manage']")).click();
		 Thread.sleep(2000);
		 WebElement submit1 = driver.findElement(By.xpath("(//span[contains(.,'2023-03-15')])[last()]/../following-sibling::td/descendant::button"));
		 js.executeScript("window.scrollTo(0,"+y+")");
		 submit1.click();
	}

}
