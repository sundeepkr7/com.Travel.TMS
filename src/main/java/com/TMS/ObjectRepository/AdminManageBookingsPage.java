package com.TMS.ObjectRepository;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.FileUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class AdminManageBookingsPage {
	
	@FindBy(xpath = "//td[contains(@data-th,'RegDate')]")
	private List<WebElement> regdateLink;
	
   @FindBy(xpath = "//tr/descendant::a[.='Cancel']")
   private List<WebElement> cancelLink;
   
   @FindBy(xpath = "//tr/descendant::a[.='Confirm']")
   private List<WebElement> confirmLink;
   
   public void searchAndClickOnConfirm(String Packagename, WebDriver driver, String username, ExcelUtility eLib, WebDriverUtility wLib) throws IOException
   {
	   String comment = eLib.readdataFromExcel("Packagedetails", 1, 8);
	   String x = "(//td[.='"+username+"']/following-sibling::td[.='"+Packagename+"']/following-sibling::td[.='"+comment+"']/following-sibling::td//a[.='Confirm'])[last()]";
	   WebElement el = driver.findElement(By.xpath(x));
	   wLib.scrollAction(driver,el);
	   wLib.elementToBeVisible(driver,el);
	   el.click();
	   wLib.acceptAlert(driver);
			
	}
	 
   public void searchAndClickOnCancel(String Packagename, WebDriver driver, String username, ExcelUtility eLib, WebDriverUtility wLib) throws IOException
   {
	   String comment = eLib.readdataFromExcel("Packagedetails", 1, 8);
	   String x1 = "(//td[.='anuj@gmail.com']/following-sibling::td[.='Nandi Hills']/following-sibling::td[@data-th='Comment ']/following-sibling::td//a[.='Cancel'])[last()]";
	  // String x1 = "(//td[.='anuj@gmail.com']/following-sibling::td[.='Nandi Hills']/following-sibling::td[.='Booking Enquiry']/following-sibling::td//a[.='Cancel'])[last()]";
	   WebElement el =driver.findElement(By.xpath(x1));
	   wLib.scrollAction(driver,el);
	   wLib.elementToBeVisible(driver,el);
	   el.click();
	   wLib.acceptAlert(driver);
			
	}
   }
   
  
   

