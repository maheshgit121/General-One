package Regression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class TC006 extends TC001 {
	
	
	@Test
	public void signup() throws InterruptedException
	{
		
		this.setlogger("TC006.class");
		this.set();
		Actions act = new Actions(d);
		JavascriptExecutor js = (JavascriptExecutor)d;
		
		String DateFormatName=dtf.format(now);
		d.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("User"+DateFormatName);
		d.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("User"+DateFormatName+"@test.com");
		d.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		
		d.findElement(By.xpath("//input[@value='Mr']")).click();
		d.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("test@123");
        Select dd = new Select(d.findElement(By.xpath("//select[@data-qa='days']")));
        dd.selectByIndex(1);
        dd = new Select(d.findElement(By.xpath("//select[@data-qa='months']")));
        dd.selectByIndex(1);
        dd = new Select(d.findElement(By.xpath("//select[@data-qa='years']")));
        dd.selectByIndex(1);
        
        d.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("User"+DateFormatName);
        d.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Adiga");
        d.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Google");
        d.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("25, 1510, Google");
        
        dd = new Select(d.findElement(By.xpath("//select[@data-qa='country']")));
        dd.selectByValue("India");
        
        d.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Karnataka");
        d.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Bangalore");
        d.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("560050");
        d.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("9880446115");
        WebElement createAccount = d.findElement(By.xpath("//button[@data-qa='create-account']"));
       // d.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        js.executeScript("arguments[0].scrollIntoView();", createAccount);
       act.moveToElement(createAccount);
       WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOf(createAccount));
        //Thread.sleep(3000);
        js.executeScript("arguments[0].click();", createAccount);
        //createAccount.click();
        String txt = d.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        
        Assert.assertEquals(txt, "ACCOUNT CREATED!");
        log.info("Account Created Successfully");
        
        
        extent.createTest(this.getClass().getName()).log(Status.PASS,"Account Creation is Successfull");
		extent.flush();
		
		this.quit();
        
       
		
	}

}
