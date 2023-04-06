package Admin_package;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CancelBookingTest {

	public static void main(String[] args) throws IOException {
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(USER);
		driver.findElement(By.name("password")).sendKeys(PASS);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
        driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
        WebElement cancel = driver.findElement(By.xpath("//tr[last()]/td[last()-1]/descendant::a[.='Cancel']"));
        int x = cancel.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,"+x+")");
        cancel.click();
        Alert a = driver.switchTo().alert();
        a.accept();
        }
        
}
