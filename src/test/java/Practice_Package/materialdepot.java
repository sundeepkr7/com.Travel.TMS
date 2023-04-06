package Practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class materialdepot {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://materialdepot.in/");
		driver.findElement(By.xpath("//div[text()='Blogs']")).click();
		String pwh=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//div[text()='Categories']")).click();
		

	}

}
