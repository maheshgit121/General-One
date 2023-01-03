package Regression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TC004 {
	
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
			String s = "I am a good boy";
			char[] c = s.toCharArray();
			for(char c1 : c)
			{
				o.write(c1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args)
	{
		TC004 t = new TC004();
		
		t.createFile();
	}
	

}
