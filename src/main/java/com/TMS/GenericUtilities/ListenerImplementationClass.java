package com.TMS.GenericUtilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass extends Baseclass implements ITestListener {
	
   ExtentReports report;
   ExtentTest test;
   
	public void onTestStart(ITestResult result) {
		
		//execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"-----> Testscript execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----->Passed");
		Reporter.log(MethodName+"-----> Testscript execution Successfull");
	}

	public void onTestFailure(ITestResult result) {
		
//		EventFiringDecorator<WebDriver> edriver = new EventFiringDecorator<WebDriver>(); 
//		//for selenium 3.141.59 version 
//		//EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.driver); 
          
		
//		String res = result.getName(); 
//		TakesScreenshot t =(TakesScreenshot)driver;
//		File src = t.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./ScreenShot/"+res+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		}
//		catch(Exception e){
//			
//		}
		try {
			String screenshot = WebDriverUtility.getScreenShot(Baseclass.driver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshot);
		}
		 catch (Throwable e) 
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable());
		Reporter.log("Testscript execution failed");
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript execution Skipped");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-47 Batch");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("TMS");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base", "chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base_URL","https://localhost:8888");
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
