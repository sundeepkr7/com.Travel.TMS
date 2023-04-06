package com.TMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	@FindBy(linkText = "Home")
	private WebElement HomeLink;
	
	@FindBy(linkText = "About")
	private WebElement AboutLink;
	
	@FindBy(linkText = "Tour Packages")
	private WebElement TourPackagesLink;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement PrivacyPolicyLink;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement TermsofUseLink;
	
	@FindBy(linkText = "Contact Us")
	private WebElement ContactUsLink;
	
	@FindBy(xpath = "//a[contains(.,'Write Us')]")
	private WebElement WriteUsLink; 
	
	@FindBy(linkText="/ Logout")
	private WebElement LogoutLink;
	
	@FindBy(linkText="My Profile")
	private WebElement MyProfileLink;
	
	@FindBy(linkText="Change Password")
	private WebElement ChangePasswordLink;
	
	@FindBy(linkText="My Tour History")
	private WebElement MyTourHistoryLink;
	
	@FindBy(linkText="Issue Tickets")
	private WebElement IssueTicketsLink;
	
	public UserHomePage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}
	
	public void ClickOnTourPackages(WebDriver driver)
	{
		TourPackagesLink.click();
	}
	
	public void clickonUserLogout()
	{
		LogoutLink.click();
	}
	
	 public void ClickonWriteUs()
     {
  	   WriteUsLink.click();
     }
	 
	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public WebElement getMyProfileLink() {
		return MyProfileLink;
	}

	public WebElement getChangePasswordLink() {
		return ChangePasswordLink;
	}

	public WebElement getMyTourHistoryLink() {
		return MyTourHistoryLink;
	}

	public WebElement getIssueTicketsLink() {
		return IssueTicketsLink;
	}


		public WebElement getHomeLink() {
			return HomeLink;
		}

		public WebElement getAboutLink() {
			return AboutLink;
		}

		public WebElement getContactUsLink() {
			return ContactUsLink;
		}

		public WebElement getWriteUsLink() {
			return WriteUsLink;
		}
      
     
}
