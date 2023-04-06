package Practice_Package;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicRankings {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		Thread.sleep(1000);
		List<WebElement> teams = driver.findElements(By.xpath("//span[@class='styles__CountryName-sc-fehzzg-6 cdgAMA']"));
		//List<WebElement> teams = driver.findElements(By.xpath("//div/following-sibling::div[2]/span[@data-cy='country-name']"));
		//List<WebElement> teams = driver.findElements(By.xpath("//div[contains(@data-row-id,'country-medal-row')]/following-sibling::div"));
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<teams.size();i++) {
			list.add(teams.get(i).getText());
		}
		for(String myteams:list) {
			String x = "//span[.='"+myteams+"']/../following-sibling::div[@title='Gold'][1]";
			String y = "//span[.='"+myteams+"']/../following-sibling::div[@title='Silver'][1]";
			String z = "//span[.='"+myteams+"']/../following-sibling::div[@title='Bronze'][1]";
			String Gold = driver.findElement(By.xpath(x)).getText();
			String Silver = driver.findElement(By.xpath(y)).getText();
			String Bronze = driver.findElement(By.xpath(z)).getText();
			//Thread.sleep(1000);
			System.out.print("teams->"+ myteams);
			System.out.println(" Medals->" + " Gold->"+ Gold + " Silver->"+ Silver + " Bronze->"+ Bronze);
		}	
	}

}