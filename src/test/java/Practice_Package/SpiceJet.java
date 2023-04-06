package Practice_Package;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions option =new EdgeOptions();
		option.addArguments("--remote-allow-origins=*","--disable-notifications");
		WebDriver driver = new EdgeDriver(option);
        driver.manage().window().maximize();
        driver.manage().getCookies();
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        driver.findElement(By.xpath("//div[.='From']/descendant::input")).sendKeys("Beng");
        driver.findElement(By.xpath("//div[.='To']/descendant::input")).sendKeys("manga");
       
        Date cdate = new Date();
        String[] d =cdate.toString().split(" ");
        String day = d[0];
        String month = d[1];
        String date = d[2];
        String year = d[5];
        driver.findElement(By.xpath("//div[contains(.,'"+month+"') and text()='"+year+"']/../../descendant::div[text()='"+date+"']")).click();
        
        String rday = "Thu";
        String rmonth = "Jun";
        String rdate = "15";
        String ryear = "2023";
       for(;;) {
        	try {
        		driver.findElement(By.xpath("//div[contains(.,'"+rmonth+"') and text()='"+ryear+"']/../../descendant::div[text()='"+rdate+"']")).click();
        		                            //div[contains(.,'Jun') and text()='2023']/../../descendant::div[text()='15']
        		break;
        	}
        	catch(Exception e) {
        		driver.findElement(By.xpath("(//*[name()='circle' and @stroke='#DDD'][1]")).click();
        	}
        }
       // driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
        /*driver.findElement(By.cssSelector("//span[class='lbl_input latoBold appendBottom5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();*/
	}
}
        
        
   