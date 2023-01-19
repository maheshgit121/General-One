package Regression;


import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class TestXpath extends TC001 {
	
	WebDriver d;
	Logger l = LogManager.getLogger(TestXpath.class);
	
    public void set() throws InterruptedException
    {   
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
    	d= new ChromeDriver(options);
    	d.get("https://automationexercise.com/login");
    	//d.get("https://devwcs3.frontgate.com/personalized-recipe-board/1107822?searchTerm=159147");
    	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	d.manage().window().maximize();
    	l.debug("Setup is successfull");
    	
    }
    
    public void quit()
    {
    	d.quit();
    	l.debug("Quit is successfull");
    }
    
    public void login()
    {
    	d.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
    	
    	if(new String(d.getTitle()).equals("Automation Exercise - Signup / Login"))
    	{
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys("maheshcharaj@gmail.com");
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")).sendKeys("Test@123");
    		d.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    	}
    }
    
    public void VerifyLoginError()
    {
    		
    	    
    		Assert.assertTrue(d.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(), "Login Failed");
    		l.debug("Login failed verification is successful");
    		extent.createTest("MyFirstTestXpath").log(Status.FAIL,"Login Verification was successful").addScreenCaptureFromPath(this.screenshotone(d));
    		extent.flush();
    		
    		
    
    	
    }
    
    public void JavaScriptExecutorTest()
    {
    	JavascriptExecutor js = (JavascriptExecutor) d;
    	
    	//d.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
    	
    	if(new String(d.getTitle()).equals("Automation Exercise - Signup / Login"))
    	{
    	WebElement username =  (WebElement) js.executeScript("document.getElementsByName('email')[0].value='maheshcharaj@gmail.com'");
    	//username.sendKeys("MaheshCharaj@gmail.com");
    	
    	
    	WebElement Password = (WebElement) js.executeScript("document.getElementsByName('password')[0].value='Test@123'");
    	//Password.sendKeys("Test@123");
    	
    	WebElement Login = (WebElement) js.executeScript(" document.getElementsByClassName('btn btn-default')[0].click()");
    	//Login.click();*/
    	
    	}
    }
    
    
    
   public void fileUploadTest()
   {
	    
	    
	    
	    d.findElement(By.xpath("//a[text()='Choose File']")).click();
	    d.findElement(By.id("filename")).sendKeys("C:\\Users\\mahesh.yr\\Pictures\\Screenshots\\GROverlapIssueFixed.png");
	    d.findElement(By.xpath("//span[text()='OK']")).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("File upload is successfull");
	    
   }
    
    @Test
    
    public  void main1() throws InterruptedException
    {
    	TestXpath t = new TestXpath();
    	t.set();
    	t.login();
    	//t.fileUploadTest();
    	//t.JavaScriptExecutorTest();
    	t.VerifyLoginError();
    	t.quit();
    	
    	
    	
    }
	

}
