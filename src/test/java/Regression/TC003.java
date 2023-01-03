package Regression;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC003 {
	
	
	public static void main(String[] args)throws Exception {
	      //Create Blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet sheet = workbook.createSheet("Employee");
	      Row r;
	      Cell c ;
	      
	      //Input values to excel
	      Map <String, Object[]> m = new TreeMap<String,Object[]>();
	      m.put("1",new Object[] {"UserName","PassWord"});
	      m.put("2",new Object[] {"Mahesh","Test@123"});
	      m.put("3",new Object[] {"Ramesh","Test@1234"});
	      m.put("4",new Object[] {"Ganesh","Test@12345"});
	      m.put("5",new Object[] {"Sukesh","Test@123456"});
	      Set<String> s = m.keySet();
	    
	      // set value to excel
	       int rowcount=0;
	       CellStyle c2 = workbook.createCellStyle();
	       XSSFFont f = workbook.createFont();
	       f.setBold(true);
	       c2.setFont(f);
	       
	       
	       
	       for(String k : s)
	       {
	    	   Object[] b = m.get(k);
	    	   r = sheet.createRow(rowcount++);
	    	   
	    	   int colcount=0;
	    	   for(Object data : b)
	    	   {
	    		   c=r.createCell(colcount++);
	    		   c.setCellValue((String)data);
	    		   if(rowcount==1)
	    		   {
	    		   c.setCellStyle(c2);
	    		   }
	    	   }
	    	   
	    	   
	       }
	      
	      
	   
	      
	      //Create file system using specific name
	      FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));

	      //write operation workbook using file out object 
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
	   }
	
	
	

}
