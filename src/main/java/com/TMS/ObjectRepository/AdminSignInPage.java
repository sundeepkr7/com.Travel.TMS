package com.TMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {
     
	@FindBy(name="username")
	private WebElement untbx;
	
	@FindBy(name="password")
	private WebElement pwtbx;
	
	@FindBy(name= "login")
	private WebElement lgBtn;
	
	@FindBy(linkText ="Back to home")
	private WebElement BacktohomeLink;
	
	public AdminSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void AdminSignin(String un,String pw) {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgBtn.click();
	}	
	public void Backtohome()
	{
		BacktohomeLink.click();
	}
}
