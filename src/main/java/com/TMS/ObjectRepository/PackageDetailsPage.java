package com.TMS.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.WebDriverUtility;

public class PackageDetailsPage {

	@FindBy(id= "datepicker")
	private WebElement Fromdate;
	
	@FindBy(id= "datepicker1")
	private WebElement Todate;
	
	@FindBy(xpath= "//input[@name='comment']")
	private WebElement commenttbx;
	
	@FindBy(name= "submit2")
	private WebElement Bookbtn;
	
	public PackageDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonFromDate(String from)
	{
		Fromdate.click();
		Fromdate.sendKeys(from);
	}

	public void clicOnTodate(String to)
	{
		Todate.click();
		Todate.sendKeys(to);
	}
	
	public void clickoncomment(String comment, WebDriver driver)
	{   WebDriverUtility wLib = new WebDriverUtility();
	    wLib.scrollAction(driver,commenttbx);
		commenttbx.click();
		commenttbx.sendKeys(comment);
	}
	
	public void clickOnBook()
	{
		Bookbtn.click();
	}

	
}
