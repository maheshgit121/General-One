package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
public class TestXpath extends TC001 {
	
    

    
    public void login() throws InterruptedException
    {
    	d.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
    	
    	if(new String(d.getTitle()).equals("Automation Exercise - Signup / Login"))
    	{
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys(username);
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")).sendKeys(password);
    		Thread.sleep(minWait);
    		d.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    		log.info("Login is Successful");
    	}
    }
    
    public void VerifyLoginError()
    {
    		
    	    
    		Assert.assertTrue(d.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(), "Login Failed");
    		log.debug("Login failed verification is successful");
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
    	
    	/*this.setlogger(this.getClass().getName());
    	this.set();
    	this.login();
    	//t.fileUploadTest();
    	//t.JavaScriptExecutorTest();
    	this.VerifyLoginError();
    	this.quit();*/
    	
    	TestXpath t = new TestXpath();
    	t.set();
    	t.quit();
    	
    	
    	
    }
	

}
