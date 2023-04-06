package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TMS.GenericUtilities.ExcelUtility;

public class Data_Pro {

	@Test(dataProvider= "readSetOfData")
	public void getData(String src, String dest, String loc)
	{
		System.out.println("From--> "+src+"to--> "+dest+"loc--> "+loc);
	}
	
	@DataProvider
	public Object[][] readSetOfData() throws Exception, Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readmultipleSetOfdata("DP");
		return value;
		
	}
}
