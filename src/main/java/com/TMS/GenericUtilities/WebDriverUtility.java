package com.TMS.GenericUtilities;

import java.awt.AWTException;
import java.io.File;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
public class WebDriverUtility {
    /**
     * This method is used to maximize the window
     * @param driver
     * @author sundeep
     */
	public void maximizeWindow(WebDriver driver) 
	{
	 driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used to wait for the page to load
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will select data from dropdown using visibletext
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	/**
	 * This method will perform Mousehover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform dragAndDrop action
	 * @param driver
	 * @param element
	 * @param src 
	 * @param dest 
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src,dest).perform();
	}
	public void rightclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleclickoption(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	public void enterkeypress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterkey(WebDriver driver) throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	public void switchToFrame(String address,WebDriver driver)
	{
		driver.switchTo().frame(address);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();;
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	public void switchToWindow(WebDriver driver, String partialTitle)
	{   // Step1: Use getWindowHandles to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		// Step2: Iterate through the windows
		Iterator<String> it = windows.iterator();
		// Step3: check whether there is next window
		while(it.hasNext())
		{   // Step4: capture current window id
			String winId = it.next();
			// Step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			// Step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
		}
	}
}
	/**
	 * This method will take screenshot and store it in folder called as screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable 
	 */
		public static String getScreenShot(WebDriver driver,String screenshotName) throws Throwable 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenshotName+".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}
		/**
		 * This method will perform random scroll
		 * @param driver
		 * @param element
		 */
		public void scrollBarAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("window.scrollBy(0,800)","");
		}
		/**
		 * This method will scroll until specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			int y =element.getLocation().getY();
			jse.executeScript("window.scrollTo(0,"+y+")");
		}
			
	}
	

