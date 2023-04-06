package Practice_Package;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER= p.getProperty("browser");
		String URL= p.getProperty("url");
		String USER= p.getProperty("un");
		String PASS= p.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASS);
		
		  WebDriverManager.chromedriver().setup();
		 // WebDriverManager.chromedriver().create();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		  driver.findElement(By.name("email")).sendKeys(USER);
		  driver.findElement(By.name("password")).sendKeys(PASS);
		  driver.findElement(By.name("signin")).click();
		

	}

}
