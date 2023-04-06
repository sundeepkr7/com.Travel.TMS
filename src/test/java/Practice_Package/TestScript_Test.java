package Practice_Package;

import org.testng.annotations.Test;

public class TestScript_Test {
    
	@Test(invocationCount=1)
	public void create()
	{
		System.out.println("-----create data-----");
	}
	
	@Test(invocationCount=2,dependsOnMethods={"create","delete"})
	public void edit()
	{
		System.out.println("-----edit data-----");
	}
	
	@Test()
	public void delete()
	{
		System.out.println("-----delete data-----");
	}
}
