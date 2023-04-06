package com.TMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignInPage {

	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement emailtbx;
	
	@FindBy(id="password")
	private WebElement passwordtbx;
	
	@FindBy(name="Forgot password")
	private WebElement ForgotpasswordLink;
	
	@FindBy(name="signin")
	private WebElement signinbtn;
	
	@FindBy(name="Facebook")
	private WebElement Facebookbtn;
	
	@FindBy(name="Google")
	private WebElement Googlebtn;
	
	@FindBy(name="Terms and Conditions")
	private WebElement TermsandConditionsLink;
	
	@FindBy(name="Privacy Policy")
	private WebElement PrivacyPolicyLink;
	
	public UserSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void UserLogin(String un, String pw) 
	{
		emailtbx.sendKeys(un);
		passwordtbx.sendKeys(pw);
		signinbtn.click();	
	}
	
	public WebElement getEmailtbx()
	{
		return emailtbx;
	}

	public WebElement getPasswordtbx() {
		return passwordtbx;
	}

	public WebElement getForgotpasswordLink() {
		return ForgotpasswordLink;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}

	public WebElement getFacebookbtn() {
		return Facebookbtn;
	}

	public WebElement getGooglebtn() {
		return Googlebtn;
	}

	public WebElement getTermsandConditionsLink() {
		return TermsandConditionsLink;
	}

	public WebElement getPrivacyPolicyLink() {
		return PrivacyPolicyLink;
	}



		
	}
	

