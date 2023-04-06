package com.TMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.ExcelUtility;

public class UpdateRemarkPage {

	
	@FindBy(name = "remark")
	private WebElement remarktbx;
	
	@FindBy(name = "submit2")
	private WebElement updatebtn;
	
	public UpdateRemarkPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void updateRemark(ExcelUtility eLib) throws Throwable
	{
		remarktbx.sendKeys(eLib.readdataFromExcel("UpdateRemark", 1, 1));
	//	eLib.readdataFromExcel("UpdateRemark", 1, 1);
		updatebtn.click();
	}
	
	
}
