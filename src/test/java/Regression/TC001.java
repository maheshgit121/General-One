package Regression;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC001 {
	
	public static Logger log = LogManager.getLogger(TC001.class);
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	public static ExtentTest et;
	
	@BeforeClass 
	public void setup()
	{
		extent.attachReporter(spark);
	}
	 
	
	public String screenshotone(WebDriver d)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   String currentDirectory=System.getProperty("user.dir");
		TakesScreenshot scrShot =((TakesScreenshot)d);
		String DateFormat=dtf.format(now);
		String className = this.getClass().getName();
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(currentDirectory+"\\screenshot\\"+className+DateFormat+".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return DestFile.getAbsolutePath();
	}
	
	
	
	

}
