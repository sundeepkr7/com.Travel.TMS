package Practice_Package;

import org.testng.annotations.Test;

public class Test03 extends Base_class{


	@Test(groups = "smoke")
	public void script5()
	{
		System.out.println("--Testscript_05--");
	}
	
	@Test(groups ="Regression")
	public void script6()
	{
		System.out.println("--Testscript_06--");
	}
}
