package com.TMS.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class HowCanWeHelpYou {

	@FindBy(name="issue")
	private WebElement selectissueDropdown;
	
	@FindBy(name = "description")
	private WebElement descriptiontbx;
	
	@FindBy(xpath = "//button[(.='Submit')]")
	private WebElement submitbtn;
	
	public HowCanWeHelpYou(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}

    public void writeUs(WebDriver wLib)
    {
    	submitbtn.click();
    }
    
    public void selectIssueAndDescription(ExcelUtility eLib, WebDriverUtility wLib)
    { 
    	String issueType = eLib.readdataFromExcel("writeUs", 1, 0);
    	String descType = eLib.readdataFromExcel("writeUs", 1, 1);
    	wLib.select(issueType, selectissueDropdown);
    	descriptiontbx.sendKeys(descType);
    	
    }
    
}
