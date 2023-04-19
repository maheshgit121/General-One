package Regression;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC005 extends TC001 {
	
	@Test
<<<<<<< HEAD
	public void print()
=======
	public void TC005()
>>>>>>> 3d413393775ad3b549a594457fc0da7909d8661f
	{
		System.out.println("Execution of Test5");
		extent.createTest(this.getClass().getName()).log(Status.PASS,"TC005 is Successfull");
		extent.flush();
	}
	
	
	

}
