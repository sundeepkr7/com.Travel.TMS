package com.TMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMSHomePage {

	
	@FindBy(linkText = "Admin Login")
	private WebElement AdminLoginLink;
	
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
	
	@FindBy(linkText = "Enquiry")
	private WebElement  EnquiryLink;
	
	@FindBy(linkText = "Sign Up")
	private WebElement SignUpLink;
	
	@FindBy(xpath = "//a[contains(.,'Sign In')]")
	private WebElement SignInLink;
	
	public TMSHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnsignin()
	{
		SignInLink.click();
	}
	
	public void clickonadminlogin()
	{
		AdminLoginLink.click();
	}
	
	public void clickonTourPackages()
	{
		TourPackagesLink.click();
	}

	public WebElement getAdminLoginLink() {
		return AdminLoginLink;
	}

	public WebElement getAboutLink() {
		return AboutLink;
	}

//	public WebElement getTourPackagesLink() {
//		return TourPackagesLink;
//	}

	public WebElement getPrivacyPolicyLink() {
		return PrivacyPolicyLink;
	}

	public WebElement getTermsofUseLink() {
		return TermsofUseLink;
	}

	public WebElement getContactUsLink() {
		return ContactUsLink;
	}

	public WebElement getEnquiryLink() {
		return EnquiryLink;
	}

	public WebElement getSignUpLink() {
		return SignUpLink;
	}

	public WebElement getSignInLink() {
		return SignInLink;
	}
	
	
}
