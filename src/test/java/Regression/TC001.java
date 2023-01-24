package Regression;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC001 {
	
	public static Logger log;
	public static WebDriver d;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark; 
	public static ExtentTest et;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
	LocalDateTime now = LocalDateTime.now(); 
	

	@BeforeTest
	public void reportname()
	{
		String DateFormat=dtf.format(now);
		spark = new ExtentSparkReporter("reports/ReportOn"+DateFormat+".html"); //creates html report to print the logs created by extent reports
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Test Type", "Regression");
		extent.setSystemInfo("Date:", now.toString());
	}
	
	public void set() throws InterruptedException
    {   
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
    	d= new ChromeDriver(options);
    	d.get("https://automationexercise.com/login");
    	//d.get("https://devwcs3.frontgate.com/personalized-recipe-board/1107822?searchTerm=159147");
    	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	d.manage().window().maximize();
    	log.debug("Setup is successfull");
    	
    }
	 
	public void setlogger(String c)
	{
		log = LogManager.getLogger(c);
	}
	
	public String screenshotone(WebDriver d)
	{
		
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
	
    public void quit()
    {
    	d.quit();
    	log.debug("Quit is successfull");
    }
	
	
	
	

}
