package com.crm.qa.testcases.Examples;

import java.io.File; 
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.Amazon;
import com.crm.qa.pages.Flipkart;
import com.crm.qa.pages.Gmail;
import com.crm.qa.pages.HtmlWebsite;
import com.crm.qa.util.TestUtil;


public class AlertsPopups  extends BaseSetup{
	Amazon amazon;
	@BeforeClass
	public void setUp() throws Exception{ 
		initialization(); 
	}

	@Test (priority=1, enabled=true)
	public void handle_alerts() throws InterruptedException
	{ 
		driver.get("https://demo.guru99.com/test/delete_customer.php");			


		driver.findElement(By.name("cusid")).sendKeys("53920");					
		driver.findElement(By.name("submit")).submit();			

		// Switching to Alert        
		Alert alert = driver.switchTo().alert();		

		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		

		// Displaying alert message		
		System.out.println("Alert Message Displayed is :::::::::"+alertMessage);	
		Thread.sleep(5000);

		// Accepting alert		
		alert.accept();	
	}


	@Test (priority=2)
	public void Handle_Popups() throws InterruptedException
	{ 
		driver.get("https://demo.guru99.com/popup.php");			
		driver.manage().window().maximize();		

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
		Thread.sleep(5000);
		String MainWindow=driver.getWindowHandle();		

		// To handle all new opened window.				
		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		

		while(i1.hasNext())			
		{		
			String ChildWindow=i1.next();		

			if(!MainWindow.equalsIgnoreCase(ChildWindow))			
			{    		

				// Switching to Child window
				driver.switchTo().window(ChildWindow);	                                                                                                           
				driver.findElement(By.name("emailid"))
				.sendKeys("gaurav.3n@gmail.com");                			

				driver.findElement(By.name("btnLogin")).click();			
				Thread.sleep(5000);
				// Closing the Child Window.
				driver.close();		
			}		
		}		
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
	}

}
