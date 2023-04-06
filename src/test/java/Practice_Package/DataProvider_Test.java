package Practice_Package;

import com.TMS.GenericUtilities.ExcelUtility;

public class DataProvider_Test {

	public void setData() throws Exception, Throwable
	{
		
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readmultipleSetOfdata("DP");
		
	}
	
}
