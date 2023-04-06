package com.TMS.ObjectRepository;

import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class AdminPackageCreation {

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement dropdowntoggleLink;
	
	@FindBy(linkText = "Manage")
	private WebElement managelink;
	 
	@FindBy(name = "packagename")
	private WebElement packagenameLink;
	
	@FindBy(name = "packagetype")
	private WebElement packagetypeLink;
	
	@FindBy(name = "packagelocation")
	private WebElement packagelocationLink;
	
	@FindBy(name = "packageprice")
	private WebElement packagepriceLink;
	
	@FindBy(name = "packagefeatures")
	private WebElement packagefeaturesLink;
	
	@FindBy(name = "packagedetails")
	private WebElement packagedetailsLink;
	
	@FindBy(name = "packageimage")
	private WebElement packageimageLink;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createbtn;
	
	@FindBy(xpath = "//a[.='Reset']")
	private WebElement resetbtn;
	
	public AdminPackageCreation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void createPackage(ExcelUtility eLib, WebDriverUtility wLib, WebDriver driver) throws EncryptedDocumentException, Throwable  
	{
		ArrayList<String> details = eLib.getMultipleData("Tour", 1); //getting the values from Excel to Arraylist
		packagenameLink.sendKeys(details.get(0));
		packagetypeLink.sendKeys(details.get(1));
		packagelocationLink.sendKeys(details.get(2));
		packagepriceLink.sendKeys(details.get(3));
		packagefeaturesLink.sendKeys(details.get(4));
		packagedetailsLink.sendKeys(details.get(5));
		packageimageLink.sendKeys(details.get(6));
		wLib.scrollAction(driver,createbtn);
		createbtn.click();
	}

	public void setResetbtn() {
		resetbtn.click();
	}
	public void ManagePackage()
	{
		managelink.click();
	}
	
}
