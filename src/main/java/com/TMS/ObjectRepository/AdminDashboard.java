package com.TMS.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard {

	@FindBy(linkText ="Dashboard")
	private WebElement DashboardLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tour Packages')]")
	private WebElement TourPackagesLink;
	
	@FindBy(linkText ="Create")
	private WebElement createlink;
	
	@FindBy(linkText = "Manage")
	private WebElement managelink;
	
	@FindBy(linkText ="Manage Users")
	private WebElement manageuserslink;
	
	@FindBy(linkText ="Manage Booking")
	private WebElement managebookinglink;
	
	@FindBy(linkText ="Manage Issues")
	private WebElement manageissueslink;
	
	@FindBy(linkText ="Manage Enquiries")
	private WebElement manageenquirieslink;
	
	@FindBy(linkText ="Manage Pages")
	private WebElement managepageslink;
	
	@FindBy(xpath = "//div[contains(@class,'profile_details')]")
	private WebElement administratorDropdown;
	
	@FindBy(xpath = "//a[contains(.,'Logout')]")
	private WebElement logoutlink;
	
	@FindBy(xpath = "//a[contains(.,'Profile')]")
	private WebElement profilelink;
	
	@FindBy(xpath = "//a[@class='sidebar-icon']")
	private WebElement sidebaricon;

	public AdminDashboard(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void clickOnTourPackages()
	{
		TourPackagesLink.click();
	}
	public void clickOnCreate()
	{
		createlink.click();
	}
	public void clickOnmanage()
	{
		managelink.click();
	}
	
	public void manageissueslink()
	{
		manageissueslink.click();
	}
	
	public void clickonSidebaricon()
	{
		sidebaricon.click();
	}
	public void clickonAdministratorDD()
	{
		administratorDropdown.click();
	}
	
	public void clickonManageBookings()
	{
		managebookinglink.click();
	}
	
	public void clickonAdminProfile()
	{
		profilelink.click();
	}
	
	public void clickonAdminLogout()
	{
		logoutlink.click();
	}
	
	
	
	
}
