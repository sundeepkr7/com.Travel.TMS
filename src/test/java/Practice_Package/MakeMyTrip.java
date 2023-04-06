package Practice_Package;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disabled-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().getCookies();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//span[@class=))"
        WebElement from= driver.findElement(By.xpath("//input[@id='fromCity']"));
        from.sendKeys("Bengaluru");
        driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
        WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));
        from.sendKeys("Mangalore");
        driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
        
        Date cdate = new Date();
        String[] d =cdate.toString().split(" ");
        String day = d[0];
        String month = d[1];
        String date = d[2];
        String year = d[5];
        String travelDate = day+" "+month+" "+date+" "+year;
        driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
        
        String rday = "Thu";
        String rmonth = "Jun";
        String rdate = "15";
        String ryear = "2023";
        String returnDate = rday+" "+rmonth+" "+rdate+" "+ryear;
        for(;;) {
        	try {
        		driver.findElement(By.xpath("//div[@aria-label='\"+returnDate+")).click();
        		break;
        	}
        	catch(Exception e) {
        		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
        	}
        }
       // driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
        driver.findElement(By.cssSelector("//span[class='lbl_input latoBold appendBottom5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();

	}

}
