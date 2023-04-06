package com.TMS.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminManageEnquiries {

	
	@FindBy(xpath = "//a[@class='sidebar-icon']")
	private WebElement sidebaricon;
	
	@FindBy(xpath = "//tr[last()]/td[last()]")
	private WebElement pendingaction;
	
	public void sidebaricon()
	{
		sidebaricon.click();
	}
	
	public void pendingAction()
	{
		pendingaction.click();
	}
}
