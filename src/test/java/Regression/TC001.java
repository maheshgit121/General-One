package Regression;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
<<<<<<< HEAD
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
=======
>>>>>>> 3d413393775ad3b549a594457fc0da7909d8661f
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC001 {
	
	public static Logger log;
<<<<<<< HEAD
	public  WebDriver d;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark; 
	public static ExtentTest et;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
	public static LocalDateTime now = LocalDateTime.now(); 
	public static String urlName;
	public static String username;
	public static String password;
	public static long minWait;
	public static long medWait;
	public static long maxWait;
	public static  String browser1;
	
	
	@BeforeTest
	public static void initialisation() throws IOException
	{
		String path = "D:\\eclipse-workspace\\GeneralOne\\Initialization.properties";
		FileReader r = new FileReader(path);
		Properties p = new Properties();
		p.load(r);
		urlName=p.getProperty("url");
		username=p.getProperty("user");
		password=p.getProperty("pass");
		minWait=Long.parseLong(p.getProperty("minwait"));
		medWait=Long.parseLong(p.getProperty("medwait"));
		maxWait=Long.parseLong(p.getProperty("maxwait"));
		browser1=p.getProperty("browser");
		
		
		
	}
	

	@BeforeTest
	public void reportname()
	{
=======
	public static WebDriver d;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark; 
	public static ExtentTest et;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
	LocalDateTime now = LocalDateTime.now(); 
	

	@BeforeTest
	public void reportname()
	{
>>>>>>> 3d413393775ad3b549a594457fc0da7909d8661f
		String DateFormat=dtf.format(now);
		spark = new ExtentSparkReporter("reports/ReportOn"+DateFormat+".html"); //creates html report to print the logs created by extent reports
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Test Type", "Regression");
		extent.setSystemInfo("Date:", now.toString());
<<<<<<< HEAD
		
		log = LogManager.getLogger();
		System.setProperty("file.name", "regression");
	}
	
	public void set() throws InterruptedException
    {   
    	
		
		
		if (browser1.contains("chrome"))
	    {
		  ChromeOptions options = new ChromeOptions();
    	 options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
    	 d= new ChromeDriver(options);
    	 d.get(urlName);
    	 //d.get("https://devwcs3.frontgate.com/personalized-recipe-board/1107822?searchTerm=159147");
    	 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	 d.manage().window().maximize();
    	 log.debug("Setup is successfull");
	    }
		
		else if(browser1.contains("firefox"))
		{
			d= new FirefoxDriver();
			d.get(urlName);
			 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	 d.manage().window().maximize();
	    	 log.debug("Setup is successfull");
			
		}
		else
		{
			d= new EdgeDriver();
			d.get(urlName);
			 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	 d.manage().window().maximize();
	    	 log.debug("Setup is successfull");
			
		}
    	
    }
	

	public void setlogger(String c)
	{
		log = LogManager.getLogger(c);
		System.setProperty("file.name", "regression");
	}
=======
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
>>>>>>> 3d413393775ad3b549a594457fc0da7909d8661f
	
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
