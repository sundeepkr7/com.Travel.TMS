package com.TMS.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.GenericUtilities.WebDriverUtility;

public class PackageListPage {

	@FindBy(xpath="//img") 
	private WebElement packageimageList;
	
	@FindBy(xpath="//h4") 
	private List<WebElement> packagenameList;
	
	@FindBy(xpath="//h6") 
	private List<WebElement> packagetypeList;
	
	@FindBy(xpath="///b[.='Package Location :']/parent::p") 
	private List<WebElement> packagelocationList;
	
	@FindBy(xpath="//b[.='Features']/parent::p") 
	private List<WebElement> featuresList;
	
	@FindBy(xpath="//a[.='Details']") 
	private List<WebElement> detailsButton;
	
	@FindBy(xpath="//h5") 
	private List<WebElement> packagepriceList;
	
	
	public PackageListPage(WebDriver driver ){
		PageFactory.initElements(driver, this);
	}
	
	public void SearchAndClickOnPackage(String Packagename, WebDriver driver)
	{
		for(int i=0;i<packagenameList.size();i++)
		{
			WebDriverUtility wLib = new WebDriverUtility();
			wLib.scrollAction(driver, packagenameList.get(i));
			wLib.elementToBeVisible(driver, packagenameList.get(i));
			if(packagenameList.get(i).getText().contains(Packagename))
			{
				detailsButton.get(i).click();
				break;
			}
		}
	}
	
	
}
