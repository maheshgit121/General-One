package Regression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC004 extends TC001 {
	
	File f;
	FileOutputStream o;
	public void createFile()
	{
		f = new File("D:\\eclipse-workspace\\GeneralOne\\TestData\\TestData.txt");
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			o = new FileOutputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
<<<<<<< HEAD
			String s = "I am a bad boy";
=======
			String s = "I am a good boy";
>>>>>>> 3d413393775ad3b549a594457fc0da7909d8661f
			char[] c = s.toCharArray();
			for(char c1 : c)
			{
				o.write(c1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent.createTest(this.getClass().getName()).log(Status.PASS,"Excel file creation is Successfull");
		extent.flush();
		
	}
	
	@Test
	public static void main1()
	{
		TC004 t = new TC004();
		
		t.createFile();
	}
	

}
