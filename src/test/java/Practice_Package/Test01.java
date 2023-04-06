package Practice_Package;

import org.testng.annotations.Test;

public class Test01 extends Base_class {


	@Test(groups = "smoke")
	public void script1()
	{
		System.out.println("--Testscript_01--");
	}
	
	@Test(groups ="Regression")
	public void script2()
	{
		System.out.println("--Testscript_02--");
	}
}
