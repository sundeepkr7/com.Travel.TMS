package com.TMS.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.WebDriverUtility;


public class AdminManageIssues {
  
	@FindBy(xpath = "//tr[last()]/td[last()]")
	private WebElement viewLink;
	
	public AdminManageIssues(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}

	
	public void clickOnView()
	{
		viewLink.click();
	}
	
	public void searchAndClickOnViewIssues(WebDriver driver, ExcelUtility eLib,String username, WebDriverUtility wLib)
	{
		//String comment = eLib.readdataFromExcel("Packagedetails", 1, 8);
		String Issues = eLib.readdataFromExcel("writeUs", 1, 0);
    	String Desc = eLib.readdataFromExcel("writeUs", 1, 1);
		String x1 = "(//td/span[.='"+username+"']/following::td[contains(.,'"+Issues+"')]/following::td[contains(.,'"+Desc+"')])[last()]";
		//(//td/span[.='anuj@gmail.com']/following::td[contains(.,'Issues')]/following::td[contains(.,'Cannot be Booked')])[last()]
		WebElement ele = driver.findElement(By.xpath(x1));
		wLib.scrollAction(driver,ele);
		wLib.elementToBeVisible(driver,ele);
	}
}
