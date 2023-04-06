package Practice_Package;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonSelectQuery {

	public static void main(String[] args) throws SQLException {
		
		  WebDriverManager.chromedriver().create();
		  WebDriver driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.get("http://rmgtestingserver:8084/");
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		  
		  driver.findElement(By.name("username")).sendKeys("rmgyantra");
		  driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		  driver.findElement(By.linkText("Sign in")).click();
	}

}
