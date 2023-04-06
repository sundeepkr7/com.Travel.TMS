package Practice_Package;

import org.testng.annotations.Test;

public class Test02 extends Base_class {
	
	@Test(groups = "smoke")
	public void script3()
	{
		System.out.println("--Testscript_03--");
	}
	
	@Test(groups ="Regression")
	public void script4()
	{
		System.out.println("--Testscript_04--");
	}

	
	
}
