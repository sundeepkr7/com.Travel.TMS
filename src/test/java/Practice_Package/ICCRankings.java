package Practice_Package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRankings {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		//List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<teams.size();i++) {
			list.add(teams.get(i).getText());
		}
		for(String myteams:list) {
			String x = "//span[.='"+myteams+"']/../following-sibling::td[3]";
			String y = "//span[.='"+myteams+"']/../preceding-sibling::td";
		    String Rating = driver.findElement(By.xpath(x)).getText();
		    String rank = driver.findElement(By.xpath(y)).getText();
		    System.out.println("team->"+myteams+" --rating->"+Rating+" --ranking->" +rank);	
		}
		
	}

}
