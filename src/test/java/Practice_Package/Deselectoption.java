package Practice_Package;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Deselectoption {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
		public static void main(String[] args) throws InterruptedException {
			//open the browser
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(option);
			
			driver.get("file:///C:/Users/hp/OneDrive/Desktop/food.html");
			WebElement mtrlistbox = driver.findElement(By.id("mtr"));
			Select s = new Select(mtrlistbox);
			List<WebElement> alloptions = s.getOptions();
			int count = alloptions.size();
			for(int i=0;i<count;i++)
			{
				s.deselectByIndex(i);
				//s.selectByIndex(i);
			}
//			for(int i=count-1; i>0; i--)
//			{
//				s.deselectByIndex(i);
//			}
//			
		}
}
