package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
 
	@Test(dataProvider= "data")
	public void getData(String src, String dest)
	{
		System.out.println("from--> "+src+" to-->"+dest);
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] ob = new Object[2][2];
		ob[0][0] = "Qspiders";
		ob[0][1] = "Testyantra";
		
		ob[1][0] = "Testyantra";
		ob[1][1] = "Sony";
		return ob;
	}
}
