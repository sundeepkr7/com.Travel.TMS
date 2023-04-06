package com.TMS.ObjectRepository;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TMS.GenericUtilities.ExcelUtility;
import com.TMS.GenericUtilities.WebDriverUtility;

public class AdminManagePackage 
{
	@FindBy(xpath = "(//tr/descendant::span[contains(.,'Nandi Hills')])[last()]/../following-sibling::td/descendant::button")
	private WebElement viewdetailsbtn;
	
	@FindBy(name = "packagename")
	private WebElement updatepackagenameLink;
	
	@FindBy(name = "packagetype")
	private WebElement updatepackagetypeLink;
	
	@FindBy(name = "packagelocation")
	private WebElement updatepackagelocationLink;
	
	@FindBy(name = "packageprice")
	private WebElement updatepackagepriceLink;
	
	@FindBy(name = "packagefeatures")
	private WebElement updatepackagefeaturesLink;
	
	@FindBy(name = "packagedetails")
	private WebElement updatepackagedetailsLink;
	
	@FindBy(name = "packageimage")
	private WebElement updatepackageimageLink;
	
    @FindBy(xpath = "//button[@name='submit']")
    private WebElement updatebtn; //button[.='Update']
    
    @FindBy(xpath = "//a[@class='sidebar-icon']")
    private WebElement sidebaricon;
    
    @FindBy(xpath = "//a[.='Change Image']")
    private WebElement changeimageLink;
    
    public AdminManagePackage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    public void clickonViewdetails(WebDriverUtility wLib, WebDriver driver)
    {   wLib.scrollAction(driver,viewdetailsbtn);
    	viewdetailsbtn.click();
    }
    public void clickonupdateimage()
    {
    	changeimageLink.click();
    }
	public void managePackage(ExcelUtility eLib, WebDriverUtility wLib, WebDriver driver) throws EncryptedDocumentException, Throwable 
	{	  
     ArrayList<String> details = eLib.getMultipleData("ManagePackage", 1); //getting the values from Excel to Arraylist
	 updatepackagepriceLink.clear();
     updatepackagepriceLink.sendKeys(details.get(0));
     wLib.scrollAction(driver,updatebtn);
     changeimageLink.click();
     updatepackageimageLink.sendKeys(details.get(1));
	 updatebtn.click();
		
    }
	
	public void clickonSidebarIcon()
	{
		sidebaricon.click();
	}
    
}
