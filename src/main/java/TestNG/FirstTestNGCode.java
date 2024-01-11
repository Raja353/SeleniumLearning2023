package TestNG;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNGCode {
	
	@Test(priority=2,description="This method is to show the login method")
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		System.out.println("hellow this is my first testNG pgm");
	}
	
	@Test(priority=4,description="This method is to show the Test2 method")
	public void test2()
	
	{
		Assert.assertTrue(false);
		System.out.println("The TC2 is executed successfully.");
	}

	@Test(priority=3,description="This method is to show the Test3 method")
	public void test3()
	{
		System.out.println("The TC3 is executed successfully.");
	}
	

}
