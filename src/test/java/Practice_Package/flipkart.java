package Practice_Package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {

	public static void main(String[] args) throws AWTException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("(//input[@type='text'])[last()]")).sendKeys("9614772441");
        Robot r = new Robot();
        driver.findElement(By.xpath("//button[.='Request OTP']")).click();
        WebElement element = driver.findElement(By.xpath("//div[@aria-label='Press & Hold']"));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        Actions a = new Actions(driver);
        a.clickAndHold(element).build().perform();
        
        //a.release(element);
        //r.keyPress(KeyEvent.VK_ENTER);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("Window.scrollBy(0,"+y+")");
//       
        
        
	}

}
