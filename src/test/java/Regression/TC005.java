package Regression;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC005 extends TC001 {
	
	@Test
	public void print()
	{
		System.out.println("Execution of Test5");
		extent.createTest(this.getClass().getName()).log(Status.PASS,"TC005 is Successfull");
		extent.flush();
	}
	
	
	

}
