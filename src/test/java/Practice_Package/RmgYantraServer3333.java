package Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraServer3333 {

	public static void main(String[] args) throws SQLException, InterruptedException, IOException {
		Connection con = null;
		String expPro = "TY_PROJ_007";
		ResultSet result = null;
	    try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("http://rmgtestingserver:8084");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.linkText("Projects")).click();
			driver.findElement(By.xpath("//span[.='Create Project']")).click();
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataFile.property");
			Properties p = new Properties();
			p.load(fis);
			String ProjectName = p.getProperty("projectName");
			String CreatedBy = p.getProperty("createdBy");
			driver.manage().window().maximize();
			//driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.name("projectName")).sendKeys(ProjectName);
			driver.findElement(By.name("createdBy")).sendKeys(CreatedBy);
	        driver.findElement(By.xpath("//input[@type='submit']")).click();
			WebElement projectstatus = driver.findElement(By.xpath("//select[@name='status']"));
			Select s = new Select(projectstatus);
			s.selectByValue("On Going");
			
			Driver d = new Driver();
			DriverManager.registerDriver(d);
		
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
	        String query = "select * from project;";
	        ResultSet res = state.executeQuery(query);
	        boolean flag = false;
	        while(res.next())
	         {
	        	String actpro= res.getString(4);
	        	if(actpro.equalsIgnoreCase(expPro)) {
	        		flag= true;
	        		break;
	        	}
	         }
	        if(flag) {
	        	System.out.println("Project is created");
	        }
	        else {
	        	System.out.println("Project is not created"); 
	        }
			
		}
		catch(Exception e) {
			System.out.println("Exeception happened in try block");
			
		}
		finally {
			con.close();
		}
	}

}
